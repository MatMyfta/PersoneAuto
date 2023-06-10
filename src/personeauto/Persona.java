package personeauto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Persona extends Record {
    static List<Persona> listaPersone = new ArrayList();
    String nome;
    String cognome;
    Integer anno;
    public Persona(String field1, String field2, Integer field3) {
	super(field1, field2, field3);
	this.nome = super.field1;
	this.cognome = super.field2;
	this.anno = super.field3;
    }
    public boolean isPresent() {
	for (Persona p : Persona.listaPersone) {
	    if (this.nome.equals(p.nome) 
		&& this.cognome.equals(p.cognome) 
		&& this.anno.equals(p.anno)) {
		return true;
	    }
	}
	return false;
    }
    public boolean isEmpty() {
	return (   this.nome.equals("") 
		|| this.cognome.equals("")
		|| this.anno == null);
    }
    public static String stampaPersone() {
	String s = new String();
	for (Persona p : Persona.listaPersone) {
	    s += p.nome + " " + p.cognome + " " + p.anno.toString() + "\n";
	}
	return s;
    }
    public static void mescolaPersone() {
	Collections.shuffle((List) listaPersone);
    }
    public static int contaPersone() {
	int res = 0;
	for (Persona p : Persona.listaPersone) res++;
	return res;
    }
}
