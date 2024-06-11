package Homework04;

import java.util.Objects;

public class Friendship {
   private String first_friend;
   private String second_friend;
   private int strength;

   public Friendship( String first_friend, String second_friend, int strength){
       this.first_friend = first_friend;
       this.second_friend = second_friend;
       this.strength = strength;
   }
   public Friendship(){
       this.first_friend = "Faris";
       this.second_friend = "IBU";
       this.strength = 0;
   }

    public String getFirst_friend() {
        return first_friend;
    }

    public String getSecond_friend() {
        return second_friend;
    }

    public int getStrength() {
        return strength;
    }

    public void setFirst_friend(String first_friend) {
        this.first_friend = first_friend;
    }

    public void setSecond_friend(String second_friend) {
        this.second_friend = second_friend;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public String toString(){
       return this.first_friend + " " + this.second_friend + " " + this.strength;
    }

}