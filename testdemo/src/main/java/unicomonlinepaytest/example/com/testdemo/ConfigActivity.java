package unicomonlinepaytest.example.com.testdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by bugtags.com on 15/7/28.
 */
public class ConfigActivity extends BaseActivity {

    @Override
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);

        setContentView(R.layout.activity_config_quick);

        findViewById(R.id.crashButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*CrashBean bean = new CrashBean();
                bean.differentOne();*/
                Button button=null;
                button.setText("aa");

            }
        });
    }
}
