package com.horvat.basicwebshop.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "role")
public class Role extends BaseEntity{

    public Role(Long id, String name, Set<User> users) {
        super(id);
        this.name = name;
        this.users = users;
    }

    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;
}
