package com.example.wasim.tabtry;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class TimeFragment extends Fragment {
    Spinner spinner11, from, to;
    TextView result,tex2,text3,text4,text5;
    EditText value;
    String[] froms ;
    String f="",t="";
    Button enterresult,bu;
    String check=null;
    double ress;
    double re;
    int Finalnumber;
    String convertTO;
    String [] CheckFloat;
    int FinalInt;
    ImageButton reset;
    String r;

    TextView metertv,meterresult,kilometertv,kilometerresult,centimmetertv,centimeterresult,miletv,mileresult,inchtv,inchresult,monthresult;
    double   meterCalcresult,kilometerCalcresult,centimeterCalcresult,mileCalcresult,inchCalcresult,monthCalcresult;
    double   meterCalcresult2,kilometerCalcresult2,centimeterCalcresult2,mileCalcresult2,inchCalcresult2;




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.timefragment, container, false);
//        Toolbar toolbar = (Toolbar) rootView.findViewById(R.id.toolbar);
//        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);



        Typeface mytypeface = Typeface.createFromAsset(getActivity().getAssets(),"sr.ttf");
        TextView tv1 = (TextView) rootView.findViewById(R.id.categoryTitle);
        tv1.setTypeface(mytypeface);


        //TextView metertv,meterresult,kilometertv,kilometerresult,centimmetertv,centimeterresult,miletv,mileresult,inchtv,inchresult;

        meterresult = (TextView)    rootView.findViewById(R.id.meterresult);
        kilometerresult= (TextView)  rootView.findViewById(R.id.kilometerresult);
        centimeterresult = (TextView)  rootView.findViewById(R.id.centimeterresult);
        mileresult = (TextView)  rootView.findViewById(R.id.mileresult);
        inchresult = (TextView)  rootView.findViewById(R.id.inchresult);
        monthresult = (TextView)  rootView.findViewById(R.id.monthresult);



        enterresult= (Button) rootView.findViewById(R.id.buttonn) ;
        //  spinner11 = (Spinner)rootView.findViewById(R.id.spinner11);
        from = (Spinner)rootView.findViewById(R.id.spinner);
        //  to = (Spinner)rootView.findViewById(R.id.spinner1);
      //  result = (TextView)rootView.findViewById(R.id.tvresult);
        value = (EditText)rootView.findViewById(R.id.value);
        reset= (ImageButton)rootView.findViewById(R.id.reset1);
      //  result.setText(" ");
        meterresult.setText(" ");
        kilometerresult.setText(" ");
        centimeterresult.setText(" ");
        mileresult.setText(" ");
        inchresult.setText(" ");
        monthresult.setText(" ");

        AdView adView = (AdView) rootView.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .setRequestAgent("android_studio:ad_template").build();
        adView.loadAd(adRequest);

        /*String[] val = {"Length" ,"Temperature" ,"Weight","Time","Area","Volume" };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),R.layout.spinner_custom,val);
        spinner11.setAdapter(adapter);*/

        spinnerCall();


        //  Toast.makeText(getActivity(),r, Toast.LENGTH_SHORT).show();

        enterresult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                f = from.getSelectedItem().toString();
                r = value.getText().toString();
                //  t = to.getSelectedItem().toString();
                // Toast.makeText(Conversion_Of_Speed.this, f+"\n"+t, Toast.LENGTH_SHORT).show();

                if (r.equals(null) || r.equals("") ||r.equals(" ") ||r.equals(".")  ) {
                    Toast.makeText(getActivity(),"Enter Some Value", Toast.LENGTH_SHORT).show();
                 //   result.setText( "Enter  Value");

                }
                else
                {

                    try {


                        re = Double.parseDouble(r);
                     //   result.setText("Enter Value...." );

                    }
                    catch (Exception e)
                    {
                        Toast.makeText(getActivity(),"Invalid Entry."+"\n", Toast.LENGTH_SHORT).show();
                     //   result.setText("Enter Value....");

                    }


                    froms = new String[] {"Second"  , "Minute" , "Hour" , "Day" , "Week" ,"Month"};
                    if (f.equals("Minute") ) {


                        MeterValues(re);




                    } else if (f.equalsIgnoreCase("Second")) {
                        KiolometerValues(re);


                    }else if (f.equalsIgnoreCase("Hour")) {

                        MileValues(re);
                    }
                    else if (f.equalsIgnoreCase("Week")) {

                        CentimeterValues(re);
                    }
                    else if (f.equalsIgnoreCase("Day")) {

                        InchValues(re);
                    }
                    else if (f.equalsIgnoreCase("Month")) {

                        MonthValues(re);
                    }

                }

            }

        });


        reset.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
            //    result.setText(" ");
                value.setText("");
                meterresult.setText(" ");
                kilometerresult.setText(" ");
                centimeterresult.setText(" ");
                mileresult.setText(" ");
                inchresult.setText(" ");
                monthresult.setText(" ");

                Toast.makeText(getActivity(),"Refreshed"+"\n", Toast.LENGTH_SHORT).show();

            }
        });



        return rootView;
    }

    public  void MeterValues(double reValue)
    {

        //   double   meterCalcresult,kilometerCalcresult,centimeterCalcresult,mileCalcresult,inchCalcresult;
    //    result.setText(" ");
        meterCalcresult = reValue *1;
        kilometerCalcresult = reValue * 60;
        centimeterCalcresult =reValue / 10080;
        mileCalcresult= reValue /60;
        inchCalcresult=reValue / 1440;
        monthCalcresult= reValue /43830;


//        meterresult.setText(meterCalcresult+" ");
//        kilometerresult.setText(kilometerCalcresult+" ");
//        centimeterresult.setText(centimeterCalcresult+" ");
//        mileresult.setText(mileCalcresult+" ");
//        inchresult.setText(inchCalcresult+" ");
//        monthresult.setText(monthCalcresult+"");
        if(meterCalcresult % 1 == 0)
        {
            // Toast.makeText(MainActivity.this,"No Float"+"\n", Toast.LENGTH_SHORT).show();
            //  CheckFloat = ;
            // Toast.makeText(MainActivity.this,"Showing"+"  " +  CheckFloat, Toast.LENGTH_SHORT).show();
            Double d = new Double(meterCalcresult);
            int i = d.intValue();
            //  Toast.makeText(MainActivity.this,"value of i"+" " + i+"", Toast.LENGTH_SHORT).show();
            meterresult.setText(i+ " ");



        }
        else
        {
            meterresult.setText(meterCalcresult+" ");
            // Toast.makeText(MainActivity.this,"Float"+"\n", Toast.LENGTH_SHORT).show();
            // result.setText("Custome Text2");

        }
        if(kilometerCalcresult % 1 == 0)
        {
            // Toast.makeText(MainActivity.this,"No Float"+"\n", Toast.LENGTH_SHORT).show();
            //  CheckFloat = ;
            // Toast.makeText(MainActivity.this,"Showing"+"  " +  CheckFloat, Toast.LENGTH_SHORT).show();
            Double d = new Double(kilometerCalcresult);
            int i = d.intValue();
            //  Toast.makeText(MainActivity.this,"value of i"+" " + i+"", Toast.LENGTH_SHORT).show();
            kilometerresult.setText(i+ " ");



        }
        else
        {
            kilometerresult.setText(kilometerCalcresult+" ");
            // Toast.makeText(MainActivity.this,"Float"+"\n", Toast.LENGTH_SHORT).show();
            // result.setText("Custome Text2");

        }
        if(centimeterCalcresult % 1 == 0)
        {
            // Toast.makeText(MainActivity.this,"No Float"+"\n", Toast.LENGTH_SHORT).show();
            //  CheckFloat = ;
            // Toast.makeText(MainActivity.this,"Showing"+"  " +  CheckFloat, Toast.LENGTH_SHORT).show();
            Double d = new Double(centimeterCalcresult);
            int i = d.intValue();
            //  Toast.makeText(MainActivity.this,"value of i"+" " + i+"", Toast.LENGTH_SHORT).show();
            centimeterresult.setText(i+ " ");



        }
        else
        {
            centimeterresult.setText(centimeterCalcresult+" ");
            // Toast.makeText(MainActivity.this,"Float"+"\n", Toast.LENGTH_SHORT).show();
            // result.setText("Custome Text2");

        }
        if(mileCalcresult % 1 == 0)
        {
            // Toast.makeText(MainActivity.this,"No Float"+"\n", Toast.LENGTH_SHORT).show();
            //  CheckFloat = ;
            // Toast.makeText(MainActivity.this,"Showing"+"  " +  CheckFloat, Toast.LENGTH_SHORT).show();
            Double d = new Double(mileCalcresult);
            int i = d.intValue();
            //  Toast.makeText(MainActivity.this,"value of i"+" " + i+"", Toast.LENGTH_SHORT).show();
            mileresult.setText(i+ " ");



        }
        else
        {
            mileresult.setText(mileCalcresult+" ");
            // Toast.makeText(MainActivity.this,"Float"+"\n", Toast.LENGTH_SHORT).show();
            // result.setText("Custome Text2");

        }
        if(inchCalcresult % 1 == 0)
        {
            // Toast.makeText(MainActivity.this,"No Float"+"\n", Toast.LENGTH_SHORT).show();
            //  CheckFloat = ;
            // Toast.makeText(MainActivity.this,"Showing"+"  " +  CheckFloat, Toast.LENGTH_SHORT).show();
            Double d = new Double(inchCalcresult);
            int i = d.intValue();
            //  Toast.makeText(MainActivity.this,"value of i"+" " + i+"", Toast.LENGTH_SHORT).show();
            inchresult.setText(i+ " ");



        }
        else
        {
            inchresult.setText(inchCalcresult+" ");
            // Toast.makeText(MainActivity.this,"Float"+"\n", Toast.LENGTH_SHORT).show();
            // result.setText("Custome Text2");

        }
        if(monthCalcresult % 1 == 0)
        {
            // Toast.makeText(MainActivity.this,"No Float"+"\n", Toast.LENGTH_SHORT).show();
            //  CheckFloat = ;
            // Toast.makeText(MainActivity.this,"Showing"+"  " +  CheckFloat, Toast.LENGTH_SHORT).show();
            Double d = new Double(monthCalcresult);
            int i = d.intValue();
            //  Toast.makeText(MainActivity.this,"value of i"+" " + i+"", Toast.LENGTH_SHORT).show();
            monthresult.setText(i+ " ");



        }
        else
        {
            monthresult.setText(monthCalcresult+" ");
            // Toast.makeText(MainActivity.this,"Float"+"\n", Toast.LENGTH_SHORT).show();
            // result.setText("Custome Text2");

        }
    }
    public  void KiolometerValues(double reValue)
    {
     //   result.setText(" ");
        meterCalcresult = reValue / 60;
        kilometerCalcresult = reValue * 1;
        centimeterCalcresult =reValue / 604800;
        mileCalcresult= reValue / 3600;
        inchCalcresult=reValue / 86400;
        monthCalcresult= reValue /2629800;


//        meterresult.setText(meterCalcresult+" ");
//        kilometerresult.setText(kilometerCalcresult+" ");
//        centimeterresult.setText(centimeterCalcresult+" ");
//        mileresult.setText(mileCalcresult+" ");
//        inchresult.setText(inchCalcresult+" ");
//        monthresult.setText(monthCalcresult+" ");
        if(meterCalcresult % 1 == 0)
        {
            // Toast.makeText(MainActivity.this,"No Float"+"\n", Toast.LENGTH_SHORT).show();
            //  CheckFloat = ;
            // Toast.makeText(MainActivity.this,"Showing"+"  " +  CheckFloat, Toast.LENGTH_SHORT).show();
            Double d = new Double(meterCalcresult);
            int i = d.intValue();
            //  Toast.makeText(MainActivity.this,"value of i"+" " + i+"", Toast.LENGTH_SHORT).show();
            meterresult.setText(i+ " ");



        }
        else
        {
            meterresult.setText(meterCalcresult+" ");
            // Toast.makeText(MainActivity.this,"Float"+"\n", Toast.LENGTH_SHORT).show();
            // result.setText("Custome Text2");

        }
        if(kilometerCalcresult % 1 == 0)
        {
            // Toast.makeText(MainActivity.this,"No Float"+"\n", Toast.LENGTH_SHORT).show();
            //  CheckFloat = ;
            // Toast.makeText(MainActivity.this,"Showing"+"  " +  CheckFloat, Toast.LENGTH_SHORT).show();
            Double d = new Double(kilometerCalcresult);
            int i = d.intValue();
            //  Toast.makeText(MainActivity.this,"value of i"+" " + i+"", Toast.LENGTH_SHORT).show();
            kilometerresult.setText(i+ " ");



        }
        else
        {
            kilometerresult.setText(kilometerCalcresult+" ");
            // Toast.makeText(MainActivity.this,"Float"+"\n", Toast.LENGTH_SHORT).show();
            // result.setText("Custome Text2");

        }
        if(centimeterCalcresult % 1 == 0)
        {
            // Toast.makeText(MainActivity.this,"No Float"+"\n", Toast.LENGTH_SHORT).show();
            //  CheckFloat = ;
            // Toast.makeText(MainActivity.this,"Showing"+"  " +  CheckFloat, Toast.LENGTH_SHORT).show();
            Double d = new Double(centimeterCalcresult);
            int i = d.intValue();
            //  Toast.makeText(MainActivity.this,"value of i"+" " + i+"", Toast.LENGTH_SHORT).show();
            centimeterresult.setText(i+ " ");



        }
        else
        {
            centimeterresult.setText(centimeterCalcresult+" ");
            // Toast.makeText(MainActivity.this,"Float"+"\n", Toast.LENGTH_SHORT).show();
            // result.setText("Custome Text2");

        }
        if(mileCalcresult % 1 == 0)
        {
            // Toast.makeText(MainActivity.this,"No Float"+"\n", Toast.LENGTH_SHORT).show();
            //  CheckFloat = ;
            // Toast.makeText(MainActivity.this,"Showing"+"  " +  CheckFloat, Toast.LENGTH_SHORT).show();
            Double d = new Double(mileCalcresult);
            int i = d.intValue();
            //  Toast.makeText(MainActivity.this,"value of i"+" " + i+"", Toast.LENGTH_SHORT).show();
            mileresult.setText(i+ " ");



        }
        else
        {
            mileresult.setText(mileCalcresult+" ");
            // Toast.makeText(MainActivity.this,"Float"+"\n", Toast.LENGTH_SHORT).show();
            // result.setText("Custome Text2");

        }
        if(inchCalcresult % 1 == 0)
        {
            // Toast.makeText(MainActivity.this,"No Float"+"\n", Toast.LENGTH_SHORT).show();
            //  CheckFloat = ;
            // Toast.makeText(MainActivity.this,"Showing"+"  " +  CheckFloat, Toast.LENGTH_SHORT).show();
            Double d = new Double(inchCalcresult);
            int i = d.intValue();
            //  Toast.makeText(MainActivity.this,"value of i"+" " + i+"", Toast.LENGTH_SHORT).show();
            inchresult.setText(i+ " ");



        }
        else
        {
            inchresult.setText(inchCalcresult+" ");
            // Toast.makeText(MainActivity.this,"Float"+"\n", Toast.LENGTH_SHORT).show();
            // result.setText("Custome Text2");

        }
        if(monthCalcresult % 1 == 0)
        {
            // Toast.makeText(MainActivity.this,"No Float"+"\n", Toast.LENGTH_SHORT).show();
            //  CheckFloat = ;
            // Toast.makeText(MainActivity.this,"Showing"+"  " +  CheckFloat, Toast.LENGTH_SHORT).show();
            Double d = new Double(monthCalcresult);
            int i = d.intValue();
            //  Toast.makeText(MainActivity.this,"value of i"+" " + i+"", Toast.LENGTH_SHORT).show();
            monthresult.setText(i+ " ");



        }
        else
        {
            monthresult.setText(monthCalcresult+" ");
            // Toast.makeText(MainActivity.this,"Float"+"\n", Toast.LENGTH_SHORT).show();
            // result.setText("Custome Text2");

        }

    }
    public  void MileValues(double reValue)
    {
    //    result.setText(" ");
        meterCalcresult = reValue * 60;
        kilometerCalcresult = reValue * 3600;
        centimeterCalcresult =reValue /168;
        mileCalcresult= reValue * 1;
        inchCalcresult=reValue / 24;
        monthCalcresult= reValue / 730.5;


//        meterresult.setText(meterCalcresult+" ");
//        kilometerresult.setText(kilometerCalcresult+" ");
//        centimeterresult.setText(centimeterCalcresult+" ");
//        mileresult.setText(mileCalcresult+" ");
//        inchresult.setText(inchCalcresult+" ");
//        monthresult.setText(monthCalcresult+"");
        if(meterCalcresult % 1 == 0)
        {
            // Toast.makeText(MainActivity.this,"No Float"+"\n", Toast.LENGTH_SHORT).show();
            //  CheckFloat = ;
            // Toast.makeText(MainActivity.this,"Showing"+"  " +  CheckFloat, Toast.LENGTH_SHORT).show();
            Double d = new Double(meterCalcresult);
            int i = d.intValue();
            //  Toast.makeText(MainActivity.this,"value of i"+" " + i+"", Toast.LENGTH_SHORT).show();
            meterresult.setText(i+ " ");



        }
        else
        {
            meterresult.setText(meterCalcresult+" ");
            // Toast.makeText(MainActivity.this,"Float"+"\n", Toast.LENGTH_SHORT).show();
            // result.setText("Custome Text2");

        }
        if(kilometerCalcresult % 1 == 0)
        {
            // Toast.makeText(MainActivity.this,"No Float"+"\n", Toast.LENGTH_SHORT).show();
            //  CheckFloat = ;
            // Toast.makeText(MainActivity.this,"Showing"+"  " +  CheckFloat, Toast.LENGTH_SHORT).show();
            Double d = new Double(kilometerCalcresult);
            int i = d.intValue();
            //  Toast.makeText(MainActivity.this,"value of i"+" " + i+"", Toast.LENGTH_SHORT).show();
            kilometerresult.setText(i+ " ");



        }
        else
        {
            kilometerresult.setText(kilometerCalcresult+" ");
            // Toast.makeText(MainActivity.this,"Float"+"\n", Toast.LENGTH_SHORT).show();
            // result.setText("Custome Text2");

        }
        if(centimeterCalcresult % 1 == 0)
        {
            // Toast.makeText(MainActivity.this,"No Float"+"\n", Toast.LENGTH_SHORT).show();
            //  CheckFloat = ;
            // Toast.makeText(MainActivity.this,"Showing"+"  " +  CheckFloat, Toast.LENGTH_SHORT).show();
            Double d = new Double(centimeterCalcresult);
            int i = d.intValue();
            //  Toast.makeText(MainActivity.this,"value of i"+" " + i+"", Toast.LENGTH_SHORT).show();
            centimeterresult.setText(i+ " ");



        }
        else
        {
            centimeterresult.setText(centimeterCalcresult+" ");
            // Toast.makeText(MainActivity.this,"Float"+"\n", Toast.LENGTH_SHORT).show();
            // result.setText("Custome Text2");

        }
        if(mileCalcresult % 1 == 0)
        {
            // Toast.makeText(MainActivity.this,"No Float"+"\n", Toast.LENGTH_SHORT).show();
            //  CheckFloat = ;
            // Toast.makeText(MainActivity.this,"Showing"+"  " +  CheckFloat, Toast.LENGTH_SHORT).show();
            Double d = new Double(mileCalcresult);
            int i = d.intValue();
            //  Toast.makeText(MainActivity.this,"value of i"+" " + i+"", Toast.LENGTH_SHORT).show();
            mileresult.setText(i+ " ");



        }
        else
        {
            mileresult.setText(mileCalcresult+" ");
            // Toast.makeText(MainActivity.this,"Float"+"\n", Toast.LENGTH_SHORT).show();
            // result.setText("Custome Text2");

        }
        if(inchCalcresult % 1 == 0)
        {
            // Toast.makeText(MainActivity.this,"No Float"+"\n", Toast.LENGTH_SHORT).show();
            //  CheckFloat = ;
            // Toast.makeText(MainActivity.this,"Showing"+"  " +  CheckFloat, Toast.LENGTH_SHORT).show();
            Double d = new Double(inchCalcresult);
            int i = d.intValue();
            //  Toast.makeText(MainActivity.this,"value of i"+" " + i+"", Toast.LENGTH_SHORT).show();
            inchresult.setText(i+ " ");



        }
        else
        {
            inchresult.setText(inchCalcresult+" ");
            // Toast.makeText(MainActivity.this,"Float"+"\n", Toast.LENGTH_SHORT).show();
            // result.setText("Custome Text2");

        }
        if(monthCalcresult % 1 == 0)
        {
            // Toast.makeText(MainActivity.this,"No Float"+"\n", Toast.LENGTH_SHORT).show();
            //  CheckFloat = ;
            // Toast.makeText(MainActivity.this,"Showing"+"  " +  CheckFloat, Toast.LENGTH_SHORT).show();
            Double d = new Double(monthCalcresult);
            int i = d.intValue();
            //  Toast.makeText(MainActivity.this,"value of i"+" " + i+"", Toast.LENGTH_SHORT).show();
            monthresult.setText(i+ " ");



        }
        else
        {
            monthresult.setText(monthCalcresult+" ");
            // Toast.makeText(MainActivity.this,"Float"+"\n", Toast.LENGTH_SHORT).show();
            // result.setText("Custome Text2");

        }


    }
    public  void InchValues(double reValue)
    {
     //   result.setText(" ");
        meterCalcresult = reValue * 1440 ;
        kilometerCalcresult = reValue * 86400 ;
        centimeterCalcresult =reValue / 7 ;
        mileCalcresult= reValue * 24  ;
        inchCalcresult=reValue * 1 ;
        monthCalcresult= reValue * 0.0328767;


//        meterresult.setText(meterCalcresult+" ");
//        kilometerresult.setText(kilometerCalcresult+" ");
//        centimeterresult.setText(centimeterCalcresult+" ");
//        mileresult.setText(mileCalcresult+" ");
//        inchresult.setText(inchCalcresult+" ");
//        monthresult.setText(monthCalcresult+"");
        if(meterCalcresult % 1 == 0)
        {
            // Toast.makeText(MainActivity.this,"No Float"+"\n", Toast.LENGTH_SHORT).show();
            //  CheckFloat = ;
            // Toast.makeText(MainActivity.this,"Showing"+"  " +  CheckFloat, Toast.LENGTH_SHORT).show();
            Double d = new Double(meterCalcresult);
            int i = d.intValue();
            //  Toast.makeText(MainActivity.this,"value of i"+" " + i+"", Toast.LENGTH_SHORT).show();
            meterresult.setText(i+ " ");



        }
        else
        {
            meterresult.setText(meterCalcresult+" ");
            // Toast.makeText(MainActivity.this,"Float"+"\n", Toast.LENGTH_SHORT).show();
            // result.setText("Custome Text2");

        }
        if(kilometerCalcresult % 1 == 0)
        {
            // Toast.makeText(MainActivity.this,"No Float"+"\n", Toast.LENGTH_SHORT).show();
            //  CheckFloat = ;
            // Toast.makeText(MainActivity.this,"Showing"+"  " +  CheckFloat, Toast.LENGTH_SHORT).show();
            Double d = new Double(kilometerCalcresult);
            int i = d.intValue();
            //  Toast.makeText(MainActivity.this,"value of i"+" " + i+"", Toast.LENGTH_SHORT).show();
            kilometerresult.setText(i+ " ");



        }
        else
        {
            kilometerresult.setText(kilometerCalcresult+" ");
            // Toast.makeText(MainActivity.this,"Float"+"\n", Toast.LENGTH_SHORT).show();
            // result.setText("Custome Text2");

        }
        if(centimeterCalcresult % 1 == 0)
        {
            // Toast.makeText(MainActivity.this,"No Float"+"\n", Toast.LENGTH_SHORT).show();
            //  CheckFloat = ;
            // Toast.makeText(MainActivity.this,"Showing"+"  " +  CheckFloat, Toast.LENGTH_SHORT).show();
            Double d = new Double(centimeterCalcresult);
            int i = d.intValue();
            //  Toast.makeText(MainActivity.this,"value of i"+" " + i+"", Toast.LENGTH_SHORT).show();
            centimeterresult.setText(i+ " ");



        }
        else
        {
            centimeterresult.setText(centimeterCalcresult+" ");
            // Toast.makeText(MainActivity.this,"Float"+"\n", Toast.LENGTH_SHORT).show();
            // result.setText("Custome Text2");

        }
        if(mileCalcresult % 1 == 0)
        {
            // Toast.makeText(MainActivity.this,"No Float"+"\n", Toast.LENGTH_SHORT).show();
            //  CheckFloat = ;
            // Toast.makeText(MainActivity.this,"Showing"+"  " +  CheckFloat, Toast.LENGTH_SHORT).show();
            Double d = new Double(mileCalcresult);
            int i = d.intValue();
            //  Toast.makeText(MainActivity.this,"value of i"+" " + i+"", Toast.LENGTH_SHORT).show();
            mileresult.setText(i+ " ");



        }
        else
        {
            mileresult.setText(mileCalcresult+" ");
            // Toast.makeText(MainActivity.this,"Float"+"\n", Toast.LENGTH_SHORT).show();
            // result.setText("Custome Text2");

        }
        if(inchCalcresult % 1 == 0)
        {
            // Toast.makeText(MainActivity.this,"No Float"+"\n", Toast.LENGTH_SHORT).show();
            //  CheckFloat = ;
            // Toast.makeText(MainActivity.this,"Showing"+"  " +  CheckFloat, Toast.LENGTH_SHORT).show();
            Double d = new Double(inchCalcresult);
            int i = d.intValue();
            //  Toast.makeText(MainActivity.this,"value of i"+" " + i+"", Toast.LENGTH_SHORT).show();
            inchresult.setText(i+ " ");



        }
        else
        {
            inchresult.setText(inchCalcresult+" ");
            // Toast.makeText(MainActivity.this,"Float"+"\n", Toast.LENGTH_SHORT).show();
            // result.setText("Custome Text2");

        }
        if(monthCalcresult % 1 == 0)
        {
            // Toast.makeText(MainActivity.this,"No Float"+"\n", Toast.LENGTH_SHORT).show();
            //  CheckFloat = ;
            // Toast.makeText(MainActivity.this,"Showing"+"  " +  CheckFloat, Toast.LENGTH_SHORT).show();
            Double d = new Double(monthCalcresult);
            int i = d.intValue();
            //  Toast.makeText(MainActivity.this,"value of i"+" " + i+"", Toast.LENGTH_SHORT).show();
            monthresult.setText(i+ " ");



        }
        else
        {
            monthresult.setText(monthCalcresult+" ");
            // Toast.makeText(MainActivity.this,"Float"+"\n", Toast.LENGTH_SHORT).show();
            // result.setText("Custome Text2");

        }


    }
    public  void CentimeterValues(double reValue)
    {
      //  result.setText(" ");
        meterCalcresult = reValue * 10080;
        kilometerCalcresult = reValue * 604800;
        centimeterCalcresult =reValue * 1;
        mileCalcresult= reValue * 168 ;
        inchCalcresult=reValue * 7 ;
        monthCalcresult= reValue * 0.2299794661;


//        meterresult.setText(meterCalcresult+" ");
//        kilometerresult.setText(kilometerCalcresult+" ");
//        centimeterresult.setText(centimeterCalcresult+" ");
//        mileresult.setText(mileCalcresult+" ");
//        inchresult.setText(inchCalcresult+" ");
//        monthresult.setText(monthCalcresult+"");
        if(meterCalcresult % 1 == 0)
        {
            // Toast.makeText(MainActivity.this,"No Float"+"\n", Toast.LENGTH_SHORT).show();
            //  CheckFloat = ;
            // Toast.makeText(MainActivity.this,"Showing"+"  " +  CheckFloat, Toast.LENGTH_SHORT).show();
            Double d = new Double(meterCalcresult);
            int i = d.intValue();
            //  Toast.makeText(MainActivity.this,"value of i"+" " + i+"", Toast.LENGTH_SHORT).show();
            meterresult.setText(i+ " ");



        }
        else
        {
            meterresult.setText(meterCalcresult+" ");
            // Toast.makeText(MainActivity.this,"Float"+"\n", Toast.LENGTH_SHORT).show();
            // result.setText("Custome Text2");

        }
        if(kilometerCalcresult % 1 == 0)
        {
            // Toast.makeText(MainActivity.this,"No Float"+"\n", Toast.LENGTH_SHORT).show();
            //  CheckFloat = ;
            // Toast.makeText(MainActivity.this,"Showing"+"  " +  CheckFloat, Toast.LENGTH_SHORT).show();
            Double d = new Double(kilometerCalcresult);
            int i = d.intValue();
            //  Toast.makeText(MainActivity.this,"value of i"+" " + i+"", Toast.LENGTH_SHORT).show();
            kilometerresult.setText(i+ " ");



        }
        else
        {
            kilometerresult.setText(kilometerCalcresult+" ");
            // Toast.makeText(MainActivity.this,"Float"+"\n", Toast.LENGTH_SHORT).show();
            // result.setText("Custome Text2");

        }
        if(centimeterCalcresult % 1 == 0)
        {
            // Toast.makeText(MainActivity.this,"No Float"+"\n", Toast.LENGTH_SHORT).show();
            //  CheckFloat = ;
            // Toast.makeText(MainActivity.this,"Showing"+"  " +  CheckFloat, Toast.LENGTH_SHORT).show();
            Double d = new Double(centimeterCalcresult);
            int i = d.intValue();
            //  Toast.makeText(MainActivity.this,"value of i"+" " + i+"", Toast.LENGTH_SHORT).show();
            centimeterresult.setText(i+ " ");



        }
        else
        {
            centimeterresult.setText(centimeterCalcresult+" ");
            // Toast.makeText(MainActivity.this,"Float"+"\n", Toast.LENGTH_SHORT).show();
            // result.setText("Custome Text2");

        }
        if(mileCalcresult % 1 == 0)
        {
            // Toast.makeText(MainActivity.this,"No Float"+"\n", Toast.LENGTH_SHORT).show();
            //  CheckFloat = ;
            // Toast.makeText(MainActivity.this,"Showing"+"  " +  CheckFloat, Toast.LENGTH_SHORT).show();
            Double d = new Double(mileCalcresult);
            int i = d.intValue();
            //  Toast.makeText(MainActivity.this,"value of i"+" " + i+"", Toast.LENGTH_SHORT).show();
            mileresult.setText(i+ " ");



        }
        else
        {
            mileresult.setText(mileCalcresult+" ");
            // Toast.makeText(MainActivity.this,"Float"+"\n", Toast.LENGTH_SHORT).show();
            // result.setText("Custome Text2");

        }
        if(inchCalcresult % 1 == 0)
        {
            // Toast.makeText(MainActivity.this,"No Float"+"\n", Toast.LENGTH_SHORT).show();
            //  CheckFloat = ;
            // Toast.makeText(MainActivity.this,"Showing"+"  " +  CheckFloat, Toast.LENGTH_SHORT).show();
            Double d = new Double(inchCalcresult);
            int i = d.intValue();
            //  Toast.makeText(MainActivity.this,"value of i"+" " + i+"", Toast.LENGTH_SHORT).show();
            inchresult.setText(i+ " ");



        }
        else
        {
            inchresult.setText(inchCalcresult+" ");
            // Toast.makeText(MainActivity.this,"Float"+"\n", Toast.LENGTH_SHORT).show();
            // result.setText("Custome Text2");

        }
        if(monthCalcresult % 1 == 0)
        {
            // Toast.makeText(MainActivity.this,"No Float"+"\n", Toast.LENGTH_SHORT).show();
            //  CheckFloat = ;
            // Toast.makeText(MainActivity.this,"Showing"+"  " +  CheckFloat, Toast.LENGTH_SHORT).show();
            Double d = new Double(monthCalcresult);
            int i = d.intValue();
            //  Toast.makeText(MainActivity.this,"value of i"+" " + i+"", Toast.LENGTH_SHORT).show();
            monthresult.setText(i+ " ");



        }
        else
        {
            monthresult.setText(monthCalcresult+" ");
            // Toast.makeText(MainActivity.this,"Float"+"\n", Toast.LENGTH_SHORT).show();
            // result.setText("Custome Text2");

        }

    }
    public  void MonthValues(double reValue)
    {
    //    result.setText(" ");
        meterCalcresult = reValue * 43830;
        kilometerCalcresult = reValue * 2629800;
        centimeterCalcresult =reValue * 4.3482142857;
        mileCalcresult= reValue * 730.5 ;
        inchCalcresult=reValue * 30.4167;
        monthCalcresult= reValue * 1;

//
//        meterresult.setText(meterCalcresult+" ");
//        kilometerresult.setText(kilometerCalcresult+" ");
//        centimeterresult.setText(centimeterCalcresult+" ");
//        mileresult.setText(mileCalcresult+" ");
//        inchresult.setText(inchCalcresult+" ");
//        monthresult.setText(monthCalcresult+"");
        if(meterCalcresult % 1 == 0)
        {
            // Toast.makeText(MainActivity.this,"No Float"+"\n", Toast.LENGTH_SHORT).show();
            //  CheckFloat = ;
            // Toast.makeText(MainActivity.this,"Showing"+"  " +  CheckFloat, Toast.LENGTH_SHORT).show();
            Double d = new Double(meterCalcresult);
            int i = d.intValue();
            //  Toast.makeText(MainActivity.this,"value of i"+" " + i+"", Toast.LENGTH_SHORT).show();
            meterresult.setText(i+ " ");



        }
        else
        {
            meterresult.setText(meterCalcresult+" ");
            // Toast.makeText(MainActivity.this,"Float"+"\n", Toast.LENGTH_SHORT).show();
            // result.setText("Custome Text2");

        }
        if(kilometerCalcresult % 1 == 0)
        {
            // Toast.makeText(MainActivity.this,"No Float"+"\n", Toast.LENGTH_SHORT).show();
            //  CheckFloat = ;
            // Toast.makeText(MainActivity.this,"Showing"+"  " +  CheckFloat, Toast.LENGTH_SHORT).show();
            Double d = new Double(kilometerCalcresult);
            int i = d.intValue();
            //  Toast.makeText(MainActivity.this,"value of i"+" " + i+"", Toast.LENGTH_SHORT).show();
            kilometerresult.setText(i+ " ");



        }
        else
        {
            kilometerresult.setText(kilometerCalcresult+" ");
            // Toast.makeText(MainActivity.this,"Float"+"\n", Toast.LENGTH_SHORT).show();
            // result.setText("Custome Text2");

        }
        if(centimeterCalcresult % 1 == 0)
        {
            // Toast.makeText(MainActivity.this,"No Float"+"\n", Toast.LENGTH_SHORT).show();
            //  CheckFloat = ;
            // Toast.makeText(MainActivity.this,"Showing"+"  " +  CheckFloat, Toast.LENGTH_SHORT).show();
            Double d = new Double(centimeterCalcresult);
            int i = d.intValue();
            //  Toast.makeText(MainActivity.this,"value of i"+" " + i+"", Toast.LENGTH_SHORT).show();
            centimeterresult.setText(i+ " ");



        }
        else
        {
            centimeterresult.setText(centimeterCalcresult+" ");
            // Toast.makeText(MainActivity.this,"Float"+"\n", Toast.LENGTH_SHORT).show();
            // result.setText("Custome Text2");

        }
        if(mileCalcresult % 1 == 0)
        {
            // Toast.makeText(MainActivity.this,"No Float"+"\n", Toast.LENGTH_SHORT).show();
            //  CheckFloat = ;
            // Toast.makeText(MainActivity.this,"Showing"+"  " +  CheckFloat, Toast.LENGTH_SHORT).show();
            Double d = new Double(mileCalcresult);
            int i = d.intValue();
            //  Toast.makeText(MainActivity.this,"value of i"+" " + i+"", Toast.LENGTH_SHORT).show();
            mileresult.setText(i+ " ");



        }
        else
        {
            mileresult.setText(mileCalcresult+" ");
            // Toast.makeText(MainActivity.this,"Float"+"\n", Toast.LENGTH_SHORT).show();
            // result.setText("Custome Text2");

        }
        if(inchCalcresult % 1 == 0)
        {
            // Toast.makeText(MainActivity.this,"No Float"+"\n", Toast.LENGTH_SHORT).show();
            //  CheckFloat = ;
            // Toast.makeText(MainActivity.this,"Showing"+"  " +  CheckFloat, Toast.LENGTH_SHORT).show();
            Double d = new Double(inchCalcresult);
            int i = d.intValue();
            //  Toast.makeText(MainActivity.this,"value of i"+" " + i+"", Toast.LENGTH_SHORT).show();
            inchresult.setText(i+ " ");



        }
        else
        {
            inchresult.setText(inchCalcresult+" ");
            // Toast.makeText(MainActivity.this,"Float"+"\n", Toast.LENGTH_SHORT).show();
            // result.setText("Custome Text2");

        }
        if(monthCalcresult % 1 == 0)
        {
            // Toast.makeText(MainActivity.this,"No Float"+"\n", Toast.LENGTH_SHORT).show();
            //  CheckFloat = ;
            // Toast.makeText(MainActivity.this,"Showing"+"  " +  CheckFloat, Toast.LENGTH_SHORT).show();
            Double d = new Double(monthCalcresult);
            int i = d.intValue();
            //  Toast.makeText(MainActivity.this,"value of i"+" " + i+"", Toast.LENGTH_SHORT).show();
            monthresult.setText(i+ " ");



        }
        else
        {
            monthresult.setText(monthCalcresult+" ");
            // Toast.makeText(MainActivity.this,"Float"+"\n", Toast.LENGTH_SHORT).show();
            // result.setText("Custome Text2");

        }

    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

    }

