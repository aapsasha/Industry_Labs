package org.aapsasha.lab6.ReadandWrite;

import java.io.*;
import java.util.List;

import static java.lang.String.format;

public class TxtWriter {
    public static void ListToFile(List<TownDistance> townDistances){

        try(FileWriter writer = new FileWriter("output.txt", false))
        {
            // запись всей строки
            townDistances.forEach((TownDistance townDistance) -> {
                try {
                    writer.write(format("%s - %d%n",townDistance.getTown(),townDistance.getDistance()));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });

            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}
