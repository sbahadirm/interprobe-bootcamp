package com.bahadirmemis.interprobe.interprobebootcamp;

import org.junit.jupiter.api.*;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
public class TestTest {

    @BeforeAll
    public static void setup(){
        System.out.println("@BeforeAll");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("@AfterAll");
    }

    @BeforeEach
    public void beforeEach(){
        System.out.println("@BeforeEach");
    }

    @AfterEach
    public void afterEach(){
        System.out.println("@AfterEach");
    }

    @Test
    public void test1(){
        System.out.println("test1");
    }

    @Test
    public void test2(){
        System.out.println("test2");
    }

    @Test
    public void test3(){
        System.out.println("test3");
    }
}
