package ingtech.com.myapplication;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseObject;

import java.util.Random;


public class MainActivity extends ActionBarActivity {

    private BolaDeCristal bolaCristal = new BolaDeCristal();//constructor de la clase BolaDeCristal//mejorando el codigo



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button01).setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {//para dar trabajar bajo la orden de click en e boton

                String respuesta = bolaCristal.ObtenerRespuestas();//mejorando el codigo

                ((TextView) findViewById(R.id.textView01)).setText(respuesta);//para hacer salida a de un  texto a una casilla
                Toast.makeText(MainActivity.this,respuesta, Toast.LENGTH_LONG).show();//esto para hacer salida en toast
            }
        }));

        //ParseObject object;
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
