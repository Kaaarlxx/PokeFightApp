package com.example.pokefightapp;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    boolean isPaused = false;

    @Override
    protected void onPause() {
        super.onPause();
        this.isPaused = true;
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        System.out.println("destroyed");
        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.isPaused = false;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageView = findViewById(R.id.picture);
        ActivityResultLauncher<Intent> someActivityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Bitmap bitmap =(Bitmap) result.getData().getExtras().get("data");
                        imageView.setImageBitmap(bitmap);
                    }
                });

        Button button = findViewById(R.id.photo);
        button.setOnClickListener(view -> someActivityResultLauncher.launch(new Intent(MediaStore.ACTION_IMAGE_CAPTURE)));
        button = findViewById(R.id.button2);
        button.setOnClickListener(view->changeActivity());
    }

    private void changeActivity() {
        Intent intent = new Intent(this,ListOfPokes.class);
        startActivity(intent);
    }

}