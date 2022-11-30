package cnu.kicksafe;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class ParentActivity extends AppCompatActivity {
    private ImageView setting, home, profile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent);

        setting = findViewById(R.id.settingButton);
        home = findViewById(R.id.homeButton);
        profile = findViewById(R.id.personButton);

        
    }
}