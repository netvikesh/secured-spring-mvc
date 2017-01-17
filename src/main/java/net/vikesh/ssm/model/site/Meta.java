package net.vikesh.ssm.model.site;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by Vikesh on 23-Dec-16.
 */
@Embeddable
public class Meta {
    @Column
    String charset;

    @Column
    String name;

    @Column
    String scheme;

    @Column
    String httpEquiv;

    @Column
    String content;

    @Column
    String property;

    @Column
    String itemprop;

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public String getHttpEquiv() {
        return httpEquiv;
    }

    public void setHttpEquiv(String httpEquiv) {
        this.httpEquiv = httpEquiv;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getItemprop() {
        return itemprop;
    }

    public void setItemprop(String itemprop) {
        this.itemprop = itemprop;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Meta)) return false;

        Meta meta = (Meta) o;

        return name.equals(meta.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
