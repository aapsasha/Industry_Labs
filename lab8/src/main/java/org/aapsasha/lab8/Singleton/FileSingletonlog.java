package org.aapsasha.lab8.Singleton;

import java.io.FileWriter;
import java.io.IOException;

public class FileSingletonlog {
    static private FileSingletonlog log;
    public FileWriter writer;
    private FileSingletonlog() throws IOException {
        writer = new FileWriter("log.txt",false);
    }
    static public FileSingletonlog getinstance() throws IOException {
        if(log == null){
            log = new FileSingletonlog();
        }
        return log;
    }
}
