package com.suningstudio.comunicationactivityandfragment;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment extends Fragment implements OnTapFavouriteListener {
    int status = 0;
    BlankFragment.OnTapFavouriteListener onTapFavouriteListener;

    public BlankFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static BlankFragment newInstance() {
        BlankFragment fragment = new BlankFragment();
        return fragment;
    }

    public void setOnTapFavouriteListener(OnTapFavouriteListener onTapFavouriteListener) {
        this.onTapFavouriteListener = onTapFavouriteListener;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    // Phương thức (callback) này được gọi khi chúng ta click button favourite ở Activity
    @Override
    public void action() {
        if (getActivity() != null){
            if (status == 0) {
                status += 1;
                imageButtonFavourite.setBackground(getActivity().getDrawable(R.drawable.ic_favourite_active));
            } else {
                status -= 1;
                imageButtonFavourite.setBackground(getActivity().getDrawable(R.drawable.ic_favourite_not_active));
            }
        }

    }

    ImageButton imageButtonFavourite;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        imageButtonFavourite = view.findViewById(R.id.imageButtonFavourite);
        imageButtonFavourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onTapFavouriteListener != null) {
                    if (status == 0) {
                        status += 1;
                        imageButtonFavourite.setBackground(getActivity().getDrawable(R.drawable.ic_favourite_active));
                    } else {
                        status -= 1;
                        imageButtonFavourite.setBackground(getActivity().getDrawable(R.drawable.ic_favourite_not_active));
                    }
                    onTapFavouriteListener.action();
                }
            }
        });
        super.onViewCreated(view, savedInstanceState);
    }

    public interface OnTapFavouriteListener {
        void action();
    }
}