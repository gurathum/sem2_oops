package com.example.assg_3;

import java.util.HashMap;
import java.util.Map;

public class DiagnosisPredictor {
    private final String[][] nearestNeighbors;
    private final String[][] actualDiagnosis;
    private int numCorrect = 0;

    public DiagnosisPredictor(String[][] nearestNeighbors, String[][] actualDiagnosis) {
        this.nearestNeighbors = nearestNeighbors;
        this.actualDiagnosis = actualDiagnosis;
    }

    public boolean[] predictAndCompareDiagnosis() {
        int numSamples = nearestNeighbors.length;
        boolean[] isCorrect = new boolean[numSamples];

        for (int i = 0; i < numSamples; i++) {
            // Count occurrences of each diagnosis class (B or M)
            Map<String, Integer> diagnosisCounts = new HashMap<>();
            for (int j = 0; j < nearestNeighbors[i].length; j++) {
                diagnosisCounts.put(nearestNeighbors[i][j], diagnosisCounts.getOrDefault(nearestNeighbors[i][j], 0) + 1);
            }

            // Find the most frequent diagnosis class
            String mostFrequentDiagnosis = null;
            int maxCount = 0;
            for (Map.Entry<String, Integer> entry : diagnosisCounts.entrySet()) {
                if (entry.getValue() > maxCount) {
                    mostFrequentDiagnosis = entry.getKey();
                    maxCount = entry.getValue();
                }
            }

            String actualClass = actualDiagnosis[i][1]; // Access actual diagnosis (second column)
            isCorrect[i] = mostFrequentDiagnosis.equals(actualClass);
        }

        return isCorrect;
    }

    public int countCorrectPredictions(boolean[] isCorrect) {
        for (boolean prediction : isCorrect) {
            if (prediction) {
                numCorrect++;
            }
        }
        return numCorrect;
    }

    public double getAnalysis() {
        return (double) numCorrect /actualDiagnosis.length;
    }


}

