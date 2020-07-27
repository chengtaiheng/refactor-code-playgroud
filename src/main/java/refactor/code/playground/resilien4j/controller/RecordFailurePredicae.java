package refactor.code.playground.resilien4j.controller;


import refactor.code.playground.resilien4j.exception.BusinessException;

import java.util.function.Predicate;

public class RecordFailurePredicae implements Predicate<Throwable> {
    @Override
    public boolean test(Throwable throwable) {
        return !(throwable instanceof BusinessException);
    }
}
