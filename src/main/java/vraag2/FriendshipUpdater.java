package vraag2;

public class FriendshipUpdater {

    final Friend[] friends;

    public FriendshipUpdater(Friend[] friends) {
        this.friends = friends;
    }

    public void update() {
        for (Friend friend : friends) {
            handleLuckyFriend(friend);

            if (friend.didSomeInteractionToday) {
                friend.friendshipLevel++;
                StarUpdater starUpdater = StarUpdaterFactory.getStarUpdaterFactoryInstance(friend);
                starUpdater.updateStars(friend);
            }
        }
    }


    private void handleLuckyFriend(Friend friend) {
        if (friend.isLucky && friend.didSomeInteractionToday) {
            friend.friendshipLevel += 4;
            friend.isLucky = false;
        }
    }

}

