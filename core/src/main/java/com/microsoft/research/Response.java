
package com.microsoft.research;

import java.io.Serializable;

/**
 * <p>Java class for Response complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Author" type="{http://research.microsoft.com}AuthorResponse" minOccurs="0"/>
 *         &lt;element name="Conference" type="{http://research.microsoft.com}ConferenceResponse" minOccurs="0"/>
 *         &lt;element name="Domain" type="{http://research.microsoft.com}DomainResponse" minOccurs="0"/>
 *         &lt;element name="Journal" type="{http://research.microsoft.com}JournalResponse" minOccurs="0"/>
 *         &lt;element name="Keyword" type="{http://research.microsoft.com}KeywordResponse" minOccurs="0"/>
 *         &lt;element name="Organization" type="{http://research.microsoft.com}OrganizationResponse" minOccurs="0"/>
 *         &lt;element name="Publication" type="{http://research.microsoft.com}PublicationResponse" minOccurs="0"/>
 *         &lt;element name="ResultCode" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/>
 *         &lt;element name="Trend" type="{http://research.microsoft.com}TrendGraph" minOccurs="0"/>
 *         &lt;element name="Version" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public class Response
    implements Serializable
{

    private final static long serialVersionUID = 2461660169443089969L;
    protected AuthorResponse author;
    protected ConferenceResponse conference;
    protected DomainResponse domain;
    protected JournalResponse journal;
    protected KeywordResponse keyword;
    protected OrganizationResponse organization;
    protected PublicationResponse publication;
    protected Long resultCode;
    protected TrendGraph trend;
    protected String version;

    /**
     * Gets the value of the author property.
     * 
     * @return
     *     possible object is
     *     {@link AuthorResponse }
     *     
     */
    public AuthorResponse getAuthor() {
        return author;
    }

    /**
     * Sets the value of the author property.
     * 
     * @param value
     *     allowed object is
     *     {@link AuthorResponse }
     *     
     */
    public void setAuthor(AuthorResponse value) {
        this.author = value;
    }

    /**
     * Gets the value of the conference property.
     * 
     * @return
     *     possible object is
     *     {@link ConferenceResponse }
     *     
     */
    public ConferenceResponse getConference() {
        return conference;
    }

    /**
     * Sets the value of the conference property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConferenceResponse }
     *     
     */
    public void setConference(ConferenceResponse value) {
        this.conference = value;
    }

    /**
     * Gets the value of the domain property.
     * 
     * @return
     *     possible object is
     *     {@link DomainResponse }
     *     
     */
    public DomainResponse getDomain() {
        return domain;
    }

    /**
     * Sets the value of the domain property.
     * 
     * @param value
     *     allowed object is
     *     {@link DomainResponse }
     *     
     */
    public void setDomain(DomainResponse value) {
        this.domain = value;
    }

    /**
     * Gets the value of the journal property.
     * 
     * @return
     *     possible object is
     *     {@link JournalResponse }
     *     
     */
    public JournalResponse getJournal() {
        return journal;
    }

    /**
     * Sets the value of the journal property.
     * 
     * @param value
     *     allowed object is
     *     {@link JournalResponse }
     *     
     */
    public void setJournal(JournalResponse value) {
        this.journal = value;
    }

    /**
     * Gets the value of the keyword property.
     * 
     * @return
     *     possible object is
     *     {@link KeywordResponse }
     *     
     */
    public KeywordResponse getKeyword() {
        return keyword;
    }

    /**
     * Sets the value of the keyword property.
     * 
     * @param value
     *     allowed object is
     *     {@link KeywordResponse }
     *     
     */
    public void setKeyword(KeywordResponse value) {
        this.keyword = value;
    }

    /**
     * Gets the value of the organization property.
     * 
     * @return
     *     possible object is
     *     {@link OrganizationResponse }
     *     
     */
    public OrganizationResponse getOrganization() {
        return organization;
    }

    /**
     * Sets the value of the organization property.
     * 
     * @param value
     *     allowed object is
     *     {@link OrganizationResponse }
     *     
     */
    public void setOrganization(OrganizationResponse value) {
        this.organization = value;
    }

    /**
     * Gets the value of the publication property.
     * 
     * @return
     *     possible object is
     *     {@link PublicationResponse }
     *     
     */
    public PublicationResponse getPublication() {
        return publication;
    }

    /**
     * Sets the value of the publication property.
     * 
     * @param value
     *     allowed object is
     *     {@link PublicationResponse }
     *     
     */
    public void setPublication(PublicationResponse value) {
        this.publication = value;
    }

    /**
     * Gets the value of the resultCode property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getResultCode() {
        return resultCode;
    }

    /**
     * Sets the value of the resultCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setResultCode(Long value) {
        this.resultCode = value;
    }

    /**
     * Gets the value of the trend property.
     * 
     * @return
     *     possible object is
     *     {@link TrendGraph }
     *     
     */
    public TrendGraph getTrend() {
        return trend;
    }

    /**
     * Sets the value of the trend property.
     * 
     * @param value
     *     allowed object is
     *     {@link TrendGraph }
     *     
     */
    public void setTrend(TrendGraph value) {
        this.trend = value;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

}
