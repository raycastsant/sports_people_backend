package com.sportspeople.main.controller.helpers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IterableHelper {

    private IterableHelper() {
        throw new AssertionError("This class cannot be instantiatied");
    }

    public static <T> List<T> iterableToList(Iterable<T> iterable) {

        if (iterable == null) {
            return Collections.emptyList();
        }

        List<T> result = new ArrayList<>();
        iterable.forEach(result::add);

        return result;
    }
}
