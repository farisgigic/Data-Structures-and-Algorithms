package Homework04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        SocialNetwork network = new SocialNetwork();
        Scanner scanner = new Scanner(System.in);



        System.out.println("Loading in the social network...");
        try {
            Scanner fileScanner = new Scanner(new File("C:\\Users\\pc\\Desktop\\DataStructures\\social_network.csv"));
            fileScanner.nextLine();

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] data = line.split(";");
                String user1 = data[0].trim();
                String user2 = data[1].trim();
                int friendshipStrength = Integer.parseInt(data[2].trim());
                Friendship friendship = new Friendship(user1, user2, friendshipStrength);
                network.addFriendship(friendship);
            }
            fileScanner.close();
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
            return;
        }

        System.out.println();

        System.out.println("Total users: " + network.V());
        System.out.println("Total friendships: " + network.E());

        System.out.println();

        System.out.println("|-|-|System is ready|-|-|");

        System.out.println();

        while (true) {
            System.out.print("Enter a name to recommend friends for, or -1 to exit: ");
            String input = scanner.nextLine();
            if (input.equals("-1")) {
                System.out.println("Thank you for using our friendship recommender algorithm.");
                break;
            }

            ArrayList<FriendshipRecommendation> recommendations = network.recommendFriends(input);
            if (recommendations.isEmpty()) {
                System.out.println("The user you are looking for does not exist in the network. \n");
            } else {
                System.out.println("Total recommendations: " + recommendations.size());
                System.out.println("Top 10 recommendations based on friendship strength: ");
                for (int i = 0; i < recommendations.size() && i < 10; i++) {
                    System.out.println(recommendations.get(i));
                }
            }
        }
        scanner.close();
}
}