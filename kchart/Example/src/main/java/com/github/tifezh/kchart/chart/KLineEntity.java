package com.github.tifezh.kchart.chart;

import com.github.tifezh.kchartlib.chart.EntityImpl.KLineImpl;


/**
 * K线实体
 * Created by tifezh on 2016/5/16.
 */

public class KLineEntity implements KLineImpl {

    public String getDatetime() {
        return date;
    }

    @Override
    public float getOpenPrice() {
        return open;
    }

    @Override
    public float getHighPrice() {
        return high;
    }

    @Override
    public float getLowPrice() {
        return low;
    }

    @Override
    public float getClosePrice() {
        return close;
    }

    public float getMa5Price() {
        return ma5Price;
    }

    public float getMa10Price() {
        return ma10Price;
    }

    public float getMa20Price() {
        return ma20Price;
    }

    @Override
    public float getDea() {
        return dea;
    }

    @Override
    public float getDif() {
        return dif;
    }

    @Override
    public float getMacd() {
        return macd;
    }

    @Override
    public float getK() {
        return k;
    }

    @Override
    public float getD() {
        return d;
    }

    @Override
    public float getJ() {
        return j;
    }

    @Override
    public float getRsi1() {
        return rsi1;
    }

    @Override
    public float getRsi2() {
        return rsi2;
    }

    @Override
    public float getRsi3() {
        return rsi3;
    }

    @Override
    public float getUp() {
        return up;
    }

    @Override
    public float getMb() {
        return mb;
    }

    @Override
    public float getDn() {
        return dn;
    }

    @Override
    public float getVolume() {
        return volume;
    }

    public float getMa5Volume() {
        return ma5Volume;
    }

    public float getMa10Volume() {
        return ma10Volume;
    }

    public String date;
    public float open;
    public float high;
    public float low;
    public float close;
    public float volume;

    public float ma5Price;

    public float ma10Price;

    public float ma20Price;

    public float dea;

    public float dif;

    public float macd;

    public float k;

    public float d;

    public float j;

    public float rsi1;

    public float rsi2;

    public float rsi3;

    public float up;

    public float mb;

    public float dn;

    public float ma5Volume;

    public float ma10Volume;




}
