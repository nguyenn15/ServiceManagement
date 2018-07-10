package Service;

import android.provider.Settings;
import android.widget.Toast;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import ORM.User;
import ORM.UserType;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static java.util.Collections.emptyList;

/**
 * Created segroup1
 */

public class UserService {

    public static  String BASE_SERVICE = "http://35.237.181.74:8080/jSMWebService/rest/";
    private UserApi userService;

    public UserService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_SERVICE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        userService = retrofit.create(UserApi.class);
    }


    public UserApi GetUserApi()
    {
        return userService;
    }



    /**
     * login user with user name and password, usertype is string of ADMIN, CUSTOMER, EMPLOYEE, MANAGER
     * @param userName
     * @param password
     * @param usertype
     * @return
     */
    public User login(String userName, String password, String usertype,  Callback<User> callback) {
        User user= null;
        try {
            // prepare map for parameters on url
            // example: username=admin&password=1234&usertype=ADMIN
            Map<String, String> params = new HashMap<String, String>();
            params.put("username", userName);
            params.put("password", password);
            params.put("usertype", usertype.toString()); /// ADMIN, CUSTOMER, EMPLOYEE, MANAGER

            user = userService
                    .Login(params, callback)
                    .execute()
                    .body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return user;
    }
}
