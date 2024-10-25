package lesson_11.code.regex;

import java.util.Arrays;

public class Example7 {
    public static void main(String[] args) {
        String inputString = "java, programming language? the% best. in the World!";
        /// -------
       // String[] words = inputString.split(" ");

        String[] words = inputString.split("[% ,\\?!\\.]\\s*");

        System.out.println(Arrays.toString(words));

    }
}
