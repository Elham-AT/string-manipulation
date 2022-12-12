package org.example;

public class StringFormatter {
    public static void main(String[] args) {
        System.out.println(reverseEveryOtherWord("Somebody once told me"));
    }
    public static String reverseEveryOtherWord(String s) {
        String words[] = s.split(" ");
        String revString = "";
        for (int i = 0; i < words.length; i++) {

            if (i % 2 != 0) {
                String word = words[i];
                String reverseWord = "";
                for (int j = word.length() - 1; j >= 0; j--) {
                    reverseWord = reverseWord + word.charAt(j);
                }
                revString = revString + reverseWord + " ";
            }else{
                revString = revString + words[i] + " ";
            }
        }
        return revString;
    }
}
