package fr.inria.astor.core.faultlocalization.cocospoon.metrics;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Aggregates a list of metrics using the cosine similarity
 */
public class CombinedMetric implements Metric {

    private List<Metric> metrics;

    public CombinedMetric(List<Metric> metrics) {
        this.metrics = metrics;
    }

    @Override
    public double value(int ef, int ep, int nf, int np) {
        double result;
        double dotProduct = 0d;
        double euclidParams = 0d;
        double euclidMostSusp = metrics.size();

        List<Double> metricResults = metrics.stream()
                .map(item -> item.value(ef, ep, nf, np))
                .collect(Collectors.toList());

        for (Double suspValue : metricResults) {
            suspValue = suspValue < 0 ? 0 : suspValue;
            dotProduct += suspValue;
            euclidParams += suspValue * suspValue;
        }
        euclidParams = Math.sqrt(euclidParams);
        euclidMostSusp = Math.sqrt(euclidMostSusp);

        if (euclidParams > 0 && euclidMostSusp > 0) {
            result = dotProduct / (euclidParams * euclidMostSusp);
        } else {
            result = 0;
        }
        /*reduce all similarities less than 0.5 cos-similarity down to 0 due to performance issues
         * and for weighting reasons
         */
        if (result < 0.5) {
            result = 0;
        }

        return result;
    }
}
