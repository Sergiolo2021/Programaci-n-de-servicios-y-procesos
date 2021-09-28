/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sergio_programasiniciales;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Alumno5
 */
public class Aventura {
	Personaje_Aventura prota = new Personaje_Aventura();

	Personaje_Aventura escudero = new Personaje_Aventura("Sancho", 2, 2, 3, 1, 1, 3, 1, 1, 2, 6);
	Personaje_Aventura consejero = new Personaje_Aventura("Sancho", 1, 1, 2, 3, 3, 2, 2, 3, 2, 3);
	Personaje_Aventura musico = new Personaje_Aventura("Mozart", 1, 3, 2, 3, 3, 2, 1, 1, 2, 3);

        
        
        
	Personaje_Aventura[] grupo = new Personaje_Aventura[4];
        Personaje_Aventura villano = new Personaje_Aventura("Voldemort", 4,4,4,5,5,5,3,3,3,5);
        
	Prueba_Aventura foso = new Prueba_Aventura("Foso", 2, 3);

	public Aventura() {
		super();
	}

	public void IniciarAventura() {
		crearProta();
		crearGrupo();
		Introduccion();
		SaltarFoso();
                PeleaAMuerte(prota, consejero);
                PeleaEnGrupo(grupo, villano);
	}

	public int LanzarDado(int tiradas) {
		int exitos = 0;
		// si sale 8,9,10 es exito
		int random;
		for (int i = 0; i < tiradas; i++) {
			random = (int) (Math.random() * 10 + 1);
			if (random >= 8) {
				exitos++;
			}
		}
		return exitos;
	}

	public void crearProta() {
		Scanner sc = new Scanner(System.in);

		// Integer.parseInt(sc.nextLine()); para no tener el problema de scanner sc que
		// pete usando letras y numeros
		System.out.print("Nombre: ");
		prota.nombre = sc.nextLine();
		System.out.print(" - Fuerza: ");
		prota.fuerza = Integer.parseInt(sc.nextLine());
		System.out.print(" - Destreza: ");
		prota.destreza = Integer.parseInt(sc.nextLine());
		System.out.print(" - Constitucion: ");
		prota.consitucion = Integer.parseInt(sc.nextLine());
		System.out.print(" - Carisma: ");
		prota.carisma = Integer.parseInt(sc.nextLine());
		System.out.print(" - Manipulacion: ");
		prota.manipulacion = Integer.parseInt(sc.nextLine());
		System.out.print(" - Compostura: ");
		prota.compostura = Integer.parseInt(sc.nextLine());
		System.out.print(" - Inteligencia: ");
		prota.inteligencia = Integer.parseInt(sc.nextLine());
		System.out.print(" - Astucia: ");
		prota.astucia = Integer.parseInt(sc.nextLine());
		System.out.print(" - Aplomo: ");
		prota.aplomo = Integer.parseInt(sc.nextLine());
		prota.vida = 5 + prota.consitucion;
	}

	public void crearGrupo() {
		grupo[0] = prota;
		grupo[1] = escudero;
		grupo[2] = consejero;
		grupo[3] = musico;
	}

	public void Introduccion() {
		System.out
				.println("\nEstas con Gandalf huyendo del Balrog cuando de repente  llegais a un puente con un foso. ");

	}

	public void SaltarFoso() {
		int exitos;
		for (int i = 0; i < grupo.length; i++) {
			System.out.println(grupo[i].nombre + " intenta saltar el foso.");
			exitos = LanzarDado(grupo[i].fuerza + grupo[i].destreza);

			if (exitos >= foso.dificultad) {
				System.out.println("Exitos: " + exitos);
				System.out.println(grupo[i].nombre + " salta el foso sin problema.");
			} else {
				System.out.println(grupo[i].nombre + " se cae al foso y sufre " + foso.danio + " puntos de da�o");
				grupo[i].vida -= foso.danio;
				System.out.println("Le quedan " + grupo[i].vida + " puntos de vida.");
			}
		}

	}

        public void PeleaAMuerte(Personaje_Aventura personaje1, Personaje_Aventura personaje2){
            System.out.println("\n" + personaje1.nombre + " se va a pelear con " + personaje2.nombre);
            while (personaje1.vida>0 && personaje2.vida>0) {
                if(personaje1.vida>0){
                    Golpear(personaje1, personaje2);
                }
                if(personaje2.vida>0){
                    Golpear(personaje2, personaje1);
                }
            }
            if(personaje1.vida>0 && personaje2.vida<=0){
                System.out.println("\n" + personaje1.nombre + " ha ganado la pelea.");
            }else if(personaje2.vida>0 && personaje1.vida<=0){
                System.out.println("\n" + personaje2.nombre + " ha ganado la pelea.");
            }
        }
        
        public void Golpear(Personaje_Aventura atacante, Personaje_Aventura defensor){
            int danio=LanzarDado(atacante.fuerza+atacante.destreza-defensor.astucia);
            defensor.vida-=danio;
            System.out.println("\n" + atacante.nombre + " golpea a " + defensor.nombre + " bajando " + danio + " puntos de vida.");
            System.out.println("\nA " + defensor.nombre + " le quedan " + defensor.vida + " puntos de vida.");
        }
        
        public void PeleaEnGrupo(Personaje_Aventura[] grupo, Personaje_Aventura enemigo){
            System.out.println("\nEl grupo de aventureros se enfrenta a " + enemigo.nombre);
            int objetivo=grupo.length-1;
            while(grupo[0].vida>0 && enemigo.vida>0){
                for (int i = 0; i < grupo.length; i++) {
                    if(grupo[i].vida>0){
                        Golpear(grupo[i], enemigo);
                        
                    }
                }
                if(enemigo.vida>0){
                    Golpear(enemigo, grupo[objetivo]);
                    if(grupo[objetivo].vida <=0){
                        objetivo--;
                    }
                }
            }
            if(enemigo.vida<=0){
                System.out.println("\n" + "El grupo ha vencido a " + enemigo.nombre);
            }else{
                System.out.println("\nEl " + enemigo.nombre + " ha vencido al grupo");
            }
        }
}
