package iats.usmp.demovc.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name = "t_product")
public class Product{

    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer id;

    private String name;
    private String precio;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrecio() {
        return this.precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }


}