package me.guid118;


import java.util.Scanner;

import static java.lang.Math.round;

public class Main {
    static double points;
    static double totalpoints;
    static double nterm;
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Config.CreateFile();
        System.out.println("this is a grade calculator, used to calculate your grade given the right inputs. \nIt can either use the config.json or the command line.");
        System.out.println("do you want to use the config.json? [y/n]");
        System.out.println("please note that the config.json must contain the appropriate values before confirming here.");
        if (scanner.nextLine().equalsIgnoreCase("y")) {
            useconfig();
        } else {
            console();
        }
    }

    private static void useconfig() {
        System.out.println("getting values from config.json");
        try {
            points = Config.getvalue("points");
            totalpoints = Config.getvalue("maximum_points");
            nterm =  Config.getvalue("n-term");
            calculate();
        } catch (Exception e) {
            System.out.println("that did not work, reverting to console method");
            console();
        }


    }

    public static void console() {
            System.out.println("getting values from console. \nHow many points did you get?");
            points = scanner.nextInt();
            System.out.println("And how many points were you able to get in total?");
            totalpoints = scanner.nextInt();
            System.out.println("What is the n-term for this test?");
            nterm = scanner.nextDouble();
            calculate();
    }

    public static void calculate() {
        double result = (points / totalpoints) * 9 + nterm;
        int scale = (int) Math.pow(10, 1);
        double roundedresult = (double) round(result * scale) / scale;
        System.out.println("result: " + roundedresult);
        System.exit(0);
    }
}
