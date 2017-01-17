package net.vikesh.ssm.model.site;

import com.google.common.base.Strings;

import javax.persistence.*;
import java.time.Instant;
import java.util.UUID;

/**
 * Created by Vikesh on 23-Dec-16.
 */
@Entity
public class Comment {

    @Id
    private String id;

    @OneToOne(optional = false)
    private User user;

    @Column
    private Instant lastEdit;

    @OneToOne
    @JoinColumn(name = "RESPONSE_TO")
    private Comment responseTo;

    @Lob
    @Column
    private String comment;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @PrePersist
    private void beforeSave() {
        if (lastEdit == null) {
            lastEdit = Instant.now();
        }
        if (Strings.isNullOrEmpty(id)) {
            id = UUID.randomUUID().toString();
        }
    }

    @PreUpdate
    private void beforeUpdate() {
        lastEdit = Instant.now();
    }

    public Instant getLastEdit() {
        return lastEdit;
    }

    public Comment getResponseTo() {
        return responseTo;
    }

    public void setResponseTo(Comment responseTo) {
        this.responseTo = responseTo;
    }

    public String getId() {
        return id;
    }
}
