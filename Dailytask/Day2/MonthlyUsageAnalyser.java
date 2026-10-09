package Dailytask.Day2;

public class MonthlyUsageAnalyser {
    public static void main(String[] args) {

        // Monthly usage for 12 months
        int[] monthlyUsage = {
            1200, 1500, 1800, 2100,
            2500, 2800, 3200, 3000,
            2700, 2300, 1900, 1600
        };

        // Slab constants
        final long LOW_RATE = 5;
        final long MEDIUM_RATE = 8;
        final long HIGH_RATE = 10;

        long total = 0;
        int max = monthlyUsage[0];
        int min = monthlyUsage[0];

        // Calculate total, maximum and minimum
        for (int usage : monthlyUsage) {

            total += (long) usage;

            if (usage > max) {
                max = usage;
            }

            if (usage < min) {
                min = usage;
            }
        }

        // Calculate average
        double average = (double) total / monthlyUsage.length;

        // Grade using ternary operator
        char grade = average >= 2500 ? 'A'
                   : average >= 2000 ? 'B'
                   : average >= 1500 ? 'C'
                   : 'D';

        // 2-D array for 3 houses
        int[][] houseUsage = {
            {1200, 1500, 1800},
            {2100, 2500, 2800},
            {3000, 2700, 2300}
        };

        System.out.println("===== Monthly Usage Analyser =====");

        System.out.println("Total Usage   : " + total);
        System.out.println("Average Usage : " + average);
        System.out.println("Maximum Usage : " + max);
        System.out.println("Minimum Usage : " + min);
        System.out.println("Usage Grade   : " + grade);

        System.out.println("\nSlab Rates:");
        System.out.println("Low Rate    : " + LOW_RATE);
        System.out.println("Medium Rate : " + MEDIUM_RATE);
        System.out.println("High Rate   : " + HIGH_RATE);

        System.out.println("\n===== 2-D Array - 3 Houses =====");

        for (int i = 0; i < houseUsage.length; i++) {
            System.out.print("House " + (i + 1) + ": ");

            for (int j = 0; j < houseUsage[i].length; j++) {
                System.out.print(houseUsage[i][j] + " ");

            }

            System.out.println();
        }
    }
}
