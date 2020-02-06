package com.epam.marina_nosadchuk.enumerations;

import org.apache.commons.lang3.StringUtils;

public enum CuteLevel {
    BAD_CAT,
    FAT_CAT,
    CUTE_CAT,
    SOFT_CAT,
    WARM_CAT;


    @Override
    public String toString() {
        return StringUtils.capitalize(StringUtils.lowerCase(StringUtils.replace(name(), "_"," ")));
    }
}
