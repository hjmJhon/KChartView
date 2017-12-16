package com.github.tifezh.kchartlib.chart.EntityImpl;

/**
 * 蜡烛图实体
 * Created by tifezh on 2016/6/9.
 */

public interface CandleImpl {

    /**
     * 开盘价
     *
     * @return
     */
    public float getOpenPrice();

    /**
     * 最高价
     *
     * @return
     */
    public float getHighPrice();

    /**
     * 最低价
     *
     * @return
     */
    public float getLowPrice();

    /**
     * 收盘价
     *
     * @return
     */
    public float getClosePrice();

    public float getMa5Price();

    public float getMa10Price();

    public float getMa20Price();
}
