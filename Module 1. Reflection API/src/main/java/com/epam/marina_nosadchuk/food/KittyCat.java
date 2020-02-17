package com.epam.marina_nosadchuk.food;

import lombok.*;

@Getter
@Setter
@ToString(exclude = "calorie")
@EqualsAndHashCode(doNotUseGetters = true)
@RequiredArgsConstructor
public class KittyCat {
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @NonNull
    private String name;
    @NonNull
    private float weight;
    private int calorie;
}
