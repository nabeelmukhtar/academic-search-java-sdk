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
 * <p>Java class for PublicationContentType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PublicationContentType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="AllInfo"/>
 *     &lt;enumeration value="MetaOnly"/>
 *     &lt;enumeration value="Title"/>
 *     &lt;enumeration value="Author"/>
 *     &lt;enumeration value="Abstract"/>
 *     &lt;enumeration value="ConferenceAndJournalInfo"/>
 *     &lt;enumeration value="FullVersionURL"/>
 *     &lt;enumeration value="Keyword"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
public enum PublicationContentType implements ValueEnum {

    ALL_INFO("AllInfo"),
    META_ONLY("MetaOnly"),
    TITLE("Title"),
    AUTHOR("Author"),
    ABSTRACT("Abstract"),
    CONFERENCE_AND_JOURNAL_INFO("ConferenceAndJournalInfo"),
    FULL_VERSION_URL("FullVersionURL"),
    KEYWORD("Keyword");
    private final String value;

    PublicationContentType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PublicationContentType fromValue(String v) {
        for (PublicationContentType c: PublicationContentType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v.toString());
    }

}
