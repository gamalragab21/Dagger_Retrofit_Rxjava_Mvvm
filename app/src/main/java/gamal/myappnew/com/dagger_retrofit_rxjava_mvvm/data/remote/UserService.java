package gamal.myappnew.com.dagger_retrofit_rxjava_mvvm.data.remote;

import gamal.myappnew.com.dagger_retrofit_rxjava_mvvm.model.User;
import io.reactivex.Single;
import retrofit2.http.GET;

public interface UserService {

    @GET("users/1")
    Single<User> getFritsUser(); // id=1


    Single<User> getUser();
}
