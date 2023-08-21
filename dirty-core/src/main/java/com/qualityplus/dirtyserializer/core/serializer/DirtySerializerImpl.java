package com.qualityplus.dirtyserializer.core.serializer;

import com.qualityplus.dirtyserializer.api.serializer.DirtySerializer;
import com.qualityplus.dirtyserializer.api.provider.StrategyProvider;
import com.qualityplus.dirtyserializer.api.strategy.FileStrategy;

import java.io.File;
import java.util.Optional;

public final class DirtySerializerImpl implements DirtySerializer {
    private final StrategyProvider<FileStrategy> provider;

    public DirtySerializerImpl(final StrategyProvider<FileStrategy> provider) {
        this.provider = provider;
    }

    @Override
    public <T> Optional<T> loadFromString(final Class<T> clazz, final String content) {
        return getDefault()
                .map(s -> s.loadFromString(clazz, content));
    }

    @Override
    public Optional<String> saveToString(final Object instance) {
        return getDefault()
                .map(s -> s.saveToString(instance));
    }

    @Override
    public <T> Optional<T> loadFromFile(final Class<T> clazz, final File file) {
        return getStrategy(file)
                .map(s -> s.loadFromFile(clazz, file));
    }

    @Override
    public Optional<File> saveToFile(final Object object, final File file) {
        return getStrategy(file)
                .map(s -> s.saveToFile(object, file));
    }

    private Optional<FileStrategy> getStrategy(final File file) {
        return this.provider.getStrategies()
                .stream()
                .filter(fileStrategy -> fileStrategy.applyFor(file))
                .findFirst();
    }

    private Optional<FileStrategy> getDefault() {
        return this.provider.getStrategies()
                .stream()
                .filter(FileStrategy::isDefault)
                .findFirst();
    }
}
