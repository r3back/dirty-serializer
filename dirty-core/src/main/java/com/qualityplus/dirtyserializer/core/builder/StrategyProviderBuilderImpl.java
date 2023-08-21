package com.qualityplus.dirtyserializer.core.builder;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.qualityplus.dirtyserializer.api.builder.StrategyProviderBuilder;
import com.qualityplus.dirtyserializer.api.provider.StrategyProvider;
import com.qualityplus.dirtyserializer.api.strategy.FileStrategy;
import com.qualityplus.dirtyserializer.core.provider.StrategyProviderImpl;
import com.qualityplus.dirtyserializer.core.strategy.SerializerStrategy;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class StrategyProviderBuilderImpl implements StrategyProviderBuilder {
    private static final List<String> JSON_EXTENSIONS = Collections.singletonList(".json");
    private static final List<String> YAML_EXTENSIONS = Arrays.asList(".yaml", "yml");
    private final StrategyProvider<FileStrategy> provider = new StrategyProviderImpl();

    public static StrategyProviderBuilderImpl init() {
        return new StrategyProviderBuilderImpl();
    }

    @Override
    public StrategyProviderBuilder withDefaultStrategies() {
        return this.withJsonStrategy()
                   .withYamlStrategy();
    }

    @Override
    public StrategyProviderBuilder withJsonStrategy() {
        this.provider.addStrategy(new SerializerStrategy(JSON_EXTENSIONS, new JsonFactory(), true));
        return this;
    }

    @Override
    public StrategyProviderBuilder withYamlStrategy() {
        this.provider.addStrategy(new SerializerStrategy(YAML_EXTENSIONS, new YAMLFactory(), false));
        return this;
    }

    @Override
    public StrategyProvider<FileStrategy> build() {
        return this.provider;
    }
}
