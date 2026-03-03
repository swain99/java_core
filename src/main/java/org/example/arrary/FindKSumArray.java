package org.example.arrary;

public class FindKSumArray {
    static void printKSumArray(int[] arr, int k){
        int i = 0;
        int j = k-1;
        int length = arr.length;
        while(i < (length-k)+1){
            int[] sub_arr = new int[k];
            int index =0;
            int sum = 0;
            for ( int a =i ; a <=j ;a++){
                sub_arr[index] = arr [a];
                index++;
                sum = sum + arr[a];
            }
            displayArray(sub_arr, sum);
            i = i+1;
            j = j+1;

        }
    }
    static void displayArray ( int[] arr, int sum){
        String data = "[";
        for(int x : arr){
            data = data + x +",";
        }
        data = data + "]";
        System.out.println(data + "With sum = "+ sum);
    }

    public static void main(String[] args) {
        int[] arr = { 2,3,4,2,8,5,3,1,6,9,2 };
        int k = 3;
        printKSumArray(arr, 3);
    }
}
