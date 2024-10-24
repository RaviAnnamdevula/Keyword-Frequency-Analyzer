package org.LambdaFunctions;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

public class Client {
    public static void main(String[] args) {
        // anonymous function
        // Calculator is an Interface
        Calculator calculator =  new Calculator() {
            @Override
            public int add(int a, int b) {
                return a+b;
            }
        };
        System.out.println(calculator.add(2,3));

        // Lambda function it will only work with the functional interfaces
        Calculator c1 = (a,b) -> a+b;
        System.out.println(c1.add(2,6));

        Calculator c2 = (a,b) ->{
            System.out.println("I created a lambda expression with same functionality of  anonymous function");
            return a+b;
        };



        //Arrays given = {1,2,3,4,5,6,7,8,9,10}
        // filter out only even numbers -> 2,4,6,8,10
        // 4+16+36+64+100 ==220

        // Iterative way of coding
        int sum = 0;
        List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        for(int num : nums){
            if(num %2 == 0){
                sum += num*num;
            }
        }
        System.out.println("sum is "+ sum);

        long start = System.currentTimeMillis();


        //Declarative way of coding -> declare first what you want to do
        // intermediate methods which return type is stream, like filter function and map function etc...
        // Terminating methods are which return another other type than stream, like reduce, collect , foreach etc...

        // Optional<Integer> ans = nums.stream().parallel().filter(new Predicate<Integer>() ---> for parallel streaming
       // Optional<Integer> ans = nums.parallelStream().filter(new Predicate<Integer>() ---> for parallel streaming another way


/*int ans*/
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

        long end =  System.currentTimeMillis();

        System.out.println("Time difference is "+ (end - start));
        //you can apply any number of methods on stream
        //terminal methods -> terminate your stream u will not use any other terminal method from stream interface


        // Same in lambda function instead of anonymous function like above
        int ans1 = nums.stream().filter(i -> i%2==0).map(i -> i*i).reduce(0,(a , b)->a+b);
        System.out.println("ans1 is "+ans1);

    }
}
