package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JavaStreamTest {
    public static void main(String[] args) {
        List<Integer> ageList = Arrays.asList(23, 34, 12, 6, 21, 18, 34, 43, 6, 8, 18);
        List<String> names = Arrays.asList("Rati", "Ram", "Gunu", "Ashvee", "Pragya");
        //Get all name start with "R"
        List<String> ls1 = names.stream().filter(name -> name.startsWith("R")).collect(Collectors.toList());
        System.out.println(ls1);
        //Get all age greater than 20
        List<Integer> ls2 = ageList.stream().filter(age -> age > 20).collect(Collectors.toList());
        System.out.println(ls2);
        //convert all name to lower case starting with "R"
        List<String> ls3 = names.stream().filter(name -> name.startsWith("R")).map(String::toLowerCase).collect(Collectors.toList());
        System.out.println(ls3);
        //Get all age greater than 20 with sorted order
        List<Integer> ls4 = ageList.stream().filter(age -> age > 20).sorted().collect(Collectors.toList());
        System.out.println(ls4);
        //Get all age greater than 20 with sorted order and remove duplicate
        List<Integer> ls5 = ageList.stream().filter(age -> age > 20).sorted().distinct().collect(Collectors.toList());
        System.out.println(ls5);
        //Get all age greater than 20 with sorted order after 3rd element
        List<Integer> ls6 = ageList.stream().filter(age -> age > 20).sorted().skip(3).collect(Collectors.toList());
        System.out.println(ls6);
        //Get all age greater than 20 with sorted order
        List<Integer> ls7 = ageList.stream().filter(age -> age > 20).sorted().map(age-> age+10).collect(Collectors.toList());
        System.out.println(ls7);


    }
}
