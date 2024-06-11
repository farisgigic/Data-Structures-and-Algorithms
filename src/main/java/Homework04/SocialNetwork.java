package Homework04;
import java.util.*;

public class SocialNetwork {
    private int V;
    private int E;
    private HashMap<String, ArrayList<Friendship>> adj;

    public SocialNetwork() {
        this.V = 0;
        this.E = 0;
        adj = new HashMap<>();
    }
    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void setV(int v) {
        V = v;
    }

    public void setE(int e) {
        E = e;
    }

    public HashMap<String, ArrayList<Friendship>> getAdj() {
        return adj;
    }

    public void setAdj(HashMap<String, ArrayList<Friendship>> newAdj) {
        this.adj = newAdj;
    }

    public SocialNetwork(Scanner in) {
        in.nextLine(); // inserting using Scanner
        while (in.hasNextLine()) {
            String line = in.nextLine();
            String[] data = line.split(";");
            if (data.length == 3) {
                String first_friend = data[0];
                String second_friend = data[1];

                int strength = Integer.parseInt(data[2]);

                addFriendship(new Friendship(first_friend, second_friend, strength));
            }
        }
    }

    public void addUser(String user) {
        if (!adj.containsKey(user)) {
            adj.put(user, new ArrayList<>());
            V++;
        }
    }

    public void addFriendship(Friendship f) {
        if (!adj.containsKey(f.getFirst_friend())) {
            addUser(f.getFirst_friend());
        }
        if (!adj.containsKey(f.getSecond_friend())) {
            addUser(f.getSecond_friend());
        }
        adj.get(f.getFirst_friend()).add(f);
        adj.get(f.getSecond_friend()).add(f);
        E++;
    }

    public ArrayList<FriendshipRecommendation> recommendFriends(String user) {

        if (!adj.containsKey(user)) {
            return new ArrayList<>();
        }

        HashMap<String, Integer> potentialFriends = new HashMap<>();
        ArrayList<Friendship> userFriendships = adj.get(user);

        String friend;

        for (Friendship f : userFriendships) {
            // user ne moze sam sebi biti prijatelj, bar u ovom slucaju :)
            if (f.getFirst_friend().equals(user)) {
                friend = f.getSecond_friend();
            } else {
                friend = f.getFirst_friend();
            }

            // ff - friends of the friend
            String potentialFriend;
            for (Friendship ff : adj.get(friend)) {
                if (ff.getFirst_friend().equals(friend)) {
                    potentialFriend = ff.getSecond_friend();
                } else {
                    potentialFriend = ff.getFirst_friend();
                }


                if (potentialFriend.equals(user) || containsFriendship(user, potentialFriend)) {
                    continue; // Skip if the potential friend is the user or if the user is already friends with the potential friend.
                }

                int currentStrength = Math.min(f.getStrength(), ff.getStrength());
                potentialFriends.merge(potentialFriend, currentStrength, Integer::sum);

                // ako potentialFriend ne postoji u mapi ubacuje novi entry u potentialFriends sa parametrima potentialFriend i currentStrength
                // ako postoji on ce uraditi update koristenjem Integer::sum i time ce updateovati vrijednost strengtha sa currentStrength
                // i to jednostavno mozemo objasniti na primjeru lambde : a -> vec postojeca vrijednost, b -> nova vrijednost, rezultat (a + b)

                // potentialFriends.merge(potentialFriend, currentStrength, (a,b) -> a + b; using lambda expression


            }
        }

        ArrayList<FriendshipRecommendation> recommendations = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : potentialFriends.entrySet()) {
            recommendations.add(new FriendshipRecommendation(entry.getKey(), entry.getValue()));
        }

        Collections.sort(recommendations);
        Collections.reverse(recommendations);

        return recommendations;
    }

    private boolean containsFriendship(String user, String potentialFriend) {
        ArrayList<Friendship> friendships = adj.get(user);

        for (Friendship f : friendships) {
            if (f.getFirst_friend().equals(potentialFriend) || f.getSecond_friend().equals(potentialFriend)) {
                return true; // here we are checking if the user is already friend with potentialFriend, true if it is
            }
        }
        return false;
    }


}