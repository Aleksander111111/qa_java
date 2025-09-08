import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;

    @Test
    public void testGetKittens() throws Exception {
        Lion lion = new Lion("Самец", feline);
        int expectedKittens = 5;
        Mockito.when(feline.getKittens()).thenReturn(expectedKittens);

        int actualKittens = lion.getKittens();
        assertEquals("getKittens() должен возвращать результат вызова feline.getKittens()", expectedKittens, actualKittens);
    }

    @Test
    public void testGetKittensCallsFelineMethod() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getKittens()).thenReturn(1);

        lion.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens();
    }

    @Test
    public void testGetFoodReturnsCorrectList() throws Exception {
        Lion lion = new Lion("Самец", feline);
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(expectedFood);

        List<String> actualFood = lion.getFood();
        assertEquals("getFood() должен возвращать результат вызова feline.eatMeat()", expectedFood, actualFood);
    }

    @Test
    public void testGetFoodCallsFelineMethod() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        lion.getFood();
        Mockito.verify(feline, Mockito.times(1)).eatMeat();
    }

    @Test(expected = Exception.class)
    public void testLionWithInvalidSexThrowsException() throws Exception {
        new Lion("Неизвестный пол", feline);
    }
}
