package com.sparepartswarehouse.entity.typ;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;

import com.sparepartswarehouse.entity.model.Model;
import com.sparepartswarehouse.entity.producent.Producent;

@Component
@Entity
@Table(name = "Typ")
public class Typ implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Typ_ID;

	@Column(name = "TypNazwa")
	private String TypNazwa;

	@Column(name = "Rodzaj")
	private String rodzaj;

	@Column(name = "InfoDodatkowe")
	private String infoDodatkowe;

	@ManyToOne()
	@JoinColumn(name = "Producent_ID")
	private Producent Producent;
	
	@OneToMany(mappedBy = "Typ", cascade = {CascadeType.ALL})
	private Set<Model> Modele;

	public Typ(String typ, String rodzaj, String info) {
		this.TypNazwa = typ;
		this.rodzaj = rodzaj;
		this.infoDodatkowe = info;
	};

	public Typ() {

	}

	public int getId() {
		return Typ_ID;
	}
	
	public void setId(int Typ_ID){
		this.Typ_ID = Typ_ID;
	}
	
	public Producent getProducent()	{
		return this.Producent;
	}
	
	public void setProducent(Producent producent) {
		this.Producent= producent;
	}

	public String getTypNazwa() {
		return TypNazwa;
	}

	public void setTypNazwa(String typ_nazwa) {
		this.TypNazwa = typ_nazwa;
	}

	public String getRodzaj() {
		return rodzaj;
	}

	public void setRodzaj(String rodzaj) {
		this.rodzaj = rodzaj;
	}

	public String getInfoDodatkowe() {
		return infoDodatkowe;
	}

	public void setInfoDodatkowe(String info) {
		this.infoDodatkowe = info;
	}
}
