package UnitConverter;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.aditya.engicalc.R;


public class temperatureFrag extends Fragment {

    Spinner tSpinner;
    Context tCt;
    boolean initialize;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_temprature, container, false);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        tCt = context;


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tSpinner= view.findViewById(R.id.temp_spinner);
        ArrayAdapter<CharSequence> mAdapter = ArrayAdapter.createFromResource(tCt, R.array.temp_array, R.layout.spinner_layout);
        mAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tSpinner.setAdapter(mAdapter);
        //mSpinner.setOnItemSelectedListener(mListener);
    }


    private AdapterView.OnItemSelectedListener mListener = new AdapterView.OnItemSelectedListener() {


        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            if(!initialize){
                initialize= true;
            }
            else {
                ((TextView) adapterView.getChildAt(0)).setTextColor(getResources().getColor(R.color.colorPrimary));
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };
}