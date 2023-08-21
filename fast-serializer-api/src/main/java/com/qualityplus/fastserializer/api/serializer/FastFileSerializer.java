package com.qualityplus.fastserializer.api.serializer;

import java.io.File;
import java.util.Optional;

public interface FastFileSerializer {
    public <T> Optional<T> loadFromFile(final Class<T> clazz,
                                        final File file);

    public Optional<File> saveToFile(final Object object,
                                     final File file);
}
