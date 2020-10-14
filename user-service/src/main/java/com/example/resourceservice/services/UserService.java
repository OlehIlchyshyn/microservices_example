package com.example.resourceservice.services;

import com.example.resourceservice.dto.UserDetailsDTO;
import com.example.resourceservice.entities.UserDetails;
import com.example.resourceservice.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    /**
     * =================================================
     * Save the user and return the saved user details.
     * =================================================
     * @param inputUser
     * @return
     */
    @Transactional
    public UserDetailsDTO saveUpdate(UserDetailsDTO inputUser) {
        try {
            UserDetails userDetails = new UserDetails();
            userDetails.setName(inputUser.getName());
            userDetails.setAge(Integer.parseInt(inputUser.getAge()));
            return getUserDetailsDTO(userRepository.save(userDetails));
        } catch (Exception e) {
            log.warn("/***** Exception in UserService -> saveUpdate(): " + e);
        }
        return null;
    }

    /**
     * ========================================
     * Return the user details based on id.
     * ========================================
     * @param id
     * @return
     */
    public UserDetailsDTO getById(Long id) {
        return getUserDetailsDTO(userRepository.getOne(id));
    }

    /**
     * ================================================
     * Returns the user details lisst based on name.
     * ================================================
     * @param name
     * @return
     */
    public List<UserDetailsDTO> getByName(String name) {
        List<UserDetails> userDetailsList = userRepository.findUserByName(name);
        if (CollectionUtils.isEmpty(userDetailsList)) {
            return null;
        }
        return userDetailsList
                .stream()
                .map(this::getUserDetailsDTO)
                .collect(Collectors.toList());
    }

    public UserDetailsDTO getUserDetailsDTO(UserDetails userDetails) {
        return new UserDetailsDTO(
                userDetails.getId().toString(),
                userDetails.getName(),
                userDetails.getAge().toString()
                );
    }

}
