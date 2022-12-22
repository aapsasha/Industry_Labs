package org.aapsasha.lab6.ReadandWrite;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class CryptoWriter {
    public static void saveToFile (byte[] info,
                                   String filename)
    {
        try
        {
            FileOutputStream fos = new FileOutputStream
                    (filename);
            fos.write(info);
            fos.close();
        }
        catch (Exception e)
        {
            System.err.println("Caught exception" + e.toString());
        }
    }// saveToFile ()
    public static void write(List<TownDistance> townDistances) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IOException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        byte[] keyBytes   = new byte[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        String algorithm  = "AES";
        SecretKeySpec key = new SecretKeySpec(keyBytes, algorithm);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        FileOutputStream fos = new FileOutputStream("outputСrypto.txt");
        for(int i =0; i< townDistances.size() - 1; ++i){
            byte[] tmp = (townDistances.get(i).getTown() + " " + townDistances.get(i).getDistance()).getBytes("UTF-8");;
            byte[] cipherText = cipher.update(tmp);
            fos.write(cipherText);
        }
        byte[] tmp = (townDistances.get(townDistances.size()-1).getTown() + " " + townDistances.get(townDistances.size()-1).getDistance()).getBytes("UTF-8");;
        byte[] cipherText = cipher.doFinal(tmp);
        fos.write(cipherText);
        fos.close();
    }
    public static void writeData(List<TownData> townDistances) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IOException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        byte[] keyBytes   = new byte[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        String algorithm  = "AES";
        SecretKeySpec key = new SecretKeySpec(keyBytes, algorithm);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        FileOutputStream fos = new FileOutputStream("inputСrypto.txt");
        for(int i =0; i< townDistances.size() - 1; ++i){
            byte[] tmp = (townDistances.get(i).getFirstTown() + " " + townDistances.get(i).getSecondTown() + " " +townDistances.get(i).getDistance()).getBytes("UTF-8");;
            byte[] cipherText = cipher.update(tmp);
            fos.write(cipherText);
        }
        byte[] tmp = (townDistances.get(townDistances.size()-1).getFirstTown() + " " + townDistances.get(townDistances.size()-1).getSecondTown() + " " + townDistances.get(townDistances.size()-1).getDistance()).getBytes("UTF-8");;
        byte[] cipherText = cipher.doFinal(tmp);
        fos.write(cipherText);
        fos.close();
    }
}
