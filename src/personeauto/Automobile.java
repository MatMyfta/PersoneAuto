/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personeauto;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author acer
 */
public class Automobile extends Record {
    
    static List<Automobile> listaAuto = new ArrayList();
    
    String marca;
    String modello;
    Integer prezzo;

    public Automobile(String field1, String field2, Integer field3) {
	super(field1, field2, field3);
	this.marca = super.field1;
	this.modello = super.field2;
	this.prezzo = super.field3;
    }
    
    public boolean isPresent() {
	for (Automobile p : Automobile.listaAuto) {
	    if (this.marca.equals(p.marca) 
		&& this.modello.equals(p.modello) 
		&& this.prezzo.equals(p.prezzo)) {
		return true;
	    }
	}
	return false;
    }
    
    public boolean isEmpty() {
	if (this.marca.equals(new String(""))
	    || this.modello.equals(new String(""))
	    || this.prezzo.equals(null)) {
	    return true;
	}
	return false;
    }
    
    public static String stampaAuto() {
	String s = new String();
	for (Automobile p : Automobile.listaAuto) {
	    s += p.marca + " " + p.modello + " " + p.prezzo.toString() + "\n";
	}
	return s;
    }
    
}
