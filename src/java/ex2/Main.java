package org.hw10.ex2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        String inputFile = "src/main/resources/file.txt";
        String outputFile = "user.json";
        List<User> userList = readUserList(inputFile);
        writeUserList(userList,outputFile);

    }


    private static List<User> readUserList(String inputFile) throws IOException {
        List<User> userList = new ArrayList<>();
        BufferedReader br = null;

        try {
           br = new BufferedReader(new FileReader(inputFile));
            String header = br.readLine();
            String line;
            while ((line = br.readLine()) != null){
                String[] tokens = ((String) line).split(" ");
                if(tokens.length == 2){
                    String name = tokens[0];
                    int age = Integer.parseInt(tokens[1]);
                    User user = new User(name,age);
                    userList.add(user);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (br !=null){
                br.close();
            }
        }
        return userList;
    }

    private static void writeUserList(List<User> userList, String outputFile) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(userList);
        try (FileWriter fileWriter = new FileWriter(outputFile)) {
            fileWriter.write(json);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    private static class User{
        private String name;
        private int age;

        public User(String name,int age){
            this.name = name;
            this.age = age;
        }
    }
}