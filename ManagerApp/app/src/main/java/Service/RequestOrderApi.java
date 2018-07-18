package Service;

import java.util.List;

import ORM.RequestOrder;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RequestOrderApi {

    @GET("RequestOrderService/RequestOrders")
    Call<List<RequestOrder>> RequestOrders(); // get all RequestOrders for testing only
}
