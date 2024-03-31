package com.example.assg_3;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DistanceMatrixCalculator extends DistanceCalculator {
    /**
     * Stores the calculated distances between all pairs of samples.
     */
    private final double[][]  distanceMatrix;
    /**
     * Stores the original data points (feature vectors).
     */
    private final double[][] data;
    private final String[][] data_diagnosis;

    /**
     * Constructor to initialize the distance matrix calculation.
     *
     * @param data          The input data points as a 2D double array.
     * @param dataDiagnosis
     */
    public DistanceMatrixCalculator(double[][] data, String[][] dataDiagnosis) {
        this.data = data;
        this.data_diagnosis = dataDiagnosis;

        distanceMatrix = new double[data.length][data.length];

        for (int i = 0; i < data.length; i++) {
            for (int j = i; j < data.length; j++) {
                // Calculate the distance between samples i and j using the BaseClass method
                distanceMatrix[i][j] = calculateDistance(data[i], data[j]);
                // Since distance is symmetric, also populate the corresponding position in the lower triangle
                distanceMatrix[j][i] = distanceMatrix[i][j];
            }
        }
    }

    public double[][] getDistanceMatrix() {
        return distanceMatrix;
    }

    public int[][] findNearestNeighbors(int N) {
        int numSamples = distanceMatrix.length;
        int[][] nearestNeighbors = new int[numSamples][N];
        String[][] diagnosisResult = new String[numSamples][N];

        for (int i = 0; i < numSamples; i++) {
            // Create a temporary array to store neighbor indices and distances (can be a custom class)
            List<Neighbor> neighbors = new ArrayList<>();
            for (int j = 0; j < numSamples; j++) {
                if (i != j) { // Exclude the sample itself
                    neighbors.add(new Neighbor(j, distanceMatrix[i][j]));
                }

            }

            // Sort neighbors by distance (ascending order - closest first)
            neighbors.sort(Comparator.comparingDouble(Neighbor::getDistance));

            // Extract top N neighbor indices
            for (int j = 0; j < Math.min(N, neighbors.size()); j++) {
                int index = neighbors.get(j).getIndex();
                nearestNeighbors[i][j] = index;
                diagnosisResult[i][j] = Result.diagnosisOutput(data_diagnosis, index, i);

            }
        }
        PrintArray.printArray(diagnosisResult);
        return nearestNeighbors;
    }

    private static class Neighbor {
        private final int index;
        private final double distance;

        public Neighbor(int index, double distance) {
            this.index = index;
            this.distance = distance;
        }

        public int getIndex() {
            return index;
        }

        public double getDistance() {
            return distance;
        }
    }

    private static class Result {
        public static String diagnosisOutput(String[][] data_diagnosis, int index, int sno) {
            String id = data_diagnosis[index][0];
            String diagnosis = data_diagnosis[index][1];
            return sno + "-" + id + "-" + diagnosis;
        }
    }
}

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