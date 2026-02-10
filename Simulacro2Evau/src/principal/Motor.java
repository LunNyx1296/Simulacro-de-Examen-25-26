package principal;

import java.util.ArrayList;
import java.util.List;

public abstract class Motor {

    private String identificador;
    private String marca;
    private List<Reparacion> reparaciones;

    public Motor(String identificador, String marca) {
        this.identificador = identificador;
        this.marca = marca;
        this.reparaciones = new ArrayList<>();
    }

    public String getMarca() {
        return marca;
    }

    public List<Reparacion> getReparaciones() {
        return reparaciones;
    }

    public void addReparacion(Reparacion r) {
        reparaciones.add(r);
    }

    public abstract double calcularCosteBase();
}