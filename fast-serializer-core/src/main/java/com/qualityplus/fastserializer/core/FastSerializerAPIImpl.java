package com.qualityplus.fastserializer.core;

import com.qualityplus.fastserializer.api.FastSerializerAPI;
import com.qualityplus.fastserializer.api.serializer.FastSerializer;

import java.io.File;
import java.util.Optional;

public final class FastSerializerAPIImpl implements FastSerializerAPI {
    private final FastSerializer serializer;

    public FastSerializerAPIImpl(final FastSerializer serializer) {
        this.serializer = serializer;
    }

    @Override
    public <T> Optional<T> loadFromString(final Class<T> clazz, final String content) {
        return this.serializer.loadFromString(clazz, content);
    }

    @Override
    public Optional<String> saveToString(final Object instance) {
        return this.serializer.saveToString(instance);
    }

    @Override
    public <T> Optional<T> loadFromFile(final Class<T> clazz, final File file) {
        return this.serializer.loadFromFile(clazz, file);
    }

    @Override
    public Optional<File> saveToFile(final Object object, final File file) {
        return this.serializer.saveToFile(object, file);
    }
}
