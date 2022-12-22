package org.aapsasha.lab6.ReadandWrite;

import java.io.*;
import java.util.zip.*;

public class ZipReader {

    public static File read(File fileName) {
        File file = null;
        try(ZipInputStream zin = new ZipInputStream(new FileInputStream(fileName)))
        {
            ZipEntry entry;
            String name;
            long size;
            while((entry=zin.getNextEntry())!=null){

                name = entry.getName(); // получим название файла
                size=entry.getSize();  // получим его размер в байтах
                //System.out.printf("File name: %s \t File size: %d \n", name, size);

                // распаковка

                FileOutputStream fout = new FileOutputStream("unarhz" + name);
                file = new File("unarhz" + name);
                for (int c = zin.read(); c != -1; c = zin.read()) {
                    fout.write(c);
                }
                fout.flush();
                zin.closeEntry();
                fout.close();
            }
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
        return file;
    }
}