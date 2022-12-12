package org.example.day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Challenge2 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("real1.txt"));
            // keep track of the maximum
            int max = 0;
            // keep track of sum of current elf:
            int sum = 0;
            // make an array list to keep track of our current sums
            List<Integer> sums = new ArrayList<>();
            while(scanner.hasNext()) {
                String current = scanner.nextLine();
                if(current.equals("")) {
                    // do some logic to move on to the next elf
                    sums.add(sum);
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
            sums.add(sum);
            System.out.println(sums);
            // Now that we have all of our sums stored in an array list, we want to get the top 3:
            // make it in order from least to greatest
            Collections.sort(sums);
            // reverse it, so the first 3 elements are the greatest:
            Collections.reverse(sums);
            System.out.println("Final answer: " + sums.get(0) + " + " + sums.get(1) + " + " + sums.get(2) + " = " + (sums.get(0) + sums.get(1) + sums.get(2)));
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            throw new RuntimeException(e);
        }
        // Challenge, Refactor this solution to use less memory/less time
    }
}
