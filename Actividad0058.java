/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad0058;

import java.util.Random;

/**
 *
 * @author Tsuki
 */
public class Actividad0058 {

    public Actividad0058() {

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Auction subasta = new Auction();
        Person[] personas = {new Person("Manuel"), new Person("Beatriz"), new Person("Alba")};
        int numeroDeLotes = 5;//Por poner un ejemplo
        int[] idLotes = new int[numeroDeLotes];
        for (int i = 0; i < numeroDeLotes; i++) {
            subasta.enterLot("Lote nº" + (i + 1));
            idLotes[i] = i + 1;

        }
        //Mostramos los lotes disponibles
        subasta.showLots();
        for (Person persona : personas) {
            //Simulamos una puja del primer lote
            //Creamos una puja por cada persona y lo que puja cada persona es aleatorio
            subasta.makeABid(idLotes[0], persona, new Random().nextLong());
        }
        subasta.showLots();
        //Preguntas
        /*
         *¿Qué objetos de otras clases del proyecto y cuántos puede almacenar internamente un objeto Auction?
         * Por poder, todos se pueden ya que las clases son públicas y se encuentran en el mismo paquete.
         Aunque en el código solo usamos Bid y Lot
         Podemos almacenar todas las clases que queramos
         *¿Qué objetos de otras clases del proyecto y cuántos puede almacenar internamente un objeto Bid?
         * Bid almacena objetos tipo Person. Y podríamos añadir todos los que queramos pero no tendria mucho
         sentido en la practica
         *¿Qué objetos de otras clases del proyecto y cuántos puede almacenar internamente un objeto Lot?
         * Lot almacena Bid para hacer referencia a la puja más alta . Podemos almacenar todos los Bid 
         que queramos, pero en la practica solo nos interesa la más alta
         */

    }

}
