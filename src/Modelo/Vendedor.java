package Modelo;

public class Vendedor {

    private String Nombre;
    private String Apellido;
    private int CodigoVendedor;

    public Vendedor(String Nombre, String Apellido, int CodigoVendedor) {
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.CodigoVendedor = CodigoVendedor;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public int getCodigoVendedor() {
        return CodigoVendedor;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public void setCodigoVendedor(int CodigoVendedor) {
        this.CodigoVendedor = CodigoVendedor;
    }

}
