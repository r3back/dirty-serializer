package com.qualityplus.fastserializer.core.type;

import com.fasterxml.jackson.core.JsonFactory;
import com.qualityplus.fastserializer.api.type.SerializerType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public final class SerializerTypeImpl implements SerializerType {
    private final List<String> extensions;
    private final JsonFactory factory;
    private final boolean isDefault;

    @Override
    public boolean isDefault() {
        return isDefault;
    }
}
