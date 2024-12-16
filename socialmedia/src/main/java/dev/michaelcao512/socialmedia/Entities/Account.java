package dev.michaelcao512.socialmedia.Entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PreUpdate;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    @Column(unique = true, nullable = false)
    private String username;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;

    @Column(updatable = false)
    private LocalDateTime dateCreated = LocalDateTime.now();
    private LocalDateTime dateUpdated = LocalDateTime.now();

    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
    private UserInfo userInfo;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<Friendship> following;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<Friendship> followers;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<Post> posts;


    @PreUpdate
    public void onUpdate() {
        this.dateUpdated = LocalDateTime.now();
    }
}
