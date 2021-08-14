package Modelo;

public class Pantalon extends Prenda{
    private boolean chupin;

    public Pantalon(boolean chupin, boolean Calidad, double precio, int CantidadStock) {
        super(Calidad, precio, CantidadStock);
        this.chupin = chupin;
    }

    public boolean isChupin() {
        return chupin;
    }

    public void setChupin(boolean chupin) {
        this.chupin = chupin;
    }
    
}
