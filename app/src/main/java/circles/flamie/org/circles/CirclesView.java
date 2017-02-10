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

    private int[] colors;
    private Paint firstCirclePaint;
    private Paint secondCirclePaint;
    private Paint thirdCirclePaint;
    private Paint fourthCirclePaint;
    private Random randomColor;

    public CirclesView(Context context) {
        super(context);
        setBackgroundColor(Color.BLACK);
        randomColor = new Random();
        colors = new int[3];

        firstCirclePaint = new Paint();
        firstCirclePaint.setColor(Color.RED);
        firstCirclePaint.setAntiAlias(true);
        firstCirclePaint.setStyle(Paint.Style.FILL);

        secondCirclePaint = new Paint();
        secondCirclePaint.setColor(Color.YELLOW);
        secondCirclePaint.setAntiAlias(true);
        secondCirclePaint.setStyle(Paint.Style.FILL);

        thirdCirclePaint = new Paint();
        thirdCirclePaint.setColor(Color.BLUE);
        thirdCirclePaint.setAntiAlias(true);
        thirdCirclePaint.setStyle(Paint.Style.FILL);

        fourthCirclePaint = new Paint();
        fourthCirclePaint.setColor(Color.GREEN);
        fourthCirclePaint.setAntiAlias(true);
        fourthCirclePaint.setStyle(Paint.Style.FILL);

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
        int firstRandomResult = Color.rgb(randomColor.nextInt(254) + 1, randomColor.nextInt(254) + 1, randomColor.nextInt(254) + 1);
        int secondRandomResult = Color.rgb(randomColor.nextInt(254) + 1, randomColor.nextInt(254) + 1, randomColor.nextInt(254) + 1);
        int thirdRandomResult = Color.rgb(randomColor.nextInt(254) + 1, randomColor.nextInt(254) + 1, randomColor.nextInt(254) + 1);
        int fourthRandomResult = Color.rgb(randomColor.nextInt(254) + 1, randomColor.nextInt(254) + 1, randomColor.nextInt(254) + 1);

        canvas.drawCircle(displayWidth - dp(80), displayHeight - dp(80), dp(30), firstCirclePaint); // left top
        canvas.drawCircle(displayWidth + dp(80), displayHeight - dp(80), dp(30), secondCirclePaint); // right top
        canvas.drawCircle(displayWidth - dp(80), displayHeight + dp(80), dp(30), thirdCirclePaint); // left bottom
        canvas.drawCircle(displayWidth + dp(80), displayHeight + dp(80), dp(30), fourthCirclePaint); // right bottom

        firstCirclePaint.setColor(firstRandomResult);
        secondCirclePaint.setColor(secondRandomResult);
        thirdCirclePaint.setColor(thirdRandomResult);
        fourthCirclePaint.setColor(fourthRandomResult);
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
