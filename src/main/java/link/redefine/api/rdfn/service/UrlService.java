package link.redefine.api.rdfn.service;

import link.redefine.api.rdfn.entity.Url;
import link.redefine.api.rdfn.exception.UrlNotFoundException;
import link.redefine.api.rdfn.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UrlService {

    @Autowired
    UrlRepository urlRepository;

    public List<Url> findAll() {
        return urlRepository.findAll();
    }

    public Url findById(Integer id) {

        Optional<Url> found = urlRepository.findById(id);

        if (found.isPresent()) {
            return found.get();
        } else {
            throw new UrlNotFoundException();
        }
    }

    public Url save(Url url) {
        Url saved = urlRepository.save(url);
        return saved;
    }

    public void deleteById(Integer id) {
        urlRepository.deleteById(id);
    }

    public Integer findUrlVisitsCount(Integer id) {
        return urlRepository.findUrlVisitsCount(id);
    }

}
