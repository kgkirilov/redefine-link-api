package link.redefine.api.rdfn.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
public class Url {
    private Integer idUrl;
    private String urlOriginal;
    private String urlRdfn;
    private Timestamp created;
    private Byte previewMode;
    private Byte customDomain;
    private User userByIdUser;
    private Collection<Visit> visitsByIdUrl;

    @Id
    @GeneratedValue
    @Column(name = "id_URL", nullable = false)
    public Integer getIdUrl() {
        return idUrl;
    }

    public void setIdUrl(Integer idUrl) {
        this.idUrl = idUrl;
    }

    @Basic
    @Column(name = "url_original", nullable = false, length = 450)
    public String getUrlOriginal() {
        return urlOriginal;
    }

    public void setUrlOriginal(String urlOriginal) {
        this.urlOriginal = urlOriginal;
    }

    @Basic
    @Column(name = "url_rdfn", nullable = false, length = 45)
    public String getUrlRdfn() {
        return urlRdfn;
    }

    public void setUrlRdfn(String urlRdfn) {
        this.urlRdfn = urlRdfn;
    }

    @Basic
    @Column(name = "created", nullable = true)
    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    @Basic
    @Column(name = "preview_mode", nullable = true)
    public Byte getPreviewMode() {
        return previewMode;
    }

    public void setPreviewMode(Byte previewMode) {
        this.previewMode = previewMode;
    }

    @Basic
    @Column(name = "custom_domain", nullable = true)
    public Byte getCustomDomain() {
        return customDomain;
    }

    public void setCustomDomain(Byte customDomain) {
        this.customDomain = customDomain;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Url url = (Url) o;

        if (idUrl != null ? !idUrl.equals(url.idUrl) : url.idUrl != null) return false;
        if (urlOriginal != null ? !urlOriginal.equals(url.urlOriginal) : url.urlOriginal != null) return false;
        if (urlRdfn != null ? !urlRdfn.equals(url.urlRdfn) : url.urlRdfn != null) return false;
        if (created != null ? !created.equals(url.created) : url.created != null) return false;
        if (previewMode != null ? !previewMode.equals(url.previewMode) : url.previewMode != null) return false;
        if (customDomain != null ? !customDomain.equals(url.customDomain) : url.customDomain != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idUrl != null ? idUrl.hashCode() : 0;
        result = 31 * result + (urlOriginal != null ? urlOriginal.hashCode() : 0);
        result = 31 * result + (urlRdfn != null ? urlRdfn.hashCode() : 0);
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + (previewMode != null ? previewMode.hashCode() : 0);
        result = 31 * result + (customDomain != null ? customDomain.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    public User getUserByIdUser() {
        return userByIdUser;
    }

    public void setUserByIdUser(User userByIdUser) {
        this.userByIdUser = userByIdUser;
    }

    @OneToMany(mappedBy = "urlByIdUrl", cascade = CascadeType.REMOVE)
    @JsonIgnore
    public Collection<Visit> getVisitsByIdUrl() {
        return visitsByIdUrl;
    }

    public void setVisitsByIdUrl(Collection<Visit> visitsByIdUrl) {
        this.visitsByIdUrl = visitsByIdUrl;
    }
}
