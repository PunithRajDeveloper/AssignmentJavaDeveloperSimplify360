package com;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class LogFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the path to the log file: ");
        String logFilePath = scanner.nextLine();

        System.out.print("Enter the target job name: ");
        String targetJob = scanner.nextLine();

        System.out.print("Enter the target timestamp (format: yyyy-MM-dd HH:mm:ss): ");
        String targetTimestamp = scanner.nextLine();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date targetDate;

        try {
            targetDate = dateFormat.parse(targetTimestamp);
        } catch (ParseException e) {
            System.out.println("Invalid target timestamp format. Please use 'yyyy-MM-dd HH:mm:ss' format.");
            scanner.close();
            return;
        }

        try (Scanner fileScanner = new Scanner(logFilePath)) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(" ", 4);

                if (parts.length >= 4) {
                    String timestampStr = parts[0] + " " + parts[1];
                    String jobName = parts[2];

                    try {
                        Date logDate = dateFormat.parse(timestampStr);

                        if (logDate.after(targetDate) && jobName.equals(targetJob)) {
                            System.out.println(line);
                            scanner.close();
                            return;
                        }
                    } catch (ParseException e) {
                        System.out.println("Invalid log entry timestamp format. Skipping the log entry.");
                    }
                }
            }

            System.out.println("No log entry found for job " + targetJob + " after " + targetTimestamp);
        } catch (Exception e) {
            System.out.println("Error occurred while reading the log file: " + e.getMessage());
        }

        scanner.close();
    }
}

