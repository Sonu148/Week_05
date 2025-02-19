package com.training.csvdatahandling.basicproblems.countsrowsincsvfile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CountRowsInCsvFile {
    public static void main(String[] args) {
        // file path of the data cav
        String filePath="src/main/java/com/training/csvdatahandling/basicproblems/countsrowsincsvfile/data.csv";

        // using try with resource which close the file automatically
        try(BufferedReader br= new BufferedReader(new FileReader(filePath))){
            // declare a string variable
           String line;
           // initialise the count -1 to avoid the count of the header line
           int count=-1;
           while((line=br.readLine())!=null){
               // store the line separated with comma
               String [] coloums= line.split(",");
               System.out.println(coloums[0]+" , "+coloums[1]+" , "+coloums[2]+" , "+coloums[3]);
               count++;// increment the count variable
           }
            System.out.println("The total rows: "+count);
        }catch(FileNotFoundException e){
            System.out.println("File not found!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    }
