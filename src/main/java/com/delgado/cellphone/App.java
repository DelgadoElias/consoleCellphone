package com.delgado.cellphone;

import java.util.*;

/**
 * * - Cellphone console App
 * @author Delgado Elias - https://linktr.ee/DelgadoElias
 *
 */
public class App {

    /**
     * *convertDataToString - Pass a character and convert in a string cellphone code to the respect char
     * @param actualCharacter {char} - The actual character to convert in cellphone code
     * @param lastCharacter {char} - The last character passed to verify if not the same to actual
     * @return result {String} - The char converted cellphone code string to the character passed
     */
    private static String convertDataToString(char actualCharacter, char lastCharacter){

        // ! - First have to work, later have to upgrade

        actualCharacter = Character.toLowerCase(actualCharacter);
        lastCharacter = Character.toLowerCase(lastCharacter);

        /**
         * *convertDataToString Variables
         * 
         * result {String} - final result to return
         * longDecisions {String} - A combination of 9 and 7 code for 4 char in key
         * shortDecisions {String} - 8 code cellphone combination
         * isTwoToSix {Int} - The key to the a,b,c ... m,n,o int combinations
         */

        final String longDecisions = "pqrswxyz";
        final String shortDecisions = " tuv";
        String result;
        int isTwoToSix = 2;


        // * - Principal statements - If the character not belongs to number but are in the cellphone keyboard
        switch(actualCharacter){
            case '*': return "*";
            case '+': result = "00"; break;
            case '#': return "#";
            case ' ': result = "0"; break;
            default: result = "";
        }

        // Principal Code

        // ? - Is 4 character key in cellphone?
        if( longDecisions.indexOf(actualCharacter) >= 0 ){ // ? - is (char in 9 or 7 keys) ? true : false

            int isNineOrSeven = longDecisions.indexOf(actualCharacter);
            if(isNineOrSeven < 4) {
                for(int i = 0; i < isNineOrSeven + 1; i++) result = result + "7";
            }else {
                for(int i = 0; i < isNineOrSeven - 3; i++) result = result + "9";
            }
            
        } else {
        // ? - is 3 character key in cellphone?
            int isTuv = shortDecisions.indexOf(actualCharacter); // is char ==  "t || u || v" ?
            if( isTuv > 0 ) {
                for (int i = 0; i < isTuv; i++) result = result + "8";
            } else {
                // *The character is in 2 to 6 combinations

                int autoIncrement = 0; // To know if it has one or more iterations
                for (int i = 97; i < 112; i++){ // java uses UNICODE for char. Ex: 97 is 'a', 98 = 'b', etc.. 'i' uses UNICODE too.
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

    public static String stringToCellphone(String word){
        
        char toCharacters[] = word.toCharArray();
        String finalResult = "";

        // Reading and passing to the function character by character
        for( int i = 0; i < toCharacters.length; i++){
            // ? - exists lastCharacter or is the first iteration?
            char lastCharacterOfResult = i > 0 ? finalResult.toCharArray()[finalResult.length() - 1] : '?';
            finalResult = finalResult + convertDataToString(toCharacters[i], lastCharacterOfResult);
        }
        return finalResult;
      }


    public static void main(String[] args) {

        System.out.println ("Enter a word:");

        Scanner scannerIn = new Scanner (System.in); // Scanner object
        String result = scannerIn.nextLine();

        // Returning
        System.out.println ("Cellphone code: \"" + stringToCellphone(result) +"\"");
    }
}