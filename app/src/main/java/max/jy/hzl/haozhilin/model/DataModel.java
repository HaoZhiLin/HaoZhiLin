package max.jy.hzl.haozhilin.model;

import java.util.List;

import javax.crypto.spec.RC2ParameterSpec;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import max.jy.hzl.haozhilin.ApiService;
import max.jy.hzl.haozhilin.bean.Max;
import max.jy.hzl.haozhilin.contract.DataContract;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class DataModel implements DataContract.Model {

    @Override
    public void getData(final DataContract.Icall icall) {
        new Retrofit.Builder()
                .baseUrl(ApiService.url)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService.class)
                .getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Max>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Max max) {
                        icall.success(max);
                    }

                    @Override
                    public void onError(Throwable e) {
                        icall.fail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
