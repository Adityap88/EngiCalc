package UnitConverter;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.Html;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


import com.aditya.engicalc.R;


public class areaFrag extends Fragment {

    boolean initialize = false;

    TextView mm2, cm2, m2,a,ha, km2,  ft2, yd2,acre;
    Spinner aSpinner;
    Context aCt;
    EditText area_edt;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_area, container, false);


    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        aCt = context;


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mm2 = view.findViewById(R.id.mm2);
        cm2 = view.findViewById(R.id.cm2);
        m2 = view.findViewById(R.id.m2);
        a= view.findViewById(R.id.are);
        ha= view.findViewById(R.id.hectare);
        km2 = view.findViewById(R.id.km2);
        ft2 = view.findViewById(R.id.ft2);
        yd2 = view.findViewById(R.id.yd2);
        acre = view.findViewById(R.id.acre);


        area_edt = view.findViewById(R.id.edt_area_input);
        aSpinner = view.findViewById(R.id.area_spinner);
        ArrayAdapter<CharSequence> aAdapter = ArrayAdapter.createFromResource(aCt, R.array.area_array, R.layout.spinner_layout);
        aAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        aSpinner.setAdapter(aAdapter);
        convertFromMm2(1.0);
        area_edt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                Double num;
                if (editable.toString().equals("")) {
                    num = 1.0;
                } else {
                    num = Double.parseDouble(editable.toString());
                }

                int pos = aSpinner.getSelectedItemPosition();
                switch (pos) {
                    case 0:
                        convertFromMm2(num);
                        break;
                    case 1:
                        convertFromCm2(num);
                        break;
                    case 2:
                        convertFromM2(num);
                        break;
                    case 3:
                        convertFromA(num);
                        break;
                    case 4:
                        convertFromHa(num);
                    case 5:
                        convertFromKm2(num);
                        break;
                    case 6:
                        convertFromFt2(num);
                        break;
                    case 7:
                        convertFromYd2(num);
                        break;
                    case 8:
                        convertFromAcre(num);
                        break;


                }
            }
        });

        aSpinner.setOnItemSelectedListener(aListener);

    }

    private AdapterView.OnItemSelectedListener aListener = new AdapterView.OnItemSelectedListener() {


        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            if (!initialize) {
                initialize = true;
            } else {
                String number = area_edt.getText().toString();
                Double num;
                if (number.equals("")) {
                    num = 1.0;
                } else {
                    num = Double.parseDouble(number);
                }

                int pos = aSpinner.getSelectedItemPosition();
                switch (pos) {
                    case 0:
                        convertFromMm2(num);
                        break;
                    case 1:
                        convertFromCm2(num);
                        break;
                    case 2:
                        convertFromM2(num);
                        break;
                    case 3:
                        convertFromA(num);
                        break;
                    case 4:
                        convertFromHa(num);
                    case 5:
                        convertFromKm2(num);
                        break;
                    case 6:
                        convertFromFt2(num);
                        break;
                    case 7:
                        convertFromYd2(num);
                        break;
                    case 8:
                        convertFromAcre(num);
                        break;


                }
            }

        }


        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };


    private void convertFromAcre(Double num) {
        mm2.setText(toSuperScript(num*4046856422.4));
        cm2.setText(toSuperScript(num*40468564.224));
        m2.setText(toSuperScript(num * 4046.8564224));
        a.setText(toSuperScript(num*40.468564224));
        ha.setText(toSuperScript(num*4.046856*Math.pow(10,-1)));
        km2.setText(toSuperScript(num*4.046856*Math.pow(10,-3)));
        ft2.setText(toSuperScript(num*43560));
        yd2.setText(toSuperScript(num*4840));
        acre.setText(toSuperScript(num ));


    }

    private void convertFromYd2(Double num) {

        mm2.setText(toSuperScript(num*836127.36));
        cm2.setText(toSuperScript(num*8361.2736));
        m2.setText(toSuperScript(num * 0.83612736));
        a.setText(toSuperScript(num*0.0083612736));
        ha.setText(toSuperScript(num*8.3612736*Math.pow(10,-5)));
        km2.setText(toSuperScript(num*8.3612736*Math.pow(10,-7)));
        ft2.setText(toSuperScript(num*9));
        yd2.setText(toSuperScript(num));
        acre.setText(toSuperScript(num *2.0661157*Math.pow(10,-4)));
    }

    private void convertFromFt2(Double num) {

        mm2.setText(toSuperScript(num*92903.04));
        cm2.setText(toSuperScript(num*929.0304));
        m2.setText(toSuperScript(num * 0.09290304));
        a.setText(toSuperScript(num*0.0009290304));
        ha.setText(toSuperScript(num*9.290304*Math.pow(10,-6)));
        km2.setText(toSuperScript(num*9.290304*Math.pow(10,-8)));
        ft2.setText(toSuperScript(num));
        yd2.setText(toSuperScript(num *0.1111111111));
        acre.setText(toSuperScript(num *2.295684113866*Math.pow(10,-5)));
    }

    private void convertFromKm2(Double num) {

        mm2.setText(toSuperScript(num*Math.pow(10,12)));
        cm2.setText(toSuperScript(num*Math.pow(10,10)));
        m2.setText(toSuperScript(num * Math.pow(10,6)));
        a.setText(toSuperScript(num*10000));
        ha.setText(toSuperScript(num*Math.pow(10,2)));
        km2.setText(toSuperScript(num));
        ft2.setText(toSuperScript(num *1.07639*Math.pow(10,7)));
        yd2.setText(toSuperScript(num *1.1960*Math.pow(10,6)));
        acre.setText(toSuperScript(num *247.1));
    }

    private void convertFromHa(Double num) {
        mm2.setText(toSuperScript(num*Math.pow(10,10)));
        cm2.setText(toSuperScript(num*Math.pow(10,8)));
        m2.setText(toSuperScript(num * 1000.0));
        a.setText(toSuperScript(num*100));
        ha.setText(toSuperScript(num));
        km2.setText(toSuperScript(num / Math.pow(10,2)));
        ft2.setText(toSuperScript(num *107639));
        yd2.setText(toSuperScript(num *11960));
        acre.setText(toSuperScript(num *2.471));
    }

    private void convertFromA(Double num) {
        mm2.setText(toSuperScript(num*Math.pow(10,8)));
        cm2.setText(toSuperScript(num*Math.pow(10,6) ));
        m2.setText(toSuperScript(num * 100.0));
        a.setText(toSuperScript(num));
        ha.setText(toSuperScript(num/Math.pow(10,2)));
        km2.setText(toSuperScript(num / Math.pow(10,4)));
        ft2.setText(toSuperScript(num *1076));
        yd2.setText(toSuperScript(num *120));
        acre.setText(toSuperScript(num /40.496));
    }

    private void convertFromM2(Double num) {
        mm2.setText(toSuperScript(num*1000000));
        cm2.setText(toSuperScript(num*10000 ));
        m2.setText(toSuperScript(num / 10000.0));
        a.setText(toSuperScript(num/100));
        ha.setText(toSuperScript(num/Math.pow(10,4)));
        km2.setText(toSuperScript(num / Math.pow(10,6)));
        ft2.setText(toSuperScript(num *10.764));
        yd2.setText(toSuperScript(num *1.196));
        acre.setText(toSuperScript(num /4047));
    }

    private void convertFromCm2(Double num) {

        mm2.setText(toSuperScript(num*100));
        cm2.setText(toSuperScript(num ));
        m2.setText(toSuperScript(num / 10000.0));
        a.setText(toSuperScript(num/Math.pow(10,6)));
        ha.setText(toSuperScript(num/Math.pow(10,8)));
        km2.setText(toSuperScript(num / Math.pow(10,10)));
        ft2.setText(toSuperScript(num / 929));
        yd2.setText(toSuperScript(num /8361));
        acre.setText(toSuperScript(num /(4.047 *Math.pow(10,7))));
    }

    private void convertFromMm2(Double num) {
        mm2.setText(toSuperScript(num));
        cm2.setText(toSuperScript(num / 100));
        m2.setText(toSuperScript(num / 1000000.0));
        a.setText(toSuperScript(num/Math.pow(10,8)));
        ha.setText(toSuperScript(num/Math.pow(10,10)));
        km2.setText(toSuperScript(num / Math.pow(10,12)));
        ft2.setText(toSuperScript(num / 92903));
        yd2.setText(toSuperScript(num /836127));
        acre.setText(toSuperScript(num /(4.047 *Math.pow(10,9))));


    }

    public Spanned toSuperScript (Double value){
        String val = Double.toString(value);
        if(val.contains("E")){
            int index=val.indexOf("E");
            String builder=val.substring(0,index);
            String ans;
            if(builder.length()>11){
                ans= builder.substring(0,11);
            }
            else {
                ans=builder;
            }

            String power = val.substring(index+1);
            return Html.fromHtml(ans+"E<sup><small>"+power+"</small></sup>");
        }
        else if(val.length()>11) {
            return Html.fromHtml(val.substring(0,11));
        }
        else {
            return Html.fromHtml(val);
        }

    }
}