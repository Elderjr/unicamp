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
@Table(name = "Person")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
    @NotNull
    private String name;

    @NotNull
    private String email;

    @NotNull
    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY, mappedBy = "person")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Address> addresses;

    @NotNull
    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY, mappedBy = "person")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Contact> contacts;
    

    public Person(){
      this.addresses = new LinkedList<>();
      this.contacts = new LinkedList<>();
    }
    
    public Person(String name, String email, List<Address> addresses, List<Contact> contacts){
       this.name = name;
       this.email = email;
       this.addresses = addresses;
       this.contacts = contacts;
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

    public String getEmail(){
      return this.email;
    }

    public void setEmail(String email){
      this.email = email; 
    }

    public List<Address> getAddresses(){
      return this.addresses;
    }

    public void setAddresses(List<Address> addresses){
      this.addresses = addresses; 
    }

    public List<Contact> getContacts(){
      return this.contacts;
    }

    public void setContacts(List<Contact> contacts){
      this.contacts = contacts; 
    }

    

    
}
