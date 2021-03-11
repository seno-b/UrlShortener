package me.bangshinho.UrlShortener.module;

import org.apache.commons.validator.routines.UrlValidator;

public interface UrlEncoder {

    char[] BASE62 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".toCharArray();

    String encode(int value);
    String encodeToLong(long value);
    int decode(String value);
    long decodeToLong(String value);

    static boolean isUrl(String url){
        UrlValidator validator = new UrlValidator();
        return !(validator.isValid(url));
    }
}
