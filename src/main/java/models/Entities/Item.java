package models.Entities;


import javax.persistence.*;

@Entity
@Table(name = "itemtable")
public class Item {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "code")
    private int code;

    @Column(name = "name")
    private String name;

    @Column(name = "productgroup")
    private ProductGroup productGroup;

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductGroup getProductGroup() {
        return productGroup;
    }

    public void setProductGroup(ProductGroup productGroup) {
        this.productGroup = productGroup;
    }

    public String getOomment() {
        return oomment;
    }

    public void setOomment(String oomment) {
        this.oomment = oomment;
    }

    public Item() {
    }

    @Column(name = "comment")
    String oomment;


    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", code=" + code +
                ", name='" + name + '\'' +
                ", productGroup=" + productGroup +
                ", oomment='" + oomment + '\'' +
                '}';
    }

}
