# Basic Storage System in Java

## Summary
This project was my first personal project, and it is a Java-based program that enables users to manage and manipulate 
text documents. It offers features like adding titles, making document copies, and randomizing content within documents. 
This application is designed to simplify the process of organizing and editing various types of textual data. I made
this simple program with idea of storing various titles across different forms of media so that I may pick and choose
titles at random in the future when I had some spare time and I couldn't decide which title I wanted to watch/ read.

## Basic Information
* The TitleManager class handles the management of titles within documents.
* The CopyWriter class creates backup copies of documents.
* The Randomizer class allows you to randomize the content of documents.
* The application provides feedback and confirmation dialogs for various actions.
* All randomized content is stored in "RandomCodes.txt" in the root directory of the repository.

## Tutorial
### Main Menu:

Upon running the application, you will be presented with a main menu with several options:
- Add title: Allows you to add a new title to a selected document. 
- Make copy: Makes a copy of the selected document.
- Randomize: Randomizes the content of the selected document.
- Randomize all: Randomizes the content of all documents.
- Show all random: Displays the content of all randomized documents.
- Exit: Exits the application. 

### Select Document:

When prompted, select the type of document you want to work with (e.g., anime, books, movies, series) from the sub-menu.

### Follow the Prompts:

Depending on your choice, you will be prompted to enter additional information or confirm actions.
Follow the on-screen instructions to complete your desired operation.

### Backup Copies:

The application automatically creates backup copies of the document for every 5 additions. Backup copies are stored in 
the same directory as the original documents with "Copy" or "Random" appended to the filenames.