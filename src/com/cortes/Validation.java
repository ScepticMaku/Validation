package com.cortes;
import java.util.*;

public class Validation {
	Scanner sc = new Scanner(System.in);
	
	int vnum;
	
	public int validateInt() {
		while(true) {
			try {
				vnum = sc.nextInt();
				break;
			} catch(InputMismatchException e) {
				System.out.print("Invalid Input: Must only be a number, try again: ");
	    		sc.next();
			}
		}
		return vnum;
	}
	
	public boolean validateName(String vname) {
		
		boolean isNotAlphabetic = false;
		
		for(char c : vname.toCharArray()) {
			if(!Character.isAlphabetic(c)){
				if(Character.toString(c).equals("'")) {
					return false;
				}
				isNotAlphabetic = true;
			}
		}
		
		if(!isNotAlphabetic) {
			return false;
		}
		
	return true;
	}
}
