package com.example.rohan.sensorcw3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import org.w3c.dom.Attr;

import java.util.ArrayList;

/**
 * Created by rohan on 9/28/17.
 */

public class PlotView extends View {

    private ArrayList<Float> data;

    public void clearList() {
        data.clear();
    }

    public void addPoint(Float f) {
        data.add(f);
        if (data.size() > 10) {
            data.remove(0);
        }
    }

    private void initData() {
        data = new ArrayList<Float>(10);
        for (int i = 0; i < 10; i++) {
            float randomVal = (float)Math.random() * 100;
            addPoint(randomVal);
        }
    }

    public PlotView(Context context) {
        super(context);
        initData();
    }

    public PlotView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initData();
    }

    public PlotView(Context context, AttributeSet attributeSet, int defStyleAttr) {
        this(context, attributeSet);
    }

    public PlotView(Context context, AttributeSet attributeSet, int defStyleAttr, int defStyleRes) {
        this(context, attributeSet);
    }

    Pair getCanvasCoords(int x, float y, int width, int height) {
        Pair result = new Pair();
        result.f = (x+1) * width * 0.9f / 10;
        result.s = (0.05f * height) + y * height * 0.9f / 100;
        return result;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // draw on canvas
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        for (int i = 0; i < data.size(); i++) {
            Pair coords = getCanvasCoords(i, data.get(i), width, height);
            paint.setColor(Color.RED);
            canvas.drawCircle(coords.f, coords.s, 20, paint);
            if (i < data.size()-1) {
                Pair coordsNext = getCanvasCoords(i+1, data.get(i+1), width, height);
                paint.setColor(Color.BLACK);
                canvas.drawLine(coords.f, coords.s, coordsNext.f, coordsNext.s, paint);
            }
        }

    }
}
