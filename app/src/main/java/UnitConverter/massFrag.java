package UnitConverter;

import android.content.Context;
import android.graphics.Color;
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


public class massFrag extends Fragment {

    boolean initialize= false;
    Context mCt;
    Spinner mSpinner;

    TextView mg,g,kg,t,gr,oz,lb,ton_us,ton_uk,ct,u;
    EditText mass_edt;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mass, container, false);
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mCt = context;


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mg = view.findViewById(R.id.mg);
        g = view.findViewById(R.id.g);
        kg = view.findViewById(R.id.kg);
        t = view.findViewById(R.id.ton);
        gr = view.findViewById(R.id.gr);
        oz = view.findViewById(R.id.oz);
        lb = view.findViewById(R.id.lb);
        ton_us = view.findViewById(R.id.t_us);
        ton_uk = view.findViewById(R.id.t_uk);
        ct = view.findViewById(R.id.ct);
        u = view.findViewById(R.id.u);

        mass_edt= view.findViewById(R.id.edt_mass_input);
        convertFromMg(1.0);

        mSpinner= view.findViewById(R.id.mass_spinner);
        ArrayAdapter<CharSequence> mAdapter = ArrayAdapter.createFromResource(mCt, R.array.mass_array, R.layout.spinner_layout);
        mAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(mAdapter);
        mSpinner.setOnItemSelectedListener(mListener);
        mass_edt.addTextChangedListener(new TextWatcher() {
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

                int pos = mSpinner.getSelectedItemPosition();
                switch (pos) {
                    case 0:
                        convertFromMg(num);
                        break;
                    case 1:
                        convertFromG(num);
                        break;
                    case 2:
                        convertFromKg(num);
                        break;
                    case 3:
                        convertFromT(num);
                        break;
                    case 4:
                        convertFromGr(num);
                    case 5:
                        convertFromOz(num);
                        break;
                    case 6:
                        convertFromLb(num);
                        break;
                    case 7:
                        convertFromTon_US(num);
                        break;
                    case 8:
                        convertFromTon_Uk(num);
                        break;
                    case 9:
                        convertFromCt(num);
                        break;
                    case 10:
                        convertFromU(num);
                        break;



                }

            }
        });

    }

    private void convertFromU(Double num) {
        mg.setText(toSuperScript(num*1.66053872801*Math.pow(10,-21)));
        g.setText(toSuperScript(num*1.66053872801*Math.pow(10,-24)));
        kg.setText(toSuperScript(num*1.66053872801*Math.pow(10,-27)));
        t.setText(toSuperScript(num*1.66053872801*Math.pow(10,-30)));
        gr.setText(toSuperScript(num*2.56260287097*Math.pow(10,-23)));
        oz.setText(toSuperScript(num*5.85737799078*Math.pow(10,-26)));
        lb.setText(toSuperScript(num *3.66086124424*Math.pow(10,-27)));
        ton_us.setText(toSuperScript(num *1.83043062212*Math.pow(10,-30)));
        ton_uk.setText(toSuperScript(num *1.63431305546*Math.pow(10,-30)));
        ct.setText(toSuperScript(num*8.30269364007*Math.pow(10,-24)));
        u.setText(toSuperScript(num* Math.pow(10,0)));
    }

        private void convertFromCt(Double num) {
            mg.setText(toSuperScript(num*2.00*Math.pow(10,2)));
            g.setText(toSuperScript(num*2.0*Math.pow(10,-1)));
            kg.setText(toSuperScript(num*2.0*Math.pow(10,-4)));
            t.setText(toSuperScript(num*2.0*Math.pow(10,-7)));
            gr.setText(toSuperScript(num*3.08647167058829*Math.pow(10,0)));
            oz.setText(toSuperScript(num*7.05479238992*Math.pow(10,-3)));
            lb.setText(toSuperScript(num *4.4092452437*Math.pow(10,-4)));
            ton_us.setText(toSuperScript(num *2.204622621849*Math.pow(10,-7)));
            ton_uk.setText(toSuperScript(num *1.968413055222*Math.pow(10,-7)));
            ct.setText(toSuperScript(num*Math.pow(10,0)));
            u.setText(toSuperScript(num *1.204428398*Math.pow(10,23)));
    }

    private void convertFromTon_Uk(Double num) {
        mg.setText(toSuperScript(num*1.0160469088*Math.pow(10,9)));
        g.setText(toSuperScript(num*1.0160469088*Math.pow(10,6)));
        kg.setText(toSuperScript(num*1.0160469088*Math.pow(10,3)));
        t.setText(toSuperScript(num*1.0160469088*Math.pow(10,0)));
        gr.setText(toSuperScript(num*1.568*Math.pow(10,7)));
        oz.setText(toSuperScript(num*35840*Math.pow(10,0)));
        lb.setText(toSuperScript(num *2240*Math.pow(10,0)));
        ton_us.setText(toSuperScript(num *1.12*Math.pow(10,0)));
        ton_uk.setText(toSuperScript(num *Math.pow(10,0)));
        ct.setText(toSuperScript(num*5.080234544*Math.pow(10,6)));
        u.setText(toSuperScript(num *6.11877875329*Math.pow(10,29)));
    }

    private void convertFromTon_US(Double num) {

        mg.setText(toSuperScript(num*9.07184740*Math.pow(10,8)));
        g.setText(toSuperScript(num*9.07184740*Math.pow(10,5)));
        kg.setText(toSuperScript(num*9.07184740*Math.pow(10,2)));
        t.setText(toSuperScript(num*9.07184740*Math.pow(10,-1)));
        gr.setText(toSuperScript(num*1.4*Math.pow(10,7)));
        oz.setText(toSuperScript(num*32000*Math.pow(10,0)));
        lb.setText(toSuperScript(num *2000*Math.pow(10,0)));
        ton_us.setText(toSuperScript(num *Math.pow(10,0)));
        ton_uk.setText(toSuperScript(num *8.9285714285714*Math.pow(10,-2)));
        ct.setText(toSuperScript(num*4535923.7*Math.pow(10,0)));
        u.setText(toSuperScript(num *5.46319531544*Math.pow(10,29)));
    }

    private void convertFromLb(Double num) {
        mg.setText(toSuperScript(num*4.5359237*Math.pow(10,5)));
        g.setText(toSuperScript(num*4.5359237*Math.pow(10,2)));
        kg.setText(toSuperScript(num*4.5359237*Math.pow(10,-1)));
        t.setText(toSuperScript(num*4.5359237*Math.pow(10,-4)));
        gr.setText(toSuperScript(num*7.0*Math.pow(10,3)));
        oz.setText(toSuperScript(num*16*Math.pow(10,0)));
        lb.setText(toSuperScript(num *Math.pow(10,0)));
        ton_us.setText(toSuperScript(num *5*Math.pow(10,-4)));
        ton_uk.setText(toSuperScript(num *4.44642857143*Math.pow(10,-4)));
        ct.setText(toSuperScript(num*2267.96185*Math.pow(10,0)));
        u.setText(toSuperScript(num *2.73159765772*Math.pow(10,26)));
    }

    private void convertFromOz(Double num) {
        mg.setText(toSuperScript(num*2.8349523125*Math.pow(10,4)));
        g.setText(toSuperScript(num*2.8349523125*Math.pow(10,1)));
        kg.setText(toSuperScript(num*2.8349523125*Math.pow(10,-2)));
        t.setText(toSuperScript(num*2.8349523125*Math.pow(10,-5)));
        gr.setText(toSuperScript(num*4.375*Math.pow(10,2)));
        oz.setText(toSuperScript(num*Math.pow(10,0)));
        lb.setText(toSuperScript(num *6.25*Math.pow(10,-2)));
        ton_us.setText(toSuperScript(num *3.125*Math.pow(10,-5)));
        ton_uk.setText(toSuperScript(num *2.790178571429*Math.pow(10,-5)));
        ct.setText(toSuperScript(num*141.747615625*Math.pow(10,0)));
        u.setText(toSuperScript(num *1.7072485360888*Math.pow(10,25)));
    }

    private void convertFromGr(Double num) {
        mg.setText(toSuperScript(num*64.79891*Math.pow(10,0)));
        g.setText(toSuperScript(num*0.06479891*Math.pow(10,0)));
        kg.setText(toSuperScript(num*6.479891*Math.pow(10,-5)));
        t.setText(toSuperScript(num*6.479891*Math.pow(10,-8)));
        gr.setText(toSuperScript(num*Math.pow(10,0)));
        oz.setText(toSuperScript(num*2.228571428571*Math.pow(10,-3)));
        lb.setText(toSuperScript(num *1.14285714286*Math.pow(10,-4)));
        ton_us.setText(toSuperScript(num *7.142857142857*Math.pow(10,-8)));
        ton_uk.setText(toSuperScript(num *6.37755102408*Math.pow(10,-8)));
        ct.setText(toSuperScript(num*3.2399455*Math.pow(10,-1)));
        u.setText(toSuperScript(num *3.90228236817*Math.pow(10,22)));
    }

    private void convertFromT(Double num) {
        mg.setText(toSuperScript(num*Math.pow(10,9)));
        g.setText(toSuperScript(num*Math.pow(10,6)));
        kg.setText(toSuperScript(num*Math.pow(10,3)));
        t.setText(toSuperScript(num*Math.pow(10,0)));
        gr.setText(toSuperScript(num*15432358.358352941*Math.pow(10,0)));
        oz.setText(toSuperScript(num*35273.96194958*Math.pow(10,0)));
        lb.setText(toSuperScript(num *2204.622621849*Math.pow(10,0)));
        ton_us.setText(toSuperScript(num *1.02311310924*Math.pow(10,0)));
        ton_uk.setText(toSuperScript(num *9.84206527611*Math.pow(10,-1)));
        ct.setText(toSuperScript(num*5*Math.pow(10,6)));
        u.setText(toSuperScript(num *6.02214199*Math.pow(10,29)));

    }

    private void convertFromKg(Double num) {
        mg.setText(toSuperScript(num*Math.pow(10,6)));
        g.setText(toSuperScript(num*Math.pow(10,3)));
        kg.setText(toSuperScript(num*Math.pow(10,0)));
        t.setText(toSuperScript(num*Math.pow(10,-3)));
        gr.setText(toSuperScript(num*15432.358358352941*Math.pow(10,0)));
        oz.setText(toSuperScript(num*35.27396194958*Math.pow(10,0)));
        lb.setText(toSuperScript(num *2.204622621849*Math.pow(10,0)));
        ton_us.setText(toSuperScript(num *1.02311310924*Math.pow(10,-3)));
        ton_uk.setText(toSuperScript(num *9.84206527611*Math.pow(10,-4)));
        ct.setText(toSuperScript(num*5*Math.pow(10,3)));
        u.setText(toSuperScript(num *6.02214199*Math.pow(10,26)));

    }

    private void convertFromG(Double num) {

        mg.setText(toSuperScript(num*Math.pow(10,3)));
        g.setText(toSuperScript(num*Math.pow(10,0)));
        kg.setText(toSuperScript(num*Math.pow(10,-3)));
        t.setText(toSuperScript(num*Math.pow(10,-6)));
        gr.setText(toSuperScript(num*15.432358358352941*Math.pow(10,0)));
        oz.setText(toSuperScript(num*3.527396194958*Math.pow(10,-2)));
        lb.setText(toSuperScript(num *2.204622621849*Math.pow(10,-3)));
        ton_us.setText(toSuperScript(num *1.02311310924*Math.pow(10,-6)));
        ton_uk.setText(toSuperScript(num *9.84206527611*Math.pow(10,-7)));
        ct.setText(toSuperScript(num*5*Math.pow(10,0)));
        u.setText(toSuperScript(num *6.02214199*Math.pow(10,23)));

    }

    private void convertFromMg(Double num) {

        mg.setText(toSuperScript(num*Math.pow(10,0)));
        g.setText(toSuperScript(num*Math.pow(10,-3)));
        kg.setText(toSuperScript(num*Math.pow(10,-6)));
        t.setText(toSuperScript(num*Math.pow(10,-9)));
        gr.setText(toSuperScript(num*1.5432358358352941*Math.pow(10,-2)));
        oz.setText(toSuperScript(num*3.527396194958*Math.pow(10,-5)));
        lb.setText(toSuperScript(num *2.204622621849*Math.pow(10,-6)));
        ton_us.setText(toSuperScript(num *1.02311310924*Math.pow(10,-9)));
        ton_uk.setText(toSuperScript(num *9.84206527611*Math.pow(10,-10)));
        ct.setText(toSuperScript(num*5*Math.pow(10,-3)));
        u.setText(toSuperScript(num *6.02214199*Math.pow(10,20)));


    }


    private AdapterView.OnItemSelectedListener mListener = new AdapterView.OnItemSelectedListener() {


        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            if(!initialize){
                initialize= true;
            }
            else {
                String number = mass_edt.getText().toString();
                Double num;
                if (number.equals("")) {
                    num = 1.0;
                } else {
                    num = Double.parseDouble(number);
                }

                int pos = mSpinner.getSelectedItemPosition();
                switch (pos) {
                    case 0:
                        convertFromMg(num);
                        break;
                    case 1:
                        convertFromG(num);
                        break;
                    case 2:
                        convertFromKg(num);
                        break;
                    case 3:
                        convertFromT(num);
                        break;
                    case 4:
                        convertFromGr(num);
                    case 5:
                        convertFromOz(num);
                        break;
                    case 6:
                        convertFromLb(num);
                        break;
                    case 7:
                        convertFromTon_US(num);
                        break;
                    case 8:
                        convertFromTon_Uk(num);
                        break;
                    case 9:
                        convertFromCt(num);
                        break;
                    case 10:
                        convertFromU(num);
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