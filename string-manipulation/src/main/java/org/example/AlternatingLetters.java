package org.example;

public class AlternatingLetters {
    public static void main(String[] args) {
        String s1 = "Spongebob";
        String s2 = "spongebob";

        System.out.println(alternate(s1));
        System.out.println(alternate(s2));



    }

    // Exercise, fill out this method
    // ex: input -> Spongebob, output -> SpOnGeBoB
    // ex: input -> spongebob, output -> sPoNgEbOb
    public static String alternate(String s) {
        char[] chars = s.toCharArray();
        if(Character.isUpperCase(chars[0])){
            for (int i = 0; i < s.length(); i+=2) {
                chars[i] = Character.toUpperCase(chars[i]);
            }
        }else{
            for (int i = 1; i < s.length(); i+=2) {
                chars[i] = Character.toUpperCase(chars[i]);
            }
        }

        String result = new String(chars);
        return result;
    }
}
