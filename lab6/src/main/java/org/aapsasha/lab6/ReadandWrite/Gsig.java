package org.aapsasha.lab6.ReadandWrite;
import java.io.*;
import java.security.*;
import java.security.spec.*;
public class Gsig
{
    public  Gsig(){}
    //сохранение байтового массива в файл
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

    public  static void go(File file)
    {
        try
        {
            /* Генерация ключей */
            KeyPairGenerator keyGen =
                    KeyPairGenerator.getInstance("DSA", "SUN");
            SecureRandom random =
                    SecureRandom.getInstance("SHA1PRNG", "SUN");
            keyGen.initialize(1024, random);
            KeyPair pair = keyGen.generateKeyPair();
            PrivateKey priv = pair.getPrivate();
            PublicKey pub = pair.getPublic();
            /* Создание объекта класса Signature */
            Signature dsa =
                    Signature.getInstance("SHA1withDSA", "SUN");
            /* Инициализация частным ключом */
            dsa.initSign(priv);
            /* Чтение данных из файла "data". Вызов метода update() */
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bufin =
                    new BufferedInputStream(fis);
            byte[] buffer = new byte[1024];
            int len;
            while (bufin.available() != 0)
            {
                len = bufin.read(buffer);
                dsa.update(buffer, 0, len);
            }
            bufin.close();
            fis.close();
            /* Генерация подписи */
            byte[] realSig = dsa.sign();
            /* Сохранение подписи в файл "signature" */
            saveToFile (realSig,"signature");
            /* Сохранение открытого ключа в файл "pubkey" */
            byte[] key = pub.getEncoded();
            saveToFile (key,"pubkey");
        }
        catch (Exception e)
        {
            System.err.println("Caught exception " +
                    e.toString());
        }
    }// go()
}// class GSig
