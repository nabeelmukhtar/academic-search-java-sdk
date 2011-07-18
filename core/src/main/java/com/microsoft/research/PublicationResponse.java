
package com.microsoft.research;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Java class for PublicationResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PublicationResponse">
 *   &lt;complexContent>
 *     &lt;extension base="{http://research.microsoft.com}ResultCollection">
 *       &lt;sequence>
 *         &lt;element name="Result" type="{http://research.microsoft.com}ArrayOfPublication" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public class PublicationResponse
    extends ResultCollection
    implements Serializable
{

    private final static long serialVersionUID = 2461660169443089969L;
    protected List<Publication> result;

    /**
     * Gets the value of the result property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfPublication }
     *     
     */
    public List<Publication> getResult() {
    	if (result == null) {
    		result = new ArrayList<Publication>();
    	}
        return result;
    }

    /**
     * Sets the value of the result property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfPublication }
     *     
     */
    public void setResult(List<Publication> value) {
        this.result = value;
    }

}
