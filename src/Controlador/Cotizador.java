/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.*;
import Modelo.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Coding
 */
public class Cotizador implements ActionListener {

    //Vistas
    private CotizadorVista cotizadorVista;
    private HistorialVista historialVista;

    //Modelos
    private Camisa camisa;
    private Pantalon pantalon;
    private Tienda tienda;
    private Vendedor vendedor;
    private int ContadorCotizaciones;
    private HistorialCotizaciones historialCotizaciones;

    public Cotizador(CotizadorVista cotizadorVista, HistorialVista historialVista) {
        this.cotizadorVista = cotizadorVista;
        this.historialVista = historialVista;
        this.tienda = new Tienda("Nombre Tienda", "Direccion 123");
        this.vendedor = new Vendedor("Juan", "Perez", 0);
        this.historialCotizaciones = new HistorialCotizaciones(vendedor);
        //Action Listeners de los botones en la vista
        this.cotizadorVista.btnCotizar.addActionListener(this);
        this.cotizadorVista.btnHistorialCotizacion.addActionListener(this);
        this.historialVista.btnCerrar.addActionListener(this);
        this.historialVista.btnCerrar1.addActionListener(this);
        this.ContadorCotizaciones = 0;
        
        //Carga de datos
        //1000 camisas en total, de las cuales
        //500 de manga corta, de las cuales
        //200 son de cuello mao, de las cuales:
        //100 son de calidad Standard
        Camisa cortaMaoStandar = new Camisa(false, true, false, 0, 100);
        tienda.agregarPrenda(cortaMaoStandar);
        //100 son de calidad Premium
        Camisa cortaMaoPremium = new Camisa(false, true, true, 0, 100);
        tienda.agregarPrenda(cortaMaoPremium);

        //300 son de cuello normal, de las cuales:
        //150 son de calidad Standard
        Camisa cortaStandar = new Camisa(false, false, false, 0, 150);
        tienda.agregarPrenda(cortaStandar);
        //150 son de calidad Premium
        Camisa cortaPremium = new Camisa(false, false, true, 0, 150);
        tienda.agregarPrenda(cortaPremium);

        //500 de manga Larga, de las cuales
        //150 son de cuello mao, de las cuales:
        //75 son de calidad Standard
        Camisa largaMaoStandar = new Camisa(true, true, false, 0, 75);
        tienda.agregarPrenda(largaMaoStandar);
        //75 son de calidad Premium
        Camisa largaMaoPremium = new Camisa(true, true, true, 0, 75);
        tienda.agregarPrenda(largaMaoPremium);

        //350 son de cuello normal, de las cuales:
        //175 son de calidad Standard
        Camisa largaStandar = new Camisa(true, false, false, 0, 175);
        tienda.agregarPrenda(largaStandar);
        //175 son de calidad Premium
        Camisa largaPremium = new Camisa(true, false, true, 0, 175);
        tienda.agregarPrenda(largaPremium);

        //2000 pantalones en total, de los cuales:
        //1500 son chupines, de los cuales
        //750 son de calidad Standard
        Pantalon chupinStandar = new Pantalon(true, false, 0, 750);
        tienda.agregarPrenda(chupinStandar);
        //750 son de calidad Premium
        Pantalon chupinPremium = new Pantalon(true, true, 0, 750);
        tienda.agregarPrenda(chupinPremium);
        //500 son normales, de los cuales

        //250 son de calidad Standard
        Pantalon normalStandar = new Pantalon(false, false, 0, 250);
        tienda.agregarPrenda(normalStandar);
        //250 son de calidad Premium
        Pantalon normalPremium = new Pantalon(false, true, 0, 250);
        tienda.agregarPrenda(normalPremium);

    }

    public void iniciarCotizador(CotizadorVista cotizadorVista) {
        this.cotizadorVista.setTitle("Cotizador Express");
        this.cotizadorVista.setLocationRelativeTo(null);
        this.cotizadorVista.setVisible(true);
    }

