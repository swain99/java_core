package org.example.recursion;

public class PrintNumber {
    static void printNumber(int n){
        if(n==0){
            System.out.println("Number : "+ n);
            return;
        }
        System.out.println("Number : "+n);
        printNumber(n-1);
    }

    public static void main(String[] args) {
        printNumber(10);
    }
}
