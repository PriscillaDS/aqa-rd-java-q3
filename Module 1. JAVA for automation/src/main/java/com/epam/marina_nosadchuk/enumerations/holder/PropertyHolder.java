package com.epam.marina_nosadchuk.enumerations.holder;

import com.epam.marina_nosadchuk.enumerations.CuteLevel;
import com.epam.marina_nosadchuk.enumerations.configs.CaloriesConfig;
import com.epam.marina_nosadchuk.enumerations.configs.CuteLevelConfig;
import org.aeonbits.owner.ConfigFactory;

import java.util.Random;

public class PropertyHolder {
    private CuteLevelConfig cuteLevel = ConfigFactory.create(CuteLevelConfig.class);
    private CaloriesConfig calories = ConfigFactory.create(CaloriesConfig.class);

    public CuteLevel getCuteLevel() {
        Random random = new Random();
        int i = random.nextInt(5);
        switch (i) {
            case (1):
                return cuteLevel.getFirstValue();
            case (2):
                return cuteLevel.getSecondValue();
            case (3):
                return cuteLevel.getThirdValue();
            case (4):
                return cuteLevel.getFourthValue();
            default:
                return cuteLevel.getFifthValue();
        }
    }

    public int getCalories() {
        Random random = new Random();
        int i = random.nextInt(5);
        switch (i) {
            case (1):
                return Integer.parseInt(calories.getFirstValue());
            case (2):
                return Integer.parseInt(calories.getSecondValue());
            case (3):
                return Integer.parseInt(calories.getThirdValue());
            case (4):
                return Integer.parseInt(calories.getFourthValue());
            default:
                return Integer.parseInt(calories.getFifthValue());
        }
    }

}
