package max.jy.hzl.haozhilin.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import max.jy.hzl.haozhilin.R;
import max.jy.hzl.haozhilin.adapter.RLVadapter;
import max.jy.hzl.haozhilin.bean.Max;
import max.jy.hzl.haozhilin.contract.DataContract;
import max.jy.hzl.haozhilin.presenter.DataPresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment implements DataContract.View {


    private View view;
    private RecyclerView mRlv;
    private RLVadapter rlVadapter;

    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_blank, container, false);
        initView(inflate);
        initData();
        return inflate;
    }

    private void initData() {
        new DataPresenter(this).getData();
    }

    private void initView(View inflate) {
        mRlv = (RecyclerView) inflate.findViewById(R.id.rlv);
        mRlv.setLayoutManager(new LinearLayoutManager(getContext()));
        rlVadapter = new RLVadapter(getContext());

        mRlv.setAdapter(rlVadapter);



    }

    private static final String TAG = "BlankFragment";
    @Override
    public void success(Max max) {
        List<Max.ResultBean> result = max.getResult();
        rlVadapter.setList((ArrayList<Max.ResultBean>) result);
        Log.e(TAG, "success: "+result.toString());

    }

    @Override
    public void fail(String error) {
        Log.e(TAG, "fail: "+error);
    }
}
