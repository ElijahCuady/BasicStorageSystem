package org.example;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

import static javax.swing.JOptionPane.*;
import static javax.swing.JOptionPane.showMessageDialog;

public class TitleManager {
    public static class Title{
        public static int confirmChoice(String newTitle, int i){
            showMessageDialog(null, "New addition!");

            // System print
            System.out.println(i + ": " + newTitle);
            int answer = JOptionPane.showConfirmDialog(null,
                    "Insert title: " + newTitle + "?", "Choose an option", YES_NO_CANCEL_OPTION);

            return answer;
        }

        public static void insertTitle(ArrayList<String> arrayCodes, String newCode, String document, String documentBackup) throws IOException {

            BufferedWriter writer = new BufferedWriter(new FileWriter(document));
            // Adds title to the document
            arrayCodes.add(newCode);
            for(String code: arrayCodes){
                writer.write(code);
                writer.newLine();
            }

            writer.close();
            showMessageDialog(null, "Title: " + newCode + " added!");

            // Updates copy every 5 new additions
            if(arrayCodes.size() % 5 == 0){
                CopyWriter.copyMachine(document, documentBackup);
            }
        }
    }

    public static void titleMenu(String document, String documentBackup) throws IOException {

        boolean loop = true;
        int i = 0;  // Count of unique titles this session
        BufferedReader reader;
        ArrayList<String> arrayTitles = new ArrayList<>();
        while(loop){
            // Insert the new title

            String newTitle = showInputDialog("Insert new title: ");
            if(newTitle.length() != 0){  // To prevent spamming yes
                try{
                    if(arrayTitles.isEmpty()){
                        System.out.println("Empty!");
                        // Starts reading file
                        reader = new BufferedReader(new FileReader(document));
                        arrayTitles = new ArrayList<>();

                        try{
                            String line;
                            while( (line = reader.readLine()) != null){                     // Reads every line in document
                                arrayTitles.add(line);                                       // Adds every line in arrayTitles
                            }
                        }catch (FileNotFoundException e){
                            e.printStackTrace();
                        }
                    }

                    // Checking if title is unique, already exists in the array
                    int check = arrayTitles.indexOf(newTitle);
                    if (check < 0){                                                     // 1. Title is unique
                        i++;
                        int answer = Title.confirmChoice(newTitle, i);                    // Returns a yes or no answer

                        if(answer == 0){                                                // 1.1 Presses yes
                            Title.insertTitle(arrayTitles, newTitle, document, documentBackup);
                        }else if(answer == 2){                                          // 1.2 Presses cancel
                            break;
                        }

                    }else if(check > 0){                                                // 2. Title is not unique
                        showMessageDialog(null, "Title already exists");
                    }

                    // Ends the loop if input is not a convertable string
                }catch (Exception e){
                    loop = false;
                }
            }
        }
    }
}
