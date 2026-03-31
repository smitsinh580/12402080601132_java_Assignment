
// Problem Statement:
// Inheritance based on Cricket Match

import java.util.Scanner;

// Base class representing a generic Player
class Player {
    String name;
    int age;

    // Constructor to initialize player details
    Player(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Method to display player details
    void display() {
        System.out.println("Name: " + name + "  Age: " + age);
    }
}

// Derived class representing a Batsman
class Batsman extends Player {
    int runs;
    int balls;

    // Constructor to initialize batsman details
    Batsman(String name, int age, int runs, int balls) {
        super(name, age); // Call Player constructor
        this.runs = runs;
        this.balls = balls;
    }

    // Method to calculate strike rate
    double strikeRate() {
        if (balls == 0) { // Avoid division by zero
            return 0;
        }
        return ((double) runs / balls) * 100;
    }

    // Override display method to show batsman stats
    @Override
    void display() {
        super.display(); // Display name and age
        System.out.println("Runs: " + runs + "  Balls: " + balls + "  Strike Rate: " + strikeRate());
    }
}

// Derived class representing a Bowler
class Bowler extends Player {
    int wickets;
    double overs;

    // Constructor to initialize bowler details
    Bowler(String name, int age, int wickets, double overs) {
        super(name, age); // Call Player constructor
        this.wickets = wickets;
        this.overs = overs;
    }

    // Override display method to show bowler stats
    @Override
    void display() {
        super.display(); // Display name and age
        System.out.println("Wickets: " + wickets + "  Overs: " + overs);
    }
}

// Main class to simulate a Cricket Match
class CricketMatch {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input batsman details
        System.out.print("Enter batsman name: ");
        String bName = sc.nextLine();
        System.out.print("Enter runs scored: ");
        int runs = sc.nextInt();
        System.out.print("Enter balls faced: ");
        int balls = sc.nextInt();

        sc.nextLine(); // Consume newline

        // Input bowler details
        System.out.print("Enter bowler name: ");
        String wName = sc.nextLine();
        System.out.print("Enter wickets taken: ");
        int wkts = sc.nextInt();
        System.out.print("Enter overs bowled: ");
        double ovrs = sc.nextDouble();

        // Create objects with sample ages
        Batsman bt = new Batsman(bName, 36, runs, balls);
        Bowler bw = new Bowler(wName, 30, wkts, ovrs);

        // Display results
        System.out.println("--- Batsman ---");
        bt.display();
        System.out.println("--- Bowler ---");
        bw.display();

        sc.close();
    }
}
