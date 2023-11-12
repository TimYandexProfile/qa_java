import com.example.Animal;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class AnimalTest {

    private static final String HERBIVORE = "Травоядное";
    private static final String PREDATOR = "Хищник";
    private static final String EXPECTED_FAMILIES = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";

    @InjectMocks
    private Animal animal;

    @Test
    public void testGetFoodForHerbivore() throws Exception {
        List<String> foodList = animal.getFood(HERBIVORE);

        assertEquals(List.of("Трава", "Различные растения"), foodList);
    }

    @Test
    public void testGetFoodForPredator() throws Exception {
        List<String> foodList = animal.getFood(PREDATOR);

        assertEquals(List.of("Животные", "Птицы", "Рыба"), foodList);
    }

    @Test
    public void testGetFamily() {
        String family = animal.getFamily();
        assertEquals(EXPECTED_FAMILIES, family);
    }

    @Test
    public void testGetFoodThrowsException() {
        assertThrows(Exception.class, () -> animal.getFood("Неизвестный вид"));
    }
}
