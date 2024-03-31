package com.example.assg_3;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        String filePath = "C:\\Users\\kharl\\IdeaProjects\\Sem_2\\src\\com\\example\\assg_3\\Experiment_data.csv";

        // Reading CSV data into 2 arrays: diagnosis and values
        ReadCSV readCSV = new ReadCSV(filePath);
        double[][] data_values = readCSV.DoubleArray(30);
        String[][] data_diagnosis = readCSV.StringArray(2);

        DistanceMatrixCalculator calculator = new DistanceMatrixCalculator(data_values, data_diagnosis);
        double[][] distanceMatrix = calculator.getDistanceMatrix();
        int[][] nearestNeighbors = calculator.findNearestNeighbors(3);
//        System.out.println("Number of rows: " + data.length);
//        System.out.println("Number of columns: " + data[0].length);
//        for (int i = 0; i < data.length; i++) {
//            System.out.println(String.join(",", data[i]));
//        }

//        PrintArray.printArray(data_values);
//        PrintArray.printArray(data_diagnosis);
//        PrintArray.printArray(distanceMatrix);
//        PrintArray.printArray(nearestNeighbors);
//        System.out.println(Arrays.deepToString(data_values).replace("], ", "],\n"));
//        System.out.println(Arrays.deepToString(data_diagnosis).replace("], ", "],\n"));
//        System.out.println(Arrays.deepToString(distanceMatrix).replace("], ", "],\n"));
        System.out.println(Arrays.deepToString(nearestNeighbors).replace("], ", "],\n"));
//        System.out.println(nearestNeighbors.length);
    }


}
