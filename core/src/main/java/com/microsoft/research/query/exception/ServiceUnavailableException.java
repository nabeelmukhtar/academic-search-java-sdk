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
package com.microsoft.research.query.exception;

/**
 * The Class ServiceUnavailableException.
 */
public class ServiceUnavailableException extends AcademicSearchException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6435235987178815498L;

	/**
	 * Instantiates a new service unavailable exception.
	 */
	public ServiceUnavailableException() {
		super("The MAS service is temporarily unavailable. Please try it later.", 3);
	}

	/**
	 * Instantiates a new service unavailable exception.
	 * 
	 * @param message the message
	 */
	public ServiceUnavailableException(String message) {
		super(message, 3);
	}

	/**
	 * Instantiates a new service unavailable exception.
	 * 
	 * @param cause the cause
	 */
	public ServiceUnavailableException(Throwable cause) {
		super(cause);
	}

	/**
	 * Instantiates a new service unavailable exception.
	 * 
	 * @param message the message
	 * @param cause the cause
	 */
	public ServiceUnavailableException(String message, Throwable cause) {
		super(message, cause);
	}
}
