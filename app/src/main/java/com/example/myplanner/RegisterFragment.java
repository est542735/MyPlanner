package com.example.myplanner;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.FragmentTransaction;


public class RegisterFragment extends Fragment {

    public RegisterFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        // Set up the return button to navigate back to LoginFragment
        Button btnReturnToLogin = view.findViewById(R.id.ReturnButton);
        btnReturnToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadLoginFragment();
            }
        });

        return view;
    }

    // Method to load the LoginFragment
    private void loadLoginFragment() {
        LoginFragment loginFragment = new LoginFragment();
        FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, loginFragment); // Make sure this ID matches your activity's fragment container
        transaction.addToBackStack(null); // Optional: Add to back stack to allow navigation back
        transaction.commit();
    }
}
