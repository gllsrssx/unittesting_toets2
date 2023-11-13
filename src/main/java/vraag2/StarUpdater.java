package vraag2;

public interface StarUpdater {
    void updateStars(Friend friend);
    static void getExtraStar(Friend friend) {
        friend.friendshipLevel = 0;
        friend.nrOfStars += 1;
    }
}
