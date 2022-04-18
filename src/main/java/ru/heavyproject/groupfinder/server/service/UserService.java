package ru.heavyproject.groupfinder.server.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.heavyproject.groupfinder.server.dao.UserRepository;
import ru.heavyproject.groupfinder.server.entities.User;

import java.util.Optional;

@Service
@Slf4j
public class UserService implements UserDetailsService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository.findByUsername(username);
        User user = userOptional.orElse(null);
        return user;
    }

    public void save (User user) {
        log.info(user.toString() + ": registred");
        userRepository.save(user);
    }
}
