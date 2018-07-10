package Service;

import java.util.List;
import java.util.Map;

import ORM.RequestOrder;
import ORM.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface RequestOrderApi {

    // Create
    @GET("RequestOrderService/Create")
    Call<RequestOrder> Create(@QueryMap Map<String, String> params);
}
