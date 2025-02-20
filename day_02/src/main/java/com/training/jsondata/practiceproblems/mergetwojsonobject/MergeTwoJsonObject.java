package com.training.jsondata.practiceproblems.mergetwojsonobject;
import org.json.JSONObject;

public class MergeTwoJsonObject {
        public static void main(String[] args) {
            // Create the first JSON object
            JSONObject jsonObj1 = new JSONObject();
            jsonObj1.put("name", "Aman");
            jsonObj1.put("age", 22);

            // Create the second JSON object
            JSONObject jsonObj2 = new JSONObject();
            jsonObj2.put("city", "Bhopal");
            jsonObj2.put("country", "India");

            // Merge the two JSON objects
            JSONObject mergedJson = new JSONObject(jsonObj1.toString());
            for (String key : jsonObj2.keySet()) {
                mergedJson.put(key, jsonObj2.get(key));
            }

            // Print the merged JSON object
            System.out.println(mergedJson.toString(2));
        }
    }

