package com.mentimeterclone.api.mentiUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.regex.Pattern;

@Service public class MentiUserService {
    private final MentiUserRepository mentiUserRepository;


    @Autowired public MentiUserService(MentiUserRepository mentiUserRepository) {
        this.mentiUserRepository = mentiUserRepository;
    }

    public Optional<MentiUser> getUser(Long userId) {
        Optional<MentiUser> userOptional = mentiUserRepository.findById(userId);

        if (userOptional.isEmpty()) {
            throw new IllegalStateException("User with id " + userId + "does not exist");
        }

        return userOptional;
    }

    public List<MentiUser> getUsers() {
        return mentiUserRepository.findAll();
    }

    @Transactional
    public void updateUser(Long userId, String username, String email) {
        MentiUser user = mentiUserRepository.findById(userId).orElseThrow(
                () -> new IllegalStateException("Student with id " + userId + "does not exist"));

        if (username != null) {
            boolean usernameIsValid = this.validateUsername(username, user);

            if (usernameIsValid) {
                user.setUsername(email);
            }
        }

        if (email != null) {
            boolean emailIsValid = this.validateEmail(email, user);

            if (emailIsValid) {
                user.setEmail(email);
            }
        }


    }

    public void deleteUser() {

    }

    public boolean validateUsername(String username, MentiUser user) {
        if (username.length() == 0) {
            throw new IllegalStateException("New username can't be empty");
        } else if (user != null && Objects.equals(user.getUsername(), username)) {
            throw new IllegalStateException("Username haven't changed");
        }

        return true;
    }
    public boolean validateEmail(String email, MentiUser user) {
        String emailPattern
                = "^(?=.{1,64}@)[A-Za-z0-9\\+_-]+(\\.[A-Za-z0-9\\+_-]+)*@[^-][A-Za-z0-9\\+-]+(\\.[A-Za-z0-9\\+-]+)*(\\.[A-Za-z]{2,})$";

        boolean newEmailIsValid = Pattern.compile(emailPattern)
                                         .matcher(email)
                                         .matches();

        if (!newEmailIsValid) {
            throw new IllegalStateException("Email isn't valid");
        } else if (email.length() == 0) {
            throw new IllegalStateException("Email can't be empty");
        } else if (user != null && Objects.equals(
                user.getEmail(), email)) {
            throw new IllegalStateException("Email haven't changed");
        }

        return true;
    }
}
