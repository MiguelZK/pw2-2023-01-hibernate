package dev.ifrs.model;

import java.util.ArrayList;
import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Channel extends PanacheEntity {

    private String hash;

    @ManyToMany(mappedBy = "channels")
    private List<User> users;

    public Channel() {
        this.users = new ArrayList<>();
    }

}
