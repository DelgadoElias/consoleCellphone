package com.delgado.cellphone;

import static org.junit.Assert.assertEquals;
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
    public void shouldReturnTwo() {

        String getKeyCode = "a";        
        
        String finalResult = App.stringToCellphone(getKeyCode);

        assertEquals("Must return two |2","2", finalResult);
    }

    @Test
    public void shouldReturnTwoSpaced() {
        String getKeyCode = App.stringToCellphone("aa");
        assertEquals("'aa' must return two with one space at the start of the string | 2","2 2", getKeyCode);
    }

    @Test
    public void shouldReturnHi() {
        
        String helloWorldString = "hi";        
        
        String finalResult = App.stringToCellphone(helloWorldString);

        assertEquals("Hi must return |44 444", "44 444", finalResult);

    }

    @Test
    public void shouldReturnYes() {
        
        String helloWorldString = "yes";
        String finalResult = App.stringToCellphone(helloWorldString);

        assertEquals("Yes must return |999337777", "999337777", finalResult);

    }

    @Test
    public void shouldReturnFoo() {
        
        String helloWorldString = "foo bar";

        String finalResult = App.stringToCellphone(helloWorldString);

        assertEquals("Foo bar must return |333666 666022 2777", "333666 666022 2777", finalResult);

    }

    @Test
    public void shouldReturnHelloWorld() {
        
        String helloWorldString = "hello world";

        String finalResult = App.stringToCellphone(helloWorldString);

        assertEquals("Hello world must return |4433555 555666096667775553", "4433555 555666096667775553", finalResult);

    }

    @Test
    public void shouldReturnHelloWorldWithUppercases() {
        
        String helloWorldString = "hELlo wOrLd";

        String finalResult = App.stringToCellphone(helloWorldString);

        assertEquals("Hello world must return with uppercases |4433555 555666096667775553", "4433555 555666096667775553", finalResult);

    }

    @Test
    public void shouldReturnHelloWorldWithSymbols() {
        
        String helloWorldString = "hELlo +wOrLd";

        String finalResult = App.stringToCellphone(helloWorldString);

        assertEquals("Hello world must return with uppercases and symbols |4433555 5556660 0096667775553", "4433555 5556660 0096667775553", finalResult);

    }
}
