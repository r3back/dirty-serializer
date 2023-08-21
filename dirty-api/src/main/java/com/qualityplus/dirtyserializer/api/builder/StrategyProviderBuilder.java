package com.qualityplus.dirtyserializer.api.builder;

import com.qualityplus.dirtyserializer.api.provider.StrategyProvider;
import com.qualityplus.dirtyserializer.api.strategy.FileStrategy;

public interface StrategyProviderBuilder {
    public StrategyProviderBuilder withDefaultStrategies();

    public StrategyProviderBuilder withJsonStrategy();

    public StrategyProviderBuilder withYamlStrategy();

    public StrategyProvider<FileStrategy> build();
}
