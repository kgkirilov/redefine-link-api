package link.redefine.api.rdfn.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Visit {
    private Integer idVisit;
    private Timestamp created;
    private Url urlByIdUrl;
    private Country countryByIdCountry;

    @Id
    @GeneratedValue
    @Column(name = "id_visit", nullable = false)
    public Integer getIdVisit() {
        return idVisit;
    }

    public void setIdVisit(Integer idVisit) {
        this.idVisit = idVisit;
    }

    @Basic
    @Column(name = "created", nullable = true)
    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Visit visit = (Visit) o;

        if (idVisit != null ? !idVisit.equals(visit.idVisit) : visit.idVisit != null) return false;
        if (created != null ? !created.equals(visit.created) : visit.created != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idVisit != null ? idVisit.hashCode() : 0;
        result = 31 * result + (created != null ? created.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "id_URL", referencedColumnName = "id_URL", nullable = false)
    public Url getUrlByIdUrl() {
        return urlByIdUrl;
    }

    public void setUrlByIdUrl(Url urlByIdUrl) {
        this.urlByIdUrl = urlByIdUrl;
    }

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "id_country", referencedColumnName = "id_country", nullable = false)
    public Country getCountryByIdCountry() {
        return countryByIdCountry;
    }

    public void setCountryByIdCountry(Country countryByIdCountry) {
        this.countryByIdCountry = countryByIdCountry;
    }
}
