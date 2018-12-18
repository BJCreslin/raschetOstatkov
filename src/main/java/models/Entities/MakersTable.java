package models.Entities;


import javax.persistence.*;


/* Таблица логистов, тех кто "делает" товары  */
/*ИД делается автоматически базой, Имя задаётся*/

@Entity
@Table(name = "maketable")
public class MakersTable {
    @Id
    @Column(name = "code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int codeMaker;

    public MakersTable() {
    }

    @Column(name = "makersname")
    String makerName;

    public int getCodeMaker() {
        return codeMaker;
    }

    public void setCodeMaker(int codeMaker) {
        this.codeMaker = codeMaker;
    }

    public String getMakerName() {
        return makerName;
    }

    public void setMakerName(String makerName) {
        this.makerName = makerName;
    }

    @Override
    public String toString() {
        return "MakersTable{" +
                "codeMaker=" + codeMaker +
                ", makerName='" + makerName + '\'' +
                '}';
    }
}
