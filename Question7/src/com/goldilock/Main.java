package com.goldilock;

public class Main {
	public static void main(String[] args) {
		if(args.length==0) {
			System.out.println("There are No inputs available..");
		}else {
			System.out.println("The Inputs are: ");
			for(String s:args) {
				System.out.println(s);
			}
		}
	}
}
