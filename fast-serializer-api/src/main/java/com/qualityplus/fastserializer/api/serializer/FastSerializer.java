package com.qualityplus.fastserializer.api.serializer;

import java.util.Optional;

public interface FastSerializer extends FastFileSerializer {
    public <T> Optional<T> loadFromString(final Class<T> clazz,
                                          final String content);

    public Optional<String> saveToString(final Object instance);
}
