package umg.edu.gt.desarrollo.estructuradedatos2025.ejercicios;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EjercicioTreeSetAndMap {

    /**
     * EJERCICIO 1: Análisis de Frecuencia de Palabras (TreeMap)
     * Lee un archivo de texto y cuenta la frecuencia de cada palabra,
     * ordenándolas alfabéticamente.
     *
     * @param filePath La ruta del archivo de texto.
     * @return Un TreeMap con la frecuencia de cada palabra.
     */
    public TreeMap<String, Integer> analizarFrecuenciaPalabras(String filePath) {
        TreeMap<String, Integer> frecuenciaPalabras = new TreeMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String linea;
            Pattern patron = Pattern.compile("[a-zA-Z]+"); // Solo letras
            while ((linea = reader.readLine()) != null) {
                String[] palabras = linea.toLowerCase().split("\\s+");
                for (String palabra : palabras) {
                    Matcher matcher = patron.matcher(palabra);
                    if (matcher.matches()) {
                        frecuenciaPalabras.put(palabra, frecuenciaPalabras.getOrDefault(palabra, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        return frecuenciaPalabras;
    }

    /**
     * EJERCICIO 2: Rastreador de Versiones de Código (TreeMap)
     */
    public static class VersionRastreador {
        private TreeMap<Integer, String> versiones = new TreeMap<>();
        private int siguienteVersion = 1;

        public void agregarVersion(String contenido) {
            versiones.put(siguienteVersion++, contenido);
            System.out.println("Agregar versión " + (siguienteVersion - 1) + ": \"" + contenido + "\"");
        }

        public String obtenerVersion(int version) {
            String contenido = versiones.get(version);
            System.out.println("Versión " + version + ": \"" + contenido + "\"");
            return contenido;
        }

        public String obtenerUltimaVersion() {
            if (!versiones.isEmpty()) {
                String ultimaVersion = versiones.lastEntry().getValue();
                System.out.println("Última versión: \"" + ultimaVersion + "\"");
                return ultimaVersion;
            }
            return null;
        }

        public boolean eliminarVersion(int version) {
            if (versiones.containsKey(version)) {
                versiones.remove(version);
                System.out.println("Versión " + version + " eliminada.");
                return true;
            } else {
                System.out.println("La versión " + version + " no existe.");
                return false;
            }
        }

        public TreeMap<Integer, String> obtenerTodasLasVersiones() {
            return versiones;
        }
    }

    /**
     * EJERCICIO 3: Sistema de Gestión de Eventos (TreeSet)
     */
    public static class Evento implements Comparable<Evento> {
        private LocalDateTime fecha;
        private String nombre;
        private String ubicacion;

        public Evento(LocalDateTime fecha, String nombre, String ubicacion) {
            this.fecha = fecha;
            this.nombre = nombre;
            this.ubicacion = ubicacion;
        }

        public LocalDateTime getFecha() {
            return fecha;
        }

        public String getNombre() {
            return nombre;
        }

        public String getUbicacion() {
            return ubicacion;
        }

        @Override
        public int compareTo(Evento otroEvento) {
            return this.fecha.compareTo(otroEvento.fecha);
        }

        @Override
        public String toString() {
            return "\"" + nombre + "\", " + fecha.toLocalDate() + " " + fecha.toLocalTime() + ", " + ubicacion;
        }
    }

    public static class EventoManager {
        private TreeSet<Evento> eventos = new TreeSet<>();

        public void agregarEvento(LocalDateTime fecha, String nombre, String ubicacion) {
            eventos.add(new Evento(fecha, nombre, ubicacion));
        }

        public void mostrarEventosOrdenados() {
            System.out.println("Lista de eventos:");
            int i = 1;
            for (Evento evento : eventos) {
                System.out.println(i + ". " + evento);
                i++;
            }
        }

        public Evento obtenerProximoEvento() {
            LocalDateTime ahora = LocalDateTime.now();
            for (Evento evento : eventos) {
                if (evento.getFecha().isAfter(ahora)) {
                    System.out.println("Próximo evento: " + evento);
                    return evento;
                }
            }
            System.out.println("No hay eventos futuros.");
            return null;
        }

        public void eliminarEventosPasados() {
            LocalDateTime ahora = LocalDateTime.now();
            eventos.removeIf(evento -> evento.getFecha().isBefore(ahora));
            System.out.println("Eventos pasados eliminados.");
        }

        public TreeSet<Evento> obtenerTodosLosEventos() {
            return eventos;
        }
    }
}