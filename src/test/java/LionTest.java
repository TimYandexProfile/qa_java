import com.example.Feline;
import com.example.Lion;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class LionTest {

    @Mock
    private Feline feline;

    @Test
    public void testGetKittens() throws Exception {
        when(feline.getKittens()).thenReturn(1);
        Lion maleLion = new Lion("Самец", feline);
        int kittens = maleLion.getKittens();
        assertEquals(1, kittens);
    }

    @ParameterizedTest
    @MethodSource("provideLionData")
    public void testDoesHaveMane(String sex, boolean expected) throws Exception {
        Lion testLion = new Lion(sex, feline);
        assertEquals(expected, testLion.doesHaveMane());
    }

    @Test
    public void testGetFood() throws Exception {
        Lion lion = new Lion("Самец", feline);
        when(feline.getFood("Хищник")).thenReturn(List.of("Мясо"));

        List<String> foodList = lion.getFood();
        assertEquals(List.of("Мясо"), foodList);
    }

    @Test
    public void testInvalidSex() {
        assertThrows(Exception.class, () -> new Lion("Некорректное значение", new Feline()), "Используйте допустимые значения пола животного - самец или самка");
    }

    private static Stream<Object[]> provideLionData() {
        return Stream.of(
                new Object[]{"Самец", true},
                new Object[]{"Самка", false}
        );
    }

}
