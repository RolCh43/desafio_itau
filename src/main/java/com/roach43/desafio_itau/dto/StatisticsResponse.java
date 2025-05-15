package com.roach43.desafio_itau.dto;

import java.util.DoubleSummaryStatistics;

public class StatisticsResponse {
    
    private final long count;
    private final double sum;
    private final double avg;
    private final double min;
    private final double max;

    public StatisticsResponse(DoubleSummaryStatistics stats) {
        this.count = stats.getCount();
        this.sum = stats.getSum();
        this.avg = stats.getAverage();
        this.min = stats.getMin();
        this.max = stats.getMax();
    }

    
    public long getCount() {
        return count;
    }

    public double getSum() {
        return sum;
    }

    public double getAvg() {
        return avg;
    }

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }

}
