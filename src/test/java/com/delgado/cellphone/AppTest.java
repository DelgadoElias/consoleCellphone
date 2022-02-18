package com.delgado.cellphone;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import com.delgado.cellphone.*;
/**
 * Unit test for Console App.
 * @author Delgado Elías Lautaro
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue( true );
    }
    
    @Test
    public void shouldReturnTwo() {
        String getKeyCode = App.convertDataToString('a', '?');
        assertEquals("Must return two |2","2", getKeyCode);
    }

    @Test
    public void shouldReturnTwoSpaced() {
        String getKeyCode = App.convertDataToString('a', '2');
        assertEquals("'a' must return two with one space at the start of the string | 2"," 2", getKeyCode);
    }

    @Test
    public void shouldReturnHi() {
        
        String helloWorldString = "hi";
        String finalResult = "";
        char toCharacters[] = helloWorldString.toCharArray();

        for(int i=0; i < toCharacters.length; i++){
            if( i == 0) { // If is the first character
                finalResult = finalResult + App.convertDataToString(toCharacters[i], '?');
            } else {
                // Sending the lastCharacter of the result to verify if are not the same with the new key code
                char lastCharacterOfResult = finalResult.toCharArray()[finalResult.length() - 1];
                finalResult = finalResult + App.convertDataToString(toCharacters[i], lastCharacterOfResult);
            }
        }

        assertEquals("Hi must return |44 444", "44 444", finalResult);

    }

    @Test
    public void shouldReturnYes() {
        
        String helloWorldString = "yes";
        String finalResult = "";
        char toCharacters[] = helloWorldString.toCharArray();

        for(int i=0; i < toCharacters.length; i++){
            if( i == 0) { // If is the first character
                finalResult = finalResult + App.convertDataToString(toCharacters[i], '?');
            } else {
                // Sending the lastCharacter of the result to verify if are not the same with the new key code
                char lastCharacterOfResult = finalResult.toCharArray()[finalResult.length() - 1];
                finalResult = finalResult + App.convertDataToString(toCharacters[i], lastCharacterOfResult);
            }
        }

        assertEquals("Yes must return |999337777", "999337777", finalResult);

    }

    @Test
    public void shouldReturnFoo() {
        
        String helloWorldString = "foo bar";
        String finalResult = "";
        char toCharacters[] = helloWorldString.toCharArray();

        for(int i=0; i < toCharacters.length; i++){
            if( i == 0) { // If is the first character
                finalResult = finalResult + App.convertDataToString(toCharacters[i], '?');
            } else {
                // Sending the lastCharacter of the result to verify if are not the same with the new key code
                char lastCharacterOfResult = finalResult.toCharArray()[finalResult.length() - 1];
                finalResult = finalResult + App.convertDataToString(toCharacters[i], lastCharacterOfResult);
            }
        }

        assertEquals("Foo bar must return |333666 666 22 2777", "333666 666 22 2777", finalResult);

    }

    @Test
    public void shouldReturnHelloWorld() {
        
        String helloWorldString = "hello world";
        String finalResult = "";
        char toCharacters[] = helloWorldString.toCharArray();

        for(int i=0; i < toCharacters.length; i++){
            if( i == 0) { // If is the first character
                finalResult = finalResult + App.convertDataToString(toCharacters[i], '?');
            } else {
                // Sending the lastCharacter of the result to verify if are not the same with the new key code
                char lastCharacterOfResult = finalResult.toCharArray()[finalResult.length() - 1];
                finalResult = finalResult + App.convertDataToString(toCharacters[i], lastCharacterOfResult);
            }
        }

        assertEquals("Hello world must return |4433555 555666 96667775553", "4433555 555666 96667775553", finalResult);

    }
}
