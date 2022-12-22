package org.aapsasha.lab5;

import java.io.*;
import java.net.URISyntaxException;
import java.util.Objects;
import java.util.Scanner;

public class MainRegular {
    public static void main(String[] args) throws IOException, URISyntaxException {

        System.out.println("do you want to read from file? Y/N");
        Scanner scan_from_console = new Scanner(System.in);
        String answer = scan_from_console.nextLine();
        String line;
        try(FileWriter writer = new FileWriter("output.txt", false);){
            if(Objects.equals(answer, "Y") || Objects.equals(answer, "y") || Objects.equals(answer, "yes")){
                try {
                    File file = new File(MainRegular.class.getClassLoader().getResource("input.txt").toURI());
                    FileReader fr = new FileReader(file);
                    BufferedReader reader = new BufferedReader(fr);
                    line = reader.readLine();
                    while (line != null) {
                        boolean suit = PhoneNumber.match(line);
                        writer.write(suit ? "YES\n" : "NO\n");
                        line = reader.readLine();
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (URISyntaxException e) {
                    throw new RuntimeException(e);
                }
                writer.flush();
            }
            else{
                System.out.println("enter string to compare or \"stop\" to end programm");
                line = scan_from_console.nextLine();
                while(!Objects.equals(line,"stop")){
                    boolean suit = PhoneNumber.match(line);
                    System.out.printf(suit ? "YES\n" : "NO\n");
                    line = scan_from_console.nextLine();
                }
            }
        }
    }
}
