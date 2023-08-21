package com.qualityplus.fastserializer.core.util;

import com.qualityplus.fastserializer.api.type.SerializerType;
import lombok.experimental.UtilityClass;

import java.io.File;
import java.util.Collections;
import java.util.List;

@UtilityClass
public final class FileUtil {
    public boolean nameEndsWith(final File file, final SerializerType type) {
        final String name = file.getName();

        return type.getExtensions()
                .stream()
                .anyMatch(name::endsWith);
    }

    public boolean nameEndsWith(final File file, final List<String> extensions) {
        final String name = file.getName();

        return extensions
                .stream()
                .anyMatch(name::endsWith);
    }

    public boolean nameEndsWith(final File file, final String extension) {
        return nameEndsWith(file, Collections.singletonList(extension));
    }
}
