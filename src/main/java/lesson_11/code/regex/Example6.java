package lesson_11.code.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Example6 {
    public static void main(String[] args) {
        String inputString = "mycat ourcat23 yourcat23_user theycaaaaat5_5e cat7.6";
        /// -------
        String regex = "(\\w*)cat\\w*";

        // A(может быть а может и НЕ быть любое количество символов)а

        // -----

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(inputString);

        int matchCounter = 0;

        while (matcher.find()) {
            matchCounter++;

            System.out.println("'" + inputString.substring(matcher.start(), matcher.end()) + "'");
            System.out.println("Start: " + matcher.start());
            System.out.println("End: " + matcher.end());
            System.out.println("Number of match: " + matchCounter);
        }

    }
}