//    @Override
//    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
//        inflater.inflate(R.menu.menu_main, menu);
//
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//        if (id == R.id.aboutus)
//        {
//            AboutUs();
//            return true;
//        }
//
//        if (id == R.id.aboutapp)
//        {
//            AboutAPP();
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
    //    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//       getActivity().getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.aboutus)
//        {
//            AboutUs();
//            return true;
//        }
//
//        if (id == R.id.aboutapp)
//        {
//            AboutAPP();
//            return true;
//        }
//
//
//        return super.onOptionsItemSelected(item);
//    }


    public  void spinnerCall()
    {
        time();

//        from.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
//                // Toast.makeText(Conversion_Of_Speed.this, spinner11.getSelectedItem()+"", Toast.LENGTH_SHORT).show();
//                final String spinervalue =  from.getSelectedItem().toString();
//                switch (spinervalue){
//                    case "MeterValues":
//                        MeterValues(re);
//                        break;
//                    case "Temperature":
//                        temperature();
//                        break;
//                    case "Weight":
//                        weight();
//                        break;
//                    case "Time":
//                        time();
//                        break;
//                    case "Area":
//                        area();
//                        break;
//                    case "Volume":
//                        volume();
//                        break;
//                }
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parentView) {
//                // your code here
//            }
//
//        });
    }

    public void area(){
        froms =new String[] {"Square Kilometer", "Square Meter" ,"Square Centimeter"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),R.layout.spinner_custom,froms);
        from.setAdapter(adapter);
        to.setAdapter(adapter);
    }

    public void volume(){
        froms =new String[] {"Liter", "Milliliter" ,"US Gallon","Imperial Gallon"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),R.layout.spinner_custom,froms);
        from.setAdapter(adapter);
        to.setAdapter(adapter);
    }

    public void temperature(){
        froms = new String[]{"Celcius", "kelvin", "Fahrenheit"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),R.layout.spinner_custom,froms);
        from.setAdapter(adapter);
        to.setAdapter(adapter);



    }
    public void lenth(){
        froms = new String[]{"Meter" ,"kilometer" ,"Centimeter" , "Mile" ,"Inch"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),R.layout.spinner_custom,froms);
        from.setAdapter(adapter);
        //  to.setAdapter(adapter);
    }
    //    public void area(){
