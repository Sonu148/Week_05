package com.training.csvdatahandling.advanceproblems.encryptanddecreyptcsvdata;
import java.io.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class EncryptDecryptCSV {
    private static final String SECRET_KEY = "1234567890123456"; // 16-byte key for AES

    public static String encrypt(String data) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        SecretKeySpec key = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedData = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encryptedData);
    }

    public static String decrypt(String encryptedData) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        SecretKeySpec key = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decodedData = Base64.getDecoder().decode(encryptedData);
        byte[] decryptedData = cipher.doFinal(decodedData);
        return new String(decryptedData);
    }

    public static void main(String[] args) throws Exception {
        String csvFile = "src/main/java/com/training/csvdatahandling/advanceproblems/encryptanddecreyptcsvdata/employees.csv";
        List<String[]> records = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
            String line;
            reader.readLine(); // Skip header
            while ((line = reader.readLine()) != null) {
                String[] record = line.split(",");
                record[2] = encrypt(record[2]);  // Encrypt Salary
                records.add(record);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Decrypt and print the data
        for (String[] record : records) {
            System.out.println(record[0] + " " + record[1] + " " + decrypt(record[2]));
        }
    }
}
