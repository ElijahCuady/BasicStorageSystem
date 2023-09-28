package org.example;

import java.io.*;
import java.util.ArrayList;

public class Randomizer {
    public static ArrayList<ArrayList<String>> allRandom = new ArrayList<>();
    public static void startRandomizer(String document, String randomOfDoc, int docIndeks) throws IOException {

        BufferedReader codeReader = new BufferedReader(new FileReader(document));   // To get the codes from the file
        ArrayList <Integer> randomIndexes = new ArrayList<>();                                  // For random codes' indexes
        ArrayList <String> codes = new ArrayList<>();                                           // All codes from file

        String newLine = "";
        while( (newLine = codeReader.readLine()) != null){                                      // Goes through the entire file
            codes.add(newLine);                                                                 // Adds every code into the arraylist
        }
        codeReader.close();

        //String input = showInputDialog(null, "How many codes do you want?"); // Getting the number of random codes

        try{    // Validating input
            int count = 10;

            while(randomIndexes.size() < count){                            // While the arraylist of indexes isn't full
                int randomInt = (int) (Math.random()*(codes.size())+1);     // Generate a random integer

                if( !randomIndexes.contains(randomInt)){                    // Add if it doesn't exist in the randomIndexes list
                    randomIndexes.add(randomInt);
                }
            }

            // Just get the elementAt(randomIndex) from codesToTxt
            BufferedWriter writer = new BufferedWriter(new FileWriter(randomOfDoc));
            ArrayList<String> newRandoms = new ArrayList<>();
            for(int i = 0; i < count; i++){
                int randomCodeIndex = randomIndexes.get(i);
                String code = codes.get(randomCodeIndex-1);                 // Getting the code from codes-list with the random index

                newRandoms.add(code);
                writer.write(code);                                         // Adds the code into the randomCodes file
                writer.newLine();

            }
            writer.close();
            if(allRandom.size()==6){        // Replace
                allRandom.remove(docIndeks);
                allRandom.add(docIndeks, newRandoms);
            }else{
                allRandom.add(newRandoms);
            }

        }catch (Exception e){   // Input no bueno
            System.out.println("Invalid input");
        }
    }

    public static void showRandomized(String doc) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(doc));
        String line;
        while ( (line = reader.readLine()) != null) System.out.print("["+line+"]" + " ");
        System.out.println();
        reader.close();
    }

    public static void writeAllRandomFile() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("RandomCodes.txt"));
        String s = "";
        for(int i = 0; i<allRandom.size(); i++){
            s = allRandom.get(i).toString();
            writer.write(s);
            writer.newLine();
        }
        writer.close();
        System.out.println("Random file written.");
    }

    public static void main(String [] args) throws IOException {
        System.out.println(allRandom.toString());
    }
}
