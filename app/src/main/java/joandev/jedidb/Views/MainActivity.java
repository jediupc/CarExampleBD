package joandev.jedidb.Views;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import joandev.jedidb.Data.CarHelper;
import joandev.jedidb.R;


public class MainActivity extends Activity {

    EditText name;
    EditText maxSpeed;

    CarHelper carHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText)findViewById(R.id.carNameEditText);
        maxSpeed =  (EditText) findViewById(R.id.maxSpeedEditText);

        carHelper = new CarHelper(getApplicationContext());

    }


    public void showCarList(View view) {
        Intent intent = new Intent(getApplicationContext(), CarListActivity.class);
        startActivity(intent);
    }

    public void addCar(View view) {
        ContentValues valuesToStore = new ContentValues();
        valuesToStore.put("name", String.valueOf(name.getText()));
        valuesToStore.put("maxSpeed", String.valueOf(maxSpeed.getText()));
        carHelper.createCar(valuesToStore, "Car");

        Toast.makeText(getApplicationContext(),"insertion done", Toast.LENGTH_SHORT).show();
        name.setText("");
        maxSpeed.setText("");
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
}
