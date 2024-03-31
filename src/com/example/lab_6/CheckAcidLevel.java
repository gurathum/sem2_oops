package com.example.lab_6;

public class CheckAcidLevel {
    public static void main(String[] args) {
        //  Acid level data 
        double[] data = {5.6, 6.2, 6, 5.5, 5.7, 6.1, 7.4, 5.5, 5.5, 6.3, 6.4, 4, 6.9};

        //  calculating average 
        double sum = 0;
        for (double num: data) {
            sum += num;
        }
        double avg = sum / data.length;

        //  Finding most distant value from the average 
        double distantValue = getDistantValue(data, avg);

        //  Compute new average without the most distant value 
        sum -= distantValue;
        double newAvg = sum / (data.length - 1);

        //  output 
        System.out.printf("Average: %.2f\n", avg);
        System.out.printf("Most distant value: %.1f\n", distantValue);
        System.out.printf("New Average: %.2f\n", newAvg);

    }

    private static double getDistantValue(double[] data, double avg) {
        double distantValue = data[0];
        double farthestDistance = 0;

        for (double value : data) {
            // Absolute difference between the current value and the average
            double currentDistance = Math.abs(value - avg);

            // If current distance is greater than the farthest distance, update values
            if (currentDistance > farthestDistance) {
                distantValue = value;
                farthestDistance = currentDistance;
            }
        }

        return distantValue;
    }
}
