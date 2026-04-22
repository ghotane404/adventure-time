package com.pluralsight;
import java.util.*;
import java.io.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() throws IOException {

        loadAventure();

    }

    public static void loadAventure() throws IOException {
        FileReader fileReader = new FileReader("adventure1.csv");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line = bufferedReader.readLine();

        try {
            while (line != null){
                System.out.println(line);
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
