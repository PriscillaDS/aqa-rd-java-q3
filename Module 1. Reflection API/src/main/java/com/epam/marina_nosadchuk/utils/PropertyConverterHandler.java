package com.epam.marina_nosadchuk.utils;

import com.epam.marina_nosadchuk.utils.interfaces.PropertyConverter;
import com.epam.marina_nosadchuk.utils.interfaces.RuntimeHandler;
import lombok.SneakyThrows;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

public class PropertyConverterHandler implements RuntimeHandler {
    @SneakyThrows
    public void removeAnnotationFromMethod(Method annotatedMethod, Class<? extends Annotation> annotationType) {
        boolean annotatedMethodAccessible;
        boolean annotationsFieldAccessible;

        annotatedMethodAccessible = annotatedMethod.isAccessible();
        annotatedMethod.setAccessible(true);
        annotatedMethod.getDeclaredAnnotations();

        Field annotations = annotatedMethod.getClass().getSuperclass().getDeclaredField("declaredAnnotations");
        annotationsFieldAccessible = annotations.isAccessible();
        annotations.setAccessible(true);

        ((Map<Class<? extends Annotation>, Annotation>) annotations.get(annotatedMethod)).remove(annotationType);

        annotations.setAccessible(annotationsFieldAccessible);
        annotatedMethod.setAccessible(annotatedMethodAccessible);
    }


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
