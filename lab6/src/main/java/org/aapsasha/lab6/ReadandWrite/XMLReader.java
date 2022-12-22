package org.aapsasha.lab6.ReadandWrite;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class XMLReader {
    private String readCharacters(XMLStreamReader reader) throws XMLStreamException {
        StringBuilder result = new StringBuilder();
        while (reader.hasNext()) {
            int eventType = reader.next();
            switch (eventType) {
                case XMLStreamReader.CHARACTERS:
                case XMLStreamReader.CDATA:
                    result.append(reader.getText());
                    break;
                case XMLStreamReader.END_ELEMENT:
                    return result.toString();
            }
        }
        throw new XMLStreamException("Premature end of file");
    }
    private static TownData readTown(XMLStreamReader reader) throws XMLStreamException {
        TownData town = new TownData();
        //book.setLanguage(reader.getAttributeValue(null, "language"));

        while (reader.hasNext()) {
            int eventType = reader.next();
            switch (eventType) {
                case XMLStreamReader.START_ELEMENT:
                    String elementName = reader.getLocalName();
                    if (elementName.equals("firstTown")){
                        reader.next();
                        town.setFirstTown(reader.getText());
                        reader.next();
                    } else if (elementName.equals("secondTown")){
                        reader.next();
                        town.setSecondTown(reader.getText());
                        reader.next();
                    }
                    else if (elementName.equals("distance")){
                        reader.next();
                        town.setDistance(Integer.parseInt(reader.getText()));
                        //reader.next();
                    }
                    break;
                case XMLStreamReader.END_ELEMENT:
                    return town;
            }
        }
        throw new XMLStreamException("Premature end of file");
    }
    private static List<TownData> readTowns(XMLStreamReader reader) throws XMLStreamException {
        List<TownData> towns = new ArrayList<>();

        while (reader.hasNext()) {
            int eventType = reader.next();
            switch (eventType) {
                case XMLStreamReader.START_ELEMENT:
                    String elementName = reader.getLocalName();
                    if (elementName.equals("Town"))
                        towns.add(readTown(reader));
                    reader.next();
                    reader.next();
                    break;
                case XMLStreamReader.END_ELEMENT:
                    return towns;
            }
        }
        throw new XMLStreamException("Premature end of file");
    }
    public static List<TownData> FileToList(File file){
        List<TownData> townData = new ArrayList<>();
        try (StaxStreamProcessor processor = new StaxStreamProcessor(Files.newInputStream(Paths.get(file.toURI())))) {
            XMLStreamReader reader = processor.getReader();
            while (reader.hasNext()) {
                int eventType = reader.next();
                switch (eventType) {
                    case XMLStreamReader.START_ELEMENT:
                        String elementName = reader.getLocalName();
                        if (elementName.equals("Towns"))
                            return readTowns(reader);
                        break;
                    case XMLStreamReader.END_ELEMENT:
                        break;
                }
            }
        } catch (XMLStreamException | IOException e) {
            throw new RuntimeException(e);
        }
        return townData;
    }
}
