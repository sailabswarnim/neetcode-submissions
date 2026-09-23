class Twitter {
    HashMap<Integer, User> users;
    int timestamp = 0;
    public Twitter() {
        this.users = new HashMap<>();
    }

    class Tweet {
        int timestamp;
        int tweetID;

        Tweet(int timestamp, int tweetID){
            this.timestamp = timestamp;
            this.tweetID = tweetID;
        }        
    }
    
    public void postTweet(int userId, int tweetId) {
        User user = users.get(userId);
        if(user == null){
            user = new User(userId);
             users.put(userId, user);
        }

        user.tweets.add(new Tweet(timestamp++, tweetId));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        User user = users.get(userId);
        if(user == null){
            return new ArrayList<>();
        }

        PriorityQueue<Tweet> feed = user.newsFeed;
        for(Tweet userTweet : user.tweets){
            feed.add(userTweet);
            if(feed.size() > 10){
                feed.poll();
            }
        }

        for(Integer followeeId : user.followees){
            User followee = users.get(followeeId);
            for(Tweet userTweet : followee.tweets){
                feed.add(userTweet);
                if(feed.size() > 10){
                    feed.poll();
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        while(!feed.isEmpty()){
            Tweet tweet = feed.poll();
            result.add(0,tweet.tweetID);
        }

        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        User follower = users.get(followerId);
        if(follower == null){
            follower = new User(followerId);
             users.put(followerId, follower);
        }

        User followee = users.get(followeeId);
        if(followee == null){
            followee = new User(followeeId);
            users.put(followeeId, followee);
        }

        if(!follower.followees.contains(followeeId)){
            follower.followees.add(followeeId);
        }

        if(!followee.followers.contains(followerId)){
            followee.followers.add(followerId);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        User follower = users.get(followerId);
        if(follower == null){
            follower = new User(followerId);
             users.put(followerId, follower);
        }

        User followee = users.get(followeeId);
        if(followee == null){
            followee = new User(followeeId);
            users.put(followeeId, followee);
        }

        if(follower.followees.contains(followeeId)){
            follower.followees.remove(followeeId);
        }

        if(followee.followers.contains(followerId)){
            followee.followers.remove(followerId);
        }
    }

    public class User {
        int userId;
        HashSet<Integer> followees;
        HashSet<Integer> followers;
        PriorityQueue<Tweet> newsFeed;
        List<Tweet> tweets;

        User(int userId){
            this.userId = userId;
            this.followees = new HashSet<>();
            this.followers = new HashSet<>();
            this.newsFeed = new PriorityQueue<>((a,b) -> a.timestamp - b.timestamp);
            this.tweets = new ArrayList<>();
        }
    }
}
