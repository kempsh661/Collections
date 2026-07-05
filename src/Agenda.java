import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Agenda {
    private Map<String, Contacto> contactos;
    private Set<String> grupos;
    private List<Contacto> listaContactos;

    public Agenda(){
        contactos = new HashMap<>();
        grupos = new HashSet<>();
        listaContactos = new ArrayList<>();

    }
    public  void agregarContacto(Contacto contacto){
        if (contactos.containsKey(contacto.getNombre())) {
            System.out.println("Error: Ya existe un contacto...");
            return;
        }
        contactos.put(contacto.getNombre(), contacto);

        listaContactos.add(contacto);
        System.out.println("Contacto agregado: " + contacto.getNombre());
    }
    public Contacto buscarContacto(String nombre){
        return contactos.get(nombre);
    }
    public boolean eliminarContacto(String nombre){
        if (!contactos.containsKey(nombre)) {
            return false;
        }
        Contacto contacto = buscarContacto(nombre);
        contactos.remove(nombre);
        listaContactos.remove(contacto);
        return true;
    }

    public  void listarContactos(){
        if (listaContactos.isEmpty()) {
            System.out.println("No hay contactos registrados.");
            return;
        }

        for (Contacto contacto : listaContactos) {
            System.out.println(contacto);
        }
    }

    public void agregarGrupo(String grupo) {
        if (grupos.contains(grupo)) {
            System.out.println("El grupo ya existe.");
            return;
        }
        grupos.add(grupo);
        System.out.println("Grupo agregado: " + grupo);
    }
    public void agregarContactoAGrupo(String nombreContacto, String nombreGrupo){

        Contacto contacto = buscarContacto(nombreContacto);
        if (contacto == null) {
            System.out.println("El contacto no existe.");
            return;
        }
        if (!grupos.contains(nombreGrupo)) {
            System.out.println("El grupo no existe.");
            return;
        }
        contacto.setGrupo(nombreGrupo);
        System.out.println("Contacto agregado al grupo '" + nombreGrupo + "'");
    }

    public void listarGrupos(){
        if (grupos.isEmpty()) {
            System.out.println("No hay grupos registrados.");
            return;
        }
        for (String grupo : grupos) {
            System.out.println(grupo);
        }
    }

    public void mostrarContactosPorGrupo(String nombreGrupo) {
        if (!grupos.contains(nombreGrupo)) {
            System.out.println("El grupo no existe.");
            return;
        }
        boolean encontrado = false;
        for (Contacto contacto : listaContactos) {
            if (contacto.getGrupo() != null &&
                    contacto.getGrupo().equals(nombreGrupo)) {
                System.out.println(contacto);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No hay contactos asignados al grupo '" + nombreGrupo + "'.");
        }
    }
}
