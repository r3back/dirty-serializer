package com.qualityplus.fastserializer.core;

import com.qualityplus.fastserializer.api.FastSerializerAPI;
import com.qualityplus.fastserializer.api.provider.StrategyProvider;
import com.qualityplus.fastserializer.api.serializer.FastSerializer;
import com.qualityplus.fastserializer.api.strategy.FileStrategy;
import com.qualityplus.fastserializer.core.builder.StrategyProviderBuilderImpl;
import com.qualityplus.fastserializer.core.serializer.FastSerializerImpl;

public class FastSerializerCore {
    private static FastSerializerAPI api;

    public static FastSerializerAPI getApi() {
        if (api == null) {
            final StrategyProvider<FileStrategy> providerBuilder = StrategyProviderBuilderImpl.init()
                    .withYamlStrategy()
                    .withJsonStrategy()
                    .build();

            final FastSerializer serializer = new FastSerializerImpl(providerBuilder);

            api = new FastSerializerAPIImpl(serializer);
        }
        return api;
    }
}
