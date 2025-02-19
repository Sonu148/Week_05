package com.training.csvdatahandling.intermediateproblems.filterrecordsfromcsv;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Records {
        public static void main(String[] args) {
            // file.csv file psth
            String filePath= "src/main/java/com/training/csvdatahandling/intermediateproblems/filterrecordsfromcsv/records.csv";

            // try and catch block to handle exception
            try{
                // create a buffer reader to read the file
                BufferedReader br=new BufferedReader(new FileReader(filePath));

                //initialise string to store the records
                String line;

                System.out.println("Eligible students: ");
                // read the line until its null
                while((line= br.readLine())!=null){
                   String[] records=line.split(",");
                   // checking the eligibility of the students
                   if(Integer.parseInt(records[1])>=80){
                       System.out.println(records[0]+ " and marks is : "+records[1]);
                   }
                }
            }catch(IOException e){
                System.out.println(e.getMessage());
            }
        }
    }

