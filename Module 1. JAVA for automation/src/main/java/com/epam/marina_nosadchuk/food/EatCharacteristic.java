package com.epam.marina_nosadchuk.food;

import com.epam.marina_nosadchuk.enumerations.CatPosition;
import com.epam.marina_nosadchuk.enumerations.DayPart;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(builderClassName = "FoodCollector", builderMethodName = "createCharacteristic")
public class EatCharacteristic {
    private float eaten;
    private DayPart dayPart;
    private CatPosition catPosition;
}