//         froms = new String[] {"Square Meter" ,"Square kilometer" ,"Square Centimeter" , "Square Mile" ,"Square Inch"};
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,froms);
//        from.setAdapter(adapter);
//        to.setAdapter(adapter);
//    }
//    public void volume(){
//         froms = new String[]{"Cubic Meter" ,"Cubic kilometer" ,"Cubic Centimeter" };
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,froms);
//        from.setAdapter(adapter);
//        to.setAdapter(adapter);
    // }
    public void weight(){
        froms =new String[] {"Kilogram" ,"Gram" ,"Milligram" , "Pound" , "Ounce"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),R.layout.spinner_custom,froms);
        from.setAdapter(adapter);
        to.setAdapter(adapter);
    }
    public void time(){
        froms = new String[] {"Second"  , "Minute" , "Hour" , "Day" , "Week" ,"Month"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),R.layout.spinner_custom,froms);
        from.setAdapter(adapter);


    }

    public void CheckFloat(double ress1)
    {



        if(ress1 % 1 == 0)
        {
            // Toast.makeText(MainActivity.this,"No Float"+"\n", Toast.LENGTH_SHORT).show();
            //  CheckFloat = ;
            // Toast.makeText(MainActivity.this,"Showing"+"  " +  CheckFloat, Toast.LENGTH_SHORT).show();
            Double d = new Double(ress1);
            int i = d.intValue();
            //  Toast.makeText(MainActivity.this,"value of i"+" " + i+"", Toast.LENGTH_SHORT).show();
     //       result.setText(i+" " +" "+t+"");
            if(ress1 <=1 )
            {
             //   result.setText(i + "  " + t);
            }
            else
            {
               // result.setText(i+ "  " + t + "(s)");
            }


        }
        else
        {
            // Toast.makeText(MainActivity.this,"Float"+"\n", Toast.LENGTH_SHORT).show();
            // result.setText("Custome Text2");
            if(ress1 <=1 )
            {
               // result.setText(ress1 + "  " + t);
            }
            else if(ress1 >1)
            {
              //  result.setText(ress1 + "  " + t+"(s)");
            }
        }


    }
   /* public void setenable(){
        from.setEnabled(true);
        to.setEnabled(true);
        value.setEnabled(true);
        result.setEnabled(true);
        enterresult.setEnabled(true);
        tex2.setEnabled(true);
        text3.setEnabled(true);
        text4.setEnabled(true);
        text5.setEnabled(true);

    }
    public void setdisable(){

        from.setEnabled(false);
        to.setEnabled(false);
        value.setEnabled(false);
        result.setEnabled(false);
        enterresult.setEnabled(false);
        tex2.setEnabled(false);
        text3.setEnabled(false);
        text4.setEnabled(false);
        text5.setEnabled(false);
    }*/



