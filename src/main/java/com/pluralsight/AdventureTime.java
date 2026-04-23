package com.pluralsight;
import java.util.*;
import java.io.*;

public class AdventureTime {
    static ArrayList<Step> adventureSteps;
    static Scanner scanner = new Scanner(System.in);

    static void main() throws IOException {
        homeScreen();
    }

    public static void homeScreen() throws IOException {
        System.out.println("Welcome to Adventure Time.");
        System.out.println("---------------------------");
        System.out.println("Press (1) to play Adventure Forest: ");
        System.out.println("Press (2) to play Haunted Castle: ");
        System.out.println("Press (Q) to quit: ");
        System.out.print("Your choice: ");

        String choice = scanner.nextLine().toUpperCase().strip();

        switch (choice) {
            case "1":
                adventureSteps = loadAdventure("adventure1.csv");
                gameScreen(1);
                break;

            case "2":
                adventureSteps = loadAdventure("adventure2.csv");
                gameScreen(1);
                break;

            case "Q":
                System.out.println("Goodbye!");
                break;

            default:
                System.out.println("Invalid selection. Please try again.");
                homeScreen();
        }
    }

    public static void gameScreen(int id) throws IOException {
        int nextId = id;

        while(nextId != -1){
            Step step = findStep(nextId);

            if (step == null) {
                System.out.println();
                System.out.println("An error occurred. The step was not found.");
            }
            else {
                System.out.println();
                System.out.println(step.getStoryText());
                System.out.println();
                System.out.println("1) " + step.getOption1Text());
                System.out.println("2) " + step.getOption2Text());
                System.out.print("Make a selection: ");

                String userInput = scanner.nextLine().toLowerCase().strip();

                switch (userInput) {
                    case "1":
                        nextId = step.getOption1NextId();
                        break;

                    case "2":
                        nextId = step.getOption2NextId();
                        break;
                }
            }
        }
    }

//    public static void printMessage(String message){
//
//    }

    public static Step findStep(int id) {
        for (int i = 0; i < adventureSteps.size(); i++) {
            Step step = adventureSteps.get(i);

            if (step.getId() == id) {
                return step;
            }
        }
        return null;
    }

    public static ArrayList<Step> loadAdventure(String adventureFile) throws IOException {
        FileReader fileReader = new FileReader(adventureFile);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        bufferedReader.readLine();
        String line = bufferedReader.readLine();

        // create the container
        // StepClass[] steps = new StepClass[100];
        // ArrayLists grows as needed when ou add new items
        ArrayList<Step> steps = new ArrayList<>();

        // populating the container
        try {
            while (line != null){
                String[] cols = line.split("\\|");
                int id = Integer.parseInt(cols[0]);
                String storyText = cols[1];
                String option1Text = cols[2];
                int option1NextId = Integer.parseInt(cols[3]);
                String option2Text = cols[4];
                int option2NextId = Integer.parseInt(cols[5]);

                Step step = new Step(id, storyText, option1Text, option1NextId, option2Text, option2NextId);
                steps.add(step);      // add the current step to the container

                line = bufferedReader.readLine();
            }
            bufferedReader.close();
        }
        catch (Exception e) {
            System.out.println("Error");
        }
        return steps;   // return the container
    }

}
