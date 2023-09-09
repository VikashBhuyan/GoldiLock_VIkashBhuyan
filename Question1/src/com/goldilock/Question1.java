package com.goldilock;

import java.util.Scanner;

//1. Write a function to convert a decimal number string into binary string.
//For example, string A contains “123” which is decimal value 123. Convert
//this string into binary string.

public class Question1 {
	public static String convertToBinary(String decimalNumber) {
		StringBuilder binary = new StringBuilder();
		int decimal = Integer.parseInt(decimalNumber);
		while(decimal>0) {
			int remainder = decimal%2;
			binary.append(remainder);
			decimal = decimal/2;
		}
		return binary.reverse().toString();
	}
	public static void main(String[] args) {
		System.out.println("Enter a Decimal Digit to convert to Binary ");
		Scanner sc = new Scanner(System.in);
		String decimalNumber = sc.next();
		String binary = convertToBinary(decimalNumber);
		System.out.println("The binary representation of "+decimalNumber+" is: "+binary);
		sc.close();
	}
}
