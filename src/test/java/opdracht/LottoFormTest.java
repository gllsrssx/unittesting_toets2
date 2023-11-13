package opdracht;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Set;
import java.util.HashSet;

public class LottoFormTest {

    @Test
    public void testConstructorValidNumbers() {
        Set<Integer> numbers = new HashSet<>(Set.of(1, 2, 3, 4, 5, 6));
        assertDoesNotThrow(() -> new LottoForm(numbers));
    }

    @Test
    public void testConstructorInvalidNumbersCount() {
        Set<Integer> numbers = new HashSet<>(Set.of(1, 2, 3, 4, 5));
        assertThrows(IllegalArgumentException.class, () -> new LottoForm(numbers));
    }

    @Test
    public void testConstructorInvalidNumberRange() {
        Set<Integer> numbers = new HashSet<>(Set.of(1, 2, 3, 4, 5, 46));
        assertThrows(IllegalArgumentException.class, () -> new LottoForm(numbers));
    }

    @Test
    public void testPlayValidNumbers() {
        Set<Integer> numbers = new HashSet<>(Set.of(1, 2, 3, 4, 5, 6));
        LottoForm lottoForm = new LottoForm(numbers);
        Set<Integer> gamble = new HashSet<>(Set.of(7, 8, 9, 10, 11, 12));
        Integer extraNumber = 13;
        assertDoesNotThrow(() -> lottoForm.play(gamble, extraNumber));
    }

    @Test
    public void testPlayInvalidNumbersCount() {
        Set<Integer> numbers = new HashSet<>(Set.of(1, 2, 3, 4, 5, 6));
        LottoForm lottoForm = new LottoForm(numbers);
        Set<Integer> gamble = new HashSet<>(Set.of(7, 8, 9, 10, 11));
        Integer extraNumber = 12;
        assertThrows(IllegalArgumentException.class, () -> lottoForm.play(gamble, extraNumber));
    }

    @Test
    public void testPlayInvalidNumberRange() {
        Set<Integer> numbers = new HashSet<>(Set.of(1, 2, 3, 4, 5, 6));
        LottoForm lottoForm = new LottoForm(numbers);
        Set<Integer> gamble = new HashSet<>(Set.of(7, 8, 9, 10, 11, 46));
        Integer extraNumber = 12;
        assertThrows(IllegalArgumentException.class, () -> lottoForm.play(gamble, extraNumber));
    }

    @Test
    public void testPlayInvalidExtraNumberRange() {
        Set<Integer> numbers = new HashSet<>(Set.of(1, 2, 3, 4, 5, 6));
        LottoForm lottoForm = new LottoForm(numbers);
        Set<Integer> gamble = new HashSet<>(Set.of(7, 8, 9, 10, 11, 12));
        Integer extraNumber = 46;
        assertThrows(IllegalArgumentException.class, () -> lottoForm.play(gamble, extraNumber));
    }

    @Test
    public void testPlayResultNoWin() {
        Set<Integer> numbers = new HashSet<>(Set.of(1, 2, 3, 4, 5, 6));
        LottoForm lottoForm = new LottoForm(numbers);
        Set<Integer> gamble = new HashSet<>(Set.of(7, 8, 9, 10, 11, 12));
        Integer extraNumber = 13;
        assertEquals(PlayResult.NO_WIN, lottoForm.play(gamble, extraNumber));
    }

    @Test
    public void testPlayResultFound4() {
        Set<Integer> numbers = new HashSet<>(Set.of(1, 2, 3, 4, 5, 6));
        LottoForm lottoForm = new LottoForm(numbers);
        Set<Integer> gamble = new HashSet<>(Set.of(1, 2, 3, 4, 11, 12));
        Integer extraNumber = 0;
        assertEquals(PlayResult.FOUND_4, lottoForm.play(gamble, extraNumber));
    }

    @Test
    public void testPlayResultFound4Plus1() {
        Set<Integer> numbers = new HashSet<>(Set.of(1, 2, 3, 4, 5, 6));
        LottoForm lottoForm = new LottoForm(numbers);
        Set<Integer> gamble = new HashSet<>(Set.of(1, 2, 3, 4, 10, 11));
        Integer extraNumber = 10;
        assertEquals(PlayResult.FOUND_4PLUS1, lottoForm.play(gamble, extraNumber));
    }

    @Test
    public void testPlayResultFound5() {
        Set<Integer> numbers = new HashSet<>(Set.of(1, 2, 3, 4, 5, 6));
        LottoForm lottoForm = new LottoForm(numbers);
        Set<Integer> gamble = new HashSet<>(Set.of(1, 2, 3, 4, 5, 43));
        Integer extraNumber = 0;
        assertEquals(PlayResult.FOUND_5, lottoForm.play(gamble, extraNumber));
    }

    @Test
    public void testPlayResultFound5Plus1() {
        Set<Integer> numbers = new HashSet<>(Set.of(1, 2, 3, 4, 5, 6));
        LottoForm lottoForm = new LottoForm(numbers);
        Set<Integer> gamble = new HashSet<>(Set.of(0,1,2,3,4,5));
        Integer extraNumber = 0;
        assertEquals(PlayResult.FOUND_5PLUS1, lottoForm.play(gamble, extraNumber));
    }

    @Test
    public void testPlayResultFound6() {
        Set<Integer> numbers = new HashSet<>(Set.of(1, 2, 3, 4, 5, 6));
        LottoForm lottoForm = new LottoForm(numbers);
        Set<Integer> gamble = new HashSet<>(Set.of(1, 2, 3, 4, 5, 6));
        Integer extraNumber = 0;
        assertEquals(PlayResult.FOUND_6, lottoForm.play(gamble, extraNumber));
    }

}