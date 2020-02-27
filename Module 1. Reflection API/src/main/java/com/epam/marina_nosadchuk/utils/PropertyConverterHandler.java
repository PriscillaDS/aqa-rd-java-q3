package com.epam.marina_nosadchuk.utils;

import com.epam.marina_nosadchuk.utils.interfaces.PropertyConverter;
import com.epam.marina_nosadchuk.utils.interfaces.RuntimeHandler;

import java.lang.reflect.Method;

public class PropertyConverterHandler implements RuntimeHandler {
    @Override
    public PropertyConverterMetadata process(Object parameter) {
        Class clazz = (Class) parameter;
        PropertyConverter annotation;
        for (Method method : clazz.getMethods()) {
//            removeAnnotationFromMethod()
            if (method.isAnnotationPresent(PropertyConverter.class)) {
                annotation = method.getAnnotation(PropertyConverter.class);
                return new PropertyConverterMetadata(annotation.converterClass(), annotation.converterMethod());
            }
        }
        return null;
    }


}
