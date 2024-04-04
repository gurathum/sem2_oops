package com.example.assg_3;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

abstract class DistanceCalculator {
    /**
     * Calculates the Euclidean distance between two data points represented as double arrays.
     *
     * @param arr1 The first data point (feature vector) as a double array.
     * @param arr2 The second data point (feature vector) as a double array.
     * @return The Euclidean distance between the two data points.
     * @throws IllegalArgumentException if the lengths of the arrays are not equal.
     */
    public double calculateDistance(double[] arr1, double[] arr2) throws IllegalArgumentException {
        if (arr1.length != arr2.length) {
            throw new IllegalArgumentException("Arrays must have the same length");
        }
        double sumSquaredDifferences = 0;
        for (int i = 0; i < arr1.length; i++) {
            double difference = arr1[i] - arr2[i];
            sumSquaredDifferences += difference * difference;
        }
        return Math.sqrt(sumSquaredDifferences);
    }
}
public class DistanceMatrixCalculator extends DistanceCalculator {
    /**
     * Stores the calculated distances between all pairs of samples.
     */
    private final double[][]  distanceMatrix;

    /**
     * Stores the original data points (values).
     */
    private double[][] data_values;
    /**
     * Stores the original data diagnosis and id
     */
    private String[][] data_diagnosis;

    /**
     * Constructor to initialize the distance matrix calculation.
     *
     * @param data_values          The input data points as a 2D double array for data values.
     * @param data_diagnosis
     */
    public DistanceMatrixCalculator(double[][] data_values, String[][] data_diagnosis) {
        this.data_values = data_values;
        this.data_diagnosis = data_diagnosis;

        distanceMatrix = new double[this.data_values.length][this.data_values.length];

        for (int i = 0; i < this.data_values.length; i++) {
            for (int j = i; j < this.data_values.length; j++) {
                // Calculate the distance between samples i and j using the BaseClass method
                distanceMatrix[i][j] = calculateDistance(this.data_values[i], this.data_values[j]);
                // Since distance is symmetric, also populate the corresponding position in the lower triangle
                distanceMatrix[j][i] = distanceMatrix[i][j];
            }
        }
    }

    public double[][] getDistanceMatrix() {
        return distanceMatrix;
    }

    public String[][] findNearestNeighbors(int N) {
        return NearestNeighbors.findNearestNeighbors(N, distanceMatrix, data_diagnosis);
    }

}

