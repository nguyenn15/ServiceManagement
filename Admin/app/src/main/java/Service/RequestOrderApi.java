package Service;

import java.util.List;
import java.util.Map;

import ORM.RequestOrder;
import ORM.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface RequestOrderApi {

    @GET("RequestOrderService/RequestOrders")
    Call<List<RequestOrder>> RequestOrders(); // get all RequestOrders for testing only
}
