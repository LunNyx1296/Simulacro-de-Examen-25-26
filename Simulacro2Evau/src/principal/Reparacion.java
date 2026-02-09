package principal;

import java.time.LocalDate;

public class Reparacion {

    private String codigo;
    private String descripcion;
    private double coste;
    private LocalDate fecha;

    public Reparacion(String codigo, String descripcion, double coste, LocalDate fecha) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.coste = coste;
        this.fecha = fecha;
    }
    

    public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public LocalDate getFecha() {
		return fecha;
	}


	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}


	public void setCoste(double coste) {
		this.coste = coste;
	}


	public double getCoste() {
        return coste;
    }
}
