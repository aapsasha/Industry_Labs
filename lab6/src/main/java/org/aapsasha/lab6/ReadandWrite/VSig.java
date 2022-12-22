package org.aapsasha.lab6.ReadandWrite;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;

/* Верификация DSA-подписи */
public class VSig {
    public VSig() {
    }

    //чтение из файла в байтовый массив
    public byte[] readFromFile(String fileName) {
        byte[] info;
        try {
            FileInputStream fis =
                    new FileInputStream(fileName);
            info = new byte[fis.available()];
            fis.read(info);
            fis.close();
        } catch (Exception e) {
            System.err.println("Caught exception " +
                    e.toString());
            info = new byte[0];
        }
        return (info);
    }// copyFromFile ()

    public void go(File file) {
        try {
            /* Получение encoded public key из файла "pubkey" */
            byte[] encKey = readFromFile("pubkey");

            /* Создание спецификации ключа */
            X509EncodedKeySpec pubKeySpec =
                    new X509EncodedKeySpec(encKey);
            /* Создание объектов Keyfactory и Publickey*/
            KeyFactory keyFactory = KeyFactory.getInstance
                    ("DSA", "SUN");
            PublicKey pubKey = keyFactory.generatePublic
                    (pubKeySpec);
            /* Чтение подписи из файла "signature" */
            byte[] sigToVerify = readFromFile("signature");
            /* Создание объекта класса Signature и инициализация с помощью открытого ключа    */
            Signature sig = Signature.getInstance
                    ("SHA1withDSA", "SUN");
            sig.initVerify(pubKey);
            /* Чтение данных из файла "data" и вызов метода update() */
            FileInputStream datafis = new FileInputStream
                    (file);
            BufferedInputStream bufin =
                    new BufferedInputStream(datafis);
            byte[] buffer = new byte[1024];
            int len;
            while (bufin.available() != 0) {
                len = bufin.read(buffer);
                sig.update(buffer, 0, len);
            }
            bufin.close();
            datafis.close();
            /* Верификация */
            boolean verifies = sig.verify(sigToVerify);
            System.out.println("Signature verifies: " + verifies);
        } catch (Exception e) {
            System.err.println("Caught exception " +
                    e.toString());
        }
    }// go()
}
