
package org.datacontract.schemas._2004._07.libra_service;


/**
 * <p>Java class for OrderType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="OrderType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Rank"/>
 *     &lt;enumeration value="Year"/>
 *     &lt;enumeration value="CitationCount"/>
 *     &lt;enumeration value="PublicationCount"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
public enum OrderType {

    RANK("Rank"),
    YEAR("Year"),
    CITATION_COUNT("CitationCount"),
    PUBLICATION_COUNT("PublicationCount");
    private final String value;

    OrderType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static OrderType fromValue(String v) {
        for (OrderType c: OrderType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v.toString());
    }

}
