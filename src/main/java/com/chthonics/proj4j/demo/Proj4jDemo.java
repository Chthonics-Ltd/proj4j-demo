/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.chthonics.proj4j.demo;

import org.locationtech.proj4j.CRSFactory;
import org.locationtech.proj4j.CoordinateReferenceSystem;
import org.locationtech.proj4j.CoordinateTransform;
import org.locationtech.proj4j.CoordinateTransformFactory;
import org.locationtech.proj4j.ProjCoordinate;

/**
 *
 * @author warwick
 */
public class Proj4jDemo {

    public static String EBSG_3395_SRSNAME_VALUE = "urn:ogc:def:crs:EPSG::3395";
    public static String EBSG_4230_SRSNAME_VALUE = "urn:ogc:def:crs:EPSG::4230";
    public static String EBSG_4269_SRSNAME_VALUE = "urn:ogc:def:crs:EPSG::4269";
    public static String EBSG_4322_SRSNAME_VALUE = "urn:ogc:def:crs:EPSG::4322";
    public static String EBSG_4326_SRSNAME_VALUE = "urn:ogc:def:crs:EPSG::4326";
    public static String OGC_CRS84_SRSNAME_VALUE = "urn:ogc:def:crs:OGC:1.3:CRS84";

    public static void main(String[] args) {

        CRSFactory crsFactory = new CRSFactory();

        CoordinateReferenceSystem EPSG_3395 = crsFactory.createFromName(convertToProj4jName(EBSG_3395_SRSNAME_VALUE)); // World Mercator (WGS84 Datum)
        CoordinateReferenceSystem EPSG_4230 = crsFactory.createFromName(convertToProj4jName(EBSG_4230_SRSNAME_VALUE));
        CoordinateReferenceSystem EPSG_4269 = crsFactory.createFromName(convertToProj4jName(EBSG_4269_SRSNAME_VALUE));
        CoordinateReferenceSystem EPSG_4322 = crsFactory.createFromName(convertToProj4jName(EBSG_4322_SRSNAME_VALUE));
        CoordinateReferenceSystem EPSG_4326 = crsFactory.createFromName(convertToProj4jName(EBSG_4326_SRSNAME_VALUE));
        CoordinateReferenceSystem OGC_CRS84 = crsFactory.createFromName(convertToProj4jName(OGC_CRS84_SRSNAME_VALUE));

        CoordinateTransformFactory ctFactory = new CoordinateTransformFactory();
        CoordinateTransform wgs84ToMercator = ctFactory.createTransform(EPSG_4326, EPSG_3395);
        ProjCoordinate forwardResult = new ProjCoordinate();
        wgs84ToMercator.transform(new ProjCoordinate(1.0, 0.0), forwardResult);
        System.out.println("WGS84 --> Mercator Result = " + forwardResult);

        CoordinateTransform mercatorToWgs84 = ctFactory.createTransform(EPSG_3395, EPSG_4326);
        ProjCoordinate reverseResult = new ProjCoordinate();
        mercatorToWgs84.transform(forwardResult, reverseResult);
        System.out.println("Mercator --> WGS84 Result = " + reverseResult);

        CoordinateTransform crs84ToWgs84 = ctFactory.createTransform(OGC_CRS84, EPSG_4326);
        crs84ToWgs84.transform(new ProjCoordinate(10.0, 20.0), forwardResult);
        System.out.println("CRS84 --> WGS84 Result = " + forwardResult);
    }

    public static String convertToProj4jName(String srsNameValue) {

        String[] fields = srsNameValue.split(":");

        if ( fields != null
                && fields.length == 7
                && "urn".equals(fields[0])
                && "ogc".equals(fields[1])
                && "def".equals(fields[2])
                && "crs".equals(fields[3])
                && fields[4] != null
                && !fields[4].isEmpty()
                && fields[6] != null
                && !fields[6].isEmpty()) {
            return fields[4] + ":" + fields[6];
        }
        else {
            throw new IllegalArgumentException();
        }

    }
}
