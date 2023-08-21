package com.qualityplus.fastserializer.api.type;

import com.fasterxml.jackson.core.JsonFactory;
import java.util.List;

public interface SerializerType {
    public List<String> getExtensions();
    public JsonFactory getFactory();
    public boolean isDefault();
}
