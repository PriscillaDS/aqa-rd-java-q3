package com.epam.marina_nosadchuk.utils;

import com.epam.marina_nosadchuk.utils.interfaces.PropertyConverter;
import org.aeonbits.owner.Config;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy {
    public static <T extends Config> T createProxy(Class<? extends T> clazz, T myProxy) {
        final PropertyConverterMetadata metadata = new PropertyConverterHandler().process(PropertyConverterHandler.class);
        Object proxy = Proxy.newProxyInstance(myProxy.getClass().getClassLoader(), new Class<?>[]{clazz}, (proxy1, method, args) -> {
            if (method.isAnnotationPresent(PropertyConverter.class)) {
                Class convertClass = metadata.getConverterClass();
                Method convertMethod = convertClass.getMethod(metadata.getConverterMethod(), String.class);
                return convertMethod.invoke(convertClass.newInstance(), method.invoke(myProxy));
            }
            return method.invoke(myProxy);
        });
        return (T) proxy;
    }

}
