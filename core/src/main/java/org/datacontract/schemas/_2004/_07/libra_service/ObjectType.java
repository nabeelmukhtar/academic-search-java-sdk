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

package org.datacontract.schemas._2004._07.libra_service;



/**
 * <p>Java class for ObjectType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ObjectType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Publication"/>
 *     &lt;enumeration value="Author"/>
 *     &lt;enumeration value="Conference"/>
 *     &lt;enumeration value="Journal"/>
 *     &lt;enumeration value="Organization"/>
 *     &lt;enumeration value="Domain"/>
 *     &lt;enumeration value="Keyword"/>
 *     &lt;enumeration value="PublicationTrend"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
public enum ObjectType implements ValueEnum {

    PUBLICATION("Publication"),
    AUTHOR("Author"),
    CONFERENCE("Conference"),
    JOURNAL("Journal"),
    ORGANIZATION("Organization"),
    DOMAIN("Domain"),
    KEYWORD("Keyword"),
    PUBLICATION_TREND("PublicationTrend");
    private final String value;

    ObjectType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ObjectType fromValue(String v) {
        for (ObjectType c: ObjectType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v.toString());
    }

}
