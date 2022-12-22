package org.aapsasha.lab6.ReadandWrite;

import com.github.junrar.Archive;
import com.github.junrar.Junrar;
import com.github.junrar.exception.RarException;
import com.github.junrar.rarfile.FileHeader;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class RarReader {
    public static void read(String fileName) throws RarException, IOException {
        Junrar.extract(fileName, "");
    }
}
