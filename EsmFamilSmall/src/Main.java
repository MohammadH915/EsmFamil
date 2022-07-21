import java.util.HashMap;
import java.util.Scanner;

class Round {
    private final String name, city, color, food;

    public Round(String name, String city, String color, String food) {
        this.name = name;
        this.city = city;
        this.color = color;
        this.food = food;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getColor() {
        return color;
    }

    public String getFood() {
        return food;
    }
}

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int n, m;

    static int[] score;


    static char word;

    public static void main(String[] args) {
        System.out.print("Number Of Players : ");
        n = Integer.parseInt(scanner.nextLine());
        score = new int[n];
        System.out.print("Number Of Rounds : ");
        m = Integer.parseInt(scanner.nextLine());
        Start();
    }

    private static void Start() {
        String AlphaNumericString = "abcdefghijklmnopqrstuvxyz";
        for(int i = 1; i <= m; i++) {
            word = AlphaNumericString.charAt((int)(AlphaNumericString.length() * Math.random()));
            System.out.println("Round " + i + " Started With Word : " + word);
            FirstMenu();
            for(int j = 1; j <= n; j++)
                System.out.println("Score Of Player " + j + " is : " + score[j - 1]);
        }
    }

    public static void FirstMenu() {
        Round[] rounds = new Round[n];
        HashMap<String, Integer> names = new HashMap<>();
        HashMap<String, Integer> cities = new HashMap<>();
        HashMap<String, Integer> colors = new HashMap<>();
        HashMap<String, Integer> foods = new HashMap<>();

        for(int i = 0; i < n; i++) {
            rounds[i] = getRound(i);
            if(names.containsKey(rounds[i].getName())) {
                names.remove(rounds[i].getName());
                names.put(rounds[i].getName(), 2);
            }
            else {
                names.put(rounds[i].getName(), 1);
            }
            if(cities.containsKey(rounds[i].getCity())) {
                cities.remove(rounds[i].getCity());
                cities.put(rounds[i].getCity(), 2);
            }
            else {
                cities.put(rounds[i].getCity(), 1);
            }
            if(colors.containsKey(rounds[i].getColor())) {
                colors.remove(rounds[i].getColor());
                colors.put(rounds[i].getColor(), 2);
            }
            else {
                colors.put(rounds[i].getColor(), 1);
            }
            if(foods.containsKey(rounds[i].getFood())) {
                foods.remove(rounds[i].getFood());
                foods.put(rounds[i].getFood(), 2);
            }
            else {
                foods.put(rounds[i].getFood(), 1);
            }
        }

        for(int i = 0; i < n; i++) {
            if(rounds[i].getName().charAt(0) == word) {
                if(names.get(rounds[i].getName()) == 2)
                    score[i] += 5;
                else
                    score[i] += 10;
            }
            if(rounds[i].getCity().charAt(0) == word) {
                if(cities.get(rounds[i].getCity()) == 2)
                    score[i] += 5;
                else
                    score[i] += 10;
            }
            if(rounds[i].getColor().charAt(0) == word) {
                if(colors.get(rounds[i].getColor()) == 2)
                    score[i] += 5;
                else
                    score[i] += 10;
            }
            if(rounds[i].getFood().charAt(0) == word) {
                if(foods.get(rounds[i].getFood()) == 2)
                    score[i] += 5;
                else
                    score[i] += 10;
            }
        }
    }

    private static Round getRound(int i) {
        System.out.println("Player " + (i + 1) + " Input : ");
        String name, city, color, food;
        System.out.print("Enter name with word " + word + " : ");
        name = scanner.nextLine();
        System.out.print("Enter city with word " + word + " : ");
        city = scanner.nextLine();
        System.out.print("Enter color with word " + word + " : ");
        color = scanner.nextLine();
        System.out.print("Enter food with word " + word + " : ");
        food = scanner.nextLine();
        return new Round(name, city, color, food);

    }
}
