/*
 * Copyright 2011 Nabeel Mukhtar 
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * 
 *  http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 * 
 */
package com.microsoft.research.query.impl;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;

import org.datacontract.schemas._2004._07.libra_service.PublicationType;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.microsoft.research.PagedArrayList;
import com.microsoft.research.PagedList;
import com.microsoft.research.query.constant.ApplicationConstants;
import com.microsoft.research.query.constant.ParameterNames;
import com.microsoft.research.query.constant.AcademicSearchApiUrls.AcademicSearchApiUrlBuilder;
import com.microsoft.research.query.exception.AcademicSearchException;
import com.microsoft.research.query.exception.InvalidAppIdException;
import com.microsoft.research.query.exception.InvalidParametersException;
import com.microsoft.research.query.exception.ServiceUnavailableException;
import com.microsoft.research.query.exception.UnsupportedSearchConditionException;

/**
 * The Class BaseApiQuery.
 */
public abstract class BaseApiQuery<T> extends
		AcademicSearchApiGateway {

	/** The Constant UTF_8_CHAR_SET. */
	protected static final Charset UTF_8_CHAR_SET = Charset
			.forName(ApplicationConstants.CONTENT_ENCODING);

	/** The api url builder. */
	protected AcademicSearchApiUrlBuilder apiUrlBuilder;

	/** The parser. */
	protected final JsonParser parser = new JsonParser();

	/**
	 * Instantiates a new base api query.
	 * 
	 * @param applicationId the application id
	 */
	public BaseApiQuery(String applicationId) {
		super();
		super.setApplicationKey(applicationId);
		requestHeaders = new HashMap<String, String>();

		// by default we compress contents
		requestHeaders.put("Accept-Encoding", "gzip, deflate");
		this.reset();
	}

	/**
	 * Instantiates a new base api query.
	 * 
	 * @param applicationId the application id
	 * @param apiVersion the api version
	 */
	public BaseApiQuery(String applicationId, String apiVersion) {
		this(applicationId);
		super.setApiVersion(apiVersion);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.stackexchange.client.query.StackOverflowApiQuery#list()
	 */
	/**
	 * List.
	 * 
	 * @return the paged list< t>
	 */
	public PagedList<T> list() {
		InputStream jsonContent = null;
		try {
			jsonContent = callApiGet(apiUrlBuilder.buildUrl());
			JsonElement response = parser.parse(new InputStreamReader(
					jsonContent, UTF_8_CHAR_SET));
			if (response.isJsonObject()) {
				JsonElement jsonElement = response.getAsJsonObject().get("d");
				if (jsonElement != null && jsonElement.isJsonObject()) {
					JsonObject jsonObject = jsonElement.getAsJsonObject();
					int resultCode = 0;
					if (jsonObject.has("ResultCode")) { 
						resultCode = jsonObject.get("ResultCode").getAsInt();
					}
					if (resultCode == 0) {
						PagedList<T> responseList = unmarshallList(jsonObject);
						return responseList;
					} else {
						throw createAcademicSearchException(resultCode);
					}
				} else {
					return new PagedArrayList<T>();
				}
			}
			throw new AcademicSearchException(
					"Unknown content found in response:" + response.toString());
		} catch (AcademicSearchException e) {
			throw e;
		} catch (Exception e) {
			throw new AcademicSearchException(e);
		} finally {
			closeStream(jsonContent);
		}
	}

	/**
	 * Creates the academic search exception.
	 * 
	 * @param resultCode the result code
	 * 
	 * @return the academic search exception
	 */
	private AcademicSearchException createAcademicSearchException(int resultCode) {
		switch (resultCode) {
		case 1:
			return new InvalidAppIdException();
		case 2:
			return new InvalidParametersException();
		case 3:
			return new ServiceUnavailableException();
		case 4:
			return new UnsupportedSearchConditionException();
		default:
			return new AcademicSearchException();
		}
	}

	/**
	 * Unmarshall list.
	 * 
	 * @param response the response
	 * 
	 * @return the paged list< t>
	 */
	protected abstract PagedList<T> unmarshallList(JsonObject response);

	/**
	 * Unmarshall list.
	 * 
	 * @param response the response
	 * @param name the name
	 * @param typeToken the type token
	 * 
	 * @return the paged list< t>
	 */
	protected PagedList<T> unmarshallList(JsonObject response, String name,
			TypeToken<? extends List<T>> typeToken) {
		if (name != null) {
			response = response.get(name).getAsJsonObject();
		}
		PagedArrayList<T> list = new PagedArrayList<T>();
		if (response != null) {
			if (response.get("EndIdx") != null) {
				list.setEndIndex(response.get("EndIdx").getAsInt());
			}
			if (response.get("StartIdx") != null) {
				list.setStartIndex(response.get("StartIdx").getAsInt());
			}
			if (response.get("TotalItem") != null) {
				list.setTotalItems(response.get("TotalItem").getAsLong());
			}
			Gson gson = getGsonBuilder().create();
			List<T> resultsList = gson.fromJson(response.get("Result"), typeToken
					.getType());
			list.addAll(resultsList);
		}
		return list;
	}
	
	/**
	 * Reset.
	 */
	public void reset() {
		
	}
	

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.code.stackexchange.client.query.StackOverflowApiQuery#singleResult()
	 */
	/**
	 * Single result.
	 * 
	 * @return the t
	 */
	public T singleResult() {
		PagedList<T> list = list();
		return (list.isEmpty()) ? null : list.get(0);
	}

	/**
	 * Gets the gson builder.
	 * 
	 * @return the gson builder
	 */
	protected GsonBuilder getGsonBuilder() {
		GsonBuilder builder = new GsonBuilder();
		builder.setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE);
		builder.registerTypeAdapter(PublicationType.class,
				new JsonDeserializer<PublicationType>() {

					@Override
					public PublicationType deserialize(JsonElement arg0,
							Type arg1, JsonDeserializationContext arg2)
							throws JsonParseException {
						return PublicationType.fromNumber(arg0.getAsInt());
					}

				});
		builder.registerTypeAdapter(Date.class,
				new JsonDeserializer<Date>() {

					@Override
					public Date deserialize(JsonElement arg0,
							Type arg1, JsonDeserializationContext arg2)
							throws JsonParseException {
						if (arg0 != null) {
							Matcher matcher = ApplicationConstants.DATE_FORMAT.matcher(arg0.getAsString());
							if (matcher.find() && matcher.groupCount() == 2) {
								return new Date(Long.parseLong(matcher.group(1)));
							}
						}
						return null;
					}

				});
		return builder;
	}

	/**
	 * Creates the academic search api url builder.
	 * 
	 * @param urlFormat the url format
	 * 
	 * @return the academic search api url builder
	 */
	protected AcademicSearchApiUrlBuilder createAcademicSearchApiUrlBuilder(
			String urlFormat) {
		AcademicSearchApiUrlBuilder urlBuilder = new AcademicSearchApiUrlBuilder(
				urlFormat);
		urlBuilder.withParameter(ParameterNames.APP_ID, getApplicationKey());
		return urlBuilder;
	}
}
