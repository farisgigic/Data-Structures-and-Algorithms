package Homework04;

public class FriendshipRecommendation implements Comparable<FriendshipRecommendation> {
    private String user;
    private int recomendationStrength ;
    public FriendshipRecommendation(String user, int recommendationStrength){
        this.user = user;
        this.recomendationStrength = recommendationStrength;
    }

    public String getUser() {
        return user;
    }

    public int getRecomendationStrength() {
        return recomendationStrength;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setRecomendationStrength(int recomendationStrength) {
        this.recomendationStrength = recomendationStrength;
    }

    @Override
    public int compareTo(FriendshipRecommendation o) {
        return Integer.compare(this.recomendationStrength, o.recomendationStrength);
    }

    public String toString(){
        return this.user + ": " + this.recomendationStrength;
    }
}