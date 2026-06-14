package Collection;

import Iterator.*;
import Modelo.Pedido;

public class ColeccionPedidos implements Agregado {
    private Pedido[] pedidos;
    private int indice = 0;

    public ColeccionPedidos(int capacidad) {
        this.pedidos = new Pedido[capacidad];


        // Carga de datos en desorden para comprobar que el ordenamiento ascendente funcione correctamente
        add(new Pedido("PED-003", "13/06/2026", "Emmanuel Yacila", "3x Polo, 2x Short", 320.00));
        add(new Pedido("PED-001", "13/06/2026", "Ximena Villalobos", "1x Vestido", 150.00));
        add(new Pedido("PED-004", "13/06/2026", "Luis Espinoza", "1x Casaca Cuero", 1200.00));
        add(new Pedido("PED-002", "13/06/2026", "Sofia Aponte", "2x Blusa", 180.00));
    }


    public void add(Pedido pedido) {

        // Restricción para la toma de decisión en Aprobar o Rechazar Pedido de manera automatica
        if (indice < pedidos.length) {
            if (pedido.getPrecioTotal() > 500.00){ // limite de S/500
                pedido.rechazar();
            } else {
                pedido.aprobar();
            }

            pedidos[indice] = pedido;
            indice++;
            sortPedidosById();
        }
    }

    // Uso del Algoritmo Bubble Sort para ordenar por ID de forma ascendente
    private void sortPedidosById() {
        for (int i = 0; i < indice - 1; i++) {
            for (int j = 0; j < indice - i - 1; j++) {
                if (pedidos[j].getId().compareTo(pedidos[j + 1].getId()) > 0) {
                    Pedido temp = pedidos[j];
                    pedidos[j] = pedidos[j + 1];
                    pedidos[j + 1] = temp;
                }
            }
        }
    }


    // Estructuración detallada y elegante de la Salida + Decisión final del Estado (Aprobado o Rechazado)

    public void mostrarDetallePedido(Pedido pedido, int numeroActual) {
        System.out.println("--------------------------------------------------");
        System.out.println("Pedido " + numeroActual + " de " + indice + ":");
        System.out.println("ID          : " + pedido.getId());
        System.out.println("Fecha       : " + pedido.getFecha());
        System.out.println("Cliente     : " + pedido.getCliente());
        System.out.println("Productos   : " + pedido.getProductos());
        System.out.println("Total       : S/ " + pedido.getPrecioTotal());
        System.out.println("Estado      : Pendiente\n");

        String opcionAbreviada = pedido.getEstado().equals("Aprobado") ? "A" : "R";
        System.out.println("¿Aprobar o Rechazar? [A/R]: " + opcionAbreviada);

        if (pedido.getEstado().equals("Aprobado")) {
            System.out.println("Pedido APROBADO :) ");
        } else {
            System.out.println("Pedido RECHAZADO :( ");
        }
    }

    // Método encargado de instanciar y retornar el Iterator para esta estructura
    @Override
    public Iterator createIterator() {
        return new ArrayIterator(pedidos);
    }
}
