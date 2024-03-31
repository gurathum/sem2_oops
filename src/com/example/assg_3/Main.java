package com.example.assg_3;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        String filePath_values = "C:\\Users\\kharl\\IdeaProjects\\Sem_2\\src\\com\\example\\assg_3\\Experiment_values.csv";
        String filePath_diagnosis = "C:\\Users\\kharl\\IdeaProjects\\Sem_2\\src\\com\\example\\assg_3\\Experiment_diagnosis.csv";

        double[][] data_values = ReadCSV.DoubleArray(filePath_values, 30);
        String[][] data_diagnosis = ReadCSV.StringArray(filePath_diagnosis, 2);

        DistanceMatrixCalculator calculator = new DistanceMatrixCalculator(data_values, data_diagnosis);
        double[][] distanceMatrix = calculator.getDistanceMatrix();
        int[][] nearestNeighbors = calculator.findNearestNeighbors(3);
//        System.out.println("Number of rows: " + data.length);
//        System.out.println("Number of columns: " + data[0].length);
//        for (int i = 0; i < data.length; i++) {
//            System.out.println(String.join(",", data[i]));
//        }
        System.out.println(Arrays.deepToString(data_values).replace("], ", "],\n"));
        System.out.println(Arrays.deepToString(data_diagnosis).replace("], ", "],\n"));
        System.out.println(Arrays.deepToString(distanceMatrix).replace("], ", "],\n"));
        System.out.println(Arrays.deepToString(nearestNeighbors).replace("], ", "],\n"));
//        System.out.println(nearestNeighbors.length);
    }
}

class ReadCSV {
    public static double[][] DoubleArray(String filepath, int amountOfFields) {
        List<String> recordList = new ArrayList<String>();

        String delimiter = ",";
        String currentLine;

        try {
            FileReader fr = new FileReader(filepath);
            BufferedReader br = new BufferedReader(fr);

            // Read header line (optional)
            br.readLine(); // Skip header line if present

            while((currentLine = br.readLine()) != null) {
                recordList.add(currentLine);
            }

            int recordCount = recordList.size();

            double[][] arrayToReturn = new double[recordCount][amountOfFields];
            String[] data;

            for (int i = 0; i < recordCount; i++) {
                data = recordList.get(i).split(delimiter);

                // ignoring id and diagnosis columns - BUG
                for (int j = 0; j < data.length; j++) {
                    double value = Double.parseDouble(data[j]);
                    arrayToReturn[i][j] = value;
                }
            }

            return arrayToReturn;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public static String[][] StringArray(String filepath, int amountOfFields) {
        List<String> recordList = new ArrayList<String>();

        String delimiter = ",";
        String currentLine;

        try {
            FileReader fr = new FileReader(filepath);
            BufferedReader br = new BufferedReader(fr);

            // Read header line (optional)
            br.readLine(); // Skip header line if present

            while((currentLine = br.readLine()) != null) {
                recordList.add(currentLine);
            }

            int recordCount = recordList.size();

            String[][] arrayToReturn = new String[recordCount][amountOfFields];
            String[] data;

            for (int i = 0; i < recordCount; i++) {
                data = recordList.get(i).split(delimiter);

                // ignoring id and diagnosis columns - BUG
                for (int j = 0; j < data.length; j++) {
                    String value = data[j];
                    arrayToReturn[i][j] = value;
                }
            }

            return arrayToReturn;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}

/**
 class ReadCSVTo2DArray {
 private final int amountOfFields;
 private final String delimiter = ",";
 private final int recordCount;
 private final List<String> recordList;

 public ReadCSVTo2DArray(String filepath, int amountOfFields) throws Exception {
 this.amountOfFields = amountOfFields;

 recordList = new ArrayList<String>();
 String currentLine;

 try{
 FileReader fr = new FileReader(filepath);
 BufferedReader br = new BufferedReader(fr);

 // Read header line (optional)
 br.readLine(); // Skip header line if present

 while((currentLine = br.readLine()) != null) {
 recordList.add(currentLine);
 }

 recordCount = recordList.size();
 } catch (Exception e) {
 System.out.println(e);
 throw new Exception(e);
 }
 }

 public double[][] getDoubleData() {
 double[][] arrayToReturn = new double[recordCount][amountOfFields];
 String[] data;

 for (int i = 0; i < recordCount; i++) {
 data = recordList.get(i).split(delimiter);

 // ignoring id and diagnosis columns - BUG
 for (int j = 0; j < data.length; j++) {
 double value = Double.parseDouble(data[j]);
 arrayToReturn[i][j] = value;
 }
 }

 return arrayToReturn;
 }

 public String[][] getStringData() {
 String[][] arrayToReturn = new String[recordCount][amountOfFields];
 String[] data;

 for (int i = 0; i < recordCount; i++) {
 data = recordList.get(i).split(delimiter);

 // ignoring id and diagnosis columns - BUG
 for (int j = 0; j < data.length; j++) {
 String value = data[j];
 arrayToReturn[i][j] = value;
 }
 }

 return arrayToReturn;
 }
 }
 */


/**
 public static double[][] readCSV(String filePath) throws IOException {
 BufferedReader reader = new BufferedReader(new FileReader(filePath));
 String line;

 // Read header line (optional)
 reader.readLine(); // Skip header line if present

 // Get number of rows and columns (assuming consistent data format)
 int numRows = 0;
 int numCols = 0;
 if ((line = reader.readLine()) != null) {
 String[] values = line.split(",");
 numRows = 1;
 numCols = values.length;
 }

 // Create the 2D data array
 double[][] data = new double[numRows][numCols];

 // Read remaining lines and populate the data array
 while ((line = reader.readLine()) != null) {
 String[] values = line.split(",");
 if (values.length != numCols) {
 throw new IOException("Inconsistent data format: Row " + (numRows + 1) + " has different number of columns.");
 }
 for (int col = 0; col < numCols; col++) {
 data[numRows][col] = Double.parseDouble(values[col]);
 }
 numRows++;
 }

 reader.close();
 return data;
 }
*/
