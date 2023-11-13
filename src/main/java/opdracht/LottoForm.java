package opdracht;

import java.util.HashSet;
import java.util.Set;

public class LottoForm {
    private final Set<Integer> numbers;
    private boolean extraNumberWasFound = false;
    private final Set<Integer> winners = new HashSet<>();

    public LottoForm(Set<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("Expecting 6 unique numbers, got " + numbers.size());
        }
        for (Integer number : numbers) {
            if (number < 0 || number > 45) {
                throw new IllegalArgumentException("Expecting numbers between 0 and 45, got " + number);
            }
        }
        this.numbers = numbers;
    }

    public PlayResult play(Set<Integer> gamble, int extraNumber) {
        if (extraNumber < 0 || extraNumber > 45) {
            throw new IllegalArgumentException("Expecting extra number between 0 and 45, got " + extraNumber);
        }
        if (gamble.size() != 6) {
            throw new IllegalArgumentException("Expecting 6 unique numbers, got " + gamble.size());
        }
        for (Integer number : gamble) {
            if (number < 0 || number > 45) {
                throw new IllegalArgumentException("Expecting numbers between 0 and 45, got " + number);
            }
        }

        this.extraNumberWasFound = false;
        this.winners.clear();

        for (Integer number : gamble) {
            if (numbers.contains(number)) {
                winners.add(number);
            }
            if (number == extraNumber) {
                extraNumberWasFound = true;
            }
        }

        if (winners.size() == 4) {
            if (extraNumberWasFound) {
                return PlayResult.FOUND_4PLUS1;
            }
            return PlayResult.FOUND_4;
        }
        if (winners.size() == 5) {
            if (extraNumberWasFound) {
                return PlayResult.FOUND_5PLUS1;
            }
            return PlayResult.FOUND_5;
        }
        if (winners.size() > 5) {
            return PlayResult.FOUND_6;
        }
        return PlayResult.NO_WIN;
    }
}
