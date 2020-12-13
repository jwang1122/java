package com.huaxia.learnrxjava;

public interface INumberParser {
    public boolean canParse(String str);
    public int parse(String str);
    public String toInt(int val);

}
