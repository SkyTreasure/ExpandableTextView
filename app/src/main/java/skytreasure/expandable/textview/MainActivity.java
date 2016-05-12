package skytreasure.expandable.textview;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    ImageView ivOne, ivTwo, ivThree;
    boolean isExpanded = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.tv_text);
        ivTwo = (ImageView) findViewById(R.id.iv_two);
        ExpandablePanel panel = (ExpandablePanel) findViewById(R.id.ep_expand);

        panel.setOnExpandListener(new ExpandablePanel.OnExpandListener() {
            @Override
            public void onExpand(View handle, View content) {
                ObjectAnimator animatorTranslateY = ObjectAnimator.ofFloat(ivTwo, "translationY", 0, -50);
                animatorTranslateY.setDuration(500);
                animatorTranslateY.start();
            }

            @Override
            public void onCollapse(View handle, View content) {
                ObjectAnimator animatorTranslateY = ObjectAnimator.ofFloat(ivTwo, "translationY", -50, 0);
                animatorTranslateY.setDuration(500);
                animatorTranslateY.start();
            }
        });
    }
}
