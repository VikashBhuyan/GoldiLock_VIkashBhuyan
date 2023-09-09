package com.goldilock;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//2. Write a program to read a CSV file and print the same in the output file.
//This csv file contains three columns having numeric value. The output file
//should additionally contain the sum of these numeric values.

public class Question2 {

	public static void main(String[] args) {
		
		 String file1 = "C:\\Users\\Asus\\Desktop\\MasaiPlacementCOmpany\\GoldiLock\\GoldiLock_VIkashBhuyan\\CsvDemoGoldilock.csv";
	     String file2 = "output.csv";

	     readcsv(file1,file2);

	     System.out.println("Output Saved");
	 }

	 public static void readcsv(String inputFile, String outputFile) {
	     try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
	          BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

	         String line;
	         boolean isLine = true;

	         while ((line = reader.readLine()) != null) {
	             String[] data = line.split(",");
	             int sum = sumofvalues(data);
	             String newLine = line + "," + sum;

	             if (isLine) {
	                 isLine = false;
	             } else {
	                 writer.newLine();
	             }

	             writer.write(newLine);
	         }

	     } catch (IOException e) {
	         e.printStackTrace();
	     }
	 }

	 public static int sumofvalues(String[] data) {
	     int sum = 0;
	     for (String value : data) {
	         sum += Integer.parseInt(value);
	     }
	     return sum;
	 }

}
