package com.example.pascalisnala.cleart.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pascalisnala.cleart.R;

public class FragmentInformation extends Fragment {
    View view;

    public FragmentInformation(){
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        view = inflater.inflate(R.layout.information_fragment,container,false);

        CardView test = view.findViewById(R.id.cardReport);

        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment;
                fragment = new FragmentReport();
                displayFragment(fragment);
            }
        });

        return view;
    }

    private void displayFragment(Fragment fragment){
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.layoutInformation,fragment)
                .commit();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