    public void inciarHistorial(HistorialCotizaciones historialCotizaciones) {
        this.historialVista.setTitle("Historial Cotizaciones");
        this.historialVista.setLocationRelativeTo(null);
        this.historialVista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == cotizadorVista.btnCotizar) {
            
            if (!this.valdiaciones()) {
                System.out.println("Existen errores en los datos ingresados");
                return;
            }

            double preciofinal=0;
            Prenda prenda = null;
            
            
            if (this.cotizadorVista.rbCamisa.isSelected()) {
                //camisa
                if (!this.cotizadorVista.cbMangaLarga.isSelected()) {
                    //mangacorta
                    if (this.cotizadorVista.cbCuelloMao.isSelected()) {
                        //cuello mao
                        if (this.cotizadorVista.rbStandar.isSelected()) {
                            if (this.tienda.getPrendas().get(0).getCantidadStock() > Integer.parseInt(this.cotizadorVista.tfCantidad.getText())) {
                                prenda = this.tienda.getPrendas().get(0);
                                preciofinal = Double.parseDouble(this.cotizadorVista.tfPrecio.getText()) * Integer.parseInt(this.cotizadorVista.tfCantidad.getText()) * 0.9 * 1.03; 
                            } else {
                                JOptionPane.showMessageDialog(cotizadorVista, "No posee stock suficiente");
                                return;
                            }
                        } else {
                            if (this.tienda.getPrendas().get(1).getCantidadStock() > Integer.parseInt(this.cotizadorVista.tfCantidad.getText())) {
                                prenda = this.tienda.getPrendas().get(1);
                                preciofinal = Double.parseDouble(this.cotizadorVista.tfPrecio.getText())*Integer.parseInt(this.cotizadorVista.tfCantidad.getText())  * 0.9 * 1.03 * 1.3;
                            } else {
                                JOptionPane.showMessageDialog(cotizadorVista, "No posee stock suficiente");
                                return;
                            }
                        }
                    } else {
                        //sin cuello mao
                        if (this.cotizadorVista.rbStandar.isSelected()) {
                            if (this.tienda.getPrendas().get(2).getCantidadStock() > Integer.parseInt(this.cotizadorVista.tfCantidad.getText())) {
                                prenda = this.tienda.getPrendas().get(2);
                                preciofinal = Double.parseDouble(this.cotizadorVista.tfPrecio.getText())*Integer.parseInt(this.cotizadorVista.tfCantidad.getText())  * 0.9;
                            } else {
                                JOptionPane.showMessageDialog(cotizadorVista, "No posee stock suficiente");
                                return;
                            }
                        } else {
                            if (this.tienda.getPrendas().get(3).getCantidadStock() > Integer.parseInt(this.cotizadorVista.tfCantidad.getText())) {
                                prenda = this.tienda.getPrendas().get(3);
                                preciofinal = Double.parseDouble(this.cotizadorVista.tfPrecio.getText())*Integer.parseInt(this.cotizadorVista.tfCantidad.getText()) * 0.9 * 1.3;
                            } else {
                                JOptionPane.showMessageDialog(cotizadorVista, "No posee stock suficiente");
                                return;
                            }
                        }
                    }
                } else {
                    //manga larga
                    if (this.cotizadorVista.cbCuelloMao.isSelected()) {
                        //cuello mao
                        if (this.cotizadorVista.rbStandar.isSelected()) {
                            if (this.tienda.getPrendas().get(4).getCantidadStock() > Integer.parseInt(this.cotizadorVista.tfCantidad.getText())) {
                                prenda = this.tienda.getPrendas().get(4);
                                preciofinal = Double.parseDouble(this.cotizadorVista.tfPrecio.getText())*Integer.parseInt(this.cotizadorVista.tfCantidad.getText())  * 1.03;
                            } else {
                                JOptionPane.showMessageDialog(cotizadorVista, "No posee stock suficiente");
                                return;
                            }
                        } else {
                            if (this.tienda.getPrendas().get(5).getCantidadStock() > Integer.parseInt(this.cotizadorVista.tfCantidad.getText())) {
                                prenda = this.tienda.getPrendas().get(5);
                                preciofinal = Double.parseDouble(this.cotizadorVista.tfPrecio.getText())*Integer.parseInt(this.cotizadorVista.tfCantidad.getText())  * 1.03 * 1.3;
                            } else {
                                JOptionPane.showMessageDialog(cotizadorVista, "No posee stock suficiente");
                                return;
                            }
                        }
                    } else {
                        //sin cuello mao
                        if (this.cotizadorVista.rbStandar.isSelected()) {
                            if (this.tienda.getPrendas().get(6).getCantidadStock() > Integer.parseInt(this.cotizadorVista.tfCantidad.getText())) {
                                prenda = this.tienda.getPrendas().get(6);
                                preciofinal = Double.parseDouble(this.cotizadorVista.tfPrecio.getText())*Integer.parseInt(this.cotizadorVista.tfCantidad.getText()) ;
                            } else {
                                JOptionPane.showMessageDialog(cotizadorVista, "No posee stock suficiente");
                                return;
                            }
                        } else {
                            if (this.tienda.getPrendas().get(7).getCantidadStock() > Integer.parseInt(this.cotizadorVista.tfCantidad.getText())) {
                                prenda = this.tienda.getPrendas().get(7);
                                preciofinal = Double.parseDouble(this.cotizadorVista.tfPrecio.getText())*Integer.parseInt(this.cotizadorVista.tfCantidad.getText())  * 1.3;
                            } else {
                                JOptionPane.showMessageDialog(cotizadorVista, "No posee stock suficiente");
                                return;
                            }
                        }
                    }
                }
            } else {
                //pantalon
                if (this.cotizadorVista.cbChupin.isSelected()) {
                    if (this.cotizadorVista.rbStandar.isSelected()) {
                        if (this.tienda.getPrendas().get(8).getCantidadStock() > Integer.parseInt(this.cotizadorVista.tfCantidad.getText())) {
                            prenda = this.tienda.getPrendas().get(8);
                            preciofinal = Double.parseDouble(this.cotizadorVista.tfPrecio.getText())*Integer.parseInt(this.cotizadorVista.tfCantidad.getText()) *0.88;
                        } else {
                            JOptionPane.showMessageDialog(cotizadorVista, "No posee stock suficiente");
                            return;
                        }
                    } else {
                        if (this.tienda.getPrendas().get(9).getCantidadStock() > Integer.parseInt(this.cotizadorVista.tfCantidad.getText())) {
                            prenda = this.tienda.getPrendas().get(9);
                            preciofinal = Double.parseDouble(this.cotizadorVista.tfPrecio.getText())*Integer.parseInt(this.cotizadorVista.tfCantidad.getText()) *0.88 * 1.3;
                        } else {
                            JOptionPane.showMessageDialog(cotizadorVista, "No posee stock suficiente");
                            return;
                        }
                    }
                } else {
                    if (this.cotizadorVista.rbStandar.isSelected()) {
                        if (this.tienda.getPrendas().get(10).getCantidadStock() > Integer.parseInt(this.cotizadorVista.tfCantidad.getText())) {
                            prenda = this.tienda.getPrendas().get(10);
                            preciofinal = Double.parseDouble(this.cotizadorVista.tfPrecio.getText())*Integer.parseInt(this.cotizadorVista.tfCantidad.getText());
                        } else {
                            JOptionPane.showMessageDialog(cotizadorVista, "No posee stock suficiente");
                            return;
                        }
                    } else {
                        if (this.tienda.getPrendas().get(11).getCantidadStock() > Integer.parseInt(this.cotizadorVista.tfCantidad.getText())) {
                            prenda = this.tienda.getPrendas().get(11);
                            preciofinal = Double.parseDouble(this.cotizadorVista.tfPrecio.getText())*Integer.parseInt(this.cotizadorVista.tfCantidad.getText()) * 1.3;
                        } else {
                            JOptionPane.showMessageDialog(cotizadorVista, "No posee stock suficiente");
                            return;
                        }
                    }
                }
            }
        
        preciofinal = Math.round(preciofinal*100.0)/100.0;
        this.cotizadorVista.labelPecioFinal.setText(""+ preciofinal);
        Date date = new Date();
        Cotizacion cotizacion = new Cotizacion(this.ContadorCotizaciones, date, this.vendedor.getCodigoVendedor(), prenda, Integer.parseInt(this.cotizadorVista.tfCantidad.getText()), preciofinal);
        this.historialCotizaciones.agregarCotizacion(cotizacion);
        this.ContadorCotizaciones++;
        }

