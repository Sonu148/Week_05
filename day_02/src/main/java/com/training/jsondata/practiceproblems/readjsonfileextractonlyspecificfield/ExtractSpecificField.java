package com.training.jsondata.practiceproblems.readjsonfileextractonlyspecificfield;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class ExtractSpecificField {
    public static void main(String[] args) throws IOException {

        ObjectMapper objectMapper= new ObjectMapper();
        Person person=objectMapper.readValue(new File("src/main/java/com/training/jsondata/practiceproblems/readjsonfileextractonlyspecificfield/file.json"), Person.class);
        System.out.println("The name is: "+ person.getName());
        System.out.println("The email is: "+ person.getEmail());

    }
}
