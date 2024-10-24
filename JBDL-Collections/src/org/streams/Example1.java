package org.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

public class Example1 {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Optional<Integer> ans = nums.stream().parallel().filter(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer%2 ==0;
            }
        }).map(new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return integer*integer;
            }
        }).reduce(0, new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer1, Integer integer2) {
                return integer1+integer2;
            }
        }).describeConstable();
        System.out.println("ans is "+ans);
    }
}
