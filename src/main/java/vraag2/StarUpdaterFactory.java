package vraag2;

public class StarUpdaterFactory {
    public static StarUpdater getStarUpdaterFactoryInstance(Friend friend) {
        return switch (friend.nrOfStars) {
            case 1 -> new OneStarUpdater();
            case 2 -> new TwoStarUpdater();
            case 3 -> new ThreeStarUpdater();
            default -> new ZeroStarUpdater();
        };
    }
}

