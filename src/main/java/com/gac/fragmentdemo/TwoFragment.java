package com.gac.fragmentdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/1/2.
 */
public class TwoFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        String text = getArguments().getString("text");
        if(text != null){
            Toast.makeText(getContext(), text, Toast.LENGTH_SHORT).show();
        }
        return inflater.inflate(R.layout.two_fragment, container, false);
    }
}
