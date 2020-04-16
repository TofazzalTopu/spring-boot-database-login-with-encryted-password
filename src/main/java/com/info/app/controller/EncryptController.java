package com.info.app.controller;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class EncryptController {

    private static String mpCryptoPassword = "MY_SECRET";

    public static void main(String[] args) {
        String value = "knit_hrms";

        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword(mpCryptoPassword);
        String encryptedPassword = encryptor.encrypt(value);
        System.out.println(encryptedPassword);

        StandardPBEStringEncryptor decryptor = new StandardPBEStringEncryptor();
        decryptor.setPassword(mpCryptoPassword);
        System.out.println(decryptor.decrypt(encryptedPassword));
    }
}
