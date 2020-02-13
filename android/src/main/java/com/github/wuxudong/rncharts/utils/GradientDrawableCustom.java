package com.github.wuxudong.rncharts.utils;

import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.PaintDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.support.annotation.ColorInt;

public class GradientDrawableCustom extends PaintDrawable {
    public GradientDrawableCustom(final String orientation, @ColorInt final int[] colors , final float[] positions) {
        ShapeDrawable.ShaderFactory sf=new ShapeDrawable.ShaderFactory() {
            @Override
            public Shader resize(int width, int height) {
                float x0, x1, y0, y1;
                switch (orientation) {
                    case "TOP_BOTTOM":
                        x0 = 0;
                        y0 = 0;
                        x1 = x0;
                        y1 = height;
                        break;
                    case "TR_BL":
                        x0 = width;
                        y0 = 0;
                        x1 = 0;
                        y1 = height;
                        break;
                    case "RIGHT_LEFT":
                        x0 = width;
                        y0 = 0;
                        x1 = 0;
                        y1 = y0;
                        break;
                    case "BR_TL":
                        x0 = width;
                        y0 = height;
                        x1 = 0;
                        y1 = 0;
                        break;
                    case "BOTTOM_TOP":
                        x0 = 0;
                        y0 = height;
                        x1 = x0;
                        y1 = 0;
                        break;
                    case "BL_TR":
                        x0 = 0;
                        y0 = height;
                        x1 = width;
                        y1 = 0;
                        break;
                    case "LEFT_RIGHT":
                        x0 = 0;
                        y0 = 0;
                        x1 = width;
                        y1 = y0;
                        break;
                    default:/* TL_BR */
                        x0 = 0;
                        y0 = 0;
                        x1 = width;
                        y1 = height;
                        break;
                }

                return new LinearGradient(
                        x0, y0, x1, y1,
                        colors,
                        positions,
                        Shader.TileMode.MIRROR
                );
            };
        };

        setShape(new RectShape());
        setShaderFactory(sf);
    }
}
