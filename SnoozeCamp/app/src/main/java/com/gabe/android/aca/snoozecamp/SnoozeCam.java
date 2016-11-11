package com.gabe.android.aca.snoozecamp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Gabe on 11/10/16.
 */

public class SnoozeCam extends MainActivity{

    private static final int CAMERA_REQUEST = 123;

    private StorageReference mStorageRef;

    private ProgressDialog mProgress;
    private ImageView mimageView;
    private Button mcaptureButton;

    private Uri mImageUri;
    private String mPicFileName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.snooze_cam);


        mStorageRef = FirebaseStorage.getInstance().getReference();
        mProgress = new ProgressDialog(this);

        mimageView = (ImageView)this.findViewById(R.id.imageView1);
        mcaptureButton = (Button) this.findViewById(R.id.sccapture);

        mcaptureButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                File photoFile = null;

                try {
                    photoFile = createImageFile();
                } catch (IOException e) {
                    Log.e("error", "error creating file");
                }
                if (photoFile != null) {
                    mImageUri = Uri.fromFile(photoFile);
                    cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(photoFile));
                    startActivityForResult(cameraIntent, CAMERA_REQUEST);
                }
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {

            mProgress.setMessage("Uploading Image");
            mProgress.show();

            final Uri photo = Uri.parse(mImageUri.toString());
            StorageReference scfilepath = mStorageRef.child("Pictures").child(photo.getLastPathSegment());

            scfilepath.putFile(photo).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                    mProgress.dismiss();

                    Uri downloadUri =  taskSnapshot.getDownloadUrl();
                    Picasso.with(SnoozeCam.this).load(photo).fit().centerCrop().into(mimageView);

                    Toast.makeText(SnoozeCam.this, "Upload Finished", Toast.LENGTH_LONG ).show();

                }
            });


        }
    }

    private File createImageFile() throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = this.getExternalFilesDir(Environment.DIRECTORY_PICTURES);

        File image = File.createTempFile(
                imageFileName,
                ".jpg",
                storageDir
        );

        mPicFileName = image.getAbsolutePath();
        Log.i("imagep", image.getAbsolutePath());
        return image;
    }


}


