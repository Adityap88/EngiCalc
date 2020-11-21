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


public class volumeFrag extends Fragment {


    TextView ml,cm3,L,m3,in3,ft3,yd3,gal_us,gal_dry_us,gal_uk,oz_us,oz_uk,qt_us,qt_uk,pt_us,pt_uk,bbl;
    EditText vol_edt;
    boolean initialize= false;
    Spinner vSpinner;
    Context vCt;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_volume, container, false);
    }

    @Override
    public void onAttach(@NonNull Context context) {

        super.onAttach(context);
        vCt = context;


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ml=view.findViewById(R.id.ml);
        cm3=view.findViewById(R.id.cm3);
        L=view.findViewById(R.id.L);
        m3=view.findViewById(R.id.m3);
        in3=view.findViewById(R.id.in3);
        ft3=view.findViewById(R.id.ft3);
        yd3=view.findViewById(R.id.yd3);
        gal_us=view.findViewById(R.id.gal_us);
        gal_dry_us=view.findViewById(R.id.gal_us_dry);
        gal_uk=view.findViewById(R.id.gal_uk);
        oz_us=view.findViewById(R.id.oz_us);
        oz_uk=view.findViewById(R.id.oz_uk);
        qt_us=view.findViewById(R.id.qt_us);
        qt_uk=view.findViewById(R.id.qt_uk);
        pt_us=view.findViewById(R.id.pt_us);
        pt_uk=view.findViewById(R.id.pt_uk);
        bbl=view.findViewById(R.id.bbl);

        vol_edt= view.findViewById(R.id.edt_vol_input);

        vSpinner = view.findViewById(R.id.volume_spinner);
        ArrayAdapter<CharSequence> vAdapter = ArrayAdapter.createFromResource(vCt, R.array.volume_array, R.layout.spinner_layout);
        vAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        vSpinner.setOnItemSelectedListener(vListener);
        vSpinner.setAdapter(vAdapter);

        vol_edt.addTextChangedListener(new TextWatcher() {
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

                int pos = vSpinner.getSelectedItemPosition();
                switch (pos) {
                    case 0:
                        convertFromMl(num);
                        break;
                    case 1:
                        convertFromCm3(num);
                        break;
                    case 2:
                        convertFromL(num);
                        break;
                    case 3:
                        convertFromM3(num);
                        break;
                    case 4:
                        convertFromIn3(num);
                        break;
                    case 5:
                        convertFromFt3(num);
                        break;
                    case 6:
                        convertFromYd3(num);
                        break;
                    case 7:
                        convertFromGal_US(num);
                        break;
                    case 8:
                        convertFromGal_dry_US(num);
                        break;
                    case 9:
                        convertFromGal_UK(num);
                        break;
                    case 10:
                        convertFromOz_US(num);
                        break;
                    case 11:
                        convertFromOz_UK(num);
                        break;

                    case 12:
                        convertFromQt_US(num);
                        break;

                    case 13:
                        convertFromQt_UK(num);
                        break;
                    case 14:
                        convertFromPt_US(num);
                        break;
                    case 15:
                        convertFromPt_UK(num);
                        break;
                    case 16:
                        convertFromBbl(num);
                        break;
                }

            }
        });

    }

    private void convertFromBbl(Double num) {
        ml.setText(toSuperScript(num*158987.2949));
        cm3.setText(toSuperScript(num*158987.2949));
        L.setText(toSuperScript(num*158.9872949));
        m3.setText(toSuperScript(num*0.1589872949));
        in3.setText(toSuperScript(num*9701.99999829134));
        ft3.setText(toSuperScript(num*5.61458333234452));
        yd3.setText(toSuperScript(num *0.20794753082757));
        gal_us.setText(toSuperScript(num *41.9999999926032));
        gal_dry_us.setText(toSuperScript(num *36.0934143034062));
        gal_uk.setText(toSuperScript(num*34.9723157482584));
        oz_us.setText(toSuperScript(num*5375.99999905321 ));
        oz_uk.setText(toSuperScript(num *5595.57051972134));
        qt_us.setText(toSuperScript(num *168.062679598309));
        qt_uk.setText(toSuperScript(num *139.892032468104));
        pt_us.setText(toSuperScript(num *336.125359196617));
        pt_uk.setText(toSuperScript(num *279.784064936208));
        bbl.setText(toSuperScript(num));
    }

    private void convertFromPt_UK(Double num) {
        ml.setText(toSuperScript(num*568.2500000000001));
        cm3.setText(toSuperScript(num*568.2500000000001));
        L.setText(toSuperScript(num*0.56825));
        m3.setText(toSuperScript(num*0.00056825));
        in3.setText(toSuperScript(num*34.6767425818316));
        ft3.setText(toSuperScript(num*34.6767425818316));
        yd3.setText(toSuperScript(num *0.00074324293943));
        gal_us.setText(toSuperScript(num *0.15011576875252));
        gal_dry_us.setText(toSuperScript(num *0.12900453895269));
        gal_uk.setText(toSuperScript(num*0.12499752534596));
        oz_us.setText(toSuperScript(num*19.2148184003223 ));
        oz_uk.setText(toSuperScript(num *19.9996040553531));
        qt_us.setText(toSuperScript(num *0.600687103594081));
        qt_uk.setText(toSuperScript(num *0.5));
        pt_us.setText(toSuperScript(num *1.201374207188161));
        pt_uk.setText(toSuperScript(num ));
        bbl.setText(toSuperScript(num *0.00357418497093));
    }

    private void convertFromPt_US(Double num) {
        ml.setText(toSuperScript(num*473));
        cm3.setText(toSuperScript(num*473));
        L.setText(toSuperScript(num*0.473));
        m3.setText(toSuperScript(num*0.000473));
        in3.setText(toSuperScript(num*28.8642309568084));
        ft3.setText(toSuperScript(num*0.01670383735926));
        yd3.setText(toSuperScript(num *0.00061866064294));
        gal_us.setText(toSuperScript(num *0.1249533807654));
        gal_dry_us.setText(toSuperScript(num *0.10738081288979));
        gal_uk.setText(toSuperScript(num*0.10404545444547));
        oz_us.setText(toSuperScript(num*15.9940327379717 ));
        oz_uk.setText(toSuperScript(num *16.647272711275));
        qt_us.setText(toSuperScript(num *0.5));
        qt_uk.setText(toSuperScript(num *0.41619005719314));
        pt_us.setText(toSuperScript(num ));
        pt_uk.setText(toSuperScript(num *0.83238011438627));
        bbl.setText(toSuperScript(num *0.00297508049494));
    }

    private void convertFromQt_UK(Double num) {
        ml.setText(toSuperScript(num*1136.5));
        cm3.setText(toSuperScript(num*1136.5));
        L.setText(toSuperScript(num*1.1365));
        m3.setText(toSuperScript(num*0.0011365));
        in3.setText(toSuperScript(num*69.3534851636633));
        ft3.setText(toSuperScript(num*0.04013511872897));
        yd3.setText(toSuperScript(num *0.001486485878851));
        gal_us.setText(toSuperScript(num *0.30023153750504));
        gal_dry_us.setText(toSuperScript(num *0.25800907790539));
        gal_uk.setText(toSuperScript(num*0.24999505069191));
        oz_us.setText(toSuperScript(num*38.4296368006446 ));
        oz_uk.setText(toSuperScript(num *39.9992081107061));
        qt_us.setText(toSuperScript(num *1.201374207188161));
        qt_uk.setText(toSuperScript(num ));
        pt_us.setText(toSuperScript(num *2.40274841437632));
        pt_uk.setText(toSuperScript(num *2));
        bbl.setText(toSuperScript(num *0.00714836994186));
    }

    private void convertFromQt_US(Double num) {
        ml.setText(toSuperScript(num*946));
        cm3.setText(toSuperScript(num*946));
        L.setText(toSuperScript(num*0.946));
        m3.setText(toSuperScript(num*0.000946));
        in3.setText(toSuperScript(num*57.7284619136167));
        ft3.setText(toSuperScript(num*0.03340767471853));
        yd3.setText(toSuperScript(num *0.001237321285871));
        gal_us.setText(toSuperScript(num *0.24990676153081));
        gal_dry_us.setText(toSuperScript(num *0.21476162577958));
        gal_uk.setText(toSuperScript(num*0.20809090889094));
        oz_us.setText(toSuperScript(num*31.9880654759435 ));
        oz_uk.setText(toSuperScript(num *33.2945454225499));
        qt_us.setText(toSuperScript(num ));
        qt_uk.setText(toSuperScript(num *0.83238011438627));
        pt_us.setText(toSuperScript(num *2));
        pt_uk.setText(toSuperScript(num *1.66476022877255));
        bbl.setText(toSuperScript(num *0.00595016098988));
    }

    private void convertFromOz_UK(Double num) {
        ml.setText(toSuperScript(num*28.4130625));
        cm3.setText(toSuperScript(num*28.4130625));
        L.setText(toSuperScript(num*0.0284130625));
        m3.setText(toSuperScript(num*2.84130625E-5));
        in3.setText(toSuperScript(num*1.73387145494763));
        ft3.setText(toSuperScript(num*0.00100339783272));
        yd3.setText(toSuperScript(num *3.716288269349E-5));
        gal_us.setText(toSuperScript(num *0.00750593703441));
        gal_dry_us.setText(toSuperScript(num *0.0064503546468));
        gal_uk.setText(toSuperScript(num*0.00625));
        oz_us.setText(toSuperScript(num*0.96075994040388 ));
        oz_uk.setText(toSuperScript(num ));
        qt_us.setText(toSuperScript(num *0.03003494978858));
        qt_uk.setText(toSuperScript(num *0.02500049494061));
        pt_us.setText(toSuperScript(num *0.06006989957717));
        pt_uk.setText(toSuperScript(num *0.05000098988121));
        bbl.setText(toSuperScript(num *0.00017871278656));
    }

    private void convertFromOz_US(Double num) {
        ml.setText(toSuperScript(num*29.5735295625));
        cm3.setText(toSuperScript(num*29.5735295625));
        L.setText(toSuperScript(num*0.0295735295625));
        m3.setText(toSuperScript(num*2.95735295625E-5));
        in3.setText(toSuperScript(num*1.8046875));
        ft3.setText(toSuperScript(num*0.00104437934028));
        yd3.setText(toSuperScript(num *3.868071630658E-5));
        gal_us.setText(toSuperScript(num *0.0078125));
        gal_dry_us.setText(toSuperScript(num *0.00671380474512));
        gal_uk.setText(toSuperScript(num*0.00650526706741));
        oz_us.setText(toSuperScript(num ));
        oz_uk.setText(toSuperScript(num *1.04084273078624));
        qt_us.setText(toSuperScript(num *0.03126165915698));
        qt_uk.setText(toSuperScript(num *0.02602158342499));
        pt_us.setText(toSuperScript(num *0.06252331831395));
        pt_uk.setText(toSuperScript(num *0.05204316684998));
        bbl.setText(toSuperScript(num *0.00018601190479));
    }

    private void convertFromGal_UK(Double num) {
        ml.setText(toSuperScript(num*4546.09));
        cm3.setText(toSuperScript(num*4546.09));
        L.setText(toSuperScript(num*4.54609));
        m3.setText(toSuperScript(num*0.00454609));
        in3.setText(toSuperScript(num*277.419432791622));
        ft3.setText(toSuperScript(num*0.16054365323589));
        yd3.setText(toSuperScript(num *0.00594606123096));
        gal_us.setText(toSuperScript(num *1.20094992550486));
        gal_dry_us.setText(toSuperScript(num *1.032056743488701));
        gal_uk.setText(toSuperScript(num));
        oz_us.setText(toSuperScript(num *153.721590464621));
        oz_uk.setText(toSuperScript(num *160));
        qt_us.setText(toSuperScript(num *4.80559196617336));
        qt_uk.setText(toSuperScript(num *4.00007919049714));
        pt_us.setText(toSuperScript(num *9.61118393234673));
        pt_uk.setText(toSuperScript(num *8.00015838099428));
        bbl.setText(toSuperScript(num *0.02859404585039));
    }

    private void convertFromGal_dry_US(Double num) {
        ml.setText(toSuperScript(num*4404.88377086));
        cm3.setText(toSuperScript(num*4404.88377086));
        L.setText(toSuperScript(num*4.40488377086));
        m3.setText(toSuperScript(num*0.003785411784));
        in3.setText(toSuperScript(num*268.8025));
        ft3.setText(toSuperScript(num*0.15555700231481));
        yd3.setText(toSuperScript(num *0.0057613704561));
        gal_us.setText(toSuperScript(num *1.16364718614719));
        gal_dry_us.setText(toSuperScript(num ));
        gal_uk.setText(toSuperScript(num*0.96893897192093));
        oz_us.setText(toSuperScript(num *148.94683982684));
        oz_uk.setText(toSuperScript(num *155.0302355073481));
        qt_us.setText(toSuperScript(num *4.65632533917548));
        qt_uk.setText(toSuperScript(num *3.87583261844259));
        pt_us.setText(toSuperScript(num *9.31265067835095));
        pt_uk.setText(toSuperScript(num *7.75166523688517));
        bbl.setText(toSuperScript(num *0.02770588538934));
    }

    private void convertFromGal_US(Double num) {
        ml.setText(toSuperScript(num*3785.411784));
        cm3.setText(toSuperScript(num*3785.411784));
        L.setText(toSuperScript(num*3.785411784));
        m3.setText(toSuperScript(num*0.003785411784));
        in3.setText(toSuperScript(num*231));
        ft3.setText(toSuperScript(num*0.13368055555556));
        yd3.setText(toSuperScript(num *0.00495113168724));
        gal_us.setText(toSuperScript(num ));
        gal_dry_us.setText(toSuperScript(num *0.8593670073753));
        gal_uk.setText(toSuperScript(num*0.83267418462899));
        oz_us.setText(toSuperScript(num *128));
        oz_uk.setText(toSuperScript(num *133.227869540638));
        qt_us.setText(toSuperScript(num *4.00149237209302));
        qt_uk.setText(toSuperScript(num *3.33076267839859));
        pt_us.setText(toSuperScript(num *8.00298474418605));
        pt_uk.setText(toSuperScript(num *6.66152535679718));
        bbl.setText(toSuperScript(num *0.02380952381372));
    }

    private void convertFromYd3(Double num) {
        ml.setText(toSuperScript(num*764554.857984));
        cm3.setText(toSuperScript(num*764554.857984));
        L.setText(toSuperScript(num*764.554857984));
        m3.setText(toSuperScript(num*0.764554857984));
        in3.setText(toSuperScript(num*46656));
        ft3.setText(toSuperScript(num*27));
        yd3.setText(toSuperScript(num ));
        gal_us.setText(toSuperScript(num *201.974025974026));
        gal_dry_us.setText(toSuperScript(num *173.569814268841));
        gal_uk.setText(toSuperScript(num*168.178557394156));
        oz_us.setText(toSuperScript(num *25852.6753246753));
        oz_uk.setText(toSuperScript(num *26908.56918306501));
        qt_us.setText(toSuperScript(num *808.197524295983));
        qt_uk.setText(toSuperScript(num *672.727547720194));
        pt_us.setText(toSuperScript(num *1616.39504859197));
        pt_uk.setText(toSuperScript(num *1345.45509544039));
        bbl.setText(toSuperScript(num *4.808905381180871));

    }

    private void convertFromFt3(Double num) {
        ml.setText(toSuperScript(num*28316.846592));
        cm3.setText(toSuperScript(num*28316.846592));
        L.setText(toSuperScript(num*28.316846592));
        m3.setText(toSuperScript(num*0.028316846592));
        in3.setText(toSuperScript(num*1728));
        ft3.setText(toSuperScript(num));
        yd3.setText(toSuperScript(num *0.03703703703704));
        gal_us.setText(toSuperScript(num *7.48051948051948));
        gal_dry_us.setText(toSuperScript(num *6.42851163958669));
        gal_uk.setText(toSuperScript(num*6.22883545904283));
        oz_us.setText(toSuperScript(num *957.506493506493));
        oz_uk.setText(toSuperScript(num *996.6136734468521));
        qt_us.setText(toSuperScript(num *29.933241640592));
        qt_uk.setText(toSuperScript(num *24.91583510074791));
        pt_us.setText(toSuperScript(num *59.8664832811839));
        pt_uk.setText(toSuperScript(num *49.8316702014958));
        bbl.setText(toSuperScript(num *0.1781076067104));
    }

    private void convertFromIn3(Double num) {
        ml.setText(toSuperScript(num*1.6387064*Math.pow(10,1)));
        cm3.setText(toSuperScript(num*1.6387064*Math.pow(10,1)));
        L.setText(toSuperScript(num*1.6387064*Math.pow(10,-2)));
        m3.setText(toSuperScript(num*1.6387064*Math.pow(10,-5)));
        in3.setText(toSuperScript(num*Math.pow(10,0)));
        ft3.setText(toSuperScript(num*5.787037037*Math.pow(10,-4)));
        yd3.setText(toSuperScript(num *2.143347050754*Math.pow(10,-5)));
        gal_us.setText(toSuperScript(num *4.3294329*Math.pow(10,-3)));
        gal_dry_us.setText(toSuperScript(num *3.72020345131*Math.pow(10,-3)));
        gal_uk.setText(toSuperScript(num*3.60465014994*Math.pow(10,-3)));
        oz_us.setText(toSuperScript(num *5.5411255411255*Math.pow(10,-1)));
        oz_uk.setText(toSuperScript(num *5.7674402398545*Math.pow(10,-1)));
        qt_us.setText(toSuperScript(num *1.73224780127*Math.pow(10,-2)));
        qt_uk.setText(toSuperScript(num *1.441888605367*Math.pow(10,-2)));
        pt_us.setText(toSuperScript(num *3.464495560254*Math.pow(10,-2)));
        pt_uk.setText(toSuperScript(num *2.288777210735*Math.pow(10,-2)));
        bbl.setText(toSuperScript(num *1.03071531661*Math.pow(10,-4)));
    }

    private void convertFromM3(Double num) {
        ml.setText(toSuperScript(num*Math.pow(10,6)));
        cm3.setText(toSuperScript(num*Math.pow(10,6)));
        L.setText(toSuperScript(num*Math.pow(10,3)));
        m3.setText(toSuperScript(num*Math.pow(10,0)));
        in3.setText(toSuperScript(num*6.102374409473*Math.pow(10,4)));
        ft3.setText(toSuperScript(num*3.53146672149*Math.pow(10,1)));
        yd3.setText(toSuperScript(num *1.307950619314*Math.pow(10,0)));
        gal_us.setText(toSuperScript(num *2.6417205236*Math.pow(10,2)));
        gal_dry_us.setText(toSuperScript(num *2.2702074607*Math.pow(10,2)));
        gal_uk.setText(toSuperScript(num*2.199692483*Math.pow(10,2)));
        oz_us.setText(toSuperScript(num *3.381402270184*Math.pow(10,4)));
        oz_uk.setText(toSuperScript(num *3.51950792785*Math.pow(10,4)));
        qt_us.setText(toSuperScript(num *1.057082452431*Math.pow(10,3)));
        qt_uk.setText(toSuperScript(num *8.7989441267*Math.pow(10,2)));
        pt_us.setText(toSuperScript(num *2.11416490486*Math.pow(10,3)));
        pt_uk.setText(toSuperScript(num *1.759788825341*Math.pow(10,3)));
        bbl.setText(toSuperScript(num *6.28981077153983*Math.pow(10,0)));


    }

    private void convertFromL(Double num) {
        ml.setText(toSuperScript(num*Math.pow(10,3)));
        cm3.setText(toSuperScript(num*Math.pow(10,3)));
        L.setText(toSuperScript(num*Math.pow(10,0)));
        m3.setText(toSuperScript(num*Math.pow(10,-3)));
        in3.setText(toSuperScript(num*6.102374409473*Math.pow(10,1)));
        ft3.setText(toSuperScript(num*3.53146672149*Math.pow(10,-2)));
        yd3.setText(toSuperScript(num *1.307950619314*Math.pow(10,-3)));
        gal_us.setText(toSuperScript(num *2.6417205236*Math.pow(10,-1)));
        gal_dry_us.setText(toSuperScript(num *2.2702074607*Math.pow(10,-1)));
        gal_uk.setText(toSuperScript(num*2.199692483*Math.pow(10,-1)));
        oz_us.setText(toSuperScript(num *3.381402270184*Math.pow(10,1)));
        oz_uk.setText(toSuperScript(num *3.51950792785*Math.pow(10,1)));
        qt_us.setText(toSuperScript(num *1.057082452431*Math.pow(10,0)));
        qt_uk.setText(toSuperScript(num *8.7989441267*Math.pow(10,-1)));
        pt_us.setText(toSuperScript(num *2.11416490486*Math.pow(10,0)));
        pt_uk.setText(toSuperScript(num *1.759788825341*Math.pow(10,0)));
        bbl.setText(toSuperScript(num *6.28981077154*Math.pow(10,-3)));
    }

    private void convertFromCm3(Double num) {
        ml.setText(toSuperScript(num*Math.pow(10,0)));
        cm3.setText(toSuperScript(num*Math.pow(10,0)));
        L.setText(toSuperScript(num*Math.pow(10,-3)));
        m3.setText(toSuperScript(num*Math.pow(10,-6)));
        in3.setText(toSuperScript(num*6.102374409473*Math.pow(10,-2)));
        ft3.setText(toSuperScript(num*3.53146672149*Math.pow(10,-5)));
        yd3.setText(toSuperScript(num *1.307950619314*Math.pow(10,-6)));
        gal_us.setText(toSuperScript(num *2.6417205236*Math.pow(10,-4)));
        gal_dry_us.setText(toSuperScript(num *2.2702074607*Math.pow(10,-4)));
        gal_uk.setText(toSuperScript(num*2.199692483*Math.pow(10,-4)));
        oz_us.setText(toSuperScript(num *3.381402270184*Math.pow(10,-2)));
        oz_uk.setText(toSuperScript(num *3.51950792785*Math.pow(10,-2)));
        qt_us.setText(toSuperScript(num *1.057082452431*Math.pow(10,-3)));
        qt_uk.setText(toSuperScript(num *8.7989441267*Math.pow(10,-4)));
        pt_us.setText(toSuperScript(num *2.11416490486*Math.pow(10,-3)));
        pt_uk.setText(toSuperScript(num *1.759788825341*Math.pow(10,-3)));
        bbl.setText(toSuperScript(num *6.28981077154*Math.pow(10,-6)));
    }

    private void convertFromMl(Double num) {

        ml.setText(toSuperScript(num*Math.pow(10,0)));
        cm3.setText(toSuperScript(num*Math.pow(10,0)));
        L.setText(toSuperScript(num*Math.pow(10,-3)));
        m3.setText(toSuperScript(num*Math.pow(10,-6)));
        in3.setText(toSuperScript(num*6.102374409473*Math.pow(10,-2)));
        ft3.setText(toSuperScript(num*3.53146672149*Math.pow(10,-5)));
        yd3.setText(toSuperScript(num *1.307950619314*Math.pow(10,-6)));
        gal_us.setText(toSuperScript(num *2.6417205236*Math.pow(10,-4)));
        gal_dry_us.setText(toSuperScript(num *2.2702074607*Math.pow(10,-4)));
        gal_uk.setText(toSuperScript(num*2.199692483*Math.pow(10,-4)));
        oz_us.setText(toSuperScript(num *3.381402270184*Math.pow(10,-2)));
        oz_uk.setText(toSuperScript(num *3.51950792785*Math.pow(10,-2)));
        qt_us.setText(toSuperScript(num *1.057082452431*Math.pow(10,-3)));
        qt_uk.setText(toSuperScript(num *8.7989441267*Math.pow(10,-4)));
        pt_us.setText(toSuperScript(num *2.11416490486*Math.pow(10,-3)));
        pt_uk.setText(toSuperScript(num *1.759788825341*Math.pow(10,-3)));
        bbl.setText(toSuperScript(num *6.28981077154*Math.pow(10,-6)));
    }


    private AdapterView.OnItemSelectedListener vListener = new AdapterView.OnItemSelectedListener() {


        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            if(!initialize){
                initialize= true;
            }
            else {
                String number = vol_edt.getText().toString();
                Double num;
                if (number.equals("")) {
                    num = 1.0;
                } else {
                    num = Double.parseDouble(number);
                }

                int pos = vSpinner.getSelectedItemPosition();
                switch (pos) {
                    case 0:
                        convertFromMl(num);
                        break;
                    case 1:
                        convertFromCm3(num);
                        break;
                    case 2:
                        convertFromL(num);
                        break;
                    case 3:
                        convertFromM3(num);
                        break;
                    case 4:
                        convertFromIn3(num);
                        break;
                    case 5:
                        convertFromFt3(num);
                        break;
                    case 6:
                        convertFromYd3(num);
                        break;
                    case 7:
                        convertFromGal_US(num);
                        break;
                    case 8:
                        convertFromGal_dry_US(num);
                        break;
                    case 9:
                        convertFromGal_UK(num);
                        break;
                    case 10:
                        convertFromOz_US(num);
                        break;
                    case 11:
                        convertFromOz_UK(num);
                        break;

                    case 12:
                        convertFromQt_US(num);
                        break;

                    case 13:
                        convertFromQt_UK(num);
                        break;
                    case 14:
                        convertFromPt_US(num);
                        break;
                    case 15:
                        convertFromPt_UK(num);
                        break;
                    case 16:
                        convertFromBbl(num);
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