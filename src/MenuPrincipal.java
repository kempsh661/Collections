import java.util.Scanner;
public class MenuPrincipal {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        while (opcion != 9) {
            System.out.println("""
                    === AGENDA DE CONTACTOS ===
                    1. Agregar contacto
                    2. Buscar contacto
                    3. Eliminar contacto
                    4. Listar todos los contactos
                    5. Agregar grupo
                    6. Agregar contacto a grupo
                    7. Listar grupos
                    8. Mostrar contactos por grupo
                    9. Salir
                    ==========================
                    Elige una opción:
                    """);
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("Ingresa el nombre del contacto:");
                    String nombre = scanner.nextLine();
                    System.out.println("Ingresa el teléfono:");
                    String telefono = scanner.nextLine();
                    System.out.println("Ingresa el email:");
                    String email = scanner.nextLine();
                    Contacto contacto = new Contacto(
                            nombre,
                            telefono,
                            email
                    );
                    agenda.agregarContacto(contacto);

                    break;
                case 2:
                    System.out.println("Ingresa el nombre del contacto:");
                    String nombreBuscar = scanner.nextLine();
                    Contacto contactoBuscar = agenda.buscarContacto(nombreBuscar);
                    if (contactoBuscar == null) {
                        System.out.println("Contacto no encontrado.");
                    } else {
                        System.out.println(contactoBuscar);
                    }
                    break;

                case 3:
                    System.out.println("Ingresa el nombre del contacto a eliminar:");
                    String nombreEliminar = scanner.nextLine();

                    if (agenda.eliminarContacto(nombreEliminar)) {
                        System.out.println("Contacto eliminado correctamente.");
                    } else {
                        System.out.println("Contacto no encontrado.");
                    }
                    break;
                case 4:
                    agenda.listarContactos();
                    break;
                case 5:
                    System.out.println("Ingresa el nombre del grupo:");
                    String grupo = scanner.nextLine();
                    agenda.agregarGrupo(grupo);
                    break;
                case 6:
                    System.out.println("Ingresa el nombre del contacto:");
                    String nombreContacto = scanner.nextLine();
                    System.out.println("Ingresa el nombre del grupo:");
                    String nombreGrupo = scanner.nextLine();
                    agenda.agregarContactoAGrupo(nombreContacto, nombreGrupo);
                    break;
                case 7:
                    agenda.listarGrupos();
                    break;
                case 8:
                    System.out.println("Ingresa el nombre del grupo:");
                    String grupoBuscar = scanner.nextLine();

                    agenda.mostrarContactosPorGrupo(grupoBuscar);
                    break;
                case 9:
                    System.out.println("¡Gracias por usar la Agenda de Contactos!");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }
        }
    }
}