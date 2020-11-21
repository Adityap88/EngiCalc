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


public class distanceFrag extends Fragment {

    TextView mm, cm, dm, m, km, in, ft, yd, mi, nmi, ly;
    EditText distance_edt;

    boolean initialize = false;
    Context dCt;
    Spinner dSpinner;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_distance, container, false);
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        dCt = context;


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mm = view.findViewById(R.id.mm);
        cm = view.findViewById(R.id.cm);
        dm = view.findViewById(R.id.dm);
        m = view.findViewById(R.id.m);
        km = view.findViewById(R.id.km);
        in = view.findViewById(R.id.in);
        ft = view.findViewById(R.id.ft);
        yd = view.findViewById(R.id.yd);
        mi = view.findViewById(R.id.mi);
        nmi = view.findViewById(R.id.nmi);
        ly = view.findViewById(R.id.ly);

        distance_edt = view.findViewById(R.id.edt_dis_input);

        dSpinner = view.findViewById(R.id.distance_spinner);
        ArrayAdapter<CharSequence> dAdapter = ArrayAdapter.createFromResource(dCt, R.array.distance_array, R.layout.spinner_layout);
        dAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dSpinner.setAdapter(dAdapter);

        convertFromMm(1.0);


        distance_edt.addTextChangedListener(new TextWatcher() {
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

                int pos = dSpinner.getSelectedItemPosition();
                switch (pos) {
                    case 0:
                        convertFromMm(num);
                        break;
                    case 1:
                        convertFromCm(num);
                        break;
                    case 2:
                        convertFromDm(num);
                        break;
                    case 3:
                        convertFromM(num);
                        break;
                    case 4:
                        convertFromKm(num);
                        break;
                    case 5:
                        convertFromIn(num);
                        break;
                    case 6:
                        convertFromFt(num);
                        break;
                    case 7:
                        convertFromYd(num);
                        break;
                    case 8:
                        convertFromMi(num);
                        break;
                    case 9:
                        convertFromNmi(num);
                        break;
                    case 10:
                        convertFromLy(num);
                        break;
                }

            }
        });


        dSpinner.setOnItemSelectedListener(dListener);
    }

    private AdapterView.OnItemSelectedListener dListener = new AdapterView.OnItemSelectedListener() {


        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            if (!initialize) {
                initialize = true;
            } else {

                String number = distance_edt.getText().toString();
                Double num;
                if (number.equals("")) {
                    num = 1.0;
                } else {
                    num = Double.parseDouble(number);
                }

                int pos = dSpinner.getSelectedItemPosition();
                switch (pos) {
                    case 0:
                        convertFromMm(num);
                        break;
                    case 1:
                        convertFromCm(num);
                        break;
                    case 2:
                        convertFromDm(num);
                        break;
                    case 3:
                        convertFromM(num);
                        break;
                    case 4:
                        convertFromKm(num);
                        break;
                    case 5:
                        convertFromIn(num);
                        break;
                    case 6:
                        convertFromFt(num);
                        break;
                    case 7:
                        convertFromYd(num);
                        break;
                    case 8:
                        convertFromMi(num);
                        break;
                    case 9:
                        convertFromNmi(num);
                        break;
                    case 10:
                        convertFromLy(num);
                        break;


                    default:
                }

            }


        }


        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };

    private void convertFromLy(Double d) {


        mm.setText(toSuperScript(d *(9.460528405 * Math.pow(10, 18))));
        cm.setText(toSuperScript(d *(9.460528405 * Math.pow(10, 17))));
        dm.setText(toSuperScript(d *(9.460528405 * Math.pow(10, 16))));
        m.setText(toSuperScript(d *(9.460528405 * Math.pow(10, 15))));
        km.setText(toSuperScript(d *9460528405000.0));
        in.setText(toSuperScript(d *(3.72461748228 * Math.pow(10,17))));
        ft.setText(toSuperScript(d *(3.1038479019*Math.pow(10,16))));
        yd.setText(toSuperScript(d*(1.0346159673*Math.pow(10,16))));
        mi.setText(toSuperScript(d *5878499814210.01));
        nmi.setText(toSuperScript(d * 5108276676565.88));
        ly.setText(toSuperScript(d));
    }

    private void convertFromNmi(Double d) {
        mm.setText(toSuperScript(d *1852000));
        cm.setText(toSuperScript(d*185200));
        dm.setText(toSuperScript(d *18520));
        m.setText(toSuperScript(d * 1852));
        km.setText(toSuperScript(d *1.852));
        in.setText(toSuperScript(d *72913.3858267717));
        ft.setText(toSuperScript(d *6067.11548555643));
        yd.setText(toSuperScript(d *2025.37182852143));
        mi.setText(toSuperScript(d *1.15077944802354));
        nmi.setText(toSuperScript(d ));
        ly.setText(toSuperScript(d / (1.95760735629 * Math.pow(10, 13))));
    }

    private void convertFromMi(Double d) {
        mm.setText(toSuperScript(d * 1609344));
        cm.setText(toSuperScript(d*160934.4));
        dm.setText(toSuperScript(d *16093.44));
        m.setText(toSuperScript(d / 1609.344));
        km.setText(toSuperScript(d / 1.609344));
        in.setText(toSuperScript(d *63360));
        ft.setText(toSuperScript(d *5280));
        yd.setText(toSuperScript(d *1760));
        mi.setText(toSuperScript(d));
        nmi.setText(toSuperScript(d/1.151 ));
        ly.setText(toSuperScript(d / (1.701111428358 * Math.pow(10, 13))));
    }

    private void convertFromYd(Double d) {
        mm.setText(toSuperScript(d * 914.4));
        cm.setText(toSuperScript(d*91.44));
        dm.setText(toSuperScript(d *9.144));
        m.setText(toSuperScript(d / 1.094));
        km.setText(toSuperScript(d /1094));
        in.setText(toSuperScript(d *36));
        ft.setText(toSuperScript(d *3));
        yd.setText(toSuperScript(d ));
        mi.setText(toSuperScript(d / 1760));
        nmi.setText(toSuperScript(d / 2025));
        ly.setText(toSuperScript(d / (9.66542206582 * Math.pow(10, 17))));
    }


    private void convertFromFt(Double d) {
        mm.setText(toSuperScript(d * 305));
        cm.setText(toSuperScript(d * 30.48));
        dm.setText(toSuperScript(d / 3.048));
        m.setText(toSuperScript(d / 3.281));
        km.setText(toSuperScript(d / 3281));
        in.setText(toSuperScript(d * 12));
        ft.setText(toSuperScript(d));
        yd.setText(toSuperScript(d / 3));
        mi.setText(toSuperScript(d / 5280));
        nmi.setText(toSuperScript(d / 6076));
        ly.setText(toSuperScript(d / (3.22180735527 * Math.pow(10, 17))));
    }

    private void convertFromIn(Double d) {
        mm.setText(toSuperScript(d * 25.4));
        cm.setText(toSuperScript(d * 2.54));
        dm.setText(toSuperScript(d / 3.937));
        m.setText(toSuperScript(d / 39.37));
        km.setText(toSuperScript(d / 39370));
        in.setText(toSuperScript(d));
        ft.setText(toSuperScript(d / 12));
        yd.setText(toSuperScript(d / 36));
        mi.setText(toSuperScript(d / 63360));
        nmi.setText(toSuperScript(d / 72913));
        ly.setText(toSuperScript(d / (2.68483946273 * Math.pow(10, 18))));
    }

    private void convertFromKm(Double d) {
        mm.setText(toSuperScript(d * 1000000));
        cm.setText(toSuperScript(d * 100000));
        dm.setText(toSuperScript(d * 10000));
        m.setText(toSuperScript(d * 1000));
        km.setText(toSuperScript(d));
        in.setText(toSuperScript(d * 39370));
        ft.setText(toSuperScript(d * 3281));
        yd.setText(toSuperScript(d * 1094));
        mi.setText(toSuperScript(d / 1.609));
        nmi.setText(toSuperScript(d / 1.852));
        ly.setText(toSuperScript(d / (1.05702341052 * Math.pow(10, 13))));
    }

    private void convertFromM(Double d) {
        mm.setText(toSuperScript(d * 1000));
        cm.setText(toSuperScript(d * 100));
        dm.setText(toSuperScript(d * 10));
        m.setText(toSuperScript(d));
        km.setText(toSuperScript(d / 1000));
        in.setText(toSuperScript(d * 39.37));
        ft.setText(toSuperScript(d * 3.281));
        yd.setText(toSuperScript(d * 1.094));
        mi.setText(toSuperScript(d / 1609));
        nmi.setText(toSuperScript(d / 1852));
        ly.setText(toSuperScript(d / (1.05702341052 * Math.pow(10, 16))));
    }

    private void convertFromDm(Double d) {

        mm.setText(toSuperScript(d * 100));
        cm.setText(toSuperScript(d * 10));
        dm.setText(toSuperScript(d));
        m.setText(toSuperScript(d / 10));
        km.setText(toSuperScript(d / 10000));
        in.setText(toSuperScript(d * 3.937));
        ft.setText(toSuperScript(d / 3.048));
        yd.setText(toSuperScript(d / 9.144));
        mi.setText(toSuperScript(d / 16093));
        nmi.setText(toSuperScript(d / 18520));
        ly.setText(toSuperScript(d / (1.05702341052 * Math.pow(10, 17))));
    }

    private void convertFromCm(Double d) {
        mm.setText(toSuperScript(d * 10));
        cm.setText(toSuperScript(d));
        dm.setText(toSuperScript(d / 10));
        m.setText(toSuperScript(d / 100));
        km.setText(toSuperScript(d / 100000));
        in.setText(toSuperScript(d / 2.54));
        ft.setText(toSuperScript(d / 30.48));
        yd.setText(toSuperScript(d / 91.44));
        mi.setText(toSuperScript(d / 160934));
        nmi.setText(toSuperScript(d / 185200));
        ly.setText(toSuperScript(d / (9.460528405 * Math.pow(10, 17))));


    }

    private void convertFromMm(Double d) {
        mm.setText(toSuperScript(d));
        cm.setText(toSuperScript(d / 10.0));
        dm.setText(toSuperScript(d / 100.0));
        m.setText(toSuperScript(d / 1000.0));
        km.setText(toSuperScript(d / 1000000));
        in.setText(toSuperScript(d / 25.40));
        ft.setText(toSuperScript(d / 304.8));
        yd.setText(toSuperScript(d / 914.4));
        mi.setText(toSuperScript(d / 1609340));
        nmi.setText(toSuperScript(d / 1852000));
        ly.setText(toSuperScript(d / (9.460528405 * Math.pow(10, 18))));


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