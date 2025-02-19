package com.training.csvdatahandling.basicproblems.writecsvfile;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteCsvFile {
    public static void main(String[] args) {
        // path of the empty file
        String filePath="src/main/java/com/training/csvdatahandling/basicproblems/writecsvfile/empty.csv";

        // try with resource in which the fileWriter used to write the data
        try(BufferedWriter bw= new BufferedWriter(new FileWriter(filePath))){
            bw.write("ID, Name, Age, Marks\n");
            bw.write("101, Rohit, 22, 76\n");
            bw.write("102, Aman, 24, 83\n");
            // print the message after successfully completion of the data
            System.out.println("The csv file written successfully!");

        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
