package com.training.csvdatahandling.advanceproblems.generatecsvreportfromdatabase;
import java.io.*;
import java.sql.*;

public class CSVReportFromDB {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/yourdb";
        String csvFile = "employee_report.csv";

        try (Connection connection = DriverManager.getConnection(jdbcURL, "user", "password");
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery("SELECT employee_id, name, department, salary FROM employees");
             BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile))) {

            writer.write("Employee ID,Name,Department,Salary\n");

            while (rs.next()) {
                writer.write(rs.getInt("employee_id") + "," +
                        rs.getString("name") + "," +
                        rs.getString("department") + "," +
                        rs.getDouble("salary") + "\n");
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
