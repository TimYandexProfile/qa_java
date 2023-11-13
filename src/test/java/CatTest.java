import com.example.Cat;
import com.example.Feline;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
public class CatTest {

    @Mock
    private Feline feline;

    @Test
    public void testGetSound() {
        Cat cat = new Cat(feline);
        String sound = cat.getSound();
        assertEquals("Мяу", sound);
    }

    @Test
    public void testGetFood() throws Exception {
        Cat cat = new Cat(feline);
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Мясо"));

        List<String> foodList = cat.getFood();
        assertEquals(List.of("Мясо"), foodList);
    }


}