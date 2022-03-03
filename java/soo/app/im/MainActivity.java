package soo.app.im;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button bs[] = new Button[16];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View.OnClickListener listner = new ThirdHandler(this);
        for(int i=0; i<bs.length;i++){
            bs[i] = (Button) findViewById(R.id.b1+i);
            bs[i].setOnClickListener(listner);
        }
    }
}
