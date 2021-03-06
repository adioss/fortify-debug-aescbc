package org.example.adfs;


import java.io.File;
import java.util.Arrays;

public class PrivateDataEncryptionAES128 implements PrivateDataEncryption {
    private static final int NB_ITERATION = 100000;
    private static final int SALT_LENGTH = 24;
    private static final int DEFAULT_KEY_LEN = 16;
    private static final int DEFAULT_IV_LEN = 16;
    private final String pseudoRandomAlgorithm;
    private final String cipherAlgorithm;
    private final String charset;
    private final RandomGenerator randomGenerator;
    private final File derivedKeyDirectory;
    private final PBKDF2 pbkdf2;

    protected PrivateDataEncryptionAES128(String secureRandomAlgorithm, String pseudoRandomAlgorithm, String cipherAlgorithm, String charset) {
        this.pseudoRandomAlgorithm = pseudoRandomAlgorithm;
        this.cipherAlgorithm = cipherAlgorithm;
        this.charset = charset;
        this.randomGenerator = new RandomGenerator(secureRandomAlgorithm);
        this.pbkdf2 = new PBKDF2(pseudoRandomAlgorithm);
        this.derivedKeyDirectory = new File(".");
        encryptData(1, new byte[0]);
    }

    public String getPseudoRandomAlgorithm() {
        return pseudoRandomAlgorithm;
    }

    public String getCipherAlgorithm() {
        return cipherAlgorithm;
    }

    public String getCharset() {
        return charset;
    }

    public RandomGenerator getRandomGenerator() {
        return randomGenerator;
    }

    public File getDerivedKeyDirectory() {
        return derivedKeyDirectory;
    }

    public PBKDF2 getPbkdf2() {
        return pbkdf2;
    }

    public String encryptData(int derivedKeyNumber, byte[] data) {


        final PBES2 pbes2 = new PBES2(cipherAlgorithm);
        final byte[] encryptedData = pbes2.encryptData("derivedKey", "iv", data);

        return Arrays.toString(encryptedData);
    }
}
