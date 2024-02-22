import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise3 {

    /*
    implement the method below so that it extracts a URL from a String
    I will write the basics for this one method, you will have to implement the other two methods from scratch
    */

    public static String extractURL(String text)
    {
        String regex = "(http|https)://(www.)?[a-zA-Z0-9@:%._-]{2,256}\\.[a-zA-Z]{2,6}";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        if (matcher.find()) {
            return matcher.group();
        }
        else
        {
            return null;
        }
    }

    /*
    implement the method below to validate an email address
     */

    public static boolean validateEmail(String email)
    {
        String regex = "^[^\\s\\.@]+@[^\\s\\.@]+\\.[^\\s\\.@]{2,3}$";

        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);

        return matcher.find();
    }

    /*
    implement the method below so that it returns a list of words with repeated letters
    */

    public static List<String> findWordsWithRepeatLetters(String input) {
        List<String> wordsWithRepeatLetters = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\b\\w*(\\w)\\w*\\1\\w*\\b");
        Matcher matcher = pattern.matcher(input);
        while(matcher.find())
        {
            wordsWithRepeatLetters.add(matcher.group());
        }
        return wordsWithRepeatLetters;

    }

    /*
    Bonus Problem ;)
    implement the method below so that it returns a list of words that are repeated twice accidentally in a string
    for example: "appleapple orange pearpear pineapple" -> ["appleapple", "pearpear"]
    */

    public static List<String> findReapetdWords(String input)
    {
        List<String> repeatedWords = new ArrayList<>();
        Pattern pattern = Pattern.compile("(\\w{2,})\\1");
        Matcher matcher = pattern.matcher(input);
        while(matcher.find())
        {
            repeatedWords.add(matcher.group());
        }
        return repeatedWords;
    }

    public static void main(String[] args)
    {
        String text = "abcc abc  abc abc abc abc ";
        Pattern pattern = Pattern.compile("abc(c)?");
        Matcher matcher = pattern.matcher(text);
        while(matcher.find())
        {
            System.out.println(matcher.group());
        }
    }
}