package com.example.assg_3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ReadCSV {
    private static List<String> recordList;
    private static int recordCount;
    public ReadCSV(String filepath) {
        recordList = new ArrayList<>();
        String currentLine;

        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            // Read header line (optional)
            br.readLine(); // Skip header line if present

            while ((currentLine = br.readLine()) != null) {
                recordList.add(currentLine);
            }

            recordCount = recordList.size();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public double[][] DoubleArray(int amountOfFields) {
        double[][] arrayToReturn = new double[recordCount][amountOfFields];
        String[] data;

        for (int i = 0; i < recordCount; i++) {
            data = recordList.get(i).split(",");

            // ignoring id and diagnosis columns
            for (int j = 2; j < data.length; j++) {
                arrayToReturn[i][j - 2] = Double.parseDouble(data[j]);
            }
        }
        return arrayToReturn;
    }

    public String[][] StringArray(int amountOfFields) {
        String[][] arrayToReturn = new String[recordCount][amountOfFields];
        String[] data;

        for (int i = 0; i < recordCount; i++) {
            data = recordList.get(i).split(",");

            // extracting first 2 columns: id and diagnosis
            for (int j = 0; j < 2; j++) {
                arrayToReturn[i][j] = data[j];
            }
        }
        return arrayToReturn;
    }
}
