package soo.app.im;

import android.Manifest;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import android.view.View;

import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;

class ThirdHandler implements View.OnClickListener{
    MainActivity a;
    ThirdHandler(MainActivity a){
        this.a = a;
    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onClick(View view){
        int id = view.getId();
        switch (id){
            case R.id.b1: m1(); break;
            case R.id.b2: m2(); break;
            case R.id.b3: m3(); break;
            case R.id.b4: m4(); break;
            case R.id.b5: m5(); break;
            case R.id.b6: m6(); break;
            case R.id.b7: m7(); break;
            case R.id.b8: m8(); break;
            case R.id.b9: m9(); break;
            case R.id.b10: m10(); break;
            case R.id.b11: m11(); break;
            case R.id.b12: m12(); break;
            case R.id.b13: m13(); break;
            case R.id.b14: m14(); break;
            case R.id.b15: m15(); break;
            case R.id.b16: m16(); break;
        }
    }
    void m1(){
        //Log.i("ThirdHandler", "b1 clicked");
        Intent intent = new Intent(Intent.ACTION_INSERT, Uri.parse("content://contacts/people"));

        a.startActivity(intent);
    }
    void m2(){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:01012341234"));

        a.startActivity(intent);
    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    private void m3(){
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:01024757431"));

        if (ActivityCompat.checkSelfPermission(a, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            a.requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, 1000);

            return;
        }
        a.startActivity(intent);
    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    private void m4(){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.putExtra("sms_body", "????????? ???????????? ????????????~!");
        intent.setType("vnd.android-dir/mms-sms");

        if (ActivityCompat.checkSelfPermission(a, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
            a.requestPermissions(new String[]{Manifest.permission.SEND_SMS}, 1000);

            return;
        }

        a.startActivity(intent);
    }
    private void m5(){ //???????????????
        String phoneNum = "01024757431";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.putExtra("address", phoneNum);
        intent.putExtra("sms_body", "????????? ???????????? ????????????~!");
        intent.setData(Uri.parse("smsto:" + phoneNum));
        a.startActivity(intent);
    }
    private void m6(){ //??????????????? ???????????????
        String phoneNum = "01024757431;01090328593";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.putExtra("sms_body", "?????????????????? ???????????? ????????????~!");
        intent.setData(Uri.parse("smsto:" + phoneNum));
        a.startActivity(intent);
    }
    void m7(){
        Intent intent = new Intent(
                Intent.ACTION_SENDTO,
                Uri.parse("mailto:khs1128@gmail.com"));
        a.startActivity(intent);
    }
    private void m8(){ //????????? ????????? ??????
        Intent intent = new Intent(
                Intent.ACTION_SENDTO, Uri.parse("mailto:khs1128@gmail.com"));
        intent.putExtra("subject", "????????????");
        intent.putExtra("body", "????????????~");
        a.startActivity(intent);
    }
    private void m9(){ //?????? ???????????? ??????
        String list[] = {"khs1128@gmail.com, khs1128@emdec.or.kr"};

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_EMAIL  , list);
        intent.putExtra(Intent.EXTRA_SUBJECT, "?????? ??????");
        intent.putExtra(Intent.EXTRA_TEXT   , "?????? ??????");
        a.startActivity(Intent.createChooser(intent, "Send mail..."));
    }
    private void m10(){ //????????? ??????
        Intent it = new Intent(Intent.ACTION_SEND);
        String[] tos = {"me@abc.com"};
        String[] ccs = {"you@abc.com"};  //?????????
        it.putExtra(Intent.EXTRA_EMAIL, tos);
        it.putExtra(Intent.EXTRA_CC, ccs);
        it.putExtra(Intent.EXTRA_TEXT, "?????? ??????");
        it.putExtra(Intent.EXTRA_SUBJECT, "?????? ??????");
        it.setType("message/rfc822");
        a.startActivity(Intent.createChooser(it, "Choose Email Client"));
    }
    private void m11(){ //??????
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT,
                "(??????)???????????? ??????.. market://details?id=com.kakao.talk");
        sendIntent.setType("text/plain");
        a.startActivity(sendIntent);
    }
    private void m12(){
        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://m.daum.net/"));
        a.startActivity(intent);
    }
    private void m13(){
        Uri uri = Uri.parse ("geo: 37.5100740, 126.761512");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        a.startActivity(intent);
    }
    private void m14(){//????????????????????? ?????? ????????? ??????
        Uri uri = Uri.parse("market://details?id=com.kakao.talk");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        a.startActivity(intent);
    }
    private void m15(){//??????????????? ??????
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.setComponent(new ComponentName(
                "com.android.settings",
                "com.android.settings.Settings"));
        a.startActivity(intent);
    }
    private void m16(){//audio ???????????? ??????
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("audio/*");
        //intent.setType("video/*");
        a.startActivity(intent);
    }
}
