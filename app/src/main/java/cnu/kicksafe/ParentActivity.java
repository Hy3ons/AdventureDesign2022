package cnu.kicksafe;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Random;

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

        //if getProfiles
//        profileAdapter = new ProfileAdapter(getProfiles());

        recyclerView.setAdapter(profileAdapter);

        Button summon = findViewById(R.id.summon);
        summon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random ran = new Random();
                Profile profile = new Profile(1, "랜덤", ran.nextInt(20), ran.nextInt(99), ran.nextInt(200), 0);
                profileAdapter.addProfile(profile);
            }
        });
    }

    private List<Profile> getProfiles () {
        //서버에서 프로필리스트들을 다 가져오는 함수

        return null;
    }
}