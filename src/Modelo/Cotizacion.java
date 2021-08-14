package Modelo;

import java.util.Date;

public class Cotizacion {
    private int NumeroIdentificacion;
    private Date FechaYHora;
    private int CodigoVendedor;
    private Prenda prenda;
    private int UnidadesPrenda;
    private double precio;

    public Cotizacion(int NumeroIdentificacion, Date FechaYHora, int CodigoVendedor, Prenda prenda, int UnidadesPrenda, double precio) {
        this.NumeroIdentificacion = NumeroIdentificacion;
        this.FechaYHora = FechaYHora;
        this.CodigoVendedor = CodigoVendedor;
        this.prenda = prenda;
        this.UnidadesPrenda = UnidadesPrenda;
        this.precio = precio;
    }

    public int getNumeroIdentificacion() {
        return NumeroIdentificacion;
    }

    public Date getFechaYHora() {
        return FechaYHora;
    }

    public int getCodigoVendedor() {
        return CodigoVendedor;
    }

    public Prenda getPrenda() {
        return prenda;
    }

    public int getUnidadesPrenda() {
        return UnidadesPrenda;
    }

    public double getPrecio() {
        return precio;
    }

    public void setNumeroIdentificacion(int NumeroIdentificacion) {
        this.NumeroIdentificacion = NumeroIdentificacion;
    }

    public void setFechaYHora(Date FechaYHora) {
        this.FechaYHora = FechaYHora;
    }

    public void setCodigoVendedor(int CodigoVendedor) {
        this.CodigoVendedor = CodigoVendedor;
    }

    public void setPrenda(Prenda prenda) {
        this.prenda = prenda;
    }

    public void setUnidadesPrenda(int UnidadesPrenda) {
        this.UnidadesPrenda = UnidadesPrenda;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    
}
