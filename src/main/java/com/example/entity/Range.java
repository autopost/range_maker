package com.example.entity;

public class Range {
    private String diapasonMin;
    private String diapasonMax;
    private String range;

    public String getDiapasonMin() {
        return diapasonMin;
    }

    public void setDiapasonMin(String diapasonMin) {
        this.diapasonMin = diapasonMin;
    }

    public String getDiapasonMax() {
        return diapasonMax;
    }

    public void setDiapasonMax(String diapasonMax) {
        this.diapasonMax = diapasonMax;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    @Override
    public String toString() {
        return "Range{" +
                "diapasonMin=" + diapasonMin +
                ", diapasonMax=" + diapasonMax +
                ", range='" + range + '\'' +
                '}';
    }
}
