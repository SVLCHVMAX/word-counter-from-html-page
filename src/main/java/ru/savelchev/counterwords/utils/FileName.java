package ru.savelchev.counterwords.utils;

import org.springframework.stereotype.Component;
import java.math.BigInteger;
import java.security.SecureRandom;

@Component
public class FileName {

    public String getFileName() {
        SecureRandom secureRandom = new SecureRandom();
        return new BigInteger(130,secureRandom).toString(36) + ".html";
    }
}
