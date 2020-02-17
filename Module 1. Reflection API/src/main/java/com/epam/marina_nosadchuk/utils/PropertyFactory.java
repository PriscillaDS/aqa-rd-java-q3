package com.epam.marina_nosadchuk.utils;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;
import org.aeonbits.owner.Factory;

import java.util.Map;
import java.util.Properties;

public class PropertyFactory {
    private static Properties props = new Properties();

    public static <T extends ConfigFactory> T createProperty(Class<? extends T> clazz) {
        return null;
    }

    public static Factory newInstance() {
        return ConfigFactory.newInstance();
    }

    public static <T extends Config> T create(Class<? extends T> clazz, Map<?, ?>... imports) {
        return ConfigFactory.create(clazz, imports);
    }

    public static String setProperty(String key, String value) {
        checkKey(key);
        return (String) props.setProperty(key, value);
    }

    private static void checkKey(String key) {
        if (key == null) {
            throw new NullPointerException("key can't be null");
        } else if (key.isEmpty()) {
            throw new IllegalArgumentException("key can't be empty");
        }
    }

    public static Properties getProperties() {
        return props;
    }

    public static void setProperties(Properties properties) {
        if (properties == null) {
            props = new Properties();
        } else {
            props = properties;
        }

    }

    public static String getProperty(String key) {
        checkKey(key);
        return props.getProperty(key);
    }

    public static String clearProperty(String key) {
        checkKey(key);
        return (String) props.remove(key);
    }
}
