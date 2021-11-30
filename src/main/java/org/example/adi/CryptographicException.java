package org.example.adi;

import java.security.GeneralSecurityException;

public class CryptographicException extends Throwable {
    public CryptographicException(GeneralSecurityException e) {
    }
}
