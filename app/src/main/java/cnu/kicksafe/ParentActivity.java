package cnu.kicksafe;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class ParentActivity extends AppCompatActivity {
    private ImageView setting, home, profile;
    private RecyclerView recyclerView;
    private ProfileAdapter profileAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent);

        setting = findViewById(R.id.settingButton);
        home = findViewById(R.id.cameraButton);
        profile = findViewById(R.id.personButton);

        recyclerView = findViewById(R.id.recyclerView);
        profileAdapter = new ProfileAdapter();

        recyclerView.setAdapter(profileAdapter);
    }

    public void getProfiles () {
        //서버에서 프로필리스트들을 다 가져오는 함수
    }
}