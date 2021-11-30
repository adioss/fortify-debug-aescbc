package org.example.adi;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.security.GeneralSecurityException;

public class PropertyCryptographicServiceImpl {
    private static final String AES_CBC_PKCS5_PADDING = "AES/CBC/PKCS5Padding";

    private static byte[] aesEncrypt(SecretKey key, byte[] iv, byte[] data) throws CryptographicException {
        try {

            Cipher aesCipher = Cipher.getInstance(AES_CBC_PKCS5_PADDING);
            aesCipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(iv));
            return aesCipher.doFinal(data);
        } catch (GeneralSecurityException e) {
            throw new CryptographicException(e);
        }
    }
}
