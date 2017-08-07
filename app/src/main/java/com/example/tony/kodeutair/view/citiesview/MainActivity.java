package com.example.tony.kodeutair.view.citiesview;

import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tony.kodeutair.R;
import com.example.tony.kodeutair.view.weatherview.WeatherActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {


    final String THITHER_CITY = "thither";
    final String BACK_CITY = "back";
    @BindView(R.id.date_thither)
    TextView thitherDateTv;
    @BindView(R.id.date_back)
    TextView backDateTv;
    @BindView(R.id.thither_city_ll)
    LinearLayout firstCityLl;
    @BindView(R.id.thither_date_ll)
    LinearLayout thitherDateLl;
    @BindView(R.id.thither_city)
    TextView thitherCityTv;
    @BindView(R.id.back_city_name)
    TextView backCityTv;
    @BindView(R.id.back_date_button)
    Button backDateBtn;
    @BindView(R.id.back_date_ll)
    LinearLayout backDateLl;
    @BindView(R.id.value_adult_tv)
    TextView valueAdultTv;
    @BindView(R.id.value_kid_tv)
    TextView valueKidTv;
    @BindView(R.id.value_baby_tv)
    TextView valueBabyTv;

    int valueAdult = 1;
    int valueKid = 0;
    int valueBaby = 0;
    DatePickerDialog datePickerDialogThither;
    DatePickerDialog datePickerDialogBack;
    Calendar calendar;
    private String thitherCityName;
    private String backCityName;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.custom_toolbar_main);

        calendar = Calendar.getInstance();

        Intent intent = getIntent();


        if (intent != null) {
            String whereCity = intent.getStringExtra("whereCity");
            if (whereCity != null) {
                if (whereCity.equals("thither")) {
                    thitherCityName = intent.getStringExtra("nameCity");
                    saveNamesCity();
                    thitherCityTv.setText(thitherCityName);
                } else {
                    backCityName = intent.getStringExtra("nameCity");
                    saveNamesCity();
                    backCityTv.setText(backCityName);
                }
            }
        } else {
            thitherCityTv.setText("Калининград");
            backCityTv.setText("Москва");
        }
        loadNamesCity();
    }

    @OnClick(R.id.info_view_toolbar_main)
    public void showInfo(View view){
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle("Информация");
        alertDialog.setMessage("Приложение Utair");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Ок",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }



    @OnClick(R.id.thither_city_ll)
    public void transitionToSelection(View view) {
        Intent intent = new Intent(this, SelectionCityActivity.class);
        intent.putExtra("whereCity", "thither");
        startActivity(intent);
    }

    @OnClick(R.id.thither_date_ll)
    public void showDatePickerThither(View view) {
        datePickerDialogThither = new DatePickerDialog(
                MainActivity.this, MainActivity.this, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialogThither.show();
        datePickerDialogBack = null;
    }

    @OnClick(R.id.back_date_ll)
    public void showDatePickerBack(View view) {
        datePickerDialogBack = new DatePickerDialog(
                MainActivity.this, MainActivity.this, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialogBack.show();
        datePickerDialogThither = null;
    }


    @OnClick(R.id.back_invisible_btn)
    public void backInvisible(View view) {
        backDateLl.setVisibility(View.GONE);
        backDateBtn.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.back_city_ll)
    public void visibleBackDate(View view) {
        Intent intent = new Intent(this, SelectionCityActivity.class);
        intent.putExtra("whereCity", "back");
        startActivity(intent);
    }

    @OnClick(R.id.back_date_button)
    public void visibleBackDate(Button button) {
        backDateLl.setVisibility(View.VISIBLE);
        button.setVisibility(View.GONE);
    }

    @OnClick(R.id.next_weather_button)
    public void transitionWeather(Button button) {
        String cityThither = thitherCityTv.getText().toString();
        String cityBack = backCityTv.getText().toString();

        Intent intent = new Intent(this, WeatherActivity.class);
        intent.putExtra("cityThither", cityThither);
        intent.putExtra("cityBack", cityBack);
        startActivity(intent);
    }


    @OnClick(R.id.btn_add_adult)
    public void addValueAdult(Button button) {
        if (correctValuePassengers() == true) {
            valueAdult++;
            valueAdultTv.setText(String.valueOf(valueAdult));
        } else {

        }
    }

    @OnClick(R.id.trade_city_btn)
    public void tradeCities(View view) {
        String cityBack = backCityTv.getText().toString();
        String cityThither = thitherCityTv.getText().toString();

        backCityTv.setText(cityThither);
        thitherCityTv.setText(cityBack);

    }

    @OnClick(R.id.btn_delete_adult)
    public void deleteValueAdult(Button button) {
        valueAdult--;
        if (valueAdult < 1) {
            valueAdult++;
        } else {
            valueAdultTv.setText(String.valueOf(valueAdult));
        }
    }

    @OnClick(R.id.btn_add_kid)
    public void addValueKid(Button button) {

        if (correctValuePassengers() == true) {
            valueKid++;
            valueKidTv.setText(String.valueOf(valueKid));
        } else {

        }
    }

    @OnClick(R.id.btn_delete_kid)
    public void deleteValueKid(Button button) {
        valueKid--;
        if (valueKid < 0) {
            valueKid++;
        } else {
            valueKidTv.setText(String.valueOf(valueKid));
        }
    }

    @OnClick(R.id.btn_add_baby)
    public void addValueBaby(Button button) {
        if (valueAdult == valueBaby) {
            Toast.makeText(this, "Младенцев не должно быть больше, чем взрослых", Toast.LENGTH_LONG).show();
        } else {
            if (correctValuePassengers() == true) {
                valueBaby++;
                valueBabyTv.setText(String.valueOf(valueBaby));
            } else {
                Toast.makeText(this, "Пассажиров не может быть больше 9", Toast.LENGTH_LONG).show();
            }

        }
    }

    @OnClick(R.id.btn_delete_baby)
    public void deleteValutBaby(Button button) {
        valueBaby--;
        if (valueBaby < 0) {
            valueBaby++;

        } else {
            valueBabyTv.setText(String.valueOf(valueBaby));
        }
    }

    public boolean correctValuePassengers() {
        int valuePassengers = valueAdult + valueBaby + valueKid;
        if (valuePassengers == 9) { // dinamic magic
            Toast.makeText(this, "Пассажиров не может быть больше 9", Toast.LENGTH_LONG).show();
            return false;
        } else {
            return true;
        }
    }


    public void saveNamesCity() {
        sharedPreferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sharedPreferences.edit();
        if (thitherCityName != null) {
            ed.putString(THITHER_CITY, thitherCityName);
        } else if (backCityName != null) {
            ed.putString(BACK_CITY, backCityName);
        }
        ed.commit();
    }

    public void loadNamesCity() {
        sharedPreferences = getPreferences(MODE_PRIVATE);
        thitherCityName = sharedPreferences.getString(THITHER_CITY, "");
        backCityName = sharedPreferences.getString(BACK_CITY, "");
        if (thitherCityName != null) {
            thitherCityTv.setText(thitherCityName);
        } else if (backCityName != null) {
            backCityTv.setText(backCityName);
        }
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        SimpleDateFormat simpledateformat = new SimpleDateFormat("dd MMM,E");
        Date date = new Date(year, month, dayOfMonth);
        String customDate = simpledateformat.format(date);

        if (datePickerDialogThither == null) {
            backDateTv.setText(customDate);
        } else if (datePickerDialogBack == null) {
            thitherDateTv.setText(customDate);

        }
    }


}