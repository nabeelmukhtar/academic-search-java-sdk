
package org.datacontract.schemas._2004._07.libra_service;


/**
 * <p>Java class for ReferenceRelationship.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ReferenceRelationship">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="Reference"/>
 *     &lt;enumeration value="Citation"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
public enum ReferenceRelationship {

    NONE("None"),
    REFERENCE("Reference"),
    CITATION("Citation");
    private final String value;

    ReferenceRelationship(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ReferenceRelationship fromValue(String v) {
        for (ReferenceRelationship c: ReferenceRelationship.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v.toString());
    }

}
