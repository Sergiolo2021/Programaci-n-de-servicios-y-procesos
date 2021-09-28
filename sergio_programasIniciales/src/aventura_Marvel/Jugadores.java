/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aventura_Marvel;

/**
 *
 * @author Alumno5
 */
public class Jugadores {
    String nombre;
    int[] carton =new int[5];
    int aciertos=0;
    public Jugadores() {
    }
    
    public Jugadores(String nombre) {
        this.nombre = nombre;
        for (int i = 0; i < carton.length; i++) {
            carton[i]=(int)(Math.random()*100+1);//con int convierto el decimal y el entero y esto llegaria de 1 a 100
        }
    }

    public void setAciertos(int aciertos) {
        this.aciertos = aciertos;
    }

    @Override
    public String toString() {
        return "Jugadores{" + "carton=" + carton + '}';
    }
    
    
}
