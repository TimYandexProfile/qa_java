import com.example.Feline;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class FelineTest {

    public static final int KITTENS_COUNT = 3;

    @Test
    public void testEatMeat() throws Exception {
        Feline feline = new Feline(); // Вручную создаем экземпляр класса Feline

        List<String> foodList = feline.eatMeat();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), foodList);
    }

    @Test
    public void testGetFamily() {
        Feline feline = new Feline();

        String family = feline.getFamily();
        assertEquals("Кошачьи", family);
    }

    @Test
    public void testGetKittens() {
        Feline feline = new Feline();

        int kittens = feline.getKittens();
        assertEquals(1, kittens);
    }

    @Test
    public void testGetKittensWithCount() {
        Feline feline = new Feline();

        int kittens = feline.getKittens(KITTENS_COUNT);
        assertEquals(3, kittens);
    }
}
