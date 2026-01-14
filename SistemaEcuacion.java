package ecuaciones;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SistemaEcuacion {

    private List<BigDecimal> xValue = new ArrayList<>();
    private List<BigDecimal> yValue = new ArrayList<>();
    private List<BigDecimal> zValue = new ArrayList<>();
    private List<BigDecimal> ecuResults = new ArrayList<>();
    private BigDecimal xResult;
    private BigDecimal yResult;
    private BigDecimal zResult;

    public List<BigDecimal> getzValue() {return zValue;}

    public BigDecimal getzResult() {return zResult;}

    public void setzResult(BigDecimal zResult) {this.zResult = zResult;}

    public BigDecimal getxResult() {
        return xResult;
    }

    public void setxResult(BigDecimal xResult) {
        this.xResult = xResult;
    }

    public BigDecimal getyResult() {
        return yResult;
    }

    public void setyResult(BigDecimal yResult) {
        this.yResult = yResult;
    }

    public List<BigDecimal> getEcuResults() {
        return ecuResults;
    }

    public List<BigDecimal> getxValue() {
        return xValue;
    }

    public List<BigDecimal> getyValue() {return yValue;}
}
