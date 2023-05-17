package com.joolshe.chargesys.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

/**
 * @author Zexi He.
 * @date 2023/5/17 11:52
 * @description:
 */
public class Utils {

    public static String getRandomSerialNumber() {
        return (UUID.randomUUID() + "-" + System.currentTimeMillis()).substring(0, 11);
    }

    public static String getFormatDateTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return now.format(formatter);
    }
}
