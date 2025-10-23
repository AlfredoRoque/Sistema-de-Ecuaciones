package ecuaciones;

import java.util.ArrayList;
import java.util.List;

public class SistemaEcuacion {

    private List<Double> xValue = new ArrayList<>();
    private List<Double> yValue = new ArrayList<>();
    private List<Double> zValue = new ArrayList<>();
    private List<Double> ecuResults = new ArrayList<>();
    private List<Double> xProcess = new ArrayList<>();
    private List<Double> yProcess = new ArrayList<>();
    private List<Double> zProcess = new ArrayList<>();
    private double xResult;
    private double yResult;
    private double zResult;

    public List<Double> getzValue() {
        return zValue;
    }

    public List<Double> getzProcess() {
        return zProcess;
    }

    public double getzResult() {
        return zResult;
    }

    public void setzResult(double zResult) {
        this.zResult = zResult;
    }

    public List<Double> getxProcess() {
        return xProcess;
    }

    public List<Double> getyProcess() {
        return yProcess;
    }

    public double getxResult() {
        return xResult;
    }

    public void setxResult(Double xResult) {
        this.xResult = xResult;
    }

    public double getyResult() {
        return yResult;
    }

    public void setyResult(Double yResult) {
        this.yResult = yResult;
    }

    public List<Double> getEcuResults() {
        return ecuResults;
    }

    public List<Double> getxValue() {
        return xValue;
    }

    public List<Double> getyValue() {
        return yValue;
    }
}
