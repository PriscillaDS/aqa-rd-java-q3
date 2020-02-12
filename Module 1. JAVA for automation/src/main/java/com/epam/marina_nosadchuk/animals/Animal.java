package com.epam.marina_nosadchuk.animals;

import lombok.*;

@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(exclude = "weight")
abstract class Animal {
    protected String name;
    @Setter
    protected int weight;
}
