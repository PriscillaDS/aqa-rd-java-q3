package com.epam.marina_nosadchuk.animals;

import com.epam.marina_nosadchuk.enumerations.CuteLevel;
import com.epam.marina_nosadchuk.food.EatCharacteristic;
import com.epam.marina_nosadchuk.food.KittyCat;
import com.epam.marina_nosadchuk.humans.Owner;
import lombok.*;
import lombok.extern.log4j.Log4j;
import org.apache.commons.lang3.StringUtils;

@ToString(callSuper = true)
@Getter
@Setter
@Log4j
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class Kitty extends Animal {
    private @EqualsAndHashCode.Include
    CuteLevel cuteLevel;
    private @EqualsAndHashCode.Include
    Owner owner;
    private KittyCat dailyFood;

    public Kitty(String name, int weight, Owner owner, CuteLevel cuteLevel) {
        super(name, weight);
        this.owner = owner;
        this.cuteLevel = cuteLevel;
        log.info("Cat was born");
    }

    public void eatFood(EatCharacteristic eatCharacteristic){
        if(this.dailyFood.getWeight() == 0.0) {
            log.warn("Cat worried about food shortage");
        }
        else{
            float foodLeft = dailyFood.getWeight() - eatCharacteristic.getEaten();
            if (foodLeft < 0) {
                foodLeft = 0;
            }
            dailyFood.setWeight(foodLeft);
            log.info(StringUtils.replace("Cat name ate", "name", this.name));
        }
    }

    @SneakyThrows
    public void killKitty(){
        log.error(StringUtils.replace("Kitty name was died", "name", this.name));
        if(this.cuteLevel!=CuteLevel.BAD_CAT){
            log.info(StringUtils.replace("Owner name is sad", "name", this.owner.getFirstName()));
        }
        throw new InterruptedException("Cat dead");
    }
}
