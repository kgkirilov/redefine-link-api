package link.redefine.api.rdfn.service;

import link.redefine.api.rdfn.entity.Visit;
import link.redefine.api.rdfn.exception.VisitNotFoundException;
import link.redefine.api.rdfn.repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Service
public class VisitService {

    @Autowired
    VisitRepository visitRepository;

    public Visit findById(Integer id) {
        Optional<Visit> visit = visitRepository.findById(id);

        if (visit.isPresent()) {
            return visit.get();
        } else {
            throw new VisitNotFoundException();
        }
    }

    public Visit save(Visit visit) {
        return visitRepository.save(visit);
    }

    public void deleteById(Integer id) {
        visitRepository.deleteById(id);
    }

}
