/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.chthonics.proj4j.demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author warwick
 */
public class Proj4jDemoTest {
    
    public Proj4jDemoTest() {
    }

    /**
     * Test of main method, of class Proj4jDemo.
     */
    @Test
    public void testMain() {
    }

    /**
     * Test of convertToProj4jName method, of class Proj4jDemo.
     */
    @Test
    public void testConvertToProj4jName() {
        System.out.println(Proj4jDemo.EBSG_4230_SRSNAME_VALUE + " --> " + Proj4jDemo.convertToProj4jName(Proj4jDemo.EBSG_4230_SRSNAME_VALUE));
        System.out.println(Proj4jDemo.EBSG_4269_SRSNAME_VALUE + " --> " + Proj4jDemo.convertToProj4jName(Proj4jDemo.EBSG_4269_SRSNAME_VALUE));
        System.out.println(Proj4jDemo.EBSG_4322_SRSNAME_VALUE + " --> " + Proj4jDemo.convertToProj4jName(Proj4jDemo.EBSG_4322_SRSNAME_VALUE));
        System.out.println(Proj4jDemo.EBSG_4326_SRSNAME_VALUE + " --> " + Proj4jDemo.convertToProj4jName(Proj4jDemo.EBSG_4326_SRSNAME_VALUE));
        System.out.println(Proj4jDemo.OGC_CRS84_SRSNAME_VALUE + " --> " + Proj4jDemo.convertToProj4jName(Proj4jDemo.OGC_CRS84_SRSNAME_VALUE));
    }
    
}
