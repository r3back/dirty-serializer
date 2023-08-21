package com.qualityplus.fastserializer.api;

import java.io.File;
import java.util.Optional;

public interface FastSerializerAPI {
    public <T> Optional<T> loadFromString(final Class<T> clazz, final String content);

    public Optional<String> saveToString(final Object instance);

    public <T> Optional<T> loadFromFile(final Class<T> clazz, final File file);

    public Optional<File> saveToFile(final Object object, final File file);
}
