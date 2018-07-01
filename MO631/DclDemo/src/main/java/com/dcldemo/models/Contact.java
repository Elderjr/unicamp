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
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Table(name = "Contact")
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
    @NotNull
    private String telephone;

    @NotNull
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;
    

    public Contact(){
    }
    
    public Contact(String telephone, String description){
       this.telephone = telephone;
       this.description = description;
    }

    public int getId(){
      return this.id;
    }

    public void setId(int id){
      this.id = id;
    }

    public String getTelephone(){
      return this.telephone;
    }

    public void setTelephone(String telephone){
      this.telephone = telephone; 
    }

    public String getDescription(){
      return this.description;
    }

    public void setDescription(String description){
      this.description = description; 
    }

    public void setPerson(Person person){
      this.person = person;
    }
    

    
}
