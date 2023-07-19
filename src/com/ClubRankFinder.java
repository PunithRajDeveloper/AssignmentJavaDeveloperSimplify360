package com;

import java.util.Arrays;
import java.util.Scanner;

public class ClubRankFinder {
    public static int findHarperRank(int[] ranks, int harperRank) {
        int left = 0;
        int right = ranks.length - 1;
        int harperIndex = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (ranks[mid] == harperRank) {
                harperIndex = mid;
                break;
            } else if (ranks[mid] > harperRank) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        // Adjust the index to represent the rank (1-based) instead of the index (0-based)
        return harperIndex != -1 ? harperIndex + 1 : -(left + 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of players: ");
        int numPlayers = scanner.nextInt();

        int[] ranks = new int[numPlayers];

        System.out.println("Enter the ranks of the players:");

        for (int i = 0; i < numPlayers; i++) {
            ranks[i] = scanner.nextInt();
        }

        System.out.print("Enter Harper's rank: ");
        int harperRank = scanner.nextInt();

        scanner.close();

        Arrays.sort(ranks); // Sort the ranks array in ascending order

        int harperIndex = findHarperRank(ranks, harperRank);

        if (harperIndex > 0) {
            System.out.println("Harper's rank is " + harperIndex);
        } else {
            System.out.println("Harper's rank is between " + (-harperIndex) + " and " + (-(harperIndex - 1)));
        }
    }
}

