package pilas;

import java.util.Stack;

public class main {
    public static void main(String[] args) {
        Stack<String> pila = new Stack<String>();

        pila.push("Miguel");
        pila.push("Juan");
        pila.push("Cristian");
        pila.push("Jorge");
        pila.push("Carlos");

        // --- Sacando elementos
        System.out.println("Sacando elementos de la pila");
        String elemento = pila.pop();
        System.out.println("Elemento sacado: " + elemento);
        System.out.println("La pila queda " + pila);
        
        while (!pila.empty()) {
            System.out.println("Sacando elemento: " + pila.pop());
        }
    }

}
