package com.epam.marina_nosadchuk.utils.interfaces;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
public @interface PropertyConverter {
    Class converterClass();
    String converterMethod();
}
