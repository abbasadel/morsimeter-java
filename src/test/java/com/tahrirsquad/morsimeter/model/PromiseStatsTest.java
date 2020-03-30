package com.tahrirsquad.morsimeter.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static com.tahrirsquad.morsimeter.model.PromiseStatus.*;
import static org.assertj.core.api.Assertions.assertThat;


class PromiseStatsTest {

    @Test
    void testCounts() {
        //GIVEN
        List<Promise> promises = Arrays.asList(
                new Promise().setStatus(DONE),
                new Promise().setStatus(DONE),
                new Promise().setStatus(DONE),
                new Promise().setStatus(DONE),
                new Promise().setStatus(DONE),
                new Promise().setStatus(IN_PROGRESS),
                new Promise().setStatus(IN_PROGRESS),
                new Promise().setStatus(IN_PROGRESS),
                new Promise().setStatus(NOT_DONE),
                new Promise().setStatus(NOT_DONE)
        );

        //WHEN
        PromiseStats promiseStats = PromiseStats.create(promises);


        //THEN
        assertThat(promiseStats).isNotNull();
        //ASSERT counts
        assertThat(promiseStats.getStatusTotal()).isEqualTo(10);
        assertThat(promiseStats.getStatusCount(DONE)).isEqualTo(5);
        assertThat(promiseStats.getStatusCount(IN_PROGRESS)).isEqualTo(3);
        assertThat(promiseStats.getStatusCount(NOT_DONE)).isEqualTo(2);

        //ASSERT percentage
        assertThat(promiseStats.getStatusPercentage(DONE)).isEqualTo(0.50);
        assertThat(promiseStats.getStatusPercentage(IN_PROGRESS)).isEqualTo(0.30);
        assertThat(promiseStats.getStatusPercentage(NOT_DONE)).isEqualTo(0.20);

    }


}