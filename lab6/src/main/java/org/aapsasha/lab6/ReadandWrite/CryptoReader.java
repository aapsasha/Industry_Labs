package org.aapsasha.lab6.ReadandWrite;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CryptoReader {
    public static List<TownData> fileToList(File file) throws IOException, InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException {
        List<TownData> townList = new ArrayList<>();
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        byte[] keyBytes   = new byte[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        String algorithm  = "AES";
        SecretKeySpec key = new SecretKeySpec(keyBytes, algorithm);
        cipher.init(Cipher.DECRYPT_MODE, key);
        try (BufferedReader reader = new BufferedReader(new FileReader(file)))  {
            String linetmp = reader.readLine();
            byte[] tmp = linetmp.getBytes();
            byte[] cipherText = cipher.update(tmp);
            String line = new String(cipherText, StandardCharsets.UTF_8);
            while (line != null) {
                StringTokenizer lexeme = new StringTokenizer(line, " ");
                String firstTown  = lexeme.nextToken();
                String secondTown = lexeme.nextToken();
                int distance = Integer.parseInt(lexeme.nextToken());
                townList.add(new TownData(firstTown,secondTown,distance));
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return townList;
    }
}
