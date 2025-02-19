package com.training.csvdatahandling.basicproblems.readcsvfile;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadCSVFIle {
    public static void main(String[] args) {
        // file.csv file psth
        String filePath= "src/main/java/com/training/csvdatahandling/basicproblems/readcsvfile/file.csv";

        // try and catch block to handle exception
        try{
            // create a buffer reader to read the file
            BufferedReader br=new BufferedReader(new FileReader(filePath));
            //initialise the string name line
            String line;

            // read the line until its null
            while((line= br.readLine())!=null){
                String [] coloums= line.split(",");
                System.out.println(coloums[0]+" ,  "+coloums[1]+" ,  "+coloums[2]+" ,  "+coloums[3]);
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
