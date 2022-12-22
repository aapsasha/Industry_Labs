package org.aapsasha.lab6;

import org.aapsasha.lab6.ReadandWrite.*;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class main {
    public static void main(String[] args) throws IOException, XMLStreamException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, URISyntaxException {
        //XMLReader.FileToList(new File("XMLTest.xml"));
        //RarReader.read("input.rar");
        Scanner console_scan = new Scanner(System.in);
        System.out.print("enter file or arch name: ");
        String filename = console_scan.next();
        // read txt || xml || json
        File file = new File(main.class.getClassLoader().getResource("input.txt").toURI());
        List<TownData> townList = switch(filename.charAt(filename.length() - 1)){
            case('t') -> TxtReader.fileToList(file);
            case('n') -> JacksonReader.fileToList(file);
            case('l') -> XMLReader.FileToList(file);
            case('p') -> TxtReader.fileToList(ZipReader.read(file));
            case('r') -> TxtReader.fileToList(JarReader.read(file));
            default -> throw new InvalidObjectException(filename);
        };
        // adjMatrix
        AdjacencyMatrixCreator creator = new AdjacencyMatrixCreator(townList);
        int[][] adjacencyMatrix = creator.adjacencyMatrix;
        for(int i = 0; i < creator.names.size(); ++i){
            for(int j = 0; j < creator.names.size(); ++j){
                System.out.printf("%d ",adjacencyMatrix[i][j]);
            }
            System.out.println();
        }
        // ways
        System.out.print("Towns: ");
        creator.names.forEach((String name) -> System.out.print(name + " "));
        System.out.println();
        System.out.print("enter town name: ");
        String town = console_scan.next();

        WaysFounder waysFounder = new WaysFounder(adjacencyMatrix, creator.names,town);
        ArrayList<Integer> priorities = waysFounder.showAll();
        List<TownDistance> townDistances = new ArrayList<>();
        for(int i =0;i < priorities.size();++i){
            townDistances.add(new TownDistance(creator.names.get(i),priorities.get(i)));
        }
        // json & xml & txt
        JacksonWriter.ListToFile(townDistances);
        XMLWriter.ListToFile(townDistances);
        TxtWriter.ListToFile(townDistances);
        // arch & crypto
        ZipWriter.write("output.txt","outputArh.zip");
        JarWriter.write("output.txt", "outputArh.jar");
        CryptoWriter.write(townDistances);
        CryptoWriter.writeData(townList);
        //JarWriter.write("input.txt", "input.jar");
        //Gsig.go(new File("input.txt"));
        // out
        TreeMap townMap = new TreeMap();
        townDistances.forEach((TownDistance townDistance) -> townMap.put(townDistance.getTown(),townDistance.getDistance()));
        Set keys = townMap.keySet();
        for (Iterator i = keys.iterator(); i.hasNext();) {
            String name =  (String) i.next();
            int distance = (Integer) townMap.get(name);
            System.out.println(name + " = " + distance);
        }
        //townDistances.forEach((TownDistance townDistance) -> System.out.printf("%s - %d%n",townDistance.getTown(),townDistance.getDistance()));
    }
}
