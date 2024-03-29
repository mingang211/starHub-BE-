package com.sparta.devstar_be.user.security;

import com.sparta.devstar_be.user.entity.User;
import com.sparta.devstar_be.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email).orElseThrow(
                () -> new UsernameNotFoundException("[Exception 발생] 가입된 정보가 없습니다."));
        log.info("userEmail"+user.getEmail());
        return new UserDetailsImpl(user);
    }
}