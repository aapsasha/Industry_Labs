package org.aapsasha.lab6.ReadandWrite;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ListIterator;

public class JacksonWriter {



    public static void ListToFile(List<TownDistance> townList) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ListIterator<TownDistance> it =townList.listIterator();
        FileWriter writer = new FileWriter("output.json", false);
        writer.write("[\n");
        while(it.hasNext()){
            String json = objectMapper.writeValueAsString(it.next());
            writer.write(json);
            writer.write(",\n");
        }
        writer.write("]");
        writer.flush();
    }
}