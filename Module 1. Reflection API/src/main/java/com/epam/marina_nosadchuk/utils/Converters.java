package com.epam.marina_nosadchuk.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public final class Converters {
    private static Properties properties;

    public static Properties getInstance() {
        if (properties == null) {
            try {
                properties = new Properties();
                FileInputStream input = new FileInputStream("src/main/resources/calories/calories.properties");
                properties.load(input);
            } catch (IOException message) {
                message.printStackTrace();
            }
        }
        return properties;
    }

    public int getProperty(String key) {
        return Integer.parseInt(getInstance().getProperty(key));
    }
}
