package cnu.kicksafe;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class ParentActivity extends AppCompatActivity {
    private ImageView setting, home, profile;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent);

        setting = findViewById(R.id.settingButton);
        home = findViewById(R.id.cameraButton);
        profile = findViewById(R.id.personButton);

        recyclerView = findViewById(R.id.recyclerView);
    }
}