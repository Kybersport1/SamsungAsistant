package com.example.sacwp;

public class RecyclerItem {
    private String mark;
    private Integer ico;

    public RecyclerItem(String mark, Integer ico) {
        this.mark = mark;
        this.ico = ico;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public Integer getIco() {
        return ico;
    }

    public void setIco(Integer ico) {
        this.ico = ico;
    }
}
