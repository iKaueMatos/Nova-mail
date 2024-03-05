/**
 * ----------------------------------------------------------------------------
 * Autor: Kaue de Matos
 * Empresa: Nova Software
 * Propriedade da Empresa: Todos os direitos reservados
 * ----------------------------------------------------------------------------
 */
package com.email.email.util.reflection;

import java.lang.reflect.Field;
import java.util.stream.Stream;

public class FieldCopier {
    public static void copyNonNullFields(Object source, Object target) {
        Field[] fields = source.getClass().getDeclaredFields();
        Stream.of(fields)
                .filter(field -> getValue(field, source) != null)
                .forEach(field -> setValue(field, target, getValue(field, source)));
    }
    
    public static Object getValue(Field field, Object object) {
        try {
            field.setAccessible(true);
            return field.get(object);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void setValue(Field field, Object object, Object value) {
        try {
            field.setAccessible(true);
            field.set(object, value);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}