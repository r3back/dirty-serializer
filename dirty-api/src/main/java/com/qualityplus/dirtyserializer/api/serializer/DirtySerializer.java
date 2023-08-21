package com.qualityplus.dirtyserializer.api.serializer;

import java.util.Optional;

public interface DirtySerializer extends DirtyFileSerializer {
    public <T> Optional<T> loadFromString(final Class<T> clazz,
                                          final String content);

    public Optional<String> saveToString(final Object instance);
}
