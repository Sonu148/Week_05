package com.training.jsondata.handonpracticeproblems.convertlistjavaobjecttojsonarray;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;

public class ListOfJavaObjectToJson {
    public static void main(String[] args) throws Exception {
        // Create a list of objects
        List<Person> people = new ArrayList<>();
        people.add(new Person("Sonu", 21));
        people.add(new Person("Aman", 22));

        // Convert list of objects to JSON array
        ObjectMapper mapper = new ObjectMapper();
        String jsonArray = mapper.writeValueAsString(people);

        // Print the JSON array
        System.out.println(jsonArray);
    }
}
