package doansah.github.amenlist.service;

import doansah.github.amenlist.entity.Church;
import doansah.github.amenlist.entity.User;
import doansah.github.amenlist.repository.ChurchRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChurchService {
    private ChurchRepository repository;

    // CONTSTRUCTOR INJECTION DAWG!!!

    public ChurchService(ChurchRepository repository) {
        this.repository = repository;
    }

    public List<Church> findAllChurchs() {
        return repository.findAll();
    }

    public Page<Church> getAllChurchesPaged(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return repository.findAll(pageable);
    }

    public List<User> getChurchMembers(Long id)  {
        return repository.findAllChurchMembers(id);

    }
}

