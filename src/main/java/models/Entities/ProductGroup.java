package models.Entities;


import javax.persistence.*;

@Entity
@Table(name = "productgroup")
public class ProductGroup {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "maketable")
    private MakersTable makersTable;


    public ProductGroup() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MakersTable getMakersTable() {
        return makersTable;
    }

    public void setMakersTable(MakersTable makersTable) {
        this.makersTable = makersTable;
    }

    @Override
    public String toString() {
        return "ProductGroup{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", makersTable=" + makersTable +
                '}';
    }
}
