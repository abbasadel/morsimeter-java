package com.tahrirsquad.morsimeter.model;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public class PromiseStats {

    private Integer cachedCount = null;
    private Map<PromiseStatus, Integer> counts = init();

    public static PromiseStats create(@NotNull List<Promise> promises) {
        return promises.stream().reduce(new PromiseStats(), (stats, promise) -> {
            stats.addStatusCount(promise.getStatus());
            return stats;
        }, (a1, a2) -> null);

    }

    private Map<PromiseStatus, Integer> init() {
        HashMap<PromiseStatus, Integer> map = new HashMap<>(PromiseStatus.values().length);
        Stream.of(PromiseStatus.values()).forEach(i -> map.put(i, 0));
        return map;

    }


    public void addStatusCount(PromiseStatus promiseStatus) {
        counts.merge(promiseStatus, 1, Integer::sum);
    }

    public Integer getStatusCount(PromiseStatus promiseStatus) {
        return counts.get(promiseStatus);
    }

    public Integer getStatusTotal() {
        cachedCount = Optional.ofNullable(cachedCount).orElseGet(() ->
                counts.values().stream().reduce(0, (a, b) -> a += b)
        );

        return cachedCount;
    }

    public double getStatusPercentage(PromiseStatus promiseStatus) {
        return BigDecimal.valueOf(counts.get(promiseStatus)).divide(BigDecimal.valueOf(getStatusTotal())).doubleValue();
    }
}
