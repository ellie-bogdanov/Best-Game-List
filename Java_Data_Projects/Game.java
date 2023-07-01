import java.util.ArrayList;
import java.util.Comparator;

public class Game implements Comparable<Game>{
    private String name;
    private String price;
    private String positive;
    private String negative;
    private double score;
    public Game(String name, String price, String positive, String negative){
        this.name = name;
        this.price = price;
        this.positive = positive;
        this.negative = negative;
        this.score = 0;
    }



    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public String getNegative() {
        return negative;
    }

    public String getPositive() {
        return positive;
    }

    public String getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNegative(String negative) {
        this.negative = negative;
    }

    public void setPositive(String positive) {
        this.positive = positive;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public int compareTo(Game game) {
        return -Double.compare(this.score, game.getScore());
    }
    


}
