package com.epam.marina_nosadchuk.main;

import com.epam.marina_nosadchuk.animals.Kitty;
import com.epam.marina_nosadchuk.enumerations.CatPosition;
import com.epam.marina_nosadchuk.enumerations.CuteLevel;
import com.epam.marina_nosadchuk.enumerations.DayPart;
import com.epam.marina_nosadchuk.enumerations.holder.PropertyHolder;
import com.epam.marina_nosadchuk.food.EatCharacteristic;
import com.epam.marina_nosadchuk.food.KittyCat;
import com.epam.marina_nosadchuk.humans.Owner;
import lombok.Cleanup;
import lombok.extern.log4j.Log4j;

import java.util.Random;

@Log4j
public class Main {
    public static void main(String[] args) {
        PropertyHolder propertyHolder = new PropertyHolder();

        Owner owner = new Owner();
        owner.setFirstName("Marina");
        owner.setLastName("Nosadchuk");
        Random random = new Random();
        owner.setAge(random.nextInt(30));
        log.debug("New owner: " + owner.toString());

        int flatershyAge = random.nextInt(10);
        log.debug("Age of cat: " + flatershyAge);

        KittyCat food = new KittyCat("Puffy", random.nextFloat() * 10);
        food.setCalorie(propertyHolder.getCalories());
        log.debug("New food for cat : " + food.toString());

        CuteLevel cuteLevelFlatershy = propertyHolder.getCuteLevel();

        @Cleanup("killKitty")
        Kitty flatershy = new Kitty("Flatershy", flatershyAge, owner, cuteLevelFlatershy);
        log.debug("Cat name: " + flatershy.getName());
        log.debug("Cat cute level: " + flatershy.getCuteLevel().toString());
        flatershy.setDailyFood(food);

        EatCharacteristic charact = EatCharacteristic
                .createCharacteristic()
                .catPosition(CatPosition.SET)
                .dayPart(DayPart.DAY)
                .eaten((float) 0.0)
                .build();
        log.debug(String.format("Diet of cat: eaten %s, position %s, day part %s",
                charact.getEaten(), charact.getCatPosition(), charact.getDayPart()));
        flatershy.eatFood(charact);
        log.debug(flatershy.getName() + " ate " + charact.getEaten());

        CuteLevel cuteLevelGloriya = propertyHolder.getCuteLevel();

        int gloriyaAge = random.nextInt(10);

        @Cleanup("killKitty")
        Kitty gloriya = new Kitty("Gloriya", gloriyaAge, owner, cuteLevelGloriya);
        log.debug("Cat name: " + gloriya.getName());
        log.debug("Cat cute level: " + gloriya.getCuteLevel().toString());
        gloriya.setDailyFood(food);

        EatCharacteristic charactForGloriya = EatCharacteristic
                .createCharacteristic()
                .catPosition(CatPosition.LIE)
                .dayPart(DayPart.EVENING)
                .eaten((float) 5.0)
                .build();
        log.debug(String.format("Diet of cat: eaten %s, position %s, day part %s",
                charactForGloriya.getEaten(), charactForGloriya.getCatPosition(), charactForGloriya.getDayPart()));
        log.debug(gloriya.getName() + " daily food " + gloriya.getDailyFood().getWeight());
        gloriya.eatFood(charactForGloriya);
        log.debug(gloriya.getName() + " left to eat " + gloriya.getDailyFood().getWeight());
    }
}
