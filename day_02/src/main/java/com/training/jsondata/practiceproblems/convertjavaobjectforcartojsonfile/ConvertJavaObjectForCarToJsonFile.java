package com.training.jsondata.practiceproblems.convertjavaobjectforcartojsonfile;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class ConvertJavaObjectForCarToJsonFile {
    public static void main(String[] args) {

        try {
            Car car = new Car("Sedan",500000, "Tata");

            ObjectMapper objectMapper= new ObjectMapper();
            objectMapper.writeValue(new File("src/main/java/com/training/jsondata/practiceproblems/convertjavaobjectforcartojsonfile/output.json"), car);
            System.out.println("The data converted to json file successfully!");

        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
}
