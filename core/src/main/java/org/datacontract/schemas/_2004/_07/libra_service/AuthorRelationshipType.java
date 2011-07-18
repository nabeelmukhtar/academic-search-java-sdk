
package org.datacontract.schemas._2004._07.libra_service;

/**
 * <p>Java class for AuthorRelationshipType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AuthorRelationshipType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="CoAuthor"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
public enum AuthorRelationshipType {

    NONE("None"),
    CO_AUTHOR("CoAuthor");
    private final String value;

    AuthorRelationshipType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AuthorRelationshipType fromValue(String v) {
        for (AuthorRelationshipType c: AuthorRelationshipType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v.toString());
    }

}
