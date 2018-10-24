package com.arduino.arduinoProject.model;

import java.math.BigDecimal;

public class Info {
    private Double max;
    private Double min;
    private Double avg;

    public Info(Double max, Double min, Double avg) {
        this.max = max;
        this.min = min;
        this.avg = avg;
    }

    public Info(){}
    public Double getMax() {
        return max;
    }

    public void setMax(Double max) {
        this.max = max;
    }

    public Double getMin() {
        return min;
    }

    public void setMin(Double min) {
        this.min = min;
    }

    public Double getAvg() {
        return avg;
    }

    public void setAvg(Double avg) {
        this.avg = avg;
    }
}
