package com.cortes;
import com.batch1.FitnessProgramEligibility.*;

public class Main {
	public static void main(String []args) {
		Validation v = new Validation();
		Fitness ft = new Fitness();
		
		System.out.print("""
				Program Selector:
				
				Program Menu:
				1. Fitness Program Eligibity
				Enter selection: """);
		int select = v.validateInt();
		
		switch(select) {
		case 1 -> ft.FitnessProgram();
		default -> System.out.println("Invalid Selection.");
		}
	}
}
