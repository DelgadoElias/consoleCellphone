package com.delgado.cellphone;

import java.util.*;

/**
 * Cellphone console App
 * @author Delgado Elias
 *
 */
public class App {

    /**
     * *convertDataToString - Convert the character to a cellphone keyboard code
     * @param actualCharacter : char - The actual character to convert in cellphone code
     * @param lastCharacter : char - The last character passed to verify if not the same to actual
     * @return result : String - The char converted cellphone code string to the character passed
     */
    public static String convertDataToString(char actualCharacter, char lastCharacter){

        // First have to work, later have to upgrade

        /**
         * convertDataToString Variables
         * 
         * result : String - final result to return
         * longDecisions : String - A combination of 9 and 7 code for 4 char in key
         * isTwoToSix : Int - The key to the a,b,c ... m,n,o combinations
         * uniBegin : Int - become to UNICODE id to alphabet
         */

        String result = "";
        String longDecisions = "pqrswxyz";
        String shortDecisions = " tuv";
        int isTwoToSix = 2;


        // Principal statements - If the character not belongs to number but are in the cellphone keyboard
        if(actualCharacter == '*') return "*";
        if(actualCharacter == '+') return "0";
        if(actualCharacter == '#') return "#";
        // Spacing are not in keyboard, but they are present in words
        if(actualCharacter == ' ') return " ";

        // Principal Code


        // If is 4 character key in cellphone
        if( longDecisions.indexOf(actualCharacter) > 0 ){ // is (char in 9 or 7 keys) ? true : false

            int isNineOrSeven = longDecisions.indexOf(actualCharacter);
            if(isNineOrSeven < 4) {
                for(int i = 0; i < isNineOrSeven + 1; i++) result = result + "7";
            }else {
                for(int i = 0; i < isNineOrSeven - 3; i++) result = result + "9";
            }
            
        } else {
            // is 3 character key in cellphone
            int isTuv = shortDecisions.indexOf(actualCharacter); // is char ==  "t || u || v" ?
            if( isTuv > 0 ) {
                for (int i = 0; i < isTuv; i++) result = result + "8";
            } else {
                // The character is in 2 to 6 combinations

                int autoIncrement = 0; // To know if it has one or more iterations
                for (int i = 97; i < 112; i++){ // 'i' uses UNICODE characters. Ex: 97 is 'a', 98 = 'b', 99 = 'c', etc..
                    char uniCharacter = (char) i;

                    if(actualCharacter == uniCharacter) {
                        for(int j = 0; j < autoIncrement + 1; j++) {
                            result = result + isTwoToSix;
                        }
                        break;

                    } else{
                        autoIncrement = autoIncrement + 1;
                    }
                    if (autoIncrement == 3) {
                        autoIncrement = 0;
                        isTwoToSix = isTwoToSix + 1;
                    };
                }
            }
        }



        // Returning
            // if the lastCharacter is the same to the first of the result. Need a space
            if(lastCharacter == result.toCharArray()[0]) {
                return " " + result;
        }
            else {
                return result;
            }
    }


    public static void main(String[] args) {

        System.out.println ("Enter a word:");

        /**
         * Main class Variables
         * toCharacters : char[] - Scanner text converted to a character array;
         * scannerIn : Scanner - Scanner object;
         * finalResult : String - The result to return;
         */
        Scanner scannerIn = new Scanner (System.in); // Scanner object
        char toCharacters[] = scannerIn.nextLine().toCharArray();
        String finalResult = "";


        // Reading and passing to the function character by character
        for(int i=0; i < toCharacters.length; i++){
            if( i == 0) { // If is the first character
                finalResult = finalResult + convertDataToString(toCharacters[i], '?');
            } else {
                // Sending the lastCharacter of the result to verify if are not the same with the new key code
                char lastCharacterOfResult = finalResult.toCharArray()[finalResult.length() - 1];
                finalResult = finalResult + convertDataToString(toCharacters[i], lastCharacterOfResult);
            }
        }


        // Returning
        System.out.println ("Cellphone code: \"" + finalResult +"\"");
    }
}
