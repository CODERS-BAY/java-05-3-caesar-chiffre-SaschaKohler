package com.sksoft;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here


        int numChars = 123 - 97;
        char[] allowedCharacters = new char[numChars];

        int counter = 0;
        for (char i = 97 ; i <= 122; i ++){
            allowedCharacters[counter] = i;
            counter++;
        }

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int shift = random.nextInt(26)+1;
        //shift = 6; //for testing against specification

        System.out.print("Bitte geben sie einen zu verschlüsselnden Text ein: ");
        String readLine = scanner.nextLine();
        String lower = readLine.toLowerCase();

        char[] toEncrypt = new char[readLine.length()];

        for (int i = 0 ; i < readLine.length(); i++) {
            char  tbS = lower.charAt(i);
             int taS = (int)(tbS - 97 + shift) % numChars;   // get a circular array with mod and start(-97 = 'a')
             if(tbS == ' '){                                 // char ' ' and char '!' not specified
                 toEncrypt[i] = ' ';
             }
             else if(tbS == '!'){
                 toEncrypt[i] = '!';
             }
             else {
                 toEncrypt[i] = allowedCharacters[taS];
             }
        }

        System.out.println(readLine.toString());         // print eingabe again

        for (int i =0 ; i< toEncrypt.length; i++){
            if(Character.isUpperCase(readLine.charAt(i))){ //   check if eingabe was uppercase char
            System.out.print(Character.toUpperCase(toEncrypt[i]));
            } else{
                System.out.print(toEncrypt[i]);
            }
        }
/*

        @Test mit shift = 6
        Bitte geben sie einen zu verschlüsselnden Text ein: Ein Charakter namens Caesar!
        Ein Charakter namens Caesar!
        Kot Ingxgqzkx tgskty Igkygx!

        Bitte geben sie einen zu verschlüsselnden Text ein: Kot Ingxgqzkx tgskty Igkygx!
        Kot Ingxgqzkx tgskty Igkygx!
        Quz Otmdmwfqd zmyqze Omqemd!

        Ausgabe erfolgt nach Spezifikation.
*/
    }
}
