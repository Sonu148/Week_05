package com.training.jsondata.practiceproblems.createjsonobjectforstudent;
import org.json.JSONArray;
import org.json.JSONObject;

public class CreateJsonObjectForStudent {
    public static void main(String[] args) {

               JSONArray subjectArray = new JSONArray();
               subjectArray.put("Maths");
               subjectArray.put("Programming");
               subjectArray.put("Dsa");

               JSONObject field = new JSONObject();
               field.put("name", "Aman");
               field.put("age", 21);
               field.put("subjects", subjectArray);
               System.out.println(field);
           }
}
