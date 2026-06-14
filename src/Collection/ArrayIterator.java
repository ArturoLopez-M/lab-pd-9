package Collection;

import Iterator.Iterator;
import Modelo.Pedido;

public class ArrayIterator implements Iterator {
    private Pedido[] pedidos;
    private int posicion = 0;

    // El constructor recibe y vincula el arreglo de datos desde la colección
    public ArrayIterator(Pedido[] pedidos) {
        this.pedidos = pedidos;
    }

    // EL boolean verifica si existen más elementos pendientes por recorrer en el arreglo
    @Override
    public boolean hasNext() {
        return posicion < pedidos.length && pedidos[posicion] != null;
    }

    // Método que retorna el elemento actual y sigue el recorrido a la siguiente posición
    @Override
    public Object next() {
        if (!hasNext()) {
            return null;
        }
        Pedido pedido = pedidos[posicion];
        posicion++;
        return pedido;
    }
}