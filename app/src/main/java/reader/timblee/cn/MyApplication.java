package reader.timblee.cn;

import android.app.Application;

import com.bugtags.library.Bugtags;
import com.bugtags.library.BugtagsCallback;
import com.bugtags.library.BugtagsOptions;

import xutils.x;

/**
 * Created by pc on 2016/4/19.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //customizable init option
        BugtagsOptions options = new BugtagsOptions.Builder().
                trackingLocation(true).//是否获取位置
                trackingCrashLog(true).//是否收集crash
                trackingConsoleLog(true).//是否收集console log
                trackingUserSteps(true).//是否收集用户操作步骤
                build();
        //appKey  网站中首页里有的  gradle也需要初始化
        Bugtags.start("1d5b11ffe6ac8e36060b50d005b0fee4", this, Bugtags.BTGInvocationEventBubble, options);


        Bugtags.setBeforeSendingCallback(new BugtagsCallback() {
            @Override
            public void run() {
                Bugtags.log("before");
            }
        });

        Bugtags.setAfterSendingCallback(new BugtagsCallback() {
            @Override
            public void run() {
                Bugtags.log("after");
            }
        });

        //这里使用了xUtils框架  需要初始化0.0
        x.Ext.init(this);
        //todo 发布项目时改成false
        x.Ext.setDebug(BuildConfig.DEBUG);
    }
}
