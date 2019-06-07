package link.redefine.api.rdfn.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Country {
    private Integer idCountry;
    private String country;
    private Collection<Visit> visitsByIdCountry;

    @Id
    @GeneratedValue
    @Column(name = "id_country", nullable = false)
    public Integer getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(Integer idCountry) {
        this.idCountry = idCountry;
    }

    @Basic
    @Column(name = "country", nullable = true, length = 75)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Country country1 = (Country) o;

        if (idCountry != null ? !idCountry.equals(country1.idCountry) : country1.idCountry != null) return false;
        if (country != null ? !country.equals(country1.country) : country1.country != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCountry != null ? idCountry.hashCode() : 0;
        result = 31 * result + (country != null ? country.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "countryByIdCountry")
    @JsonIgnore
    public Collection<Visit> getVisitsByIdCountry() {
        return visitsByIdCountry;
    }

    public void setVisitsByIdCountry(Collection<Visit> visitsByIdCountry) {
        this.visitsByIdCountry = visitsByIdCountry;
    }
}
