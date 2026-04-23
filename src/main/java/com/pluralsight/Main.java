package com.pluralsight;
import java.util.*;
import java.io.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() throws IOException {
        ArrayList<StepClass> steps = new ArrayList<>();
        steps = loadAdventure();
        homeScreen();
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
        ArrayList<StepClass> steps = loadAdventure();
        for (int i = 0; i < steps.size(); i++) {
            StepClass step = steps.get(i);

            if (step.getId() == id) {
                System.out.println("\n" + step.getStoryText() + "\n");

                System.out.println("You decide to: ");
                System.out.println("1) " + step.getOption1Text());
                System.out.println("2) " + step.getOption2Text());

                System.out.print("Your choice: ");
            }
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
