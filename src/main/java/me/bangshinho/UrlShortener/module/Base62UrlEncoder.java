package me.bangshinho.UrlShortener.module;

import org.springframework.stereotype.Component;

@Component
public class Base62UrlEncoder implements UrlEncoder {

    public final String URL_PREFIX = "http://localhost:8080/";

    public String encode(int value) {
        final StringBuilder sb = new StringBuilder();
        do {
            int i = (int) (value % 62);
            sb.append(BASE62[i]);
            value /= 62;
        } while (value > 0);
        return URL_PREFIX + sb.toString();
    }

    public String encodeToLong(long value) {
        final StringBuilder sb = new StringBuilder();
        do {
            int i = (int) (value % 62);
            sb.append(BASE62[i]);
            value /= 62;
        } while (value > 0);
        return URL_PREFIX + sb.toString();
    }

    public int decode(String value) {
        int result=0;
        int power= 1;
        for (int i = 0; i < value.length(); i++) {
            int digit = new String(BASE62).indexOf(value.charAt(i));
            result += digit * power;
            power *= 62;
        }
        return result;
    }

    public long decodeToLong(String value) {
        long result=0;
        long power=1;
        for (int i = 0; i < value.length(); i++) {
            int digit = new String(BASE62).indexOf(value.charAt(i));
            result += digit * power;
            power *= 62;
        }
        return result;
    }

}
