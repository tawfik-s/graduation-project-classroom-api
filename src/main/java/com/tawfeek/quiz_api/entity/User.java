package com.tawfeek.quiz_api.entity;


import com.tawfeek.quiz_api.model.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String userName;

    private String password;

    @OneToMany(cascade =CascadeType.ALL)
    private List<ClassRoom> classRooms;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(unique = true)
    private String email;

    public User(String userName, String password, Role role, String email) {
        this.userName = userName;
        this.password = password;
        this.role = role;
        this.email = email;
    }

    public User(long id, String name, String password, Role role, String mail) {
        this.id=id;
        this.userName=name;
        this.password=password;
        this.role=role;
        this.email=mail;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    public void addClassRoom(ClassRoom classRoom){
        if(classRooms==null){
            classRooms=new ArrayList<>();
        }
        classRooms.add(classRoom);
    }
    @Override
    public String getUsername() {
        return email;
    }

    public String getActualName(){
        return userName;
    }

    @Override
    public String getPassword() {
        return password;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
