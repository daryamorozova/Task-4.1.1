package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {
    private Smartphone smartphone = new Smartphone(1, "Honor10", 20000, "Huawei");

    @Test
    public void shouldCompareNameIfExist(){
        String text = "Honor10";
        assertTrue(smartphone.matches(text));
    }

    @Test
    public void shouldCompareNameIfNotExist(){
        String text = "Honor20";
        assertFalse(smartphone.matches(text));
    }

    @Test
    public void shouldCompareVendorIfExist(){
        String text = "Huawei";
        assertTrue(smartphone.matches(text));
    }

    @Test
    public void shouldCompareVendorIfNotExist(){
        String text = "Honor";
        assertFalse(smartphone.matches(text));
    }

}