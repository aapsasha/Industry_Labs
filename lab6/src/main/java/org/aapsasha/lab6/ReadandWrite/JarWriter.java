package org.aapsasha.lab6.ReadandWrite;
import java.io.*;
import java.util.jar.*;

public class JarWriter {

    public static void write(String fileName, String arh) {

        try(JarOutputStream jout = new JarOutputStream(new FileOutputStream(arh));
            FileInputStream fis= new FileInputStream(fileName))
        {
            JarEntry entry1=new JarEntry(fileName);
            jout.putNextEntry(entry1);
            // считываем содержимое файла в массив byte
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            // добавляем содержимое к архиву
            jout.write(buffer);
            // закрываем текущую запись для новой записи
            jout.closeEntry();
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
    }
}