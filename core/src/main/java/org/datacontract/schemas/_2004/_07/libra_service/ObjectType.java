
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
public enum ObjectType {

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
