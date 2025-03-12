package com.github.lsantana32.hackacode3.Setter;

import java.lang.reflect.Field;
import java.util.logging.Logger;

public abstract class BaseSetter {
    static Logger log = Logger.getLogger(BaseSetter.class.getName());
    public static <T> void set(T objectToUpdate, T objectWithNewInformation){
        for (Field field : objectToUpdate.getClass().getDeclaredFields()){
            log.info("Setting field: " + field.getName());
            if (isFieldId(field)){
                continue;
            }
            field.setAccessible(true);
            try {
                Object value = field.get(objectWithNewInformation);
                log.info("Value to set: " + value);
                if (value != null){
                    field.set(objectToUpdate, value);
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Failed to set field value", e);
            }
        }
    }

    private static boolean isFieldId(Field field) {
        return field.getName().equals("id");
    }
}

