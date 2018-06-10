package org.leagueofcole.musicFoundationProject.role;


import javax.persistence.*;

import org.leagueofcole.musicFoundationProject.teacher.Teacher;

import java.util.Set;

@Entity
@Table(name = "role")
public class Role {
	@Id
	@GeneratedValue
    private Long id;
    private String name;
   //@ElementCollection(targetClass=Teacher.class)
    @ManyToMany(fetch=FetchType.EAGER, mappedBy = "roles")
    private Set<Teacher> teachers;

    public Role(String name) {
    		this.name = name;
    }
    
    Role(){
    	
    
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(fetch=FetchType.EAGER, mappedBy = "roles")
    public Set<Teacher> getUsers() {
        return teachers;
    }

    public void setUsers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }
}
