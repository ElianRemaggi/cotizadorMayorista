package Modelo;

import java.util.ArrayList;

public class HistorialCotizaciones {
    private Vendedor vendedor;
    public ArrayList<Cotizacion>Cotizaciones;

    public HistorialCotizaciones(Vendedor vendedor) {
        this.vendedor = vendedor;
        this.Cotizaciones = new ArrayList<>();
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }
    
    public void agregarCotizacion(Cotizacion cotizacion){
        this.Cotizaciones.add(cotizacion);
    }
}
