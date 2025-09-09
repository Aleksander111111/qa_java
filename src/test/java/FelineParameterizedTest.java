import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineParameterizedTest {

    private final int expectedKittens;
    private final int inputCount;

    public FelineParameterizedTest(int expectedKittens, int inputCount) {
        this.expectedKittens = expectedKittens;
        this.inputCount = inputCount;
    }

    @Parameterized.Parameters
    public static Object[][] getKittensData() {
        return new Object[][]{
                {1, 1},
                {0, 0},
                {5, 5},
        };
    }

    Feline feline = new Feline();

    @Test
    public void testGetKittensWithParameterizedArgs() {
        int actualKittens = feline.getKittens(inputCount);
        assertEquals(expectedKittens, actualKittens);
    }
}
