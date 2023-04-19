package com.example.practico6android.ui.gallery;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.practico6android.R;

public class GalleryFragment extends Fragment {

    private GalleryViewModel vm;
    private EditText etCel;
    private Button btLlamar;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        vm =
                new ViewModelProvider(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);

        etCel = root.findViewById(R.id.editTextPhone);
        btLlamar = root.findViewById(R.id.buttonCall);

        btLlamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numCel = etCel.getText().toString();
                if (numCel.isEmpty()) {
                    Toast.makeText(getActivity(), "Debe ingresar un número de teléfono", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + numCel));
                    if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CALL_PHONE}, 1);
                        return;
                    }
                    startActivity(intent);
                }
            }
        });
        return root;
    }
}