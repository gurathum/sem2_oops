package com.example.assg_3;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        String filePath = "C:\\Users\\kharl\\IdeaProjects\\Sem_2\\src\\com\\example\\assg_3\\Experiment_sample.csv";

        // Reading CSV data into 2 arrays: diagnosis and values
        ReadCSV readCSV = new ReadCSV(filePath);
        double[][] data_values = readCSV.DoubleArray(30);
        String[][] data_diagnosis = readCSV.StringArray(2);

        DistanceMatrixCalculator calculator = new DistanceMatrixCalculator(data_values, data_diagnosis);
        double[][] distanceMatrix = calculator.getDistanceMatrix();
        String[][] nearestNeighbors = calculator.findNearestNeighbors(3);
//        int[][] nearestNeighbors = calculator.findNearestNeighbors(3);

        DiagnosisPredictor predictor = new DiagnosisPredictor(nearestNeighbors, data_diagnosis);
        boolean[] predictionResults = predictor.predictAndCompareDiagnosis();
        int numCorrect = predictor.countCorrectPredictions(predictionResults);
        double analysisPercent = predictor.getAnalysis();


//        PrintArray.printArray(data_values);
        PrintArray.printArray(data_diagnosis);
        PrintArray.printArray(distanceMatrix);
        PrintArray.printArray(nearestNeighbors);
        System.out.println(Arrays.toString(predictionResults));
        System.out.println(numCorrect);
        System.out.format("%.2f", analysisPercent*100);
    }


}
