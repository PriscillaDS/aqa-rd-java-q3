package com.epam.marina_nosadchuk;

import org.aeonbits.owner.Converter;

import java.lang.reflect.Method;

public class SupportedBrowsersConverter implements Converter<SupportedBrowsers> {
    public SupportedBrowsers convert(Method method, String s) {
        return SupportedBrowsers.valueOf(s.toUpperCase());
    }
}