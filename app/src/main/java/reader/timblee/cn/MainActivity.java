package reader.timblee.cn;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import reader.timblee.cn.activities.PersonActivity;
import reader.timblee.cn.fragments.BooksFragment;
import xutils.image.ImageOptions;
import xutils.view.annotation.ContentView;
import xutils.view.annotation.Event;
import xutils.view.annotation.ViewInject;
import xutils.x;

@ContentView(R.layout.activity_main)
public class MainActivity extends BaseActivity {

    @ViewInject(R.id.menu_roundImageView_head)
    ImageView imgView;
    @ViewInject(R.id.main_menu_personal)
    RelativeLayout main_menu_personal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ImageOptions imageOptions = new ImageOptions.Builder()
                .setCircular(true)
                .setCrop(true) // 很多时候设置了合适的scaleType也不需要它.
                .setImageScaleType(ImageView.ScaleType.CENTER_CROP)
                .setIgnoreGif(false).setLoadingDrawableId(R.drawable.defaultheader).setFailureDrawableId(R.drawable.defaultheader)
                .build();

        x.image().bind(imgView, "http://a.hiphotos.baidu.com/image/h%3D200/sign=4da4ff1895ef76c6cfd2fc2bad16fdf6/f9dcd100baa1cd11daf25f19bc12c8fcc3ce2d46.jpg", imageOptions);

        Fragment fragment = new BooksFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.bookShop_frameLayout, fragment).commit();

    }

    @Event(value = {R.id.main_menu_personal})
    private void onClick(View view) {
        Intent intent = new Intent(this, PersonActivity.class);
        startActivity(intent);
    }

}
