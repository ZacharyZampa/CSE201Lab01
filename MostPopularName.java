/**
 * Authors: Zachary Zampa & Caleb Martin
 * Since: 2020/01/30
 *
 * Description: This is the methods for the program
 */


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MostPopularName {
    private static final String namePrompt = "Enter the name you wish to search";
    private static final String filePrompt = "Enter the file you wish to upload";


    /**
     * Checks if a Given ArrayList contains a string as a full word or substring
     * @param name string to search for
     * @param storage storage to look through
     * @return String outcome
     */
    public static String isSuccess(String name, ArrayList<String> storage) {
        if (arrayContains(name, storage)) {
            return ("That name is one of the 200 most popular!");
        } else if (arrayContainsSubstring(name, storage)) {
            return ("That name is not of the most popular but it is a substring of a top 200 most popular name!");
        }
        return "That name is not one of the 200 most popular NOR is it a substring of a top 200 most popular.";
    }

    /**
     * Search a given arraylist for if it contains the given string
     * @param name string to look for
     * @param namesFromFile arraylist to search through
     * @return boolean true if contained
     */
    public static boolean arrayContains(String name, ArrayList<String> namesFromFile) {
        for (int i = 0; i < namesFromFile.size(); i++) {
            if (namesFromFile.get(i).equals(name)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Search a given arraylist for if it contains the given substring
     * @param name substring to look for
     * @param namesFromFile arraylist to search through
     * @return boolean true if contained
     */
    public static boolean arrayContainsSubstring(String name, ArrayList<String> namesFromFile) {
        for (int i = 0; i < namesFromFile.size(); i++) {
            if (namesFromFile.get(i).contains(name) && !namesFromFile.get(i).equals(name)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Take user input
     * @param promptText what to prompt user
     * @return String
     */
    public static String userInput(String promptText) {
        Scanner keyboard = new Scanner(System.in);  // take input from user
        System.out.println(promptText);

        // take name system input
        String text = keyboard.nextLine();

        return text;
    }

    /**
     * Read a .txt file into memory
     * @param fileName Name of file if local directory / name and path of file
     * @return Arraylist: String
     */
    public static ArrayList<String> fileRead(String fileName) {
        ArrayList<String> storage = new ArrayList<>();
        // grab the file
        File file = new File(fileName);
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            // read to memory
            String line;
            while ((line = br.readLine()) != null)
                storage.add(line);
        } catch (FileNotFoundException e) {
            System.out.println("File was not found. File Name: " + fileName);
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return storage;
    }

    public static String itWasClicked(String name, String fileName) {
        ArrayList<String> nameList = fileRead(fileName);
        return isSuccess(name, nameList);
    }

//    public static void main (String[] args) {
//        String file = userInput(filePrompt);
//        ArrayList<String> nameList = fileRead(file);
//        System.out.println(nameList.toString());
//        String name = userInput(namePrompt);
//        System.out.println(isSuccess(name, nameList));
//    }

}
