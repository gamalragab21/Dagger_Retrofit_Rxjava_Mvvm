package gamal.myappnew.com.dagger_retrofit_rxjava_mvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import javax.inject.Inject;

import gamal.myappnew.com.dagger_retrofit_rxjava_mvvm.app.BaseApplication;
import gamal.myappnew.com.dagger_retrofit_rxjava_mvvm.data.remote.UserService;
import gamal.myappnew.com.dagger_retrofit_rxjava_mvvm.databinding.ActivityMainBinding;
import gamal.myappnew.com.dagger_retrofit_rxjava_mvvm.model.Address;
import gamal.myappnew.com.dagger_retrofit_rxjava_mvvm.model.Company;
import gamal.myappnew.com.dagger_retrofit_rxjava_mvvm.model.Geo;
import gamal.myappnew.com.dagger_retrofit_rxjava_mvvm.model.User;
import gamal.myappnew.com.dagger_retrofit_rxjava_mvvm.viewmodel.UserViewModel;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding activityMainBinding;
    @Inject
    ViewModelProvider.Factory viewModelFactory;
    private static final String TAG = "MainActivity";
    private UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        ((BaseApplication) getApplication()).getAppComponents().injectMainActivity(this);
        userViewModel = new ViewModelProvider(this, viewModelFactory).get(UserViewModel.class);

        activityMainBinding.setLifecycleOwner(this);

        userViewModel.getMutableLiveData().observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                activityMainBinding.setUser(user);
                Log.d(TAG, " aly onChanged: Show" + user.toString());
            }
        });

    }
}