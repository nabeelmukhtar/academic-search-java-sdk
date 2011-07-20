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
 * The Class InvalidParametersException.
 */
public class InvalidParametersException extends AcademicSearchException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6435235987178815498L;

	/**
	 * Instantiates a new invalid parameters exception.
	 */
	public InvalidParametersException() {
		super("Some parameters are invalid. For example, none of the search condition is specified.", 2);
	}

	/**
	 * Instantiates a new invalid parameters exception.
	 * 
	 * @param message the message
	 */
	public InvalidParametersException(String message) {
		super(message, 2);
	}

	/**
	 * Instantiates a new invalid parameters exception.
	 * 
	 * @param cause the cause
	 */
	public InvalidParametersException(Throwable cause) {
		super(cause);
	}

	/**
	 * Instantiates a new invalid parameters exception.
	 * 
	 * @param message the message
	 * @param cause the cause
	 */
	public InvalidParametersException(String message, Throwable cause) {
		super(message, cause);
	}
}
