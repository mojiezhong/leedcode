package main.com.molingxi.i355;

import java.util.*;

class Twitter {

    class Message {
        public int tweetid;
        public int sequence;

        public Message(int tid, int s) {
            this.tweetid = tid;
            this.sequence = s;
        }
    }



    int seed;

    class Person{
        public Set<Integer> followed = new HashSet<>();
        public ArrayList<Message> messages = new ArrayList<>();
    }

    Map<Integer, Person> persons = new HashMap<>();

    /** Initialize your data structure here. */
    public Twitter() {

    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        persons.computeIfAbsent(userId, (k) -> new Person()).messages.add(new Message(tweetId, seed++));
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        return null;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        persons.computeIfAbsent(followerId, (k) -> new Person()).followed.add(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        persons.computeIfAbsent(followerId, (k) -> new Person()).followed.remove(followeeId);
    }
}