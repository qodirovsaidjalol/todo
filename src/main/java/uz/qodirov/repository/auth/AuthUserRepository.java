package uz.qodirov.repository.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.qodirov.entity.auth.AuthUser;

public interface AuthUserRepository extends JpaRepository<AuthUser, Long> {
    AuthUser findAuthUserByUsername(String username);
}
