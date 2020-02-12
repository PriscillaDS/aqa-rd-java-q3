package com.epam.marina_nosadchuk.enumerations.converters;

import com.epam.marina_nosadchuk.enumerations.CuteLevel;
import org.aeonbits.owner.Converter;

import java.lang.reflect.Method;

public class CuteLevelConverter implements Converter<CuteLevel> {
    public CuteLevel convert(Method method, String s) {
        return CuteLevel.valueOf(s);
    }
}
