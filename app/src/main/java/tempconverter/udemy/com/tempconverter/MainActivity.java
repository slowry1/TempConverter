package tempconverter.udemy.com.tempconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText tempEditText;
    private Button celButton;
    private Button fButton;
    private TextView showTempTextView;

    DecimalFormat round = new DecimalFormat("0.0");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tempEditText = (EditText) findViewById(R.id.editTextId);
        celButton = (Button) findViewById(R.id.celsiusButtonId);
        fButton = (Button) findViewById(R.id.fButtonId);
        showTempTextView = (TextView) findViewById(R.id.showResultTextView);

        //Set up our buttons (event listeners)
        celButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //call convertToCelsius()
                        String editTextVal = tempEditText.getText().toString();

                if (editTextVal.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Enter a value", Toast.LENGTH_LONG).show();
                }else {
                    // we are good
                    double intEditText = Double.parseDouble(editTextVal);
                    double convertedVal = convertToCelsius(intEditText);

                    String stringResult = String.valueOf(round.format(convertedVal));

                    showTempTextView.setText(stringResult + " C");

                }

            }
        });

        fButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //call convertToFahrenheit()
                String editTextVal = tempEditText.getText().toString();

                if (editTextVal.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Enter a value", Toast.LENGTH_LONG).show();
                }else {
                    // we are good
                    double doubleEditText = Double.parseDouble(editTextVal);
                    double convertedVal = convertToFahrenheit(doubleEditText);

                    String stringResult = String.valueOf(round.format(convertedVal));

                    showTempTextView.setText(stringResult + " F");

                }



            }
        });
    }

    public double convertToCelsius(double farVal){
        //[C] = ([F]-32)*5/9 --> From Fahrenheit to celsius
        double resultCel;
        resultCel = (farVal - 32) * 5/9 ;

        return resultCel;

    }

    public double convertToFahrenheit(double celVal){
        //[F] = [C] * 9/5 +32 --> From celsius to Fahrenheit

        double resultFahr;
        resultFahr = (celVal * 9 / 5) + 32;

        return resultFahr;
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
