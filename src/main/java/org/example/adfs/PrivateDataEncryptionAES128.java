package org.example.adfs;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import java.nio.charset.StandardCharsets;
import java.security.Key;

public class PrivateDataEncryptionAES128 extends PrivateDataEncryption {

    public static byte[] iv;
    private final byte[] bytes;
    public Key key;
    public String data;


    public PrivateDataEncryptionAES128(String sha1PRNG, String hmacSHA256, String cypher, String s1) throws Exception {
        super();
        Cipher aesCipher = Cipher.getInstance(cypher);
        aesCipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(iv));
        bytes = aesCipher.doFinal(data.getBytes(StandardCharsets.UTF_8));
    }

    public byte[] getBytes() {
        return bytes;
    }
}
