package com.sparepartswarehouse.entity.model;

import java.io.Serializable;

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

import org.springframework.stereotype.Component;

import com.sparepartswarehouse.entity.typ.Typ;

@Component
@Entity
@Table(name = "model")
public class Model implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Model_ID;

	@Column(name = "ModelNazwa")
	private String modelNazwa;

	@Column(name = "Obudowa")
	private String obudowa;
	
	@Column(name = "Info")
	private String info;

	@ManyToOne()
	@JoinColumn(name = "Typ_ID")
	private Typ Typ;

	public Model() {
	};

	public int getId() {
		return Model_ID;
	}
	
	public void setId(int Model_ID){
		this.Model_ID = Model_ID;
	}
	
	public String getModelNazwa() {
		return modelNazwa;
	}

	public void setModelNazwa(String modelName) {
		this.modelNazwa = modelName;
	}

	public String getObudowa() {
		return obudowa;
	}

	public void setObudowa(String obudowa) {
		this.obudowa = obudowa;
	}
	
	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	
	public Typ getTyp()	{
		return this.Typ;
	}
	
	public void setTyp(Typ type) {
		this.Typ = type;
	}
	
	public String getName(){
		return modelNazwa;
	}

}