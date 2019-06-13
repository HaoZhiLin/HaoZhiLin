package max.jy.hzl.haozhilin.contract;

import max.jy.hzl.haozhilin.bean.Max;

public interface DataContract {
    interface Model {
        void getData(Icall icall);
    }

    interface View {
        void success(Max  max);
        void fail(String error);
    }

    interface Presenter {
        void getData();
    }

    interface Icall {
        void success(Max  max);
        void fail(String error);
    }
}
