package com.epam.marina_nosadchuk.utils.interfaces;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:calories/calories.properties")
public interface CaloriesConfigReflection extends Config {
    @Key("one.prop")
    @PropertyConverter(converterClass = CaloriesConfigReflection.class, converterMethod = "getFirstValue")
    int getFirstValue();

    @Key("two.prop")
    @PropertyConverter(converterClass = CaloriesConfigReflection.class, converterMethod = "getFirstValue")
    int getSecondValue();

    @Key("three.prop")
    @PropertyConverter(converterClass = CaloriesConfigReflection.class, converterMethod = "getFirstValue")
    int getThirdValue();

    @Key("four.prop")
    @PropertyConverter(converterClass = CaloriesConfigReflection.class, converterMethod = "getFirstValue")
    int getFourthValue();

    @Key("five.prop")
    @PropertyConverter(converterClass = CaloriesConfigReflection.class, converterMethod = "getFirstValue")
    int getFifthValue();
}
