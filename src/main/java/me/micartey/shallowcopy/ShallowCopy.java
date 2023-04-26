package me.micartey.shallowcopy;

import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.util.*;

public class ShallowCopy<T> {

    private static final Map<Class<?>, List<Field>> FIELDS = new WeakHashMap<>();
    private final Class<T> clazz;

    public ShallowCopy(Class<T> clazz) {
        this.clazz = clazz;

        if (FIELDS.containsKey(clazz))
            return;

        List<Field> fields = new ArrayList<>();
        Arrays.stream(clazz.getDeclaredFields()).filter(field -> field.isAnnotationPresent(Expose.class)).forEach(field -> {
            field.setAccessible(true);
            fields.add(field);
        });
        FIELDS.put(clazz, fields);
    }

    @SneakyThrows
    public T copy(T parent) {
        T instance = clazz.newInstance();

        for (Field field : FIELDS.get(clazz)) {
            field.set(instance, field.get(parent));
        }

        return instance;
    }

    @SneakyThrows
    public T copy(T parent, T instance) {
        for (Field field : FIELDS.get(clazz)) {
            field.set(instance, field.get(parent));
        }

        return instance;
    }
}
