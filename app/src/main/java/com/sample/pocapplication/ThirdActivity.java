package com.sample.pocapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.github.barteksc.pdfviewer.PDFView;

import java.io.File;
import static android.content.Intent.FLAG_GRANT_READ_URI_PERMISSION;
import static android.content.Intent.FLAG_GRANT_WRITE_URI_PERMISSION;
import static android.provider.ContactsContract.Directory.PACKAGE_NAME;


public class ThirdActivity extends AppCompatActivity {
    private TextView txtView1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);


        PDFView pdfView=(PDFView)findViewById(R.id.pdfView);
        pdfView.fromAsset("android_POC_ANDROID_ToolsPipeline-converted.pdf").pages(0).load();


    }
}
