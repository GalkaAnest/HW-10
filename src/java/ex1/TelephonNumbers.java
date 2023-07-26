package hw10.ex1;


import java.io.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class TelephonNumbers {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new FileReader("/Users/galyna.gaponova/IdeaProjects/Test1/src/main/java/hw10/ex1/file.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (isValidPhoneNumber(line)) {
                    System.out.println(line);
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static boolean isValidPhoneNumber(String phoneNumber) {
        String pattern = "(\\(\\d{3}\\) \\d{3}-\\d{4})|(\\d{3}-\\d{3}-\\d{4})";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(phoneNumber);
        return matcher.matches();
    }
}
