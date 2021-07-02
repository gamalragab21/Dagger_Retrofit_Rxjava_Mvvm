package gamal.myappnew.com.dagger_retrofit_rxjava_mvvm.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

import gamal.myappnew.com.dagger_retrofit_rxjava_mvvm.model.User;
import gamal.myappnew.com.dagger_retrofit_rxjava_mvvm.repository.UserRepository;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class UserViewModel extends ViewModel {
    private static final String TAG = "UserViewModel";
    private UserRepository userRepository;
    private CompositeDisposable disposable = new CompositeDisposable();


    private MutableLiveData<User> mutableLiveData = new MutableLiveData<>();

    @Inject
    public UserViewModel(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public MutableLiveData<User> getMutableLiveData() {
        loadData();
        return mutableLiveData;
    }

    private void loadData() {
//
        disposable.add(userRepository.getUser()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<User>() {
                    @Override
                    public void onSuccess(@NotNull User user) {
                        getMutableLiveData().setValue(user);

                    }

                    @Override
                    public void onError(@NotNull Throwable e) {
                        Log.d(TAG, "onError: " + e.getMessage());
                    }

                }));

    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }
}
