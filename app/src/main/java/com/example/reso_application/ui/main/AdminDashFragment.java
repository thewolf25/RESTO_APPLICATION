package com.example.reso_application.ui.main;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.reso_application.R;

public class AdminDashFragment extends Fragment {

    private MainViewModel mViewModel;

    private String action="ADD";


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        System.out.println("OnCreateView "+this.action);

        if(action.equals("ADD"))
        return inflater.inflate(R.layout.frag_add, container, false);
        else if (action.equals("UPDATE"))
            return inflater.inflate(R.layout.fragment_frag_update,container,false);
        else
            return inflater.inflate(R.layout.fragment_delete, container, false);

    }



    @Override
    public void setArguments(@Nullable Bundle args) {
        super.setArguments(args);

        this.action = args.getString("action");
        System.out.println("set argument "+this.action);
    }
}