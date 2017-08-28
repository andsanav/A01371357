/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.pkg1;

/**
 *
 * @author Andrea
 */
public abstract class Planta extends Empleado {

	protected double pagoSemanal;
	protected boolean[] prestaciones;
	protected double diaVacaciones;
	protected String nombrePuesto;
	
	private static final String [] PRESTACIONES = {"Vales despensa", "Afore", "Infonavit", "Vacaciones Semana Santa", 
				"Vacaciones Verano", "Descuento proveedores afiliados", "Seguro de auto", "Seguro de vida"}; 
	private static final double [] PAGO_PRESTACIONES = {1000, 0.2, 0.1, 7, 2, 0.25, 5000, 25000}; 				 
	private static final double PORCENTAJE_PLANTA = 0.1;			
	private static final int MAXIMO_SUELDO = 25000;
	
	

        
	public Planta( String nombre, String apellido, int antiguedad, double pagoSemanal, boolean[] prestaciones) {
		super(nombre, apellido, antiguedad);
                
                this.prestaciones = prestaciones;
                
                /* for(int i=0; i < prestaciones.length; i++)
                    this.prestaciones[i] = prestaciones[i];
                */
                
                if(pagoSemanal > 0 && pagoSemanal<=MAXIMO_SUELDO)
                    this.pagoSemanal = pagoSemanal;
                else
                    this.pagoSemanal = 0;
                
                this.diaVacaciones = this.pagoSemanal*this.antiguedad*PORCENTAJE_PLANTA;
        }
   
    private String regresaPrestaciones() {
         String prestacion = "";
         for(int i=1; i< this.prestaciones.length; i++){
             if(prestaciones[i] == true) {
                 prestacion = PRESTACIONES[1];
             }
         }
    	return prestacion;
	}
	
	
        @Override
	public double sueldo() { 
            double sueldo = this.pagoSemanal;
            for(int i=0; i< prestaciones.length; i++) {
                if(prestaciones[i] == true) {
                    switch (i) {
                        case 0:        
                        case 6:
                        case 7:
                            sueldo += PAGO_PRESTACIONES[i];
                            break;
                        case 1:
                        case 2:
                        case 5:
                            sueldo += PAGO_PRESTACIONES[i] * pagoSemanal;
                            break;
                        case 3:
                        case 4:
                            sueldo += PAGO_PRESTACIONES[i] * diaVacaciones;
                            break;
                        default:
                            break;
                    }
	}
            }
            return sueldo;
        }
	
    public void setPagoSemanal( double pagoSemanal ) { 
		if (pagoSemanal > 0 && pagoSemanal <= MAXIMO_SUELDO)
			this.pagoSemanal = pagoSemanal;
	}
   
        @Override
   	public String toString() {
		return "\n***  Empleado de Planta  ***\n" + super.toString() + "\nCon puesto: " + this.getNombrePuesto() +
				"\nPago semanal: " + this.pagoSemanal + "\nSueldo integrado: " + this.sueldo() + "\nPrestaciones: " + this.regresaPrestaciones();
	}
	
	public String getNombrePuesto() {
		return this.nombrePuesto;
	}
	
        public abstract void setNombrePuesto(String nombrePuesto);
}