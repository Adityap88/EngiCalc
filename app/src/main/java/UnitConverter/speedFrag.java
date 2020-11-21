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



public class speedFrag extends Fragment {

    TextView m_s,m_min,km_min,km_hr,ft_s,mph,Mach,kn;
    EditText speed_edt;
    Context sCt;
    Spinner sSpinner;
    boolean initialize;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_speed, container, false);
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        sCt = context;


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        m_s= view.findViewById(R.id.m_s);
        m_min= view.findViewById(R.id.m_min);
        km_min= view.findViewById(R.id.km_min);
        km_hr= view.findViewById(R.id.km_hour);
        ft_s= view.findViewById(R.id.ft_sec);
        mph= view.findViewById(R.id.mi_hour);
        Mach= view.findViewById(R.id.mach);
        kn= view.findViewById(R.id.kn);
        speed_edt= view.findViewById(R.id.edt_speed_input);


        sSpinner= view.findViewById(R.id.speed_spinner);
        ArrayAdapter<CharSequence> sAdapter = ArrayAdapter.createFromResource(sCt, R.array.speed_array, R.layout.spinner_layout);
        sAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sSpinner.setAdapter(sAdapter);
        sSpinner.setOnItemSelectedListener(sListener);
        speed_edt.addTextChangedListener(new TextWatcher() {
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

                int pos = sSpinner.getSelectedItemPosition();
                switch (pos) {
                    case 0:
                        convertFromM_sec(num);
                        break;
                    case 1:
                        convertFromM_min(num);
                        break;
                    case 2:
                        convertFromKm_min(num);
                        break;
                    case 3:
                        convertFromKm_hour(num);
                        break;
                    case 4:
                        convertFromFt_sec(num);
                    case 5:
                        convertFromMph(num);
                        break;
                    case 6:
                        convertFromMach(num);
                        break;
                    case 7:
                        convertFromKnot(num);
                        break;

                }

            }
        });
    }

    private void convertFromKnot(Double num) {
        m_s.setText(toSuperScript(num*0.51444444444444));
        m_min.setText(toSuperScript(num*30.8666666666667));
        km_min.setText(toSuperScript(num*0.03086666666667));
        km_hr.setText(toSuperScript(num*1.852));
        ft_s.setText(toSuperScript(num*1.6878098571012));
        mph.setText(toSuperScript(num*1.15077944802354));
        Mach.setText(toSuperScript(num *0.00155140061654));
        kn.setText(toSuperScript(num ));
    }

    private void convertFromMach(Double num) {
        m_s.setText(toSuperScript(num*331.6));
        m_min.setText(toSuperScript(num*19896));
        km_min.setText(toSuperScript(num*19.896));
        km_hr.setText(toSuperScript(num*1193.76));
        ft_s.setText(toSuperScript(num*1087.92650918635));
        mph.setText(toSuperScript(num*741.76807444524));
        Mach.setText(toSuperScript(num ));
        kn.setText(toSuperScript(num *741.76807444524));
    }

    private void convertFromMph(Double num) {
        m_s.setText(toSuperScript(num*0.44704));
        m_min.setText(toSuperScript(num*26.8224));
        km_min.setText(toSuperScript(num*0.0268224));
        km_hr.setText(toSuperScript(num*1.609344));
        ft_s.setText(toSuperScript(num*1.46666666666667));
        mph.setText(toSuperScript(num));
        Mach.setText(toSuperScript(num *0.00134813027744));
        kn.setText(toSuperScript(num *0.86897624190065));
    }

    private void convertFromFt_sec(Double num) {
        m_s.setText(toSuperScript(num*0.3048));
        m_min.setText(toSuperScript(num*18.288));
        km_min.setText(toSuperScript(num*0.018288));
        km_hr.setText(toSuperScript(num*1.09728));
        ft_s.setText(toSuperScript(num));
        mph.setText(toSuperScript(num*0.68181818181818));
        Mach.setText(toSuperScript(num *0.00091917973462));
        kn.setText(toSuperScript(num *0.5924838012959));
    }

    private void convertFromKm_hour(Double num) {
        m_s.setText(toSuperScript(num*0.27777777777778));
        m_min.setText(toSuperScript(num*16.6666666666667));
        km_min.setText(toSuperScript(num*0.01666666666667));
        km_hr.setText(toSuperScript(num));
        ft_s.setText(toSuperScript(num*0.91134441528142));
        mph.setText(toSuperScript(num*0.62137119223733));
        Mach.setText(toSuperScript(num *0.00083768931779));
        kn.setText(toSuperScript(num *0.53995680345572));
    }

    private void convertFromKm_min(Double num) {
        m_s.setText(toSuperScript(num*16.6666666666667));
        m_min.setText(toSuperScript(num*1000));
        km_min.setText(toSuperScript(num));
        km_hr.setText(toSuperScript(num*60));
        ft_s.setText(toSuperScript(num*54.6806649168854));
        mph.setText(toSuperScript(num*37.28227153424));
        Mach.setText(toSuperScript(num *0.05026135906715));
        kn.setText(toSuperScript(num *32.39740820734341));
    }

    private void convertFromM_min(Double num) {
        m_s.setText(toSuperScript(num*0.01666666666667));
        m_min.setText(toSuperScript(num));
        km_min.setText(toSuperScript(num*0.001));
        km_hr.setText(toSuperScript(num*0.06));
        ft_s.setText(toSuperScript(num*0.05468066491689));
        mph.setText(toSuperScript(num*0.03728227153424));
        Mach.setText(toSuperScript(num *5.026135906715E-5));
        kn.setText(toSuperScript(num *0.03239740820734));
    }

    private void convertFromM_sec(Double num) {


        m_s.setText(toSuperScript(num));
        m_min.setText(toSuperScript(num*60));
        km_min.setText(toSuperScript(num*0.06));
        km_hr.setText(toSuperScript(num*3.6));
        ft_s.setText(toSuperScript(num*3.28083989501312));
        mph.setText(toSuperScript(num*2.2369362920544));
        Mach.setText(toSuperScript(num *0.00301568154403));
        kn.setText(toSuperScript(num *1.9438444924406));
    }


    private AdapterView.OnItemSelectedListener sListener = new AdapterView.OnItemSelectedListener() {


        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            if(!initialize){
                initialize= true;
            }
            else {
                String number = speed_edt.getText().toString();
                Double num;
                if (number.equals("")) {
                    num = 1.0;
                } else {
                    num = Double.parseDouble(number);
                }

                int pos = sSpinner.getSelectedItemPosition();
                switch (pos) {
                    case 0:
                        convertFromM_sec(num);
                        break;
                    case 1:
                        convertFromM_min(num);
                        break;
                    case 2:
                        convertFromKm_min(num);
                        break;
                    case 3:
                        convertFromKm_hour(num);
                        break;
                    case 4:
                        convertFromFt_sec(num);
                    case 5:
                        convertFromMph(num);
                        break;
                    case 6:
                        convertFromMach(num);
                        break;
                    case 7:
                        convertFromKnot(num);
                        break;
                }

            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };

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