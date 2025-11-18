package doansah.github.amenlist.service;

import doansah.github.amenlist.entity.enums.Role;
import doansah.github.amenlist.repository.UserRepository;
import doansah.github.amenlist.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.PageRequest;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public Page<User> findAll(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return userRepository.findAll(pageable);

    }


    public class UserMapper {
        private Long id;
        private String name;
        private String email;
        private String phoneNumber;
        private Role role;

        public UserMapper(User u) {
            id = u.getId();
            name = u.getName();
            email = u.getEmail();
            phoneNumber = u.getPhoneNumber();
            role = u.getRole();

        }

    }

        public record UserBasicDTO() {
            private static String name;
            private static String email;
            private static String phoneNumber;

        }
        // the idea here is that if the ADMIN requests -> UserADMINDTO
        // JWT claims inform who Admin is for Controller.
        // How is that passed on to service?????


        public record UserAdminDTO() {
            private static String name;
            private static String email;
            private static String phoneNumber;
            private static String role; // only difference for now...
        }

        public UserBasicDTO toBasicDTO(User u) {
            return new UserBasicDTO();

        }
        public UserAdminDTO toAdminDTO(User u) {
            return new UserAdminDTO();
        }






}
