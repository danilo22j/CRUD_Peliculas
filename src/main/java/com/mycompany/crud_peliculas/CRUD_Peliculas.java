package com.mycompany.crud_peliculas;

import com.peliculas.crud.peliculasCrud;
import com.pelicula.entities.Peliculas;
import java.util.List;
import java.util.Scanner;

public class CRUD_Peliculas {

    public static void main(String[] args) {
        peliculasCrud crud = new peliculasCrud();
        Scanner teclado = new Scanner(System.in);
        int opcion = 0;
        do {
            System.out.println("\n===== CRUD HBO MAX =====");
            System.out.println("1. Agregar Pelicula");
            System.out.println("2. Listar Peliculas");
            System.out.println("3. Actualizar Pelicula");
            System.out.println("4. Eliminar Pelicula");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Titulo: ");
                    String tit = teclado.nextLine();
                    System.out.print("Genero: ");
                    String gen = teclado.nextLine();
                    System.out.print("Actor Principal: ");
                    String act = teclado.nextLine();
                    System.out.print("Duracion (min): ");
                    int dur = teclado.nextInt();
                    teclado.nextLine();
                    System.out.print("Fecha Estreno (DD/MM/AAAA): ");
                    String fec = teclado.nextLine();

                    crud.crear(new Peliculas(tit, gen, act, dur, fec));
                    break;

                case 2:
                    System.out.println("\n--- LISTA DE PELICULAS ---");
                    List<Peliculas> lista = crud.leerTodas();
                    if (lista.isEmpty()) {
                        System.out.println("No hay peliculas registradas.");
                    } else {
                        for (Peliculas p : lista) {
                            System.out.println("ID: " + p.getId() + " | " + p.getTitulo() + " (" + p.getGenero() + ") - " + p.getTiempo_Min() + " min");
                        }
                    }
                    break;

                case 3:
                    System.out.print("Ingrese el ID de la pelicula a modificar: ");
                    int idMod = teclado.nextInt();
                    teclado.nextLine();
                    Peliculas pMod = crud.buscarPorId(idMod);

                    if (pMod != null) {
                        System.out.print("Nuevo Titulo (Actual: " + pMod.getTitulo() + "): ");
                        pMod.setTitulo(teclado.nextLine());
                        System.out.print("Nuevo Genero (Actual: " + pMod.getGenero() + "): ");
                        pMod.setGenero(teclado.nextLine());
                        System.out.print("Nuevo Actor (Actual: " + pMod.getActor_Principal() + "): ");
                        pMod.setActor_Principal(teclado.nextLine());
                        System.out.print("Nueva Duracion (Actual: " + pMod.getTiempo_Min() + "): ");
                        pMod.setTiempo_Min(teclado.nextInt());
                        teclado.nextLine();
                        System.out.print("Nueva Fecha (Actual: " + pMod.getFecha_Estreno() + "): ");
                        pMod.setFecha_Estreno(teclado.nextLine());

                        crud.actualizar(pMod);
                    } else {
                        System.out.println("Pelicula no encontrada.");
                    }
                    break;

                case 4:
                    System.out.print("Ingrese el ID de la pelicula a eliminar: ");
                    int idEli = teclado.nextInt();
                    teclado.nextLine();
                    crud.eliminar(idEli);
                    break;

                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opcion invalida.");
            }
        } while (opcion != 5);

        // Cerrar recursos finales de conexión
        teclado.close();
        crud.cerrar();
    }
}
