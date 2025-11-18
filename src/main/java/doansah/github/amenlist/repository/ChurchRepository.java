package doansah.github.amenlist.repository;

import doansah.github.amenlist.entity.Church;
import doansah.github.amenlist.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChurchRepository extends JpaRepository<Church, Long> {
    List<User> findAllChurchMembers(Long id);

    // will need to optimize query, and include pagination as well...

    Page<Church> findAll(Pageable pageable);



}
