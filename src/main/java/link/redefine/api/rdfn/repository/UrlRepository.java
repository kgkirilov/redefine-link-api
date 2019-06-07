package link.redefine.api.rdfn.repository;

import link.redefine.api.rdfn.entity.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UrlRepository extends JpaRepository<Url, Integer> {

    @Query("select count(v.idVisit) from Visit v where v.urlByIdUrl.idUrl = :idUrl")
    Integer findUrlVisitsCount(@Param("idUrl") Integer idUrl);

}
