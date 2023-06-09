/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package randomchoose;

import java.util.Scanner;
import java.util.Random;

/**
 * Generar una eleccion de un ejercicio aleatorio.
 *
 * @author frangimz
 */
public class RandomChoose {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner leer = new Scanner(System.in);
        int numGuias = 0;
        int guiaTrabajar = 0;
        int cantEjercicios = 0;
        int numEjercicio = 0;

        System.out.println("Cuantas personas son?");
        int cantPersona = leer.nextInt();

        String[] vect = new String[cantPersona];
        int[] posRandom = new int[cantPersona];

        ingresoPersona(leer, vect, posRandom, cantPersona);

        divTareas(vect, posRandom, cantPersona);

        //Elegir Ejercicio por guia y por numero de ejercicio
        elegirGuia(numGuias, guiaTrabajar, leer);
        elegirEjercicio(cantEjercicios, numEjercicio, leer);

    }

    private static void ingresoPersona(Scanner leer, String[] vect, int[] posRandom, int cantPersona) {
        leer.nextLine();
        for (int i = 0; i < cantPersona; i++) {
            int pos = i + 1;
            System.out.println("Ingrese nombre de participante " + pos);
            vect[i] = leer.nextLine();
        }
    }

    //Dividir tareas de acuerdo a personas
    //Quien comparte pantalla
    private static void divTareas(String[] vect, int[] posRandom, int cantPersona) {
        Random random = new Random();
        int posPerComPant;

        boolean flagExiste = false;

        for (int i = 0; i < cantPersona; i++) {
            do {
                flagExiste = false;
                posRandom[i] = random.nextInt(cantPersona);
                //System.out.println("posRandom=  "+posRandom[i]);
                for (int j = 0; j < i; j++) {
                    if (posRandom[i] == posRandom[j]) {
                        flagExiste = true;
                    }
                }
            } while (flagExiste);
        }

        for (int i = 0; i < cantPersona; i++) {
            int pos = i + 1;
            System.out.println("Tarea " + pos + " - " + vect[posRandom[i]]);
        }

        posPerComPant = random.nextInt(cantPersona);
        System.out.println("La persona que comparte pantalla es: " + vect[posPerComPant]);

    }

    private static void elegirGuia(int numGuias, int guiaTrabajar, Scanner leer) {
        System.out.println("Ingrese la cantidad de guías");
        numGuias = leer.nextInt();
        //Math.random() devuelve un número decimal entre 0 y 0.9. Por eso se suma 1 para que sea desde 1 hasta el número ingresado
        //el int por delante va a redondear el resultado del calculo
        guiaTrabajar = (int) (Math.random() * numGuias) + 1;

        System.out.println("La guía a trabajar será: " + guiaTrabajar);
    }

    private static void elegirEjercicio(int cantEjercicios, int numEjercicio, Scanner leer) {
        System.out.println("Ingrese la cantidad de ejercicios que posee la guía");
        cantEjercicios = leer.nextInt();

        numEjercicio = (int) (Math.random() * cantEjercicios) + 1;

        System.out.println("El ejercicio que deberán realizar será: " + numEjercicio);
    }

}
