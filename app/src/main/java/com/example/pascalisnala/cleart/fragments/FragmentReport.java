package com.example.pascalisnala.cleart.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pascalisnala.cleart.Activities.HomeActivity;
import com.example.pascalisnala.cleart.Activities.ReportActivity;
import com.example.pascalisnala.cleart.R;

public class FragmentReport extends Fragment {
    View view;

    public FragmentReport() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.report_fragment, container, false);
        return view;
    }

    private CardView addReport;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        addReport = view.findViewById(R.id.addReport);
        addReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), ReportActivity.class);
                startActivity(i);
            }
        });
    }

}