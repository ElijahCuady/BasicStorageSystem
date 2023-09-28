package org.example;

import java.io.*;

public class CopyWriter {
    public static void copyMachine(String document, String documentBackup){
        try{
            BufferedReader reader = new BufferedReader(new FileReader(document));
            BufferedWriter copyWriter = new BufferedWriter(new FileWriter(documentBackup));
            String s;
            while( (s = reader.readLine()) != null){    // Reads each line in the given txt file
                copyWriter.write(s + "\n");         // Writes down each line from "main" txt file to copy.txt
            }
            reader.close();
            copyWriter.close();
            System.out.println("Successful copy!");
        }catch(FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String [] args){
        //copyMachine();
    }
}
