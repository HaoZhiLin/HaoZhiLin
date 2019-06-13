package max.jy.hzl.haozhilin;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    /**
     * 欢迎你来到积云教育！
     */
    private TextView mTv;
    private Timer timer;
    private  int a=3;
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            if(a>0){
                a--;
            }else {
                startActivity(new Intent(MainActivity.this,Main2Activity.class));
                timer.cancel();
                finish();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }


    private void initView() {
        mTv = (TextView) findViewById(R.id.tv);

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                handler.sendEmptyMessage(1);

            }
        },500,1000);
    }
}
