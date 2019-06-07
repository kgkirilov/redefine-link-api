package link.redefine.api.rdfn.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Domain {
    private Integer idDomain;
    private String domain;
    private User userByIdUser;

    @Id
    @GeneratedValue
    @Column(name = "id_domain", nullable = false)
    public Integer getIdDomain() {
        return idDomain;
    }

    public void setIdDomain(Integer idDomain) {
        this.idDomain = idDomain;
    }

    @Basic
    @Column(name = "domain", nullable = true, length = 100)
    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Domain domain1 = (Domain) o;

        if (idDomain != null ? !idDomain.equals(domain1.idDomain) : domain1.idDomain != null) return false;
        if (domain != null ? !domain.equals(domain1.domain) : domain1.domain != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idDomain != null ? idDomain.hashCode() : 0;
        result = 31 * result + (domain != null ? domain.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id_user", nullable = false)
    @JsonIgnore
    public User getUserByIdUser() {
        return userByIdUser;
    }

    public void setUserByIdUser(User userByIdUser) {
        this.userByIdUser = userByIdUser;
    }
}
