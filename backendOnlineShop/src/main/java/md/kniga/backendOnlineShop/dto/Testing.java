package md.kniga.backendOnlineShop.dto;

import org.springframework.util.StopWatch;

import java.util.*;
import java.util.stream.Collectors;

public class Testing {

    public static Integer maxValue1(int[] a){


//        Task description
//        Task
//        This is a demo task.
//
//                Write a function:
//
//        class Solution { public int solution(int[] A); }
//
//        that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
//
//        For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
//
//        Given A = [1, 2, 3], the function should return 4.
//
//        Given A = [−1, −3], the function should return 1.
//
//        Write an efficient algorithm for the following assumptions:
//
//        N is an integer within the range [1..100,000];
//        each element of array A is an integer within the range [−1,000,000..1,000,000].
//        Copyright 2009–2018 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.

        //return Collections.max(Arrays.stream(a).boxed().collect(Collectors.toList()));
        //Arrays.stream(a).boxed().sorted().filter(b -> b > 0 & )
        TreeSet<Integer> list = new TreeSet<>();
        for(int el: a){
            list.add(el);
        }
        return list.first();
    }

    public static Integer maxValue2(int[] a){

        int res;
        int min = a[0];
        List<Integer> list = new ArrayList<>();
        for(int el: a){
            //list.add(el);
            if (el < min && el != 0){
                min = el;
            }
        }

        min = Collections.min(list);
        int index = list.indexOf(min);



        return Collections.max(list);
    }

    public static void main(String[] args) {

        int[] a = new int[10000000];
        for (int i = 0; i < 10000000; ++i){
            a[i] = i;
        }

        StopWatch stopWatch1 = new StopWatch();
        stopWatch1.start();
        maxValue1(a);
        stopWatch1.stop();
        StopWatch stopWatch2 = new StopWatch();
        stopWatch2.start();
        maxValue2(a);
        stopWatch2.stop();
        System.out.println("with stream: " + stopWatch1.getTotalTimeSeconds());
        System.out.println("with loop for: " + stopWatch2.getTotalTimeSeconds());
    }
}
