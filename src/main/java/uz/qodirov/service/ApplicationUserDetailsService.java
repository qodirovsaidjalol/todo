package uz.qodirov.service;


import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uz.qodirov.configs.UserDetails;
import uz.qodirov.entity.auth.AuthUser;
import uz.qodirov.repository.auth.AuthUserRepository;


@Service
public class ApplicationUserDetailsService implements UserDetailsService {

    private final AuthUserRepository authUserRepository;

    public ApplicationUserDetailsService(AuthUserRepository authUserRepository) {
        this.authUserRepository = authUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AuthUser user = authUserRepository.findAuthUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new UserDetails(user);
    }
}
