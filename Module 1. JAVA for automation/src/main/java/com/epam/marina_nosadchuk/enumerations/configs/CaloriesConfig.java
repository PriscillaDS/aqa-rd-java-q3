package com.epam.marina_nosadchuk.enumerations.configs;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:calories/calories.properties")
public interface CaloriesConfig extends Config{
    @Key("one.prop")
    String getFirstValue();

    @Key("two.prop")
    String getSecondValue();

    @Key("three.prop")
    String getThirdValue();

    @Key("four.prop")
    String getFourthValue();

    @Key("five.prop")
    String getFifthValue();
}
