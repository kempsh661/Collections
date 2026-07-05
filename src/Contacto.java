public class Contacto {
    private String nombre;
    private String telefono;
    private String email;
    private String grupo;
    public Contacto(String nombre, String telefono, String email) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }
    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }
    public String getGrupo() {
        return grupo;
    }
    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString() {
        if (grupo == null) {
            return nombre + " | Teléfono: " + telefono + " | Email: " + email;

        }
        return nombre + " | Teléfono: " + telefono + " | Email: " + email + " | Grupo: " + grupo;
    }
}
