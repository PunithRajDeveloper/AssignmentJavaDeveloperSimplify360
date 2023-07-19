package com;

import java.util.*;
import java.util.Scanner;

public class BouquetManager  {
    private Map<String, String> bouquetMap;

    public BouquetManager() {
        bouquetMap = new HashMap<>();
    }

    public void addFlower(String flower, String bouquet) {
        bouquetMap.put(flower, bouquet);
    }

    public String getBouquet(String flower) {
        return bouquetMap.get(flower);
    }

    public static void main(String[] args) {
    	BouquetManager manager = new BouquetManager();
        Scanner scanner = new Scanner(System.in);

        // Populate the bouquet data
        manager.addFlower("Red", "Bouquet1");
        manager.addFlower("White", "Bouquet1");
        manager.addFlower("Rose", "Bouquet1");
        manager.addFlower("Yellow", "Bouquet1");
        manager.addFlower("Tulp", "Bouquet1");
        manager.addFlower("White", "Bouquet1");
        manager.addFlower("Purple", "Bouquet1");
        manager.addFlower("Lily", "Bouquet1");
        manager.addFlower("White", "Bouquet1");
        manager.addFlower("Rose", "Bouquet2");
        manager.addFlower("Pink", "Bouquet2");
        manager.addFlower("Orange", "Bouquet2");
        manager.addFlower("Yellow", "Bouquet2");
        manager.addFlower("chrysanthemum", "Bouquet2");
        manager.addFlower("Pink", "Bouquet2");
        manager.addFlower("Balsam", "Bouquet2");


        System.out.print("Enter flower name: ");
        String flower = scanner.nextLine();
        String bouquet = manager.getBouquet(flower);
        System.out.println("Bouquet: " + bouquet);
        
        
    }
}

