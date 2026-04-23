package com.pluralsight;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        homeScreen();
        loadAdventure();


//        ArrayList<StepClass> adventureSteps = loadAdventure();
//        for (int i = 0; i < adventureSteps.size(); i++) {
//            System.out.println(adventureSteps.get(i));
//        }

    }

    public static void homeScreen() throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Adventure Time.");
        System.out.println("---------------------------");
        System.out.println("Press (P) to play: ");
        System.out.println("Press (Q) to quit: ");
        System.out.print("Your choice: ");
        String choice = scanner.nextLine().toUpperCase();

        if (choice.equals("P")){
            gameScreen(1);
        }
    }

    public static void gameScreen(int id) throws IOException {
        Scanner scanner = new Scanner(System.in);
        ArrayList<StepClass> steps = loadAdventure();
//        System.out.println(steps.get(id));

        for(int i = 0; i < steps.size(); i++) {
            id = id - 1;
            System.out.println("\n" + steps.get(id).getStoryText() + "\n");

            System.out.println("You decide to: ");
            System.out.println("1) " + steps.get(id).getOption1Text());
            System.out.println("2) " + steps.get(id).getOption2Text());

            System.out.print("Your choice: ");
            int choice = scanner.nextInt();

            if (choice == 1 ){
//                System.out.println("Option 1) " + steps.get(id).getOption1NextId());
                id = steps.get(id).getOption1NextId();
            }

            else if (choice == 2 ){
//                System.out.println("Option 2) " + steps.get(id).getOption2NextId());
                id = steps.get(id).getOption2NextId();

                if (steps.get(id).getOption2NextId() == -1){
                    System.out.println("Quitter Loser");
                    System.exit(0);
                }
            }

            i++;
        }

    }

    public static ArrayList<StepClass> loadAdventure() throws IOException {
        FileReader fileReader = new FileReader("adventure1.csv");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        bufferedReader.readLine();
        String line = bufferedReader.readLine();

        // create the container
        // StepClass[] steps = new StepClass[100];
        // ArrayLists grows as needed when ou add new items
        ArrayList<StepClass> steps = new ArrayList<>();

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

                StepClass stepClass = new StepClass(id, storyText, option1Text, option1NextId, option2Text, option2NextId);
                steps.add(stepClass);      // add the current step to the container

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
