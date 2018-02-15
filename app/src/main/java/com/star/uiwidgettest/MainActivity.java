package com.star.uiwidgettest;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mButton;
    private EditText mEditText;
    private ImageView mImageView;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = findViewById(R.id.button);
        mButton.setOnClickListener(v -> {
            String inputText = mEditText.getText().toString();
            Toast.makeText(MainActivity.this, inputText, Toast.LENGTH_LONG).show();

            mImageView.setImageResource(R.drawable.emma2);

            if (mProgressBar.getVisibility() == View.GONE) {
                mProgressBar.setVisibility(View.VISIBLE);
            } else {
                mProgressBar.setVisibility(View.GONE);
            }

            int progress = mProgressBar.getProgress();
            if (progress < mProgressBar.getMax()) {
                progress += 10;
                mProgressBar.setProgress(progress);
            }

            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder
                    .setTitle("AlertDialog")
                    .setMessage("Something important")
                    .setCancelable(false)
                    .setPositiveButton("OK", (dialog, which) -> {

                    })
                    .setNegativeButton("Cancel", (dialog, which) -> {

                    })
                    .show();

            ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setTitle("ProgressDialog");
            progressDialog.setMessage("Loading...");
            progressDialog.setCancelable(true);
            progressDialog.show();
        });

        mEditText = findViewById(R.id.edit_text);

        mImageView = findViewById(R.id.image_view);

        mProgressBar = findViewById(R.id.progress_bar);
    }
}
