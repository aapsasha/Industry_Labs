package org.aapsasha.lab6.ReadandWrite;
import java.io.*;
import java.util.jar.*;

public class JarReader {

    public static File read(File fileName) {
        File file = null;
        try(JarInputStream jin = new JarInputStream(new FileInputStream(fileName)))
        {
            JarEntry entry;
            String name;
            long size;
            while((entry=jin.getNextJarEntry())!=null){

                name = entry.getName(); // получим название файла
                size=entry.getSize();  // получим его размер в байтах
                //System.out.printf("File name: %s \t File size: %d \n", name, size);

                // распаковка

                FileOutputStream fout = new FileOutputStream("unarhj" + name);
                file = new File("unarhj" + name);
                for (int c = jin.read(); c != -1; c = jin.read()) {
                    fout.write(c);
                }
                fout.flush();
                jin.closeEntry();
                fout.close();
            }
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
        return file;
    }
}