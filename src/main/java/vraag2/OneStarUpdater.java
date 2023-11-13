package vraag2;

public class OneStarUpdater implements StarUpdater {
    @Override
    public void updateStars(Friend friend) {
        if (friend.friendshipLevel == 10) {
            StarUpdater.getExtraStar(friend);
        }
    }
}
