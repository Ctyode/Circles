package circles.flamie.org.circles;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/**
 * Created by flamie on 30.01.17 :3
 */

public class MainObjects extends RelativeLayout {

    private MainActivity activity;

    public MainObjects(Context context, MainActivity activity) {
        super(context);
        this.activity = activity;

        init();
    }

    private void init() {
        final Context context = activity.getApplication().getApplicationContext();
        CirclesView circlesView = new CirclesView(context);
        LayoutParams circlesViewParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        circlesViewParams.addRule(CENTER_IN_PARENT);

        addView(circlesView, circlesViewParams);
    }

}
