package com.qualityplus.dirtyserializer.core;

import com.qualityplus.dirtyserializer.api.DirtySerializerAPI;
import com.qualityplus.dirtyserializer.api.provider.StrategyProvider;
import com.qualityplus.dirtyserializer.api.serializer.DirtySerializer;
import com.qualityplus.dirtyserializer.api.strategy.FileStrategy;
import com.qualityplus.dirtyserializer.core.builder.StrategyProviderBuilderImpl;
import com.qualityplus.dirtyserializer.core.serializer.DirtySerializerImpl;

public class DirtySerializerCore {
    private static DirtySerializerAPI api;

    public static DirtySerializerAPI getApi() {
        if (api == null) {
            final StrategyProvider<FileStrategy> providerBuilder = StrategyProviderBuilderImpl.init()
                    .withYamlStrategy()
                    .withJsonStrategy()
                    .build();

            final DirtySerializer serializer = new DirtySerializerImpl(providerBuilder);

            api = new DirtySerializerAPIImpl(serializer);
        }
        return api;
    }
}
