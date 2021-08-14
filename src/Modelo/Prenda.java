package Modelo;

public abstract class Prenda {

    private boolean Calidad;// standar 0 , premium 1
    private double precio;
    private int CantidadStock;

    public Prenda(boolean Calidad, double precio, int CantidadStock) {
        this.Calidad = Calidad;
        this.precio = precio;
        this.CantidadStock = CantidadStock;
    }

    public boolean isCalidad() {
        return Calidad;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidadStock() {
        return CantidadStock;
    }

    public void setCalidad(boolean Calidad) {
        this.Calidad = Calidad;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setCantidadStock(int CantidadStock) {
        this.CantidadStock = CantidadStock;
    }
    
}
