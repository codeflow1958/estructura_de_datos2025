package umg.edu.gt.desarrollo.estructuradedatos2025.ejercicios;

package umg.edu.gt.test.EjercicioLinkedList;

import org.junit.jupiter.api.Test;
import umg.edu.gt.desarrollo.estructuradedatos2025.ejercicios.EjercicioLinkedList;

import java.util.LinkedList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class EjercicioLinkedListTest {

    @Test
    public void testEliminarDuplicados() {
        LinkedList<Integer> lista = new LinkedList<>(Arrays.asList(1, 2, 2, 3, 4, 4, 5));
        LinkedList<Integer> resultadoEsperado = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
        assertEquals(resultadoEsperado, EjercicioLinkedList.eliminarDuplicados(lista));
    }

    @Test
    public void testInvertirLinkedList() {
        LinkedList<String> lista = new LinkedList<>(Arrays.asList("A", "B", "C", "D"));
        LinkedList<String> resultadoEsperado = new LinkedList<>(Arrays.asList("D", "C", "B", "A"));
        assertEquals(resultadoEsperado, EjercicioLinkedList.invertirLinkedList(lista));
    }

    @Test
    public void testIntercalarListasOrdenadas() {
        LinkedList<Integer> lista1 = new LinkedList<>(Arrays.asList(1, 3, 5));
        LinkedList<Integer> lista2 = new LinkedList<>(Arrays.asList(2, 4, 6));
        LinkedList<Integer> resultadoEsperado = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertEquals(resultadoEsperado, EjercicioLinkedList.intercalarListasOrdenadas(lista1, lista2));
    }

    @Test
    public void testIntercalarListasOrdenadasConFalla() {
        LinkedList<Integer> lista1 = new LinkedList<>(Arrays.asList(1, 3, 5));
        LinkedList<Integer> lista2 = new LinkedList<>(Arrays.asList(2, 4, 6));
        LinkedList<Integer> resultadoEsperado = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 6, 5)); // Resultado incorrecto para forzar la falla
        assertEquals(resultadoEsperado, EjercicioLinkedList.intercalarListasOrdenadas(lista1, lista2));
    }
}