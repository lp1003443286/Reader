package tool.lp.xutil;

import com.google.gson.Gson;

import java.lang.reflect.Type;

import xutils.http.app.ResponseParser;
import xutils.http.request.UriRequest;

/**
 * Created by 鹏 on 2016/2/15.
 */
public class JsonResponseParser implements ResponseParser {
    //检查服务器返回的响应头信息
    @Override
    public void checkResponse(UriRequest request) throws Throwable {

        // custom check ?
        // get headers ?
    }

    /**
     * 转换result为resultType类型的对象
     *
     * @param resultType  返回值类型(可能带有泛型信息)
     * @param resultClass 返回值类型
     * @param result      字符串数据
     * @return
     * @throws Throwable
     */
    @Override
    public Object parse(Type resultType, Class<?> resultClass, String result) throws Throwable {
        return new Gson().fromJson(result, resultClass);
    }
}
