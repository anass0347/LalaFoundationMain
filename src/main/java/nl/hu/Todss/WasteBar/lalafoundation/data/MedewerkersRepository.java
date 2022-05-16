package nl.hu.Todss.WasteBar.lalafoundation.data;

import nl.hu.Todss.WasteBar.lalafoundation.domain.Medewerker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MedewerkersRepository extends JpaRepository<Medewerker, Long> {
    Optional<Medewerker> findById(Long id);
}
