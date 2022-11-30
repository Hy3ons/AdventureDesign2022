package cnu.kicksafe;

import android.Manifest;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.Preview;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.PreviewView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.common.util.concurrent.ListenableFuture;

import java.net.ServerSocket;

public class CameraActivity extends AppCompatActivity implements View.OnClickListener {
    private PreviewView previewView;
    private ServerSocket serverSocket;
    private ImageView imageView;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onClick(View view) {
        Bitmap bitmap = previewView.getBitmap();
        Toast.makeText(this, "사진 버튼 누름", Toast.LENGTH_SHORT).show();

        Bitmap resized = Bitmap.createScaledBitmap(bitmap, 200, 350, true);
        imageView.setPadding(5, 5, 5, 5);
        imageView.setImageBitmap(resized);



    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.CAMERA}, 10);

        imageView = findViewById(R.id.imageView);
        imageView.setPadding(0, 0, 0, 0);
        imageView.setImageDrawable(null);

        ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.CAMERA}, 10);

        previewView = findViewById(R.id.previewView);

        ListenableFuture<ProcessCameraProvider> provider = ProcessCameraProvider.getInstance(this);

        provider.addListener(() -> {
            try {
                ProcessCameraProvider pro = provider.get();
                Preview preview = new Preview.Builder().build();
                preview.setSurfaceProvider(previewView.getSurfaceProvider());
                pro.unbindAll();
                pro.bindToLifecycle(this, CameraSelector.DEFAULT_FRONT_CAMERA, preview);
            } catch (Exception e) {}
        }, ContextCompat.getMainExecutor(this));

        ImageButton imageButton = findViewById(R.id.imageButton);
        imageButton.setOnClickListener(this);
    }

    private void failed () {
        Toast.makeText(this, "헬멧 인식에 실패하였습니다.", Toast.LENGTH_SHORT).show();
    }



}