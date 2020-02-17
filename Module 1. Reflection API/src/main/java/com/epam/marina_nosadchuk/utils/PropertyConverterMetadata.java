package com.epam.marina_nosadchuk.utils;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class PropertyConverterMetadata {

    private Class converterClass;
    private String converterMethod;

}
