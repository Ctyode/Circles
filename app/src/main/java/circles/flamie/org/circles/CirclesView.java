package circles.flamie.org.circles;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;

import java.util.Random;

import static circles.flamie.org.circles.Dimen.dp;

/**
 * Created by flamie on 30.01.17 :3
 */

public class CirclesView extends View {

    private int displayWidth;
    private int displayHeight;

    private Paint[] paints;
    private Random randomColor;

    public CirclesView(Context context) {
        super(context);
        setBackgroundColor(Color.BLACK);
        randomColor = new Random();
        paints = new Paint[4];
        for(int i = 0; i <= 3; i++) {
            paints[i] = new Paint();
            paints[i].setAntiAlias(true);
            paints[i].setStyle(Paint.Style.FILL);
            paints[i].setColor(Color.rgb(randomColor.nextInt(254) + 1, randomColor.nextInt(254) + 1, randomColor.nextInt(254) + 1));
        }

        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if(Build.VERSION.SDK_INT >= 16) {
                    getViewTreeObserver().removeOnGlobalLayoutListener(this);
                } else {
                    getViewTreeObserver().removeGlobalOnLayoutListener(this);
                }

                displayWidth = getWidth() / 2;
                displayHeight = getHeight() / 2;
            }
        });
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(displayWidth - dp(80), displayHeight - dp(80), dp(30), paints[0]); // left top
        canvas.drawCircle(displayWidth + dp(80), displayHeight - dp(80), dp(30), paints[1]); // right top
        canvas.drawCircle(displayWidth - dp(80), displayHeight + dp(80), dp(30), paints[2]); // left bottom
        canvas.drawCircle(displayWidth + dp(80), displayHeight + dp(80), dp(30), paints[3]); // right bottom

        for(int i = 0; i <= 3; i++) {
            paints[i].setColor(Color.rgb(randomColor.nextInt(254) + 1, randomColor.nextInt(254) + 1, randomColor.nextInt(254) + 1));
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                invalidate();
        }
        return true;
    }
}
