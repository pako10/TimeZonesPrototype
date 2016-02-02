package com.example.pakoandrade.timezonesprototype;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.format.Time;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText textViewDay;
    EditText textViewMonth;
    EditText textViewYear;
    EditText textViewTime;
    EditText textViewTimeZome;
    EditText textViewGmt;
    EditText textViewMeridiano;
    EditText textViewVerano;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        textViewDay = (EditText) findViewById(R.id.etDia);
        textViewMonth = (EditText) findViewById(R.id.etMes);
        textViewYear = (EditText) findViewById(R.id.etAño);
        textViewTime = (EditText) findViewById(R.id.etHora);
        textViewTimeZome = (EditText) findViewById(R.id.etZonaHoraria);
        textViewGmt = (EditText) findViewById(R.id.etGmt);
        textViewMeridiano = (EditText) findViewById(R.id.etMeridiano);
        textViewVerano = (EditText) findViewById(R.id.etVerano);
        Button btRevisar = (Button) findViewById(R.id.btRevisar);

        btRevisar.setOnClickListener(new Button.OnClickListener(){
            @Override
        public void onClick(View v){
                obtenerZonaHoraria();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void obtenerZonaHoraria(){
        Time today = new Time(Time.getCurrentTimezone());
        today.setToNow();
        textViewDay.setText(today.monthDay + ""); //Dia del mes (1-31)
        textViewMonth.setText(today.month + ""); //mes ()0-11
        textViewYear.setText(today.year + ""); //Año
        textViewTime.setText(today.format("%k:%M:%S")); //Hora actual
        textViewTimeZome.setText(today.timezone + "");
        textViewGmt.setText(today.gmtoff/3600 + ""); //zona en meridiano de greenwich dividir resultado / 3600
        textViewVerano.setText(today.isDst + "");
        textViewMeridiano.setText(today.hour + today.gmtoff/3600 * -1 + ""  + ":"+ today.minute + "" + ":"+ today.second + "");
        if(today.isDst != 0){

        }

    }
    public void minuts(){

        Time today = new Time(Time.getCurrentTimezone());
        today.setToNow();
        if(today.minute < 10){
            textViewMeridiano.setText("0" + today.minute);
        }else{
            textViewMeridiano.setText(today.minute);
        }
    }
    //192.168.1.67:85/API/CALENDARIO
}



