import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class IntegerDecodeTests{
    @Test
    public void testEmpty(){
        assertThrows(NumberFormatException.class, () -> Integer.decode(""));
    }
    @Test
    public void testZeroes(){
        assertEquals(0, Integer.decode("00000"));
    }
    @Test
    public void testMinus(){
        assertEquals(-1, Integer.decode("-1"));
    }
    @Test
    public void testPlus(){
        assertEquals(1, Integer.decode("+1"));
    }
    @Test
    public void testStartsWithZero(){
        assertNotEquals(12, Integer.decode("012"));
    }
    @Test
    void TestOcta(){
        Assertions.assertEquals(10, Integer.decode("012"));
    }
    @Test
    void TestNegativeOcta(){
        Assertions.assertEquals(-10, Integer.decode("-012"));
    }
    @Test
    public void testHex(){
        assertEquals(10, Integer.decode("0xA"));
        assertEquals(11, Integer.decode("0xB"));
    }
    @Test
    public void testHashtag() {
        assertEquals(10, Integer.decode("#A"));
        assertEquals(11, Integer.decode("#B"));
    }
    @Test
    public void testNegativeHex(){
        assertEquals(-11, Integer.decode("-0xB"));
    }
    @Test
    public void testNegativeHashtagHex(){
        assertEquals(-17, Integer.decode("-#11"));
    }
    @Test
    public void testSystems(){
        assertNotEquals(Integer.decode("012"), Integer.decode("12"));
    }
    @Test
    public void testCatchMinValue(){
        assertEquals(Optional.of(Integer.MIN_VALUE), Optional.of(Integer.decode("-2147483648")));
    }
    @Test
    public void testCatchMaxValue(){
        assertEquals(Optional.of(Integer.MIN_VALUE), Optional.of(Integer.decode("-2147483648")));
    }
    @Test
    public void testRandomString() {
        assertThrows(NumberFormatException.class, () -> Integer.decode("Ulululu"));
    }
}
