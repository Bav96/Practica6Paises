package com.bav.paises3;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bav.paises3.databinding.FragmentDetallePaisBinding;
import com.bav.paises3.placeholder.PlaceholderContent;


public class DetallePaisFragment extends android.app.Fragment {
    private FragmentDetallePaisBinding binding;
    private PlaceholderContent.Pais mPais;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mPais = getArguments().getParcelable("pais");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetallePaisBinding.inflate(inflater,container,false);
        ImageView iv = binding.foto;
        iv.setImageResource(getImageId(mPais.foto));
        TextView tv= binding.descripciN;
        tv.setText(mPais.detalles);

        return binding.getRoot();
    }
    private  int getImageId (String imagePath){
        String imageName = imagePath.substring(imagePath.lastIndexOf("/")+1,imagePath.lastIndexOf("."));
        return  getResources().getIdentifier(imageName,("drawable"),getContext().getPackageName());
    }
}