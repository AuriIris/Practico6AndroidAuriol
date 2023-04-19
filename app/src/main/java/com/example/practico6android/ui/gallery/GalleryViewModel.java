package com.example.practico6android.ui.gallery;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GalleryViewModel extends ViewModel {
    private Context context;
    private MutableLiveData<String> mensajeErrorLiveData = new MutableLiveData<>();

    public GalleryViewModel(Context context) {
        this.context = context;
    }
    public GalleryViewModel() {
        // Constructor vacío
    }

    public MutableLiveData<String> getMensajeErrorLiveData() {
        return mensajeErrorLiveData;
    }


    public void llamar(String numero) {
        if (TextUtils.isEmpty(numero)) {
            mensajeErrorLiveData.setValue("Número vacío");
        } else {
                Uri uri = Uri.parse("tel:" + numero);
                Intent intent = new Intent(Intent.ACTION_CALL, uri);

                if (ContextCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE)
                        != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions((Activity) context,
                            new String[]{Manifest.permission.CALL_PHONE}, 1);
                } else {
                    context.startActivity(intent);
                }
        }
    }

}
