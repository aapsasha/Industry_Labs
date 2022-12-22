package org.aapsasha.lab6.ReadandWrite;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TxtReader {
    public static List<TownData> fileToList(File file) throws IOException {
        List<TownData> townList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file)))  {
            String line = reader.readLine();
            while (line != null) {
                StringTokenizer lexeme = new StringTokenizer(line, " ");
                String firstTown  = lexeme.nextToken();
                String secondTown = lexeme.nextToken();
                int distance = Integer.parseInt(lexeme.nextToken());
                townList.add(new TownData(firstTown,secondTown,distance));
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return townList;
    }
}
