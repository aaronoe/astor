package fr.inria.astor.core.faultlocalization.cocospoon.metrics;

import fr.inria.astor.core.faultlocalization.cocospoon.CocoSpoonEngineFaultLocalizer;

/**
 * Metric that returns the constructor argument as a result.
 * Should be used as an adapter in the {@link CocoSpoonEngineFaultLocalizer}
 * when aggregating other metrics.
 */
public class IdentityMetric implements Metric {

    public IdentityMetric(double value) {
        this.value = value;
    }

    double value;

    @Override
    public double value(int ef, int ep, int nf, int np) {
        return value;
    }
}
