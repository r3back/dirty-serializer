package com.qualityplus.dirtyserializer.core;

import com.qualityplus.dirtyserializer.api.DirtySerializerAPI;
import com.qualityplus.dirtyserializer.api.serializer.DirtySerializer;

import java.io.File;
import java.util.Optional;

public final class DirtySerializerAPIImpl implements DirtySerializerAPI {
    private final DirtySerializer serializer;

    public DirtySerializerAPIImpl(final DirtySerializer serializer) {
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
