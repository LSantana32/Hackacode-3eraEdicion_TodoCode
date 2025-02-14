package com.github.lsantana32.hackacode3.parse;

import java.util.ArrayList;
import java.util.List;

public class IterableToList{
    public static <T> List<T> convert(Iterable<T> iterable) {
        List<T> list = new ArrayList<>();
        iterable.forEach(list::add);
        return list;
    }
}
