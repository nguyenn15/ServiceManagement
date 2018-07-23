package Service;

import java.util.List;
import java.util.Map;

import ORM.RequestResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by 300272368 on 7/20/2018.
 */

public interface RequestResponseApi {

    @GET("RequestResponseService/byRequestId")
    Call<List<RequestResponse>> getQuoteById(@QueryMap Map<String, String> params);


}