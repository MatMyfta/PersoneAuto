/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personeauto;

/**
 *
 * @author acer
 */
public class Record {
    String field1;
    String field2;
    Integer field3;
    Record(String field1, String field2, Integer field3) {
	this.field1 = field1;
	this.field2 = field2;
	this.field3 = field3;
    }
    public boolean equals(Record r) {
	return (this.field1.equals(r.field1)
		&& this.field2.equals(r.field2)
		&& this.field3.equals(r.field3));
    }
}
