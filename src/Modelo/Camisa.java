package Modelo;

public class Camisa extends Prenda{
    private boolean mangaLarga; 
    private boolean cuelloMao;

    public Camisa(boolean mangaLarga, boolean cuelloMao, boolean Calidad, double precio, int CantidadStock) {
        super(Calidad, precio, CantidadStock);
        this.mangaLarga = mangaLarga;
        this.cuelloMao = cuelloMao;
    }

    public boolean isMangaLarga() {
        return mangaLarga;
    }

    public boolean isCuelloMao() {
        return cuelloMao;
    }

    public void setMangaLarga(boolean mangaLarga) {
        this.mangaLarga = mangaLarga;
    }

    public void setCuelloMao(boolean cuelloMao) {
        this.cuelloMao = cuelloMao;
    }


    
}