/*    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        if (id == R.id.aboutapp) {
            AboutAPP();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/




    public  void AboutUs()
    {




        AlertDialog alertDialog = new AlertDialog.Builder(getActivity()).create();
        alertDialog.setTitle("About US ");
        alertDialog.setIcon(R.drawable.dg);
        alertDialog.setMessage(" Why Digital Application? Digital Application’s Plans and Price has no hidden charges." +
                "We have all-inclusive prices and unbeatable value.\n  Other Companies promise to provide cheap solutions," +
                "but they charge extra as setup fees or higher renewal rates, or some hidden charges.");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

    public  void AboutAPP()
    {




        AlertDialog alertDialog1 = new AlertDialog.Builder(getActivity()).create();
        alertDialog1.setTitle("About App");
        alertDialog1.setIcon(R.drawable.logocamp);
        alertDialog1.setMessage("Unit Converter is a simple,fast and easy application that allows you to convert any number into another unit number anytime.\n   This application has friendly user interface with display messages so that user enter correct value according to the standard format.\n");
        alertDialog1.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog1.show();
    }

//    public void resetBtn(View view) {
//        result.setText(" ");
//        value.setText("");
//        Toast.makeText(getActivity(),"Refreshed"+"\n", Toast.LENGTH_SHORT).show();
//    }

//    //Program exist on back button
//    @Override
//    public void onBackPressed() {
//        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
//        alertDialogBuilder.setTitle("Exit Unit Converter Application?");
//        alertDialogBuilder.setIcon(R.drawable.cancel);
//        alertDialogBuilder
//                .setMessage("         Do you want to Exist?")
//                .setCancelable(false)
//                .setPositiveButton("Yes",
//                        new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog, int id) {
//                                moveTaskToBack(true);
//                                android.os.Process.killProcess(android.os.Process.myPid());
//                              //  finish();
//                                System.exit(1);
//                            }
//                        })
//
//                .setNegativeButton("No", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//
//                        dialog.cancel();
//                    }
//                });
//
//        AlertDialog alertDialog = alertDialogBuilder.create();
//        alertDialog.show();
//    }
}
