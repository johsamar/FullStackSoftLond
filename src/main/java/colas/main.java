package colas;

import java.util.LinkedList;
import java.util.Queue;

public class main {
    public static void main(String[] args) {
        Queue<String> cola = new LinkedList<String>();

        cola.offer("Miguel");
        cola.offer("Juan");
        cola.offer("Cristian");
        cola.offer("Jorge");
        cola.offer("Carlos");

        // --- Sacando elementos
        System.out.println("Sacando elementos de la cola");
        String elemento = cola.poll();
        System.out.println("Elemento sacado: " + elemento);
    }
    
}
