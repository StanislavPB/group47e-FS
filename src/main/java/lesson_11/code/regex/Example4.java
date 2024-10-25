package lesson_11.code.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Example4 {
    public static void main(String[] args) {
        String inputString = "привет Алла Александр Ада Алла Андрей";
        // ------
 //       String regex = "А.+а"; // жадный режим
        String regex = "А.+?а"; // ленивый режим
 //       String regex = "А.++а"; // сверхжадный режим


        //
        // -----

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(inputString);

        int matchCounter = 0;

        while (matcher.find()){
            matchCounter++;

            System.out.println("'" + inputString.substring(matcher.start(), matcher.end()) + "'");
            System.out.println("Start: " + matcher.start());
            System.out.println("End: " + matcher.end());
            System.out.println("Number of match: " +matchCounter );
        }


    }
}
