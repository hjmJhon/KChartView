package com.github.tifezh.kchartlib.chart.draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;

import com.github.tifezh.kchartlib.R;
import com.github.tifezh.kchartlib.chart.BaseKChartView;
import com.github.tifezh.kchartlib.chart.EntityImpl.VolumeImpl;
import com.github.tifezh.kchartlib.chart.impl.IChartDraw;
import com.github.tifezh.kchartlib.utils.ViewUtil;

/**
 * Created by hjm on 2017/11/14 17:49.
 */

public class VolumeDraw implements IChartDraw<VolumeImpl> {

    private Paint mRedPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Paint mGreenPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Paint ma5Paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Paint ma10Paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private int pillarWidth = 0;

    public VolumeDraw(BaseKChartView view) {
        Context context = view.getContext();
        mRedPaint.setColor(ContextCompat.getColor(context, R.color.chart_red));
        mGreenPaint.setColor(ContextCompat.getColor(context, R.color.chart_green));
        pillarWidth = ViewUtil.Dp2Px(context, 4);
    }

    @Override
    public void drawTranslated(
            @Nullable VolumeImpl lastPoint, @NonNull VolumeImpl curPoint, float lastX, float curX,
            @NonNull Canvas canvas, @NonNull BaseKChartView view, int position) {

        drawHistogram(canvas, curPoint, lastPoint, curX, view, position);
        view.drawChildLine(canvas, ma5Paint, lastX, lastPoint.getMa5Volume(), curX, curPoint.getMa5Volume());
        view.drawChildLine(canvas, ma10Paint, lastX, lastPoint.getMa10Volume(), curX, curPoint.getMa10Volume());
    }

    private void drawHistogram(
            Canvas canvas, VolumeImpl curPoint, VolumeImpl lastPoint, float curX,
            BaseKChartView view, int position) {

        float r = pillarWidth / 2;
        float top = view.getChildY(curPoint.getVolume());
        int bottom = view.getChildRect().bottom;
        if (curPoint.getClosePrice() >= curPoint.getOpenPrice()) {//涨
            canvas.drawRect(curX - r, top, curX + r, bottom, mRedPaint);
        } else {
            canvas.drawRect(curX - r, top, curX + r, bottom, mGreenPaint);
        }

    }

    @Override
    public void drawText(
            @NonNull Canvas canvas, @NonNull BaseKChartView view, int position, float x, float y) {

        VolumeImpl point = (VolumeImpl) view.getItem(position);
        String text = "MA5:" + view.formatValue(point.getMa5Volume()) + " ";
        canvas.drawText(text, x, y, ma5Paint);
        x += ma5Paint.measureText(text);
        text = "MA10:" + view.formatValue(point.getMa10Volume()) + " ";
        canvas.drawText(text, x, y, ma10Paint);
    }

    @Override
    public float getMaxValue(VolumeImpl point) {
        return Math.max(point.getVolume(),Math.max(point.getMa5Volume(),point.getMa10Volume()));
    }

    @Override
    public float getMinValue(VolumeImpl point) {
        return Math.min(point.getVolume(),Math.min(point.getMa5Volume(),point.getMa10Volume()));
    }

    /**
     * 设置 MA5 线的颜色
     * @param color
     */
    public void setMa5Color(int color) {
        this.ma5Paint.setColor(color);
    }

    /**
     * 设置 MA10 线的颜色
     * @param color
     */
    public void setMa10Color(int color) {
        this.ma10Paint.setColor(color);
    }

    public void setLineWidth(float width) {
        this.ma5Paint.setStrokeWidth(width);
        this.ma10Paint.setStrokeWidth(width);
    }

    /**
     * 设置文字大小
     * @param textSize
     */
    public void setTextSize(float textSize) {
        this.ma5Paint.setTextSize(textSize);
        this.ma10Paint.setTextSize(textSize);
    }

}
