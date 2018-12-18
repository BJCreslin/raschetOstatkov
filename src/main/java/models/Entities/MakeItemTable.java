package models.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "make")
public class MakeItemTable {
    @Id
    @Column(name = "code")
    private int code;
    @Column(name = "maker")
    private MakersTable makersTable;
    @Column(name = "min")
    private int min;

    public MakeItemTable() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public MakersTable getMakersTable() {
        return makersTable;
    }

    public void setMakersTable(MakersTable makersTable) {
        this.makersTable = makersTable;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    @Override
    public String toString() {
        return "MakeItemTable{" +
                "code=" + code +
                ", makersTable=" + makersTable +
                ", min=" + min +
                '}';
    }
}
