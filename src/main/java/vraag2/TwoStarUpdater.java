package vraag2;

public class TwoStarUpdater implements StarUpdater {
    @Override
    public void updateStars(Friend friend) {
        if (friend.friendshipLevel == 30) {
            StarUpdater.getExtraStar(friend);
        }
    }
}
