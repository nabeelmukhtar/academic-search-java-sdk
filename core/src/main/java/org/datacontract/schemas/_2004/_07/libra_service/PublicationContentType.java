
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
public enum PublicationContentType {

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
