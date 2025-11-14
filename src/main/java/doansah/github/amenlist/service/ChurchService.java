package doansah.github.amenlist.service;

import doansah.github.amenlist.entity.User;
import doansah.github.amenlist.repository.ChurchRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChurchService {
    private ChurchRepository repository;

    // CONTSTRUCTOR INJECTION DAWG!!!

    public ChurchService(ChurchRepository repository) {
        this.repository = repository;
    }

    public List<User> getChurchMembers(Long id)  {
        return repository.findAllChurchMembers(id);

    }
}

