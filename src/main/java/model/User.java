package model;

import org.springframework.data.jpa.domain.AbstractAuditable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@EntityListeners({AuditingEntityListener.class})
public class User extends AbstractAuditable<User, Long> {
    @Basic
    @Column
    private String name;

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User {" +
                "id='" + getId() + "', " +
                "name='" + getName() + "'} ";
    }

}