
package org.datacontract.schemas._2004._07.libra_service;

/**
 * <p>Java class for SuggestionType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SuggestionType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="NameSuggestion"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
public enum SuggestionType {

    NONE("None"),
    NAME_SUGGESTION("NameSuggestion");
    private final String value;

    SuggestionType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SuggestionType fromValue(String v) {
        for (SuggestionType c: SuggestionType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v.toString());
    }

}
