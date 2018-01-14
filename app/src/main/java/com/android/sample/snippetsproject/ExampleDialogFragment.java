package com.android.sample.snippetsproject;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class ExampleDialogFragment extends DialogFragment {

    EditText mName;

    public ExampleDialogFragment() {
        // Required empty public constructor
    }

    /**
     * method to pass data into the
     * @param name person's name
     * @return ExampleDialogFragment Fragment to be created
     */
    public static ExampleDialogFragment newInstance(String name, String title){
        ExampleDialogFragment edFragment = new ExampleDialogFragment();

        if(name != null){

            //add arguments to the bundle that can be accessed by the fragment on creation.
            Bundle bundle = new Bundle();
            bundle.putString("name", name);
            bundle.putString("title", title);
            edFragment.setArguments(bundle);
        }
        return edFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_example_dialog, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mName = (EditText) view.findViewById(R.id.name_input);

        //sets the name to Carl on creation
        mName.setText(getArguments().getString("name"));

        //The second argument is the default value of the title if none is passed
        String mTitle = getArguments().getString("title", "Enter Name");
        getDialog().setTitle(mTitle);

        // Show soft keyboard automatically and request focus to field
        mName.requestFocus();
        getDialog().getWindow().setSoftInputMode(

                WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);


    }
}
