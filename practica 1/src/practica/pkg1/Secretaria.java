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
public class Secretaria extends Planta {

	public Secretaria( String nombre, String apellido, int antiguedad, boolean[] prestaciones, double pagoSemanal, String nombrePuesto) {
		super( nombre, apellido, antiguedad, pagoSemanal, prestaciones);  
		setNombrePuesto(nombrePuesto);
	}
   
   
        @Override
   public String toString() {
		return "\n\n***  Secretaria  ***\n" + super.toString() + "\nSueldo integrado: " + this.sueldo();
	}
	
	
        @Override
	public void setNombrePuesto(String nombre){
		this.nombrePuesto = nombre;
	}
	
	
	public String llenaRegistros() {
		return "llena los registros de los empleados del departamento";
	}
	
}