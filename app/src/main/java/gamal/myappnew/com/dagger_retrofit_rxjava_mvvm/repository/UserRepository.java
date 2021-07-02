package gamal.myappnew.com.dagger_retrofit_rxjava_mvvm.repository;

import javax.inject.Inject;
import javax.inject.Singleton;

import gamal.myappnew.com.dagger_retrofit_rxjava_mvvm.data.remote.UserService;
import gamal.myappnew.com.dagger_retrofit_rxjava_mvvm.model.User;
import io.reactivex.Single;

@Singleton
public class UserRepository {
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public Single<User> getUser() {
        return userService.getFritsUser();
    }

    @Inject
    public UserRepository(UserService userService) {
        this.userService = userService;
    }
}
