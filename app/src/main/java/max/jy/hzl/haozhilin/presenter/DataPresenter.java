package max.jy.hzl.haozhilin.presenter;

import max.jy.hzl.haozhilin.bean.Max;
import max.jy.hzl.haozhilin.contract.DataContract;
import max.jy.hzl.haozhilin.model.DataModel;

public class DataPresenter implements DataContract.Presenter {
    private final DataModel dataModel;
    private DataContract.View view;

    public DataPresenter(DataContract.View view) {
        this.view = view;
        dataModel = new DataModel();
    }

    @Override
    public void getData() {
        if(dataModel!=null){
            dataModel.getData(new DataContract.Icall() {
                @Override
                public void success(Max max) {
                    view.success(max);
                }

                @Override
                public void fail(String error) {
                    view.fail(error);

                }
            });
        }
    }
}
