package com.test;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public int[] findNext(int[] A, int n) {
        int[] B = new int[A.length];
        for (int i=0; i<A.length; i++){
            if (i == A.length - 1)
                B[i] = -1;
            else {
                List<Integer> list = new ArrayList<>();
                for (int j = i + 1; j < A.length; j++) {
                    if (A[i] < A[j]) {
                        list.add(A[j]);
                    }
                    if (list.isEmpty()) {
                        B[i] = -1;
                    } else {
                        if (list.size() == 1)
                            B[i] = list.get(0);
                        else
                            B[i] = getMin(list);
                    }
                }
            }
        }
        return B;
    }

    public int getMin(List<Integer> list){
        int[] a = new int[list.size()];
        int min = 0;
        for (int i=0; i<list.size(); i++){
            a[i] = list.get(i);
        }
        for (int i=0; i<a.length-1; i++){
           min = a[i] < a[i+1] ? a[i] : a[i+1];
        }
        return min;
    }

    public static void main(String[] args) throws Exception {
        int[] b = new int[]{11,13,10,5,12,21,3};
        int[] c = new Test().findNext(b,7);
        for (int d : c){
            System.out.print(d+" ");
        }
    }
}
