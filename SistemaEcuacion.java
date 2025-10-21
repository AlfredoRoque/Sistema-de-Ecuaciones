package ecuaciones;

import java.util.ArrayList;
import java.util.List;

public class SistemaEcuacion {

    private List<Double> xValue = new ArrayList<>();
    private List<Double> yValue = new ArrayList<>();
    private List<Double> ecuResults = new ArrayList<>();
    private List<Double> xProcess = new ArrayList<>();
    private List<Double> yProcess = new ArrayList<>();
    private double xResult;
    private double yResult;

    public List<Double> getxProcess() {
        return xProcess;
    }

    public void setxProcess(List<Double> xProcess) {
        this.xProcess = xProcess;
    }

    public List<Double> getyProcess() {
        return yProcess;
    }

    public void setyProcess(List<Double> yProcess) {
        this.yProcess = yProcess;
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

    public void setEcuResults(List<Double> ecuResults) {
        this.ecuResults = ecuResults;
    }

    public List<Double> getxValue() {
        return xValue;
    }

    public void setxValue(List<Double> xValue) {
        this.xValue = xValue;
    }

    public List<Double> getyValue() {
        return yValue;
    }

    public void setyValue(List<Double> yValue) {
        this.yValue = yValue;
    }
}
