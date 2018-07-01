package com.dcldemo.models;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
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
import javax.validation.constraints.NotNull;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Table(name = "Address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
    @NotNull
    private long cep;

    @NotNull
    private String street;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;
    

    public Address(){
    
    }

    public Address(long cep, String street){
       this.cep = cep;
       this.street = street;
    }

    public int getId(){
      return this.id;
    }

    public void setId(int id){
      this.id = id;
    }

    public long getCep(){
      return this.cep;
    }

    public void setCep(long cep){
      this.cep = cep; 
    }

    public String getStreet(){
      return this.street;
    }

    public void setStreet(String street){
      this.street = street; 
    }

    public void setPerson(Person person){
      this.person = person;
    }
    
    
}
