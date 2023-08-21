package com.qualityplus.fastserializer.core.provider;

import com.qualityplus.fastserializer.api.provider.StrategyProvider;
import com.qualityplus.fastserializer.api.strategy.FileStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class StrategyProviderImpl implements StrategyProvider<FileStrategy> {
    private final List<FileStrategy> strategies = new ArrayList<>();

    @Override
    public void addStrategy(final FileStrategy strategy) {
        this.strategies.add(strategy);
    }

    @Override
    public List<FileStrategy> getStrategies() {
        return Collections.unmodifiableList(this.strategies);
    }
}
