import Modelo.Pedido;
import Iterator.*;
import Collection.*;

public class Main {
    public static void main(String[] args) {
        Agregado coleccion = new ColeccionPedidos(4);
        Iterator iterator = coleccion.createIterator();

        int contador = 1;

        // Inicio del Recorrido
        while (iterator.hasNext()) {
            Pedido pedido = (Pedido) iterator.next();
            ((ColeccionPedidos) coleccion).mostrarDetallePedido(pedido, contador);
            contador++;
        }
        // Fin del Recorrido

        System.out.println("--------------------------------------------------");
    }
}
