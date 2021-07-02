package gamal.myappnew.com.dagger_retrofit_rxjava_mvvm.di.moduels;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import gamal.myappnew.com.dagger_retrofit_rxjava_mvvm.common.Common;
import gamal.myappnew.com.dagger_retrofit_rxjava_mvvm.data.remote.UserService;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public abstract class NetWorkModel {
    @Provides
    @Singleton
    static Retrofit ProvideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(Common.BASE_URL_USER)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    static UserService ProvideUserService(Retrofit retrofit) {
        return retrofit.create(UserService.class);
    }
}
