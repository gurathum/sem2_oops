package com.example.assg_3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class NearestNeighbors {
    public static String[][] findNearestNeighbors(int N, double[][] distanceMatrix, String[][] dataDiagnosis) {
        int numSamples = distanceMatrix.length;
        String[][] nearestNeighbors = new String[numSamples][N];

        for (int i = 0; i < numSamples; i++) {
            // Create a temporary array to store neighbor indices and distances
            List<Neighbor> neighbors = new ArrayList<>();
            for (int j = 0; j < numSamples; j++) {
                if (i != j) { // Exclude the sample itself
                    neighbors.add(new Neighbor(j, distanceMatrix[i][j]));
                }
            }

            // Sort neighbors by distance (ascending order - closest first)
            neighbors.sort(Comparator.comparingDouble(Neighbor::getDistance));

            // Extract top N neighbor diagnoses
            for (int j = 0; j < Math.min(N, neighbors.size()); j++) {
                int index = neighbors.get(j).getIndex();
                nearestNeighbors[i][j] = Result.diagnosisOutput(dataDiagnosis, index);
            }
        }

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
        public static String diagnosisOutput(String[][] data_diagnosis, int index) {
            String id = data_diagnosis[index][0];
            String diagnosis = data_diagnosis[index][1];
            return diagnosis;
        }
    }
}
