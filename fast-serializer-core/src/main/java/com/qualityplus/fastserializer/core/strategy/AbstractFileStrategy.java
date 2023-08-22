package com.qualityplus.fastserializer.core.strategy;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qualityplus.fastserializer.api.type.SerializerType;
import com.qualityplus.fastserializer.api.strategy.FileStrategy;
import com.qualityplus.fastserializer.core.util.FileUtil;
import com.qualityplus.fasttry.core.FastTry;
import lombok.extern.slf4j.Slf4j;

import java.io.File;

@Slf4j
public abstract class AbstractFileStrategy implements FileStrategy {
    private static final String SAVE_FILE_ERROR_MESSAGE = "Exception found saving content to file: ";
    private static final String EMPTY_STRING = "";
    private final ObjectMapper objectMapper;
    private final SerializerType type;

    public AbstractFileStrategy(final SerializerType serializerType) {
        this.objectMapper = configureMapper(serializerType);
        this.type = serializerType;
    }

    @Override
    public boolean isDefault() {
        return this.type.isDefault();
    }

    @Override
    public boolean applyFor(final File file) {
        return FileUtil.nameEndsWith(file, this.type);
    }

    @Override
    public <T> T loadFromString(final Class<T> clazz, final String content) {
        return FastTry.of(() -> this.objectMapper.readValue(content, clazz))
                .getOrElse(tryToInit(clazz));
    }

    @Override
    public String saveToString(final Object instance) {
        return FastTry.of(() -> this.objectMapper.writeValueAsString(instance))
                .getOrElse(EMPTY_STRING);
    }

    @Override
    public <T> T loadFromFile(final Class<T> clazz, final File file) {
        return FastTry.of(() -> this.objectMapper.readValue(file, clazz))
                .getOrElse(tryToInit(clazz));
    }

    @Override
    public File saveToFile(final Object object, final File file) {
        FastTry.of(() -> this.objectMapper.writeValue(file, object));
                        //.onFailure(e -> log.error(SAVE_FILE_ERROR_MESSAGE, e));
        return file;
    }

    private <T> T tryToInit(final Class<T> clazz) {
        return FastTry.of(clazz::newInstance)
                .getOrElse((T) null);
    }

    private ObjectMapper configureMapper(final SerializerType type) {
        return new ObjectMapper(type.getFactory())
                .configure(JsonParser.Feature.IGNORE_UNDEFINED, true);
    }
}
