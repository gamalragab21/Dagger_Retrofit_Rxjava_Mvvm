package gamal.myappnew.com.dagger_retrofit_rxjava_mvvm.di.moduels;


import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import gamal.myappnew.com.dagger_retrofit_rxjava_mvvm.di.annotions.ViewModelKey;
import gamal.myappnew.com.dagger_retrofit_rxjava_mvvm.viewmodel.UserViewModel;
import gamal.myappnew.com.dagger_retrofit_rxjava_mvvm.viewmodel.ViewModelFactory;

@Module
public abstract class viewModelModels {
    @Binds
    @IntoMap
    @ViewModelKey(UserViewModel.class)
    abstract ViewModel bindViewModel(UserViewModel userViewModel);


    @Binds
    abstract ViewModelProvider.Factory bindFactory(ViewModelFactory viewModelFactory);


}
