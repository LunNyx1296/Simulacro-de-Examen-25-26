package principal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {

        Scanner cs = new Scanner(System.in);
        List<Motor> motores = new ArrayList<>();

        Motor m1 = new MotorElectrico("E1", "Mercedes", 220);
        m1.addReparacion(new Reparacion("R1", "Cambio batería", 300, LocalDate.now()));

        Motor m2 = new MotorNoElectrico("N1", "Renault", Combustible.DIESEL);
        m2.addReparacion(new Reparacion("R2", "Filtro", 200, LocalDate.now()));
        m2.addReparacion(new Reparacion("R3", "Aceite", 150, LocalDate.now()));

        motores.add(m1);
        motores.add(m2);

        int opcion;
        do {
            System.out.println("1 - Eliminar por marca (SIN auxiliar)");
            System.out.println("2 - Eliminar por marca (CON auxiliar)");
            System.out.println("3 - Calcular estadísticas");
            System.out.println("0 - Salir");
            opcion = cs.nextInt();
            cs.nextLine();

            switch (opcion) {
                case 1 -> eliminarSinAux(motores, cs);
                case 2 -> eliminarConAux(motores, cs);
                case 3 -> calcularEstadisticas(motores);
            }

        } while (opcion != 0);

        GestorFicheros.guardarMotores(motores, "motores.txt");
    }

    
    private static void eliminarSinAux(List<Motor> motores, Scanner sc) {
        System.out.print("Marca a eliminar: ");
        String marca = sc.nextLine();

        for (int i = motores.size() - 1; i >= 0; i--) {
            if (motores.get(i).getMarca().equalsIgnoreCase(marca)) {
                motores.remove(i);
            }
        }
    }

    private static void eliminarConAux(List<Motor> motores, Scanner sc) {
        System.out.print("Marca a eliminar: ");
        String marca = sc.nextLine();

        List<Motor> aux = new ArrayList<>();

        for (Motor m : motores) {
            if (!m.getMarca().equalsIgnoreCase(marca)) {
                aux.add(m);
            }
        }

        motores.clear();
        motores.addAll(aux);
    }

   
    private static void calcularEstadisticas(List<Motor> motores) {
    	
        TreeMap<String, List<Motor>> mapa = new TreeMap<>();

        for (Motor m : motores) {
            String marca = m.getMarca();
            
            if (!mapa.containsKey(marca)) {
                mapa.put(marca, new ArrayList<>());
            }
            
            mapa.get(marca).add(m);
        }

        System.out.println("\nMarca | Nº Reparaciones | Coste Máx");

        for (String marca : mapa.keySet()) {
            int total = 0;
            double max = 0;

            for (Motor m : mapa.get(marca)) {
                for (Reparacion r : m.getReparaciones()) {
                    total++;
                    if (r.getCoste() > max) {
                        max = r.getCoste();
                    }
                }
            }
            System.out.println(marca + " | " + total + " | " + max);
        }
    }	
  }
