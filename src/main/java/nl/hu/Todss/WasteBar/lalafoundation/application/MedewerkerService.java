package nl.hu.Todss.WasteBar.lalafoundation.application;

import nl.hu.Todss.WasteBar.lalafoundation.data.MedewerkersRepository;
import nl.hu.Todss.WasteBar.lalafoundation.domain.Medewerker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class MedewerkerService {

    @Autowired
    private final MedewerkersRepository medewerkersRepository;

    public MedewerkerService(MedewerkersRepository medewerkersRepository) {
        this.medewerkersRepository = medewerkersRepository;
    }

    public Medewerker save(Medewerker medewerker) {
        Medewerker medewerker1 = new Medewerker(medewerker.getId(), medewerker.getVoornaam(), medewerker.getAchternaam());
        return this.medewerkersRepository.save(medewerker1);
    }

    public List<Medewerker> getAllMedewerker() {
        return medewerkersRepository.findAll();
    }

    public void deleteViaId(long id) {
        medewerkersRepository.deleteById(id);
    }

    public Medewerker getById(Long id) {
        Optional<Medewerker> optional = medewerkersRepository.findById(id);
        Medewerker medewerker = null;
        if (optional.isPresent())
            medewerker = optional.get();
        else
            throw new RuntimeException(
                    "medewerker not found for id : " + id);
        return medewerker;
    }

}
