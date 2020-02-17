package com.epam.marina_nosadchuk.utils.interfaces;

public interface RuntimeHandler<R, P> {
    R process(P parameter);
}
