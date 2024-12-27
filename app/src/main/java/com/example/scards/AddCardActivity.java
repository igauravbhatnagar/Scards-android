package com.example.scards;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class AddCardActivity extends AppCompatActivity {

    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private static final int REQUEST_QR_CODE_SCAN = 2;

    private Button captureImageButton;
    private Button scanQrCodeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);

        captureImageButton = findViewById(R.id.capture_image_button);
        scanQrCodeButton = findViewById(R.id.scan_qr_code_button);

        captureImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dispatchTakePictureIntent();
            }
        });

        scanQrCodeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dispatchScanQrCodeIntent();
            }
        });
    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    private void dispatchScanQrCodeIntent() {
        // Implement QR code scanning functionality
        // Placeholder for QR code scanning intent
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            saveCapturedImage(imageBitmap);
        } else if (requestCode == REQUEST_QR_CODE_SCAN && resultCode == RESULT_OK) {
            // Handle QR code scan result
            // Placeholder for handling QR code scan result
        }
    }

    private void saveCapturedImage(Bitmap imageBitmap) {
        // Implement functionality to save the captured image
        // Placeholder for saving captured image

        // Check for duplicate cards and provide a warning message
        if (isDuplicateCard(imageBitmap)) {
            Toast.makeText(this, "Duplicate card detected!", Toast.LENGTH_SHORT).show();
        } else {
            // Save the card
            // Placeholder for saving the card
        }
    }

    private boolean isDuplicateCard(Bitmap imageBitmap) {
        // Implement functionality to check for duplicate cards
        // Placeholder for checking duplicate cards
        return false;
    }
}
