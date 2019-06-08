package link.redefine.api.rdfn.service;

import link.redefine.api.rdfn.entity.Domain;
import link.redefine.api.rdfn.entity.Url;
import link.redefine.api.rdfn.entity.User;
import link.redefine.api.rdfn.exception.UserNotFoundException;
import link.redefine.api.rdfn.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Integer id) {

        Optional<User> found = userRepository.findById(id);

        if (found.isPresent()) {
            return found.get();
        } else {
            throw new UserNotFoundException();
        }
    }

    public User save(User url) {
        User saved = userRepository.save(url);
        return saved;
    }

    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }

    public List<Url> getUserUrls(Integer idUser) {
        return userRepository.getUserUrls(idUser);
    }

    public List<Domain> getUserDomains(Integer idDomain) {
        return userRepository.getUserDomains(idDomain);
    }

}
