package net.vikesh.ssm.model.site;

import com.google.common.base.Strings;

import javax.persistence.*;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Vikesh on 24-Dec-16.
 */
@Entity
@Table(name = "GROUPS")
public class UserGroup {
    private static final Locale DEFAULT_LOCALE = Locale.US;

    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "GROUP_NAME", nullable = false)
    private String groupName;

    @ElementCollection
    @CollectionTable(name = "GROUP_DESCRIPTION")
    @MapKeyColumn(name = "LOCALE")
    private Map<Locale, String> description = new LinkedHashMap<>();

    @PrePersist
    private void setId() {
        if (Strings.isNullOrEmpty(id)) {
            id = UUID.randomUUID().toString();
        }
    }

    public String getId() {
        return id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getDescription() {
        return getDescription(DEFAULT_LOCALE);
    }

    public void setDescription(String description) {
        setDescription(DEFAULT_LOCALE, description);
    }

    public String getDescription(Locale locale) {
        return description.getOrDefault(locale, description.get(DEFAULT_LOCALE));
    }

    public void setDescription(Locale locale, String value) {
        description.put(locale, value);
    }
}
