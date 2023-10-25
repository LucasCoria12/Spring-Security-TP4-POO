package service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import model.User;


public interface UserService extends UserDetailsService {

    public User create(User user);
    
    public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException;
}
