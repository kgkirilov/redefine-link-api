package link.redefine.api.rdfn.repository;

import link.redefine.api.rdfn.entity.Domain;
import link.redefine.api.rdfn.entity.Url;
import link.redefine.api.rdfn.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("select u from Url u where u.userByIdUser.idUser = :idUser")
    List<Url> getUserUrls(@Param("idUser") Integer idUser);

    @Query("select d from Domain d where d.userByIdUser.idUser = :idUser")
    List<Domain> getUserDomains(@Param("idUser") Integer idUser);

}
