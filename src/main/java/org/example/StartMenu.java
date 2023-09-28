package org.example;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;


public class StartMenu {
    public static void start() throws IOException {
        String [] menuOptions = {"Add title", "Make copy", "Randomize", "Randomize all", "Show all random", "Exit"};

        String [][] documents = {
                {"storage/anime/anime.txt", "storage/anime/animeCopy.txt", "storage/anime/animeRandom.txt"},
                {"storage/books/books.txt", "storage/books/booksCopy.txt", "storage/books/booksRandom.txt"},
                {"storage/movies/movies.txt", "storage/movies/moviesCopy.txt", "storage/movies/moviesRandom.txt"},
                {"storage/series/series.txt", "storage/series/seriesCopy.txt", "storage/series/seriesRandom.txt"}
        };
        String [] documentOptions = {"anime", "books", "movies","series", "Exit"};

        boolean loop = true;
        while(loop){
            int x = JOptionPane.showOptionDialog(null, "What do you want to do?",
                    "Code menu",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, menuOptions, menuOptions[menuOptions.length-1]);

            int documentIndeks;
            if(x == menuOptions.length-1){                         // Exit menu loop
                loop = false;
            }else if(x == 0){                    // Go to insert code
                documentIndeks = selectDoc(documentOptions);
                TitleManager.titleMenu(documents[documentIndeks][0], documents[documentIndeks][1]);
            }else if(x == 1){                   // Saves a copy of the text file
                documentIndeks = selectDoc(documentOptions);
                CopyWriter.copyMachine(documents[documentIndeks][0], documents[documentIndeks][1]);

            }else if(x == 2){                   // Returns a text file of random codes
                documentIndeks = selectDoc(documentOptions);
                Randomizer.startRandomizer(documents[documentIndeks][0], documents[documentIndeks][2], documentIndeks);

            }else if(x == 3){                   // Randomize all
                Randomizer.allRandom = new ArrayList<>();
                for(int i = 0; i<documents.length; i++){
                    Randomizer.startRandomizer(documents[i][0],documents[i][2], i);
                }
                System.out.println("All randomized!");
                Randomizer.writeAllRandomFile();
                System.out.println("All random file updated!");

            }else if(x == 4){                   // Shows every random doc
                for(int i = 0; i<documents.length; i++){
                    Randomizer.showRandomized(documents[i][2]);
                }
                System.out.println("All randomized showed!");

            }
            else{                              // None of the options were chosen
                return;
            }
        }
    }

    public static int selectDoc (String [] documentOptions){

        int selectDoc = JOptionPane.showOptionDialog(null, "Which document do you want to edit?",
                "Document selection",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, documentOptions, documentOptions[4]);
        if(selectDoc == documentOptions.length-1) return -1;

        return selectDoc;
    }
}
