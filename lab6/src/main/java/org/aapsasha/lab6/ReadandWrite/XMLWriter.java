package org.aapsasha.lab6.ReadandWrite;

import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class XMLWriter {
    public static void ListToFile(List<TownDistance> townDistances) throws IOException, XMLStreamException {
        XMLOutputFactory output = XMLOutputFactory.newInstance();
        XMLStreamWriter writer = output.createXMLStreamWriter(new FileWriter("output.xml"));
        writer.writeStartDocument("1.0");
        writer.writeStartElement("Towns");
        for (TownDistance townDistance : townDistances) {
            writer.writeStartElement("Town");
            writer.writeStartElement("Name");
            writer.writeCharacters(townDistance.getTown());
            writer.writeEndElement();
            writer.writeStartElement("Distance");
            writer.writeCharacters(Integer.toString(townDistance.getDistance()));
            writer.writeEndElement();
            writer.writeEndElement();
        }
        writer.writeEndElement();
        writer.writeEndDocument();
        writer.flush();
        writer.close();
    }
}
