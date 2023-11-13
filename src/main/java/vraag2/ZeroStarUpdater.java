package vraag2;

public class ZeroStarUpdater implements StarUpdater {
    @Override
    public void updateStars(Friend friend) {
        StarUpdater.getExtraStar(friend);
    }
}
