import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.junit.jupiter.params.ParameterizedTest;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MockitoTest {

    //    Tested system
    private IntegerPower integerPower;

//    Mock
    @Mock
    private Values mockValues;




    @ParameterizedTest
    @CsvSource({"-1, 1"})
    public void testPow1(int base, int exp) {
        when(mockValues.getBase()).thenReturn(base);
        when(mockValues.getExp()).thenReturn(exp);

        integerPower = new IntegerPower(mockValues);

        long result = integerPower.intPower();

        Assertions.assertEquals(-1, result);
    }

    @ParameterizedTest
    @CsvSource({"99, 0"})
    public void testPow2(int base, int exp) {
        when(mockValues.getBase()).thenReturn(base);
        when(mockValues.getExp()).thenReturn(exp);

        integerPower = new IntegerPower(mockValues);

        long result = integerPower.intPower();

        Assertions.assertEquals(1, result);
    }

    @ParameterizedTest
    @CsvSource({"0, 71"})
    public void testPow3(int base, int exp) {
        when(mockValues.getBase()).thenReturn(base);
        when(mockValues.getExp()).thenReturn(exp);

        integerPower = new IntegerPower(mockValues);

        long result = integerPower.intPower();

        Assertions.assertEquals(0, result);
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 2})
    public void testPow4() {
        mockValues.setBase(2);
        mockValues.setExp(2);
        when(mockValues.getBase()).thenReturn(2);
        when(mockValues.getExp()).thenReturn(2);

        integerPower = new IntegerPower(mockValues);

        long result = integerPower.intPower();
        System.out.println(result);

        Assertions.assertEquals(4,result);
    }

    @ParameterizedTest
    @CsvSource({"25, 6"})
    public void testPow5(int base, int exp) {
        when(mockValues.getBase()).thenReturn(base);
        when(mockValues.getExp()).thenReturn(exp);

        integerPower = new IntegerPower(mockValues);

        long result = integerPower.intPower();

        Assertions.assertEquals(244_140_625, result);
    }

    @ParameterizedTest
    @CsvSource({"0, 0"})
    public void testPowException(int base, int exp) {
        when(mockValues.getBase()).thenReturn(base);
        when(mockValues.getExp()).thenReturn(exp);

        integerPower = new IntegerPower(mockValues);

        ArithmeticException e = assertThrows(ArithmeticException.class, () -> integerPower.intPower());
    }

}
