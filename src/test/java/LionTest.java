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
        Mockito.verify(feline, Mockito.times(1)).getKittens();
        assertEquals(expectedKittens, actualKittens);
    }

    @Test
    public void testGetFood() throws Exception {
        Lion lion = new Lion("Самец", feline);
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(expectedFood);

        List<String> actualFood = lion.getFood();
        Mockito.verify(feline, Mockito.times(1)).eatMeat();
        assertEquals(expectedFood, actualFood);
    }

    @Test(expected = Exception.class)
    public void testLionWithInvalidSexThrowsException() throws Exception {
        new Lion("Неизвестный пол", feline);
    }
}
