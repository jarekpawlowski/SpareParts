package com.sparepartswarehouse.entity.producent;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.springframework.stereotype.Component;

import com.sparepartswarehouse.entity.typ.Typ;

@Component
@Entity
@Table(name = "producent")
public class Producent implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Producent_ID;

	@Column(name = "ProducentNazwa")
	private String producentNazwa;
	
	@OneToMany(mappedBy = "Producent", cascade = {CascadeType.ALL})
	private Set<Typ> Typy;

	public Producent() {
	};

	public int getId() {
		return Producent_ID;
	}
	
	public void setId(int Producent_Id){
		this.Producent_ID = Producent_Id;
	}

	public String getProducentNazwa() {
		return producentNazwa;
	}

	public void setProducentNazwa(String producent_nazwa) {
		this.producentNazwa = producent_nazwa;
	}
	
	public String getName(){
		return "Jarek";
	}

}
