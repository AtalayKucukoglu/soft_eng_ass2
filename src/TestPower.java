import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestPower {

    @Test
    public void testIntegerParam() {
        Values v1 = new Values(2,2);
        Values v2 = new Values(10,4);
        IntegerPower integerPower = new IntegerPower(v1);
        assertEquals(4, integerPower.intPower());
        integerPower = new IntegerPower(v2);
        assertEquals(10000, integerPower.intPower());
    }

    @Test
    public void testZeroFirstParam() {
        Values v1 = new Values(0,1);
        Values v2 = new Values(0,71);
        IntegerPower integerPower = new IntegerPower(v1);
        assertEquals(0, integerPower.intPower());
        integerPower = new IntegerPower(v2);
        assertEquals(0, integerPower.intPower());
    }

    @Test
    public void testZeroSecondParam() {
        Values v1 = new Values(99,0);
        Values v2 = new Values(157,-0);
        Values v3 = new Values(1,0);
        Values v4 = new Values(100,0);
        Values v5 = new Values(-1,0);
        IntegerPower integerPower = new IntegerPower(v1);
        assertEquals(1, integerPower.intPower());
        integerPower = new IntegerPower(v2);
        assertEquals(1, integerPower.intPower());
        integerPower = new IntegerPower(v3);
        assertEquals(1, integerPower.intPower());
        integerPower = new IntegerPower(v4);
        assertEquals(1, integerPower.intPower());
        integerPower = new IntegerPower(v5);
        assertEquals(1, integerPower.intPower());
    }

    @Test
    public void testPowerLargeNums() {
        Values v1 = new Values(4,10);
        Values v2 = new Values(25,6);
        Values v3 = new Values(142,8);
        Values v4 = new Values(Integer.MAX_VALUE,2);
        IntegerPower integerPower = new IntegerPower(v1);
        assertEquals(1_048_576, integerPower.intPower());
        integerPower = new IntegerPower(v2);
        assertEquals(244_140_625, integerPower.intPower());
        integerPower = new IntegerPower(v3);
        assertEquals(165_312_903_998_914_816L, integerPower.intPower());
        integerPower = new IntegerPower(v4);
        assertEquals(4_611_686_014_132_420_609L, integerPower.intPower());
    }

    @Test(expected = ArithmeticException.class)
    public void testOverflow() {
        Values v4 = new Values(2,70);
        IntegerPower integerPower = new IntegerPower(v4);
        integerPower.intPower();
    }

    @Test
    public void testNegFirstParam() {
        Values v1 = new Values(-1,71);
        Values v2 = new Values(-1,1);
        Values v3 = new Values(-50,3);
        Values v4 = new Values(-25,5);
        IntegerPower integerPower = new IntegerPower(v1);
        assertEquals(-1, integerPower.intPower());
        integerPower = new IntegerPower(v2);
        assertEquals(-1, integerPower.intPower());
        integerPower = new IntegerPower(v3);
        assertEquals(-125000, integerPower.intPower());
        integerPower = new IntegerPower(v4);
        assertEquals(-9765625, integerPower.intPower());
    }

    @Test(expected = ArithmeticException.class)
    public void testZeroZero() {
        Values v4 = new Values(0,0);
        IntegerPower integerPower = new IntegerPower(v4);
        integerPower.intPower();
    }

    @Test(expected = ArithmeticException.class)
    public void testNegSecondParam() {
        Values v4 = new Values(5,-2);
        IntegerPower integerPower = new IntegerPower(v4);
        integerPower.intPower();
    }

}
