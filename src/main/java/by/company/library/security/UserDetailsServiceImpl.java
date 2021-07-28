package by.company.library.security;

import by.company.library.domain.dbo.UserEntity;
import by.company.library.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetailsImpl loadUserByUsername(String passportNo) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByPassportNo(passportNo);

        if(userEntity == null) {
            throw new UsernameNotFoundException("User wasn't found. Check your input passport number");
        }

        return UserDetailsImpl.fromUserEntityToUserDetailsImpl(userEntity);
    }

}