package Service;

import java.util.List;
import java.util.Map;

import ORM.RequestOrder;
import ORM.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface RequestOrderApi {

    @GET("RequestOrderService/all")
    Call<List<RequestOrder>> RequestOrders(); // get all RequestOrders for testing only

    @GET("RequestOrderService/byId")
    Call<RequestOrder> RequestOrdersById(@QueryMap Map<String, String> params); //get request order with particular id

    @GET("RequestOrderService/byStatus")
    Call<List<RequestOrder>> byStatus(@QueryMap Map<String, String> params); // get all RequestOrders for testing only


    @GET("RequestOrderService/update")
    Call<RequestOrder> Update(@QueryMap Map<String, String> params);

}
