package com.qualityplus.fastserializer.api.strategy;

import java.io.File;

public interface FileStrategy {
    public boolean isDefault();

    public boolean applyFor(final File file);

    public <T> T loadFromString(final Class<T> clazz,
                                final String content);

    public String saveToString(final Object instance);

    public <T> T loadFromFile(final Class<T> clazz,
                              final File file);

    public File saveToFile(final Object object,
                           final File file);
}
