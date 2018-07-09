package fr.inria.astor.core.faultlocalization.cocospoon.code;

public class MetricParams {

    private SourceLocation sourceLocation;
    private int ef;
    private int ep;
    private int nf;
    private int np;

    public MetricParams(SourceLocation sourceLocation, int ef, int ep, int nf, int np) {
        this.sourceLocation = sourceLocation;
        this.ef = ef;
        this.ep = ep;
        this.nf = nf;
        this.np = np;
    }

    public SourceLocation getSourceLocation() {
        return sourceLocation;
    }

    public int getEf() {
        return ef;
    }

    public int getEp() {
        return ep;
    }

    public int getNf() {
        return nf;
    }

    public int getNp() {
        return np;
    }

}
