package org.aapsasha.lab6.ReadandWrite;
import java.io.*;
import java.util.zip.*;

public class ZipWriter {

    public static void write(String fileName, String arh) {

        try(ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(arh));
            FileInputStream fis= new FileInputStream(fileName))
        {
            ZipEntry entry1=new ZipEntry(fileName);
            zout.putNextEntry(entry1);
            // считываем содержимое файла в массив byte
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            // добавляем содержимое к архиву
            zout.write(buffer);
            // закрываем текущую запись для новой записи
            zout.closeEntry();
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
    }
}