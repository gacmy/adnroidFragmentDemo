package com.gac.fragmentdemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/1/2.
 */
public class TextFragment extends Fragment {
    private TextView tv ;
    private OnTextClickListener listener;
    public interface OnTextClickListener{
        public void textClick(String str);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_text,container,false);
        tv =(TextView) view.findViewById(R.id.id_tv_click);
        tv.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                listener.textClick(tv.getText().toString());
            }
        });
        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            listener = (OnTextClickListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnTextClickListener");
        }
    }
}
