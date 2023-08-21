package com.qualityplus.fastserializer.api.builder;

import com.qualityplus.fastserializer.api.provider.StrategyProvider;
import com.qualityplus.fastserializer.api.strategy.FileStrategy;

public interface StrategyProviderBuilder {
    public StrategyProviderBuilder withDefaultStrategies();

    public StrategyProviderBuilder withJsonStrategy();

    public StrategyProviderBuilder withYamlStrategy();

    public StrategyProvider<FileStrategy> build();
}
