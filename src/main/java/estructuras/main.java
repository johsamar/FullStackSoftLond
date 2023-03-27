package estructuras;

import java.util.ArrayList;
import java.util.List;

public class main {

    public static void main(String[] args) {

        List<String> lista = new ArrayList<String>();

        // Adicionar elementos a la lista
        lista.add("Hola");
        lista.add("Mundo");
        lista.add("Cruel");
        lista.add("!");

        // Imprimir elementos la lista
        for (String elemento_lista : lista) {
            System.out.println(elemento_lista);
        }

        //
        List<Integer> lista2 = new ArrayList<>();
        for (int i = 0; i < lista.size(); i++) {
            if(lista.get(i).contains("o")){
                lista2.add(i);
            }
        }
        for(int indices: lista2){
            System.out.println(lista.get(indices));
        }

        // obtener elemento por indice
        System.out.println(lista.get(0));

        // Obtener indice de un elemento
        System.out.println(lista.indexOf("Hola"));

        // Eliminar elementos de la lista
        // Por indice
        lista.remove(1);

        System.out.println(lista);

        // Por elemento
        lista.remove("Hola");

        System.out.println(lista);

        // Eliminar por filtro
        lista.removeIf(elemento -> elemento.contains("o"));
        System.out.println(lista);
    }
}
