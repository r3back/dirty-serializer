package com.qualityplus.dirtyserializer.core.strategy;

import com.fasterxml.jackson.core.JsonFactory;
import com.qualityplus.dirtyserializer.core.type.SerializerTypeImpl;

import java.util.List;

public final class SerializerStrategy extends AbstractFileStrategy {
    public SerializerStrategy(final List<String> extensions, final JsonFactory factory, final boolean isDefault) {
        super(new SerializerTypeImpl(extensions, factory, isDefault));
    }
}
