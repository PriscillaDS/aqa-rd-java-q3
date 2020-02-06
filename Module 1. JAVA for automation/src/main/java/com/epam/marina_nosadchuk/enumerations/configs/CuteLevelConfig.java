package com.epam.marina_nosadchuk.enumerations.configs;

import com.epam.marina_nosadchuk.enumerations.CuteLevel;
import com.epam.marina_nosadchuk.enumerations.converters.CuteLevelConverter;
import org.aeonbits.owner.Config;

@Config.Sources("classpath:cuteLevel/cuteLevel.properties")
public interface CuteLevelConfig extends Config{
    @Key("one.prop")
    @ConverterClass(CuteLevelConverter.class)
    CuteLevel getFirstValue();

    @Key("two.prop")
    @ConverterClass(CuteLevelConverter.class)
    CuteLevel getSecondValue();

    @Key("three.prop")
    @ConverterClass(CuteLevelConverter.class)
    CuteLevel getThirdValue();

    @Key("four.prop")
    @ConverterClass(CuteLevelConverter.class)
    CuteLevel getFourthValue();

    @Key("five.prop")
    @ConverterClass(CuteLevelConverter.class)
    CuteLevel getFifthValue();
}
