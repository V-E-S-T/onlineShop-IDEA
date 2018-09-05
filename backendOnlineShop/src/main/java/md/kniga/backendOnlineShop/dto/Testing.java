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



//    public static Integer minValue2(int[] A){
//
//        if (A.length==1){
//            if(A[0]>0){
//                return A[0] + 1;
//            }
//            else{
//                return 1;
//            }
//        }
//        Arrays.sort(A);
//        for (int el: A){
//            System.out.println(el);
//        }
//
//        int in;
//
//        for (int i = 1; i < A.length; ++i){
//            in = A[i-1];
//            if(in >= 0){
//                if ((in +1 != A[i]) && (in != A[i])){
//                    if (in >= 0){
//                        return in+1;
//                    }
//                }
//                if (i == A.length - 1){
//                    return A[i] + 1;
//                }
//            }
//            else {
//                return 1;
//            }
//        }
//        return 1;
//    }

    public static int solution(String A, String B) {

        String[] strA = A.split("");
        String[] strB = B.split("");

        int counter = 0;

        HashMap<String, Integer> mapvalue = new HashMap<>();
        mapvalue.put("A", 13);
        mapvalue.put("K", 12);
        mapvalue.put("Q", 11);
        mapvalue.put("J", 10);
        mapvalue.put("9", 9);
        mapvalue.put("8", 8);
        mapvalue.put("7", 7);
        mapvalue.put("6", 6);
        mapvalue.put("5", 5);
        mapvalue.put("4", 4);
        mapvalue.put("3", 3);
        mapvalue.put("2", 2);

        for(int i = 0; i < strA.length; ++i){

            if (mapvalue.get(strA[i]) > mapvalue.get(strB[i])){
                counter++;
            }
        }
        return counter;
    }

    public int solution2(int[] A) {

        int max = 0;
        int min = 0;
        for (int i = 0; i < A.length; ++i) {

            if (A[i] > max) {
                max = A[i];
            }
            if (A[i] < min) {
                min = A[i];
            }


        }

        return 1;


        // write your code in Java SE 8
    }

    public static void main(String[] args) {


        String str1="23456789AJKQ";
        StringBuilder sb1=new StringBuilder(1000);
        StringBuilder sb2=new StringBuilder(1000);
        Random r = new Random();

        //System.out.println("\n\t Unique codes are \n\n");
        //for(int i=0;i<10;i++){
            for(int j=0;j<1000;j++){
                sb1.append(str1.charAt(r.nextInt(str1.length())));
                sb2.append(str1.charAt(r.nextInt(str1.length())));
            }
            System.out.println(sb1);
            System.out.println(sb2);
        System.out.println(solution("K", "A"));

        //}
    }
}
