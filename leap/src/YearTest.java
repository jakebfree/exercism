import org.junit.Test;

import static org.junit.Assert.*;

public class YearTest {

    @Test
    public void test1971IsntLeapYear() throws Exception {
        Year year = new Year(1971);
        assertFalse("Result is that 1971 is a leap year, which it isn't", year.isLeapYear());
    }

    @Test
    public void test2000IsLeapYear() throws Exception {
        Year year = new Year(2000);
        assertTrue("Result is that 2000 isn't a leap year, but it is", year.isLeapYear());
    }

    @Test
    public void test1900IsntLeapYear() throws Exception {
        Year year = new Year(1900);
        assertFalse("Result is that 1900 is a leap year, which it isn't", year.isLeapYear());
    }

    @Test
    public void test2012IsntLeapYear() throws Exception {
        Year year = new Year(2012);
        assertTrue("Result is that 2012 isn't a leap year, but it is", year.isLeapYear());
    }
}