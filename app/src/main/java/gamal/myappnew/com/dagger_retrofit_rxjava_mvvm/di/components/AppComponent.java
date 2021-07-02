package gamal.myappnew.com.dagger_retrofit_rxjava_mvvm.di.components;


import javax.inject.Singleton;

import dagger.Component;
import gamal.myappnew.com.dagger_retrofit_rxjava_mvvm.MainActivity;
import gamal.myappnew.com.dagger_retrofit_rxjava_mvvm.di.moduels.ContextModel;
import gamal.myappnew.com.dagger_retrofit_rxjava_mvvm.di.moduels.NetWorkModel;
import gamal.myappnew.com.dagger_retrofit_rxjava_mvvm.di.moduels.viewModelModels;

@Singleton
@Component(modules = {NetWorkModel.class, ContextModel.class, viewModelModels.class})
public interface AppComponent {
    void injectMainActivity(MainActivity activity);
}
