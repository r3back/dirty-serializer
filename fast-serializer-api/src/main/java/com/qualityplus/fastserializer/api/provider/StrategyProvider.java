package com.qualityplus.fastserializer.api.provider;

import java.util.List;

public interface StrategyProvider<T> {
    public void addStrategy(final T strategy);

    public List<T> getStrategies();
}
