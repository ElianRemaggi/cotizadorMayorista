/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mayoristarevision;

import Controlador.Cotizador;
import Vista.CotizadorVista;
import Vista.HistorialVista;

/**
 *
 * @author Coding
 */
public class MayoristaRevision {
    
    private CotizadorVista cotizadorVista;
    private HistorialVista historialVista;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CotizadorVista cotizadorVista = new CotizadorVista();
        HistorialVista historialVista = new HistorialVista();
        Cotizador cotizador = new Cotizador(cotizadorVista, historialVista);
        cotizador.iniciarCotizador(cotizadorVista);
        cotizadorVista.setVisible(true);
        
    }
    
}
