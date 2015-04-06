package ingtech.com.myapplication;

import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    private BolaDeCristal bolaCristal = new BolaDeCristal();//constructor de la clase BolaDeCristal//mejorando el codigo
    private TextView mEtiquetaRespuesta;
    private Button mBotonRespuesta;
    private ImageView mBoladCristal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEtiquetaRespuesta = (TextView) findViewById(R.id.textView01);//mejoramos la etiqueta
        mBotonRespuesta = (Button)findViewById(R.id.button01);

        mBotonRespuesta.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {//para dar trabajar bajo la orden de click en e boton

                String respuesta = bolaCristal.ObtenerRespuestas();//mejorando el codigo

                mEtiquetaRespuesta.setText(respuesta);//para hacer salida a de un  texto a una casilla
                Toast.makeText(MainActivity.this, respuesta, Toast.LENGTH_LONG).show();//esto para hacer salida en toast
                //agregamos la animacion al click
                animarBola();
                //llamamos el metodo de animacion de texto
                animarRespuesta();
                //llamar al metodo reproducir sonido
                reproducirSonido();
            }
        }));

        //ParseObject object;
    }


    //nuevo metodo para realizar la animacion
    private void animarBola(){

        mBoladCristal = (ImageView)findViewById(R.id.imageView);
        //agregar el recurso al objeto imageView
        mBoladCristal.setImageResource(R.drawable.animacion);
        //para declarar la animacion debemos decarar animationDrawable
        AnimationDrawable animacionBola = (AnimationDrawable) mBoladCristal.getDrawable();

        if (animacionBola.isRunning()){
            animacionBola.stop();
        }
        //darle la orden de arrancar
        animacionBola.start();
    }

    //metodo para animacion de texto
    private void animarRespuesta(){
        //la clase para la animacion se llama AlphaAnimation
        AlphaAnimation animaEntrada = new AlphaAnimation(0,1);//pide dos valores uno al inicio y otro al final de la animacion(0, 1)
        //(0 -> opacidad 0 invisible  1-> opacidad 1 Visible
        animaEntrada.setDuration(1500);//ms
        //mantenga el valor de alpha en 1 al finalizar la animacion
        animaEntrada.setFillAfter(true);

        mEtiquetaRespuesta.setAnimation(animaEntrada);
    }

    //metodo para sonido
    private void reproducirSonido(){
        //variable tipo MediaPlayer
        MediaPlayer reproductor = MediaPlayer.create(this, R.raw.sonido);//create necesita un objeto de contexto, un ID de recurso
        reproductor.start();//reproducir
        //liberar los recursos de memoria con setOnCompletionListener q se ejecuta cuando el reproductor termina
        reproductor.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                //llamamos al metodo release
                mp.release();
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
}
