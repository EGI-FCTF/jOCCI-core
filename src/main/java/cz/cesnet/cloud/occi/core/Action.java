package cz.cesnet.cloud.occi.core;

import cz.cesnet.cloud.occi.type.Identifiable;
import java.net.URI;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

public class Action implements Identifiable {

    private Category category;

    public Action(URI scheme, String term, String title, URI location, Collection<Attribute> attributes) {
        this.category = new Category(scheme, term, title, location, attributes);
    }

    public Action(URI scheme, String term) {
        this(scheme, term, null, null, null);
    }

    public URI getScheme() {
        return category.getScheme();
    }

    public void setScheme(URI scheme) {
        category.setScheme(scheme);
    }

    public String getTerm() {
        return category.getTerm();
    }

    public void setTerm(String term) {
        category.setTerm(term);
    }

    @Override
    public String getIdentifier() {
        return category.getIdentifier();
    }

    public String getTitle() {
        return category.getTitle();
    }

    public void setTitle(String title) {
        category.setTitle(title);
    }

    public URI getLocation() {
        return category.getLocation();
    }

    public void setLocation(URI location) {
        category.setLocation(location);
    }

    public boolean containsAttribute(Attribute attribute) {
        return category.containsAttribute(attribute);
    }

    public boolean containsAttribute(String attributeName) {
        return category.containsAttribute(attributeName);
    }

    public boolean addAttribute(Attribute attribute) {
        return category.addAttribute(attribute);
    }

    public Attribute getAttribute(String attributeName) {
        return category.getAttribute(attributeName);
    }

    public boolean removeAttribute(Attribute attribute) {
        return category.removeAttribute(attribute);
    }

    public Set<Attribute> getAttributes() {
        return category.getAttributes();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.category);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Action other = (Action) obj;
        if (!Objects.equals(this.category, other.category)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Action{" + "category=" + category + '}';
    }
}
