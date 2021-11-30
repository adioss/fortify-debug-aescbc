package org.example.adfs;

public final class PrivateDataEncryptionFactory {


    private PrivateDataEncryptionFactory() {
    }

    public enum Version {
        /**
         * Version 1 of the algorithm
         */
        V1,
    }

    public static PrivateDataEncryption getInstance(Version version) throws Exception {
        if (version.equals(Version.V1)) {
            return new PrivateDataEncryptionAES128("SHA1PRNG", "HmacSHA256", "AES/CBC/PKCS5Padding", "UTF-8");
        }

        throw new IllegalArgumentException("Unsupported version " + version.name());
    }

}
