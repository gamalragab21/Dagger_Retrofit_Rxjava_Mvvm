package gamal.myappnew.com.dagger_retrofit_rxjava_mvvm.app;

import android.app.Application;

import dagger.android.support.DaggerAppCompatActivity;
import gamal.myappnew.com.dagger_retrofit_rxjava_mvvm.di.components.AppComponent;
import gamal.myappnew.com.dagger_retrofit_rxjava_mvvm.di.components.DaggerAppComponent;

public class BaseApplication extends Application {
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.create();
        // appComponent=DaggerAppCompo

    }

    public AppComponent getAppComponents() {
        return appComponent;
    }
}
