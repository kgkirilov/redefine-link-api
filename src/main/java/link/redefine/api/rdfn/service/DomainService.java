package link.redefine.api.rdfn.service;

import link.redefine.api.rdfn.entity.Domain;
import link.redefine.api.rdfn.exception.DomainNotFoundException;
import link.redefine.api.rdfn.repository.DomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DomainService {

    @Autowired
    DomainRepository domainRepository;

    public Domain findDomainById(Integer id) {
        Optional<Domain> domain = domainRepository.findById(id);

        if (domain.isPresent()) {
            return domain.get();
        } else {
            throw new DomainNotFoundException();
        }
    }

    public Domain save(Domain domain) {
        return domainRepository.save(domain);
    }

    public void deleteById(Integer id) {
        domainRepository.deleteById(id);
    }
    
}
