package Service;

import ORM.User;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created segroup1
 */

public class FactoryServiceAPI {

    public static  String BASE_SERVICE = "http://35.237.181.74:8080/jSMWebService/rest/";
    private static UserApi userApi;
    private static RequestOrderApi requestOrderApi;
    private static RequestResponseApi requestResponseApi;
    // variable keep logged user
    public  static User currentUser; //
    
    static{
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_SERVICE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        // apis
        userApi = retrofit.create(UserApi.class);
        requestOrderApi = retrofit.create(RequestOrderApi.class);
        requestResponseApi=retrofit.create(RequestResponseApi.class);

    }


    public static UserApi GetUserApi()
    {
        return userApi;
    }


    public static RequestOrderApi GetRequesetOrderApi()
    {
        return requestOrderApi;
    }

    public static RequestResponseApi GetRequestResponseApi() { return requestResponseApi;}

}
