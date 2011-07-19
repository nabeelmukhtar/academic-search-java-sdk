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

package com.microsoft.research;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>Java class for CFPInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CFPInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AbstractSubmissionDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="City" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ConferenceEndDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="ConferenceStartDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="Country" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FinalVersionDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="HomepageURL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PaperSubmissionDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="ResultNotificationDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public class CFPInfo
    implements Serializable
{

    private final static long serialVersionUID = 2461660169443089969L;
    protected Date abstractSubmissionDate;
    protected String city;
    protected Date conferenceEndDate;
    protected Date conferenceStartDate;
    protected String country;
    protected Date finalVersionDate;
    protected String homepageURL;
    protected Date paperSubmissionDate;
    protected Date resultNotificationDate;

    /**
     * Gets the value of the abstractSubmissionDate property.
     * 
     * @return
     *     possible object is
     *     {@link Date }
     *     
     */
    public Date getAbstractSubmissionDate() {
        return abstractSubmissionDate;
    }

    /**
     * Sets the value of the abstractSubmissionDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Date }
     *     
     */
    public void setAbstractSubmissionDate(Date value) {
        this.abstractSubmissionDate = value;
    }

    /**
     * Gets the value of the city property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the value of the city property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCity(String value) {
        this.city = value;
    }

    /**
     * Gets the value of the conferenceEndDate property.
     * 
     * @return
     *     possible object is
     *     {@link Date }
     *     
     */
    public Date getConferenceEndDate() {
        return conferenceEndDate;
    }

    /**
     * Sets the value of the conferenceEndDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Date }
     *     
     */
    public void setConferenceEndDate(Date value) {
        this.conferenceEndDate = value;
    }

    /**
     * Gets the value of the conferenceStartDate property.
     * 
     * @return
     *     possible object is
     *     {@link Date }
     *     
     */
    public Date getConferenceStartDate() {
        return conferenceStartDate;
    }

    /**
     * Sets the value of the conferenceStartDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Date }
     *     
     */
    public void setConferenceStartDate(Date value) {
        this.conferenceStartDate = value;
    }

    /**
     * Gets the value of the country property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the value of the country property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountry(String value) {
        this.country = value;
    }

    /**
     * Gets the value of the finalVersionDate property.
     * 
     * @return
     *     possible object is
     *     {@link Date }
     *     
     */
    public Date getFinalVersionDate() {
        return finalVersionDate;
    }

    /**
     * Sets the value of the finalVersionDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Date }
     *     
     */
    public void setFinalVersionDate(Date value) {
        this.finalVersionDate = value;
    }

    /**
     * Gets the value of the homepageURL property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHomepageURL() {
        return homepageURL;
    }

    /**
     * Sets the value of the homepageURL property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHomepageURL(String value) {
        this.homepageURL = value;
    }

    /**
     * Gets the value of the paperSubmissionDate property.
     * 
     * @return
     *     possible object is
     *     {@link Date }
     *     
     */
    public Date getPaperSubmissionDate() {
        return paperSubmissionDate;
    }

    /**
     * Sets the value of the paperSubmissionDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Date }
     *     
     */
    public void setPaperSubmissionDate(Date value) {
        this.paperSubmissionDate = value;
    }

    /**
     * Gets the value of the resultNotificationDate property.
     * 
     * @return
     *     possible object is
     *     {@link Date }
     *     
     */
    public Date getResultNotificationDate() {
        return resultNotificationDate;
    }

    /**
     * Sets the value of the resultNotificationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Date }
     *     
     */
    public void setResultNotificationDate(Date value) {
        this.resultNotificationDate = value;
    }

}
