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
@Table(name = "Person")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
    @NotNull
    private String name;

    @NotNull
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "person")
    private List<Address> addresses;
    

    public Person(){
    
    }

    public Person(String name, List<Address> addresses){
       this.name = name;
       this.addresses = addresses;
    }

    public int getId(){
      return this.id;
    }

    public void setId(int id){
      this.id = id;
    }

    public String getName(){
      return this.name;
    }

    public void setName(String name){
      this.name = name; 
    }

    public List<Address> getAddresses(){
      return this.addresses;
    }

    public void setAddresses(List<Address> addresses){
      this.addresses = addresses; 
    }

    
    
}
