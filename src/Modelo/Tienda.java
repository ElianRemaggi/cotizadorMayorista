package Modelo;

import java.util.ArrayList;

public class Tienda {
    private String Nombre;
    private String Direccion;
    private ArrayList<Prenda>Prendas;

    public Tienda(String Nombre, String Direccion) {
        this.Nombre = Nombre;
        this.Direccion = Direccion;
        this.Prendas = new ArrayList<>();
    }

    public String getNombre() {
        return Nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    public ArrayList<Prenda> getPrendas() {
        return Prendas;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public void setPrendas(ArrayList<Prenda> Prendas) {
        this.Prendas = Prendas;
    }

    
    public void agregarPrenda(Prenda prenda){
        this.Prendas.add(prenda);
    }
}
