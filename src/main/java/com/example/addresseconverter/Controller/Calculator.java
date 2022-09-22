package com.example.addresseconverter.Controller;

import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Calculator {


    public String getStringAddress(int searchNum) {
        String message = "Der findes ikke nogen by med det postnummer";

        HashMap<Integer,String> database = getHashMapFromDataBase();

        for(Map.Entry<Integer,String> entry : database.entrySet()){
            if(searchNum == entry.getKey()){
                message = entry.getValue();
            }
        }

        return message;

    }

    private HashMap<Integer, String> getHashMapFromDataBase() {
        HashMap<Integer, String> databaseList = new HashMap<>();

        try {
            File database = new File("C:\\Users\\Kristian Wede\\IdeaProjects\\AddresseConverter\\src\\main\\resources\\static\\database\\postnumre.csv");
            Scanner fileScanner = new Scanner(database);
            fileScanner.nextLine();

            while(fileScanner.hasNextLine()){

                Scanner lineSeparator = new Scanner(fileScanner.nextLine());
                lineSeparator.useDelimiter(";");

                int postNummer = lineSeparator.nextInt();
                String by = lineSeparator.next();
                databaseList.put(postNummer,by);

            }

            return databaseList;

        } catch (Exception e){
            System.out.println(e);
            System.out.println("Der gik noget galt!");
        }



    return null;
    }


}
