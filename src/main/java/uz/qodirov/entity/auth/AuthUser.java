package uz.qodirov.entity.auth;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class AuthUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    private String email;

    @Column(name = "is_active", nullable = false)
    private boolean active;

    @Column(name = "is_blocked", nullable = false)
    private boolean blocked;

    private String profile_image;

    @OneToOne
    private AuthRole role;
}
