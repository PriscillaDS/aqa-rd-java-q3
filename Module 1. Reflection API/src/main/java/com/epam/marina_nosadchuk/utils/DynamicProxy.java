package com.epam.marina_nosadchuk.utils;

import config.customAnnotation.PropertyConverter;
import config.property.PropertyConverterHandler;
import config.property.PropertyConverterMetadata;
import config.property.PropertyHandler;
import org.aeonbits.owner.Config;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy {
    public static <T extends Config> T getProxy(Class<? extends T> clazz, T createdProxy) {
        PropertyConverterMetadata metadata = new PropertyConverterHandler().process(PropertyHandler.class);

        Object proxy = Proxy.newProxyInstance(createdProxy.getClass().getClassLoader(), new Class<?>[]{clazz}, new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) {
                try {
                    if (method.isAnnotationPresent(PropertyConverter.class)) {
                        Class convertClass = metadata.getConverterClass();
                        Method convertMethod = convertClass.getMethod(metadata.getConverterMethod(), String.class);
                        return convertMethod.invoke(convertClass.newInstance(), method.invoke(createdProxy));
                    } else {
                        return method.invoke(createdProxy);
                    }
                } catch (Exception e) {
                    System.out.println(String.format("Error using reflection %s", e.getMessage()));
                }
                return null;
            }
        });
        return (T) proxy;
    }
}
