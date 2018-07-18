package Service;

import java.util.List;
import java.util.Map;

import ORM.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created  on 7/9/2018.
 */

public interface UserApi {

    @GET("UserService/users")
    Call<List<User>> Users(); // get all users for testing only

    // login
    @GET("UserService/login")
    Call<User> Login(@QueryMap Map<String, String> params);
}
