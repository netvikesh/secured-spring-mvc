package net.vikesh.ssm.model.site;

import com.google.common.base.Strings;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;

/**
 * Created by Vikesh on 13-Dec-16.
 * This describes the web page displayed.
 */
@Entity
@Table(name = "PAGE")
public class Page {
    private static final Locale DEFAULT_LOCALE = Locale.US;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Id
    @Column(name = "ID")
    private String id;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "PAGE_TITLE")
    @MapKeyColumn(name = "LOCALE")
    private Map<Locale, String> title = new HashMap<>();

    @Lob
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "PAGE_CONTENT")
    @MapKeyColumn(name = "LOCALE")
    private Map<Locale, String> content = new HashMap<>();

    @ElementCollection
    @CollectionTable(name = "META_VALUES_PAGE")
    private Set<Meta> metas = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID", nullable = false)
    private List<Comment> comments = new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "PAGES_AUTHORS", joinColumns = @JoinColumn(name = "PAGE_ID"), inverseJoinColumns = @JoinColumn(name = "AUTHOR_ID"))
    private List<User> authors = new ArrayList<>();

    @PrePersist
    private void setId() {
        if (Strings.isNullOrEmpty(id)) {
            this.id = UUID.randomUUID().toString();
        }
    }

    public String getTitle(@NotNull Locale locale) {
        if (title.containsKey(locale)) {
            return title.get(locale);
        }
        return title.get(DEFAULT_LOCALE);
    }

    public String getTitle() {
        return getTitle(DEFAULT_LOCALE);
    }

    public void setTitle(String value) {
        setTitle(DEFAULT_LOCALE, value);
    }

    public void setTitle(@NotNull Locale locale, String value) {
        title.put(locale, value);
    }

    public void setContent(@NotNull Locale locale, String value) {
        content.put(locale, value);
    }

    public String getContent() {
        return getContent(DEFAULT_LOCALE);
    }

    public void setContent(String value) {
        setContent(DEFAULT_LOCALE, value);
    }

    public String getContent(Locale locale) {
        if (content.containsKey(locale)) {
            return content.get(locale);
        }
        return content.get(DEFAULT_LOCALE);
    }

    public List<User> getAuthors() {
        return authors;
    }

    public void setAuthors(List<User> authors) {
        this.authors = authors;
    }

    public void addAuthor(User user) {
        authors.add(user);
    }
}
