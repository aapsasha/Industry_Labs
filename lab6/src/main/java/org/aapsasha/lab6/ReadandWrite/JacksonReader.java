package org.aapsasha.lab6.ReadandWrite;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JacksonReader {


    public static List<TownData> fileToList(File file) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        //File file = new File("TownList.json");
        return objectMapper.readValue(file, new TypeReference<>(){});
        //assertThat(employeeList).hasSize(2);
        //assertThat(employeeList.get(0).getAge()).isEqualTo(33);
        //assertThat(employeeList.get(0).getLastName()).isEqualTo("Simpson");
        //assertThat(employeeList.get(0).getFirstName()).isEqualTo("Marge");
    }
}
