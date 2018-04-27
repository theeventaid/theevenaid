package com.tgj.eventaid.utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DomainUtils {

    public static String extractSubdomain(String url) {
        Matcher m = Pattern.compile("\\.*(.*)\\.").matcher(url);
        while (m.find())
            return m.group(1);
        return null;
    }
}