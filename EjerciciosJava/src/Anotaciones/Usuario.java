package Anotaciones;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.Period;

public class Usuario {

    private String nombre;
    private String identidad;
    @EdadMinima(valor = 18)
    private LocalDate fechaNacimiento;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentidad() {
        return identidad;
    }

    public void setIdentidad(String identidad) {
        this.identidad = identidad;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public boolean usuarioValido(Usuario usuario){
        if(!usuario.getNombre().matches("[a-zA-Záàâãéèêíïóôõöúçñ\\s]+")){
            return false;
        }
        if(!usuario.getIdentidad().matches("[^0-9]+")){
            return false;
        }
        return Period.between(usuario.getFechaNacimiento(), LocalDate.now()).getYears() >= 18;
    }


    /*public static <T> boolean validador(T objeto) {
        Class<?> clase = objeto.getClass();
        for (Field field : clase.getDeclaredFields()) {
            if (field.isAnnotationPresent(EdadMinima.class)) {
                EdadMinima edadMinima = field.getAnnotation(EdadMinima.class);
                try{
                    field.setAccessible(true);
                    LocalDate fechaNacimiento = (LocalDate) field.get(objeto);
                    return Period.between(fechaNacimiento, LocalDate.now()).getYears() >= EdadMinima.valor();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }*/
}
