package me.yifeiyuan.hf.activity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * Created by 程序亦非猿 on 2023/4/14.
 */
public class TView extends View {

    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public TView(Context context) {
        super(context);
        init(context, null, 0);
    }

    public TView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public TView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        paint.setColor(Color.parseColor("#00ff00"));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Path p = new Path();
        p.moveTo(0, 0);
        p.lineTo(getWidth() / 2, getHeight());
        p.lineTo(getWidth(), 0);
        p.close();
        canvas.drawPath(p, paint);
    }
}
