package md.kniga.backendOnlineShop.dto;

import org.springframework.util.StopWatch;

import java.util.*;

public class Testing {




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



    public static Integer minValue2(int[] a){

        Arrays.sort(a);
        int in;
        for (int i = 1; i < a.length; ++i){
            in = a[i-1];
            if(in > 0){
                if ((in +1 != a[i]) && (in != a[i])){
                    return in+1;
                }
                if (i == a.length - 1){
                    return a[i] + 1;
                }
            }
        }
        return 1;
    }

    public static void main(String[] args) {

        int[] a = {1, 2, 3};
//        int[] a = new int[1000000];
//        for (int i = 0; i < 20; ++i){
//            a[i] = new Random().nextInt(100);
//            System.out.println(a[i]);
//        }

        StopWatch stopWatch2 = new StopWatch();
        stopWatch2.start();
        System.out.println("min related value: " + minValue2(a));
        stopWatch2.stop();
        System.out.println("with loop for: " + stopWatch2.getTotalTimeSeconds());
    }
}
