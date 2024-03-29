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
 * The Class UnsupportedSearchConditionException.
 */
public class UnsupportedSearchConditionException extends AcademicSearchException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6435235987178815498L;

	/**
	 * Instantiates a new unsupported search condition exception.
	 */
	public UnsupportedSearchConditionException() {
		super("The search condition is not supported yet.", 4);
	}

	/**
	 * Instantiates a new unsupported search condition exception.
	 * 
	 * @param message the message
	 */
	public UnsupportedSearchConditionException(String message) {
		super(message, 4);
	}

	/**
	 * Instantiates a new unsupported search condition exception.
	 * 
	 * @param cause the cause
	 */
	public UnsupportedSearchConditionException(Throwable cause) {
		super(cause);
	}

	/**
	 * Instantiates a new unsupported search condition exception.
	 * 
	 * @param message the message
	 * @param cause the cause
	 */
	public UnsupportedSearchConditionException(String message, Throwable cause) {
		super(message, cause);
	}
}
