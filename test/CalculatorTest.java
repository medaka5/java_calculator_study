import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Disabled;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
    private Calculator calculator;

    @Before
    public void setUp(){
        calculator = new Calculator();
    }

    @Test
    public void test_init(){
        assertEquals("0", calculator.GetDisplayText());
    }
    @Test
    public void test_1(){
        calculator.keyNumber(1);
        assertEquals("1", calculator.GetDisplayText());
    }
    @Test
    public void test_12(){
        calculator.keyNumber(1);
        calculator.keyNumber(2);
        assertEquals("12", calculator.GetDisplayText());
    }
    @Test
    public void test_10(){
        calculator.keyNumber(1);
        calculator.keyNumber(0);
        assertEquals("10", calculator.GetDisplayText());
    }
    @Test
    public void test_0(){
        calculator.keyNumber(0);
        assertEquals("0", calculator.GetDisplayText());
    }
    @Test
    public void test_01(){
        calculator.keyNumber(0);
        calculator.keyNumber(1);
        assertEquals("1", calculator.GetDisplayText());
    }
    @Test
    public void test_minus(){
        calculator.keyNumber(1);
        calculator.keyMinus();
        calculator.keyNumber(2);
        calculator.keyEqual();
        assertEquals("-1", calculator.GetDisplayText());
    }
    @Test
    public void test_minus_float(){
        calculator.keyNumber(1);
        calculator.keyMinus();
        calculator.keyNumber(2);
        calculator.keyDivide();
        calculator.keyNumber(2);
        calculator.keyEqual();
        assertEquals("-0.5", calculator.GetDisplayText());
    }
    @Test
    public void test_long(){
        for (int i = 1; i <= 9; i++) {
           calculator.keyNumber(i);
        }
        calculator.keyNumber(0);
        assertEquals("1234567890", calculator.GetDisplayText());
    }
    @Test
    public void test_keyNumber_outofrange() {
        assertThrows(IllegalArgumentException.class, ()->calculator.keyNumber(10));
        assertThrows(IllegalArgumentException.class, ()->calculator.keyNumber(-1));
    }

    @Test
    public void test_123_plus_789(){
        calculator.keyNumber(1);
        calculator.keyNumber(2);
        calculator.keyNumber(3);
        assertEquals("123", calculator.GetDisplayText());
        calculator.keyPlus();
        assertEquals("123", calculator.GetDisplayText());
        calculator.keyNumber(7);
        calculator.keyNumber(8);
        calculator.keyNumber(9);
        assertEquals("789", calculator.GetDisplayText());
        calculator.keyEqual();
        assertEquals("912", calculator.GetDisplayText());
    }
    @Test
    public void test_912_minus_789(){
        calculator.keyNumber(9);
        calculator.keyNumber(1);
        calculator.keyNumber(2);
        assertEquals("912", calculator.GetDisplayText());
        calculator.keyMinus();
        assertEquals("912", calculator.GetDisplayText());
        calculator.keyNumber(7);
        calculator.keyNumber(8);
        calculator.keyNumber(9);
        assertEquals("789", calculator.GetDisplayText());
        calculator.keyEqual();
        assertEquals("123", calculator.GetDisplayText());
    }

    @Test
    public void test_12_multiply_30(){
        calculator.keyNumber(1);
        calculator.keyNumber(2);
        assertEquals("12", calculator.GetDisplayText());
        calculator.keyMultiply();
        assertEquals("12", calculator.GetDisplayText());
        calculator.keyNumber(3);
        calculator.keyNumber(0);
        assertEquals("30", calculator.GetDisplayText());
        calculator.keyEqual();
        assertEquals("360", calculator.GetDisplayText());
    }

    @Test
    public void test_600_divide_20(){
        calculator.keyNumber(6);
        calculator.keyNumber(0);
        calculator.keyNumber(0);
        assertEquals("600", calculator.GetDisplayText());
        calculator.keyDivide();
        assertEquals("600", calculator.GetDisplayText());
        calculator.keyNumber(2);
        calculator.keyNumber(0);
        assertEquals("20", calculator.GetDisplayText());
        calculator.keyEqual();
        assertEquals("30", calculator.GetDisplayText());
    }

    @Test
    public void test_6_divide_12(){
        calculator.keyNumber(6);
        assertEquals("6", calculator.GetDisplayText());
        calculator.keyDivide();
        assertEquals("6", calculator.GetDisplayText());
        calculator.keyNumber(1);
        calculator.keyNumber(2);
        assertEquals("12", calculator.GetDisplayText());
        calculator.keyEqual();
        assertEquals("0.5", calculator.GetDisplayText());
    }
    @Test
    public void test_mix(){
        calculator.keyNumber(3);
        calculator.keyMultiply();
        calculator.keyNumber(5);
        calculator.keyPlus();
        assertEquals("15", calculator.GetDisplayText());
        calculator.keyNumber(2);
        assertEquals("2", calculator.GetDisplayText());
        calculator.keyEqual();
        assertEquals("17", calculator.GetDisplayText());
    }
    @Test
    public void test_mix2(){
        calculator.keyNumber(3);
        calculator.keyMultiply();
        calculator.keyNumber(5);
        calculator.keyPlus();
        assertEquals("15", calculator.GetDisplayText());
        calculator.keyNumber(2);
        assertEquals("2", calculator.GetDisplayText());
        calculator.keyMinus();
        assertEquals("17", calculator.GetDisplayText());
        calculator.keyNumber(1);
        calculator.keyNumber(4);
        assertEquals("14", calculator.GetDisplayText());
        calculator.keyEqual();
        assertEquals("3", calculator.GetDisplayText());
    }
}