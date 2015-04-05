package ingtech.com.myapplication;

import java.util.Random;

/**
 * Created by usuario on 03/04/2015.
 */
public class BolaDeCristal {

    public String ObtenerRespuestas(){

        String[] respuestas = {//agregamos este arreglo
                "Hola",
                "Chao",
                "Suerte",
                "Sayonara",
                "Suerte Papa",
                "Te jodistes"
        };
        Random genAlea = new Random();
        int numAlea = genAlea.nextInt(respuestas.length);//selecciona un numero alea de 0- 3 el 4 no entra /con.length me ahorro eso

        return respuestas[numAlea];
    }
}