        if (e.getSource() == cotizadorVista.btnHistorialCotizacion) {
            this.inciarHistorial(historialCotizaciones);
            DefaultTableModel modelo = (DefaultTableModel) this.historialVista.tabla.getModel();
            this.eliminarRegistros(modelo);
            this.cargarTabla();
            this.historialVista.setVisible(true);
        }
        
        if(e.getSource() == historialVista.btnCerrar || e.getSource() == historialVista.btnCerrar1){
            this.historialVista.dispose();
        }

    }

    public boolean valdiaciones() {

        //La mayor parte de las validaciones estan en la vista, de ser un entorno web, utilizaria mas validaicones dobles, tanto en la vista como el codigo siguiente
        if (this.cotizadorVista.rbCamisa.isSelected() && this.cotizadorVista.rbPantalon.isSelected()) {
            JOptionPane.showMessageDialog(cotizadorVista, "Camisa tiene seleccionada opciones de pantalon");
            return false;
        }

        if (!this.cotizadorVista.rbPremium.isSelected() && !this.cotizadorVista.rbStandar.isSelected()) {
            JOptionPane.showMessageDialog(cotizadorVista, "Es necesario Seleccionar un tipo de calidad, standar o premium");
            return false;
        }

        if (!this.cotizadorVista.rbCamisa.isSelected() && !this.cotizadorVista.rbPantalon.isSelected()) {
            JOptionPane.showMessageDialog(cotizadorVista, "Seleccione un tipo de prenda");
            return false;
        }

        if (this.cotizadorVista.tfPrecio.getText().equals("")/*Falta Validacion si es numero */) {
            JOptionPane.showMessageDialog(cotizadorVista, "Seleccione una precio de prenda para poder cotizar");
            return false;
        }

        if (this.cotizadorVista.tfCantidad.getText().equals("")/*Falta Validacion si es numero */) {
            JOptionPane.showMessageDialog(cotizadorVista, "Seleccione una cantidad de prendas para poder cotizar");
            return false;
        }

        return true;
    }

    //Logica Historial
    
    
    public void cargarTabla(){
        DefaultTableModel modelo = (DefaultTableModel) this.historialVista.tabla.getModel();
        this.eliminarRegistros(modelo);
        
        for(Cotizacion c : this.historialCotizaciones.Cotizaciones){
        
                    Object[] fila = { c.getNumeroIdentificacion(),c.getCodigoVendedor(),c.getUnidadesPrenda(),c.getFechaYHora(),c.getPrenda(),c.getPrecio()
                    };
                    modelo.addRow(fila);
        }
    }
    
    public static void eliminarRegistros(final DefaultTableModel modelo) {
        for (int i = modelo.getRowCount() - 1; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }
}
