package edu.unbosque.JPATutorial.jpa.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "UserApp")
public class UserApp {

    @Id
    @Column(name = "email")
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String role;

    // FetchType.EAGER: When we retrieve an user, we'll also automatically retrieve all of its corresponding wallet histories
    @OneToMany(mappedBy = "userApp", fetch = FetchType.EAGER)
    private List<WalletHistory> walletHistories = new ArrayList<>();

    public UserApp() {
    }

    public UserApp(String email, String password, String name, String role) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public List<WalletHistory> getWalletHistories() {
        return walletHistories;
    }
}
