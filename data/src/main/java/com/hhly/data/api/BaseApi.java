package com.hhly.data.api;

import com.hhly.data.bean.HistoryInfoBean;
import com.hhly.data.bean.MeiZhiPictureBean;
import com.hhly.data.bean.ResultBaseBean;
import com.hhly.data.bean.TestBean;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * 描    述：获取数据的api
 * 作    者：xul@13322.com
 * 时    间：2016/9/7
 */
public interface BaseApi {

    @GET("history/content/{pageSize}/{pageIndex}")
    Observable<ResultBaseBean<List<HistoryInfoBean>>> getHistoryInfo(@Path("pageSize") int pageSize, @Path("pageIndex") int pageIndex);

    @GET("data/福利/{pageSize}/{pageIndex}")
    Observable<ResultBaseBean<List<MeiZhiPictureBean>>> getMeiZhiPicture(@Path("pageSize") int pageSize, @Path("pageIndex") int pageIndex);
}
