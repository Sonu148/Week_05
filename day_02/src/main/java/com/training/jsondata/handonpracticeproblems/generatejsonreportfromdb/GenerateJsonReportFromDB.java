package com.training.jsondata.handonpracticeproblems.generatejsonreportfromdb;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.*;

public class GenerateJsonReportFromDB {

        public static void main(String[] args) throws Exception {
            // Connect to database and query
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sonu", "username", "password");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT name, age FROM users");

            // Convert ResultSet to JSON
            ObjectMapper mapper = new ObjectMapper();
            while (rs.next()) {
                String json = mapper.writeValueAsString(rs);
                System.out.println(json);
            }

            rs.close();
            stmt.close();
            conn.close();
        }
    }

