
package com.tigo.xmlns.requestheader.v3;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para CountryContentType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="CountryContentType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="SLV"/>
 *     &lt;enumeration value="GTM"/>
 *     &lt;enumeration value="HND"/>
 *     &lt;enumeration value="BOL"/>
 *     &lt;enumeration value="COL"/>
 *     &lt;enumeration value="PRY"/>
 *     &lt;enumeration value="TCD"/>
 *     &lt;enumeration value="COG"/>
 *     &lt;enumeration value="GHA"/>
 *     &lt;enumeration value="MUS"/>
 *     &lt;enumeration value="RWA"/>
 *     &lt;enumeration value="SEN"/>
 *     &lt;enumeration value="TZA"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CountryContentType")
@XmlEnum
public enum CountryContentType {

    SLV,
    GTM,
    HND,
    BOL,
    COL,
    PRY,
    TCD,
    COG,
    GHA,
    MUS,
    RWA,
    SEN,
    TZA;

    public String value() {
        return name();
    }

    public static CountryContentType fromValue(String v) {
        return valueOf(v);
    }

}
