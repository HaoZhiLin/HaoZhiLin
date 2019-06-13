package max.jy.hzl.haozhilin;

import io.reactivex.Observable;
import max.jy.hzl.haozhilin.bean.Max;
import retrofit2.http.GET;

public interface ApiService {

    String url="http://api.apiopen.top/";

    @GET("getJoke")
    Observable<Max>  getData();

}
