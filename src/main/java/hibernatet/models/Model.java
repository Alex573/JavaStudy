package hibernatet.models;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass

public abstract class Model implements Serializable{

    private static final long serialVersionUID = 3775384305112309944L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    public Model() {
    }
    public Model(Long id) {
       this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
