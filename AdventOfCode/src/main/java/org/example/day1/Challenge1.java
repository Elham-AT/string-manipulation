package org.example.day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Challenge1 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("real1.txt"));
            // keep track of the maximum
            int max = 0;
            // keep track of sum of current elf:
            int sum = 0;
            while(scanner.hasNext()) {
                String current = scanner.nextLine();
                if(current.equals("")) {
                    // do some logic to move on to the next elf
                    if(sum > max) max = sum;
                    // this happens even if we have a new max (reset sum to 0 because we move on to a new elf)
                    sum = 0;
                }
                else {
                    // parse the current number:
                    int currentInt = Integer.parseInt(current);
                    // add the current to the sum of the current elf:
                    sum += currentInt;
                }
            }
            System.out.println("Final answer: " + max);
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            throw new RuntimeException(e);
        }
    }
}
