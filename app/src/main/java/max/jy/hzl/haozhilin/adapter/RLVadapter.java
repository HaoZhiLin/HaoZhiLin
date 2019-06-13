package max.jy.hzl.haozhilin.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import max.jy.hzl.haozhilin.R;
import max.jy.hzl.haozhilin.bean.Max;

public class RLVadapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private final ArrayList<Max.ResultBean> resultBeans = new ArrayList<>();

    public RLVadapter(Context context) {
        this.context = context;
    }

    private ArrayList<Max.ResultBean> list= new ArrayList<>();

    public void setList(ArrayList<Max.ResultBean> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType==0){
            return new viewHolder(View.inflate(context,R.layout.item,null));

        }else if(viewType==1){
            return new viewHolder2(View.inflate(context,R.layout.item2,null));
        }else if(viewType==2){
            return new viewHolder3(View.inflate(context,R.layout.item3,null));
        }else {
            return new viewHolder3(View.inflate(context,R.layout.item3,null));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int viewType = getItemViewType(position);



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {

        if(position==0){
            return 0;
        }else if(position%3==1){
            return 1;
        }else if(position%3==2){
            return 2;
        }else {
            return 3;
        }
    }




    class viewHolder extends  RecyclerView.ViewHolder{
        private Banner ba;
         public viewHolder(View itemView) {
             super(itemView);
             ba=itemView.findViewById(R.id.ban);
         }
     }


    class viewHolder2 extends  RecyclerView.ViewHolder{
        private TextView tvTitle_item2;
        private ImageView iv_item2;
        private TextView  tvContent_item2;
        public viewHolder2(View itemView) {
            super(itemView);
            tvTitle_item2=itemView.findViewById(R.id.tvTitle_item2);
            iv_item2=itemView.findViewById(R.id.iv_item2);
            tvContent_item2=itemView.findViewById(R.id.tvContent_item2);

        }
    }

    class viewHolder3 extends  RecyclerView.ViewHolder{
        private TextView tvTitle_item3;
        private ImageView iv_item3,iv2_item3;
        private TextView  tvContent_item3;
        public viewHolder3(View itemView) {
            super(itemView);
            tvTitle_item3=itemView.findViewById(R.id.tvTitle_item3);
            tvContent_item3=itemView.findViewById(R.id.tvContent_item3);
            iv_item3=itemView.findViewById(R.id.iv1_item3);
            iv2_item3=itemView.findViewById(R.id.iv2_item3);

        }
    }

    class viewHolder4 extends  RecyclerView.ViewHolder{
        private TextView tvTitle_item4,tvContent_item4;
        private ImageView iv_item4,iv2_item4,iv3_item4;
        private TextView  tvContent_item3;
        public viewHolder4(View itemView) {
            super(itemView);

            tvTitle_item4=itemView.findViewById(R.id.tvTitle_item4);
            tvContent_item4=itemView.findViewById(R.id.tvContent_item4);
            iv_item4=itemView.findViewById(R.id.iv1_item4);
            iv2_item4=itemView.findViewById(R.id.iv2_item4);
            iv3_item4=itemView.findViewById(R.id.iv3_item4);
        }
    }
}
