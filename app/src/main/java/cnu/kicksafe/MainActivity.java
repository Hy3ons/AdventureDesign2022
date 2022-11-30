package cnu.kicksafe;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;

import java.net.Socket;

public class MainActivity extends AppCompatActivity {

    private DBHelper loginDB;
    private Socket socket;
    private String name, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginDB = new DBHelper(this, 0);
        tryLogin();
    }

    private void tryLogin() {
        Cursor cursor = loginDB.getLastLogin();

        if (cursor.moveToNext()) {
            if (cursor.getInt(3) == 2) {
                //지녀의 화면으로 이동한다 자녀의 모드이기 때문이다.

            } else {
                //서버를 사용하여 로그인 시도, 로그인이 되지 않으면, 로그인 시도 창을 뛰운다.


                setLoginActivity();
            }
        } else {
            setLoginActivity();
        }
    }

    private void setLoginActivity() {
        //로그인 화면을 띄운다.
        //인텐트를 이용하여, 로그인 성공시, 아이디와 패스워드도 가지고 온다.

    }
}