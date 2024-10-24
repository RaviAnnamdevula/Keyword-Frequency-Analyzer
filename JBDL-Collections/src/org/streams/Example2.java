package org.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Example2 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("adsfadsf","fads","fd","","fadsf","ff");
        // 1)if the string length is >5 then trim the string to length 5
        // 2)if the letter at starting index  and ending is same then collect in the list
        // 3) print the stream

       List<String> l = list.stream().filter(str -> !str.isEmpty())
                                     .map(str -> str.substring(0,Math.min(str.length(),5)))
                                     .filter(str -> str.charAt(0)==str.charAt(str.length()-1))
                                     .collect(Collectors.toList());

        System.out.println(Runtime.getRuntime().availableProcessors());
        // it prints the number of cores;
        // core is the smallest unit of the cpu

        System.out.println(l);


        // Concurrency --> switching between tasks; in present time the switching is so fast that looks parallel run
        // Parallelism --> example we are listening and eating at the same time
    }
}
