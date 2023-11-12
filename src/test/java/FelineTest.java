import com.example.Feline;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class FelineTest {

    public static final int KITTENS_COUNT = 3;
    @InjectMocks
    private Feline feline;

    @Test
    public void testEatMeat() throws Exception {

        List<String> foodList = feline.eatMeat();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), foodList);
    }

    @Test
    public void testGetFamily() {
        String family = feline.getFamily();
        assertEquals("Кошачьи", family);
    }

    @Test
    public void testGetKittens() {
        int kittens = feline.getKittens();
        assertEquals(1, kittens);
    }

    @Test
    public void testGetKittensWithCount() {
        int kittens = feline.getKittens(KITTENS_COUNT);
        assertEquals(3, kittens);
    }
}

