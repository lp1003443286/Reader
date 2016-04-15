package tool.lp.xutil;

import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;


import java.util.Map;

import xutils.common.Callback;
import xutils.common.util.DensityUtil;
import xutils.http.RequestParams;
import xutils.image.ImageOptions;
import xutils.x;

/**
 * Created by 鹏 on 2016/2/15.
 */
public class XUtil {
    private static ImageOptions options;
    private static AnimationSet set;

    /*
    * xUtils  中的公用的请求头可以在这里设置
    *
    * RequestParams  中也可以设置超时时间   公共请求头等
    *
    * */

    /**
     * 发送get请求
     *
     * @param <T>
     */
    public static <T> Callback.Cancelable Get(String url, Map<String, String> map, Callback.CommonCallback<T> callback) {
        RequestParams params = new RequestParams(url);
        if (null != map) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                //这个就相当于在url  后面直接加字符串
                params.addQueryStringParameter(entry.getKey(), entry.getValue());
            }
        }

        Callback.Cancelable cancelable = x.http().get(params, callback);
        return cancelable;

    }

    /**
     * 发送post请求
     *
     * @param <T>
     */
    public static <T> Callback.Cancelable Post(String url, Map<String, Object> map, Callback.CommonCallback<T> callback) {
        RequestParams params = new RequestParams(url);
        if (null != map) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                params.addParameter(entry.getKey(), entry.getValue());
            }
        }
        Callback.Cancelable cancelable = x.http().post(params, callback);
        return cancelable;
    }


    /**
     * 上传文件
     *
     * @param <T>
     */
    public static <T> Callback.Cancelable UpLoadFile(String url, Map<String, Object> map, Callback.CommonCallback<T> callback) {
        RequestParams params = new RequestParams(url);
        if (null != map) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                params.addParameter(entry.getKey(), entry.getValue());
            }
        }
        params.setMultipart(true);
        Callback.Cancelable cancelable = x.http().get(params, callback);
        return cancelable;
    }

    /**
     * 下载文件
     *
     * @param <T>
     */
    public static <T> Callback.Cancelable DownLoadFile(String url, String filepath, Callback.CommonCallback<T> callback) {
        RequestParams params = new RequestParams(url);
        //设置断点续传
        params.setAutoResume(true);
        params.setSaveFilePath(filepath);
        Callback.Cancelable cancelable = x.http().get(params, callback);
        return cancelable;
    }

    static {
        set = new AnimationSet(false);
        set.setFillAfter(true);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.1f, 1.0f);
        alphaAnimation.setDuration(1000);

        ScaleAnimation animation = new ScaleAnimation(0, 180, 0, 180);
        animation.setDuration(2000);
        set.addAnimation(alphaAnimation);
        options = new ImageOptions.Builder()
                .setSize(DensityUtil.dip2px(120), DensityUtil.dip2px(120))
                        //.setRadius(DensityUtil.dip2px(5))
                .setCircular(false).setRadius(DensityUtil.dip2px(50))
                        // 如果ImageView的大小不是定义为wrap_content, 不要crop.
                .setCrop(true) // 很多时候设置了合适的scaleType也不需要它.
                        // 加载中或错误图片的ScaleType
                        //.setPlaceholderScaleType(ImageView.ScaleType.MATRIX)
                .setImageScaleType(ImageView.ScaleType.FIT_XY)
                .setAnimation(set).setIgnoreGif(false)
                .build();

    }

    static int loadingDrawableId = 0;
    static int failureDrawableId = 0;

    public static void setLoadingDrawableId(int id) {
        loadingDrawableId = id;
        ImageOptions.Builder builder = new ImageOptions.Builder();
        builder
                .setSize(DensityUtil.dip2px(120), DensityUtil.dip2px(120))
                        //.setRadius(DensityUtil.dip2px(5))
                .setCircular(false).setRadius(DensityUtil.dip2px(50))
                // 如果ImageView的大小不是定义为wrap_content, 不要crop.
                .setCrop(true) // 很多时候设置了合适的scaleType也不需要它.
                        // 加载中或错误图片的ScaleType
                        //.setPlaceholderScaleType(ImageView.ScaleType.MATRIX)
                .setImageScaleType(ImageView.ScaleType.CENTER_CROP)
                .setAnimation(set).setIgnoreGif(false);
        if (loadingDrawableId != 0) {
            builder.setLoadingDrawableId(loadingDrawableId);
        }
        if (failureDrawableId != 0) {
            builder.setFailureDrawableId(failureDrawableId);
        }
        options = builder.build();
    }

    public static void setFailureDrawableId(int id) {
        failureDrawableId = id;
        ImageOptions.Builder builder = new ImageOptions.Builder();
        builder
                .setSize(DensityUtil.dip2px(120), DensityUtil.dip2px(120))
                        //.setRadius(DensityUtil.dip2px(5))
                .setCircular(false).setRadius(DensityUtil.dip2px(50))
                        // 如果ImageView的大小不是定义为wrap_content, 不要crop.
                .setCrop(true) // 很多时候设置了合适的scaleType也不需要它.
                        // 加载中或错误图片的ScaleType
                        //.setPlaceholderScaleType(ImageView.ScaleType.MATRIX)
                .setImageScaleType(ImageView.ScaleType.CENTER_CROP)
                .setAnimation(set).setIgnoreGif(false);
        if (loadingDrawableId != 0) {
            builder.setLoadingDrawableId(loadingDrawableId);
        }
        if (failureDrawableId != 0) {
            builder.setFailureDrawableId(failureDrawableId);
        }
        options = builder.build();
    }


    public static void loadImage(ImageView imageView, String url) {
        x.image().bind(imageView,
                url,
                options);
    }

    public static void loadImage(ImageView imageView, String url, ImageOptions options) {
        x.image().bind(imageView,
                url,
                options);
    }

    public static void loadImage(ImageView imageView, String url, Callback.CommonCallback callback) {
        x.image().bind(imageView,
                url,
                options,
                callback);
    }

    public static void loadImage(ImageView imageView, String url, ImageOptions options, Callback.CommonCallback callback) {
        x.image().bind(imageView,
                url,
                options,
                callback);
    }
}
