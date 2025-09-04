import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineTest {

    private final int expectedKittens;
    private final int inputCount;

    public FelineTest(int expectedKittens, int inputCount) {
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
    public void testEatMeat() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        List<String> actualFood = feline.eatMeat();
        assertEquals(expectedFood, actualFood);
    }

    @Test
    public void testGetFamily() {
        String expectedFamily = "Кошачьи";
        String actualFamily = feline.getFamily();
        assertEquals(expectedFamily, actualFamily);
    }

    @Test
    public void testGetKittensNoArgs() {
        int expectedKittens = 1;
        int actualKittens = feline.getKittens();
        assertEquals(expectedKittens, actualKittens);
    }

    @Test
    public void testGetKittensWithParameterizedArgs() {
        int actualKittens = feline.getKittens(inputCount);
        assertEquals(expectedKittens, actualKittens);
    }
}