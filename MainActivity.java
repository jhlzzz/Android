package soo.app.albuma;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView iv;
    final static int IMGS[] = {
            R.mipmap.ys01, R.mipmap.ys02, R.mipmap.ys03,
            R.mipmap.ys04, R.mipmap.ys05, R.mipmap.ys06,
            R.mipmap.ys07, R.mipmap.ys08, R.mipmap.ys09,
            R.mipmap.ys10
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv = (ImageView)findViewById(R.id.iv);
        /*iv.setOnClickListener(new View.OnClickListener() {
            int i = 0;
            @Override
            public void onClick(View view) {
                iv.setBackgroundResource(IMGS[i++]);
                if(i>=IMGS.length) i = 0;
            }
        });*/
        iv.setOnTouchListener(new TouchHandler(this));
    }
    void showMsg(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}