package com.epam.mjc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return x -> {
            for (String s :
                    x) {
                if (!Character.isUpperCase(s.charAt(0))) {
                    return false;
                }
            }
            return true;
        };

    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return x -> {
            int size = x.size();
            for (int i = 0; i < size; i++) {
                if (x.get(i) % 2 == 0) {
                    x.add(x.get(i));
                }
            }
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        {
            return () -> {
                int size = values.size();
                List<String> result = new ArrayList<>();

                for (int i = 0; i < size; i++) {
                    String string = values.get(i);

                    if (Character.isUpperCase(string.charAt(0)) && '.' == string.charAt(string.length() - 1) && string.split(" ").length > 3) {
                        result.add(string);
                    }
                }
                return result;
            };

        }

    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        {
            return x -> {
                Map<String, Integer> resultMap = new HashMap<>();
                for (int i = 0; i < x.size(); i++) {
                    String key = x.get(i);
                    int value = key.length();
                    resultMap.put(key, value);
                }

                return resultMap;

            };
        }
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2) -> {
            List<Integer> integerList = new ArrayList<>();
            integerList.addAll(list1);
            integerList.addAll(list2);


            return integerList;
        };
    }
}
