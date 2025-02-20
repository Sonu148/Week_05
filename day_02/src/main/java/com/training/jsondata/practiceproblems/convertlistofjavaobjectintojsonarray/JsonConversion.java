package com.training.jsondata.practiceproblems.convertlistofjavaobjectintojsonarray;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
public class JsonConversion {

        public static void main(String[] args) throws Exception {
            // Create a list of Java objects
            List<Person> people = new ArrayList<>();
            people.add(new Person("Sonu", 22));
            people.add(new Person("Aman", 22));
            people.add(new Person("Satyam", 22));

            // Create ObjectMapper instance
            ObjectMapper mapper = new ObjectMapper();

            // Convert list of Java objects into a JSON array
            String jsonArray = mapper.writeValueAsString(people);

            // Print the resulting JSON array
            System.out.println(jsonArray);
        }
    }

