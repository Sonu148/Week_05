package com.training.csvdatahandling.intermediateproblems.searchforrecord;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SearchForRecord {
    public static void main(String[] args) {

        // file path of the employee list
        String filePath="src/main/java/com/training/csvdatahandling/intermediateproblems/searchforrecord/employees.csv";

        // using file reader read the file
        try(BufferedReader br= new BufferedReader(new FileReader(filePath))){

          String  line;

          //taking name of the employee for searching
          String name="Bishu";

          // looping to search get the data
            while((line=br.readLine())!=null){

                String [] data= line.split(",");
                if(data[0].equals(name)){

                    //display the department and salary of the employee
                    System.out.println("The departement is "+data[1]+" and the salary is "+data[2]);
                }
            }
        }catch(IOException e){
            System.out.println("File not found!");
        }

    }
}
