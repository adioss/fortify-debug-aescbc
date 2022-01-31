package org.example.adfs;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.NoSuchAlgorithmException;

public class PBES2 {
    private String cipherAlgorithm;

    public PBES2(String cipherAlgorithm) {
        this.cipherAlgorithm = cipherAlgorithm;
    }

    public byte[] encryptData(String derivedKey, String iv, byte[] data) {
        Cipher cipher = null;
        if (cipher == null) {
            try {
                cipher = Cipher.getInstance(cipherAlgorithm);
                cipher.doFinal();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (NoSuchPaddingException e) {
                e.printStackTrace();
            } catch (IllegalBlockSizeException e) {
                e.printStackTrace();
            } catch (BadPaddingException e) {
                e.printStackTrace();
            }
        }

        return new byte[0];
    }
}
