package com.batch1.FitnessProgramEligibility;
import java.util.*;
import com.cortes.Validation;

public class Execution {
    Scanner sc = new Scanner(System.in);
    Implementor[] implement = new Implementor[100];
    Validation v = new Validation();
    
    String status;
    boolean input = true;
    
    int id, app;
    String name;
    
    public void inputRecord(){
    	
        System.out.println("Fitness Program Eligibility\n");
        System.out.print("Enter number of applicants: ");
        app = v.validateInt();
        
        for(int i = 0; i < app; i++){
            System.out.printf("\nEnter details of application %d: \n",(i+1));
            System.out.print("ID: ");
            id = v.validateInt();
            System.out.print("Name: ");
            name = sc.next();
            
            while(v.validateName(name)) {
            	System.out.print("Invalid Input: Numbers or special characters are not allowed, try again: ");
            	name = sc.next();
            }
            
            System.out.print("Age: ");
            int age = v.validateInt();
            
            while(true) {
            	if(!(age > 0 && age <100)) {
                	System.out.print("Invalid Input: Age must not be below 1 or above 99, try again: ");
                	age = v.validateInt();
                } else {
                	break;
                }
            }
            
            System.out.print("BMI: ");
            double bmi = sc.nextDouble();
            System.out.print("Fitness Goals: ");
            String goal = sc.nextLine();
            
            implement[i] = new Implementor();     
            implement[i].addRecord(id, name, age, bmi, goal, criteria(age, bmi, goal));
        }
        
        System.out.printf("\n%-5s %-10s %-5s %-5s %-20s %-20s\n", "ID", "Name", "Age", "BMI", "Fitness Goals", "Eligibility Status");
        
        for(int i = 0; i < app; i++){
            implement[i].viewRecord();
        }
    }
    
    public String criteria(int cage, double cbmi, String cgoal){
        if(cage < 18){
                status = "Not Eligible (Age too low)";
            } else if(cage > 65){
                status = "Not Eligible (Age too high)";
            } else if(cbmi < 18.5){
                status = "Not eligible (BMI too low)";
            } else if(cbmi > 30.0){
                status = "Not eligible (BMI too high)";
            } else if(!(cgoal.equals("Weight Loss") || cgoal.equals("Muscle Gain") || cgoal.equals("General Fitness"))){
                status = "Not eligible (Not a valid goal)";
            } else{
                status = "Eligible";
            }
        return status;
    }
    
}
