package com.techelevator.view;

import org.w3c.dom.ls.LSOutput;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Products {
    private final int MAX_INVENTORY = 5;

    public static void main(String[] args) {
        String fileName = "C:\\Users\\Student\\workspace\\oct-blue-capstone-1-team-5\\capstone\\vendingmachine.csv";

        File file = new File(fileName);

        try(Scanner fileReader = new Scanner(file)) {

            Map<String, Integer> productList = new HashMap<>();

            while (fileReader.hasNextLine()){
                String line = fileReader.nextLine();

                //split line var from file
                String[] linePart = line.split("|");
                    //assign a price from arrayname[0]
                    String price = linePart[2];
                System.out.println(price);
                    //Integer price = Integer.parseInt(linepart[0])
                //make new variable and parse into an int
                Integer intPrice = Integer.parseInt(linePart[2]);



            }


        } catch (Exception ex){
            System.out.println("Figure this out later");
        }

    }





    //read list
    //sout it out





}
