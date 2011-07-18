
package com.microsoft.research;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Java class for TrendGraph complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TrendGraph">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Trend" type="{http://research.microsoft.com}ArrayOfTrendPoint" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public class TrendGraph
    implements Serializable
{

    private final static long serialVersionUID = 2461660169443089969L;
    protected List<TrendPoint> trend;

    /**
     * Gets the value of the trend property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfTrendPoint }
     *     
     */
    public List<TrendPoint> getTrend() {
    	if (trend == null) {
    		trend = new ArrayList<TrendPoint>();
    	}
        return trend;
    }

    /**
     * Sets the value of the trend property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfTrendPoint }
     *     
     */
    public void setTrend(List<TrendPoint> value) {
        this.trend = value;
    }

}
