package org.example.recursion;

public class FactorialOfNumber {

    static int getFactorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * getFactorial(n - 1);
    }

    public static void main(String[] args) {
        int result = getFactorial(0);
        System.out.println(result);
    }
}
