package cz.cesnet.cloud.occi;

import cz.cesnet.cloud.occi.collection.SetCover;
import cz.cesnet.cloud.occi.core.Action;
import cz.cesnet.cloud.occi.core.Kind;
import cz.cesnet.cloud.occi.core.Link;
import cz.cesnet.cloud.occi.core.Mixin;
import cz.cesnet.cloud.occi.core.Resource;
import cz.cesnet.cloud.occi.exception.AmbiguousIdentifierException;
import cz.cesnet.cloud.occi.parser.CollectionType;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * Class representing an OCCI model. Can contain instances of classes Kind,
 * Mixin and Action.
 *
 * @author Michal Kimle <kimle.michal@gmail.com>
 */
public class Model {

    private final SetCover<Kind> kinds = new SetCover<>();
    private final SetCover<Mixin> mixins = new SetCover<>();
    private final SetCover<Action> actions = new SetCover<>();

    /**
     * Creates an empty model.
     */
    public Model() {
    }

    /**
     * Checks whether model contains a kind
     *
     * @param kind kind looked up in the model
     * @return true if model contains the kind, false otherwise
     */
    public boolean containsKind(Kind kind) {
        return kinds.contains(kind);
    }

    /**
     * Checks whether model contains a kind specified by the identifier
     *
     * @param kindIdentifier identifier for the kind looked up in the model
     * @return true if model contains the kind, false otherwise
     */
    public boolean containsKind(String kindIdentifier) {
        return kinds.contains(kindIdentifier);
    }

    /**
     * Adds kind to the model.
     *
     * @param kind kind to be added to the model
     * @return true if the addition was successful, false otherwise
     */
    public boolean addKind(Kind kind) {
        return kinds.add(kind);
    }

    /**
     * Retrieves a kind from the model.
     *
     * @param kindIdentifier identifier of the kind to be retrieved
     * @return kind instance from the mdoel
     */
    public Kind getKind(String kindIdentifier) {
        return kinds.get(kindIdentifier);
    }

    /**
     * Removes kind from model.
     *
     * @param kind kind to be removed from the model
     * @return true if the removal was successful, false otherwise
     */
    public boolean removeKind(Kind kind) {
        return kinds.remove(kind);
    }

    /**
     * Remove all kinds from the model.
     */
    public void clearKinds() {
        kinds.clear();
    }

    /**
     * Returns all kinds from the model in a form of set.
     *
     * @return set of all kinds from the model
     */
    public Set<Kind> getKinds() {
        return kinds.getSet();
    }

    /**
     * Checks whether model contains a mixin
     *
     * @param mixin mixin looked up in the model
     * @return true if model contains the mixin, false otherwise
     */
    public boolean containsMixin(Mixin mixin) {
        return mixins.contains(mixin);
    }

    /**
     * Checks whether model contains a mixin specified by the identifier
     *
     * @param mixinIdentifier identifier for the mixin looked up in the model
     * @return true if model contains the mixin, false otherwise
     */
    public boolean containsMixin(String mixinIdentifier) {
        return mixins.contains(mixinIdentifier);
    }

    /**
     * Adds mixin to the model.
     *
     * @param mixin mixin to be added to the model
     * @return true if the addition was successful, false otherwise
     */
    public boolean addMixin(Mixin mixin) {
        return mixins.add(mixin);
    }

    /**
     * Retrieves a mixin from the model.
     *
     * @param mixinIdentifier identifier of the mixin to be retrieved
     * @return mixin instance from the mdoel
     */
    public Mixin getMixin(String mixinIdentifier) {
        return mixins.get(mixinIdentifier);
    }

    /**
     * Removes mixin from model.
     *
     * @param mixin mixin to be removed from the model
     * @return true if the removal was successful, false otherwise
     */
    public boolean removeMixin(Mixin mixin) {
        return mixins.remove(mixin);
    }

    /**
     * Remove all mixins from the model.
     */
    public void clearMixins() {
        mixins.clear();
    }

    /**
     * Returns all mixins from the model in a form of set.
     *
     * @return set of all mixins from the model
     */
    public Set<Mixin> getMixins() {
        return mixins.getSet();
    }

    /**
     * Checks whether model contains a action
     *
     * @param action action looked up in the model
     * @return true if model contains the action, false otherwise
     */
    public boolean containsAction(Action action) {
        return actions.contains(action);
    }

    /**
     * Checks whether model contains a action specified by the identifier
     *
     * @param actionIdentifier identifier for the action looked up in the model
     * @return true if model contains the action, false otherwise
     */
    public boolean containsAction(String actionIdentifier) {
        return actions.contains(actionIdentifier);
    }

    /**
     * Adds action to the model.
     *
     * @param action action to be added to the model
     * @return true if the addition was successful, false otherwise
     */
    public boolean addAction(Action action) {
        return actions.add(action);
    }

    /**
     * Retrieves a action from the model.
     *
     * @param actionIdentifier identifier of the action to be retrieved
     * @return action instance from the mdoel
     */
    public Action getAction(String actionIdentifier) {
        return actions.get(actionIdentifier);
    }

    /**
     * Removes action from model.
     *
     * @param action action to be removed from the model
     * @return true if the removal was successful, false otherwise
     */
    public boolean removeAction(Action action) {
        return actions.remove(action);
    }

    /**
     * Remove all actions from the model.
     */
    public void clearActions() {
        actions.clear();
    }

    /**
     * Returns all actions from the model in a form of set.
     *
     * @return set of all actions from the model
     */
    public Set<Action> getActions() {
        return actions.getSet();
    }

    /**
     * Finds kind with given identifier (schema+term) in model.
     *
     * @param identifier
     * @return Kind instance with given identifier if found, null otherwise
     */
    public Kind findKind(URI identifier) {
        if (identifier == null) {
            return null;
        }

        String identifierString = identifier.toString();
        for (Kind kind : kinds.getSet()) {
            if (kind.getIdentifier().equals(identifierString)) {
                return kind;
            }
        }

        return null;
    }

    /**
     * Finds kind with given term in model.
     *
     * @param term
     * @return Kind instance with given term if found, null otherwise
     * @throws AmbiguousIdentifierException if model contains more than one kind
     * with given term
     */
    public Kind findKind(String term) throws AmbiguousIdentifierException {
        Kind foundKind = null;
        for (Kind kind : kinds.getSet()) {
            if (kind.getTerm().equals(term)) {
                if (foundKind != null) {
                    throw new AmbiguousIdentifierException("term '" + term + "' is ambiguous");
                }
                foundKind = kind;
            }
        }

        return foundKind;
    }

    /**
     * Finds kinds related to kind specified by given identifier.
     *
     * @param identifier
     * @return list of Kinds related to the one specified Kind
     */
    public List<Kind> findRelatedKinds(URI identifier) {
        Kind main = findKind(identifier);
        return getRelatedKinds(main);
    }

    /**
     * Finds kinds related to kind specified by given term.
     *
     * @param term
     * @return list of Kinds related to the one specified Kind
     * @throws AmbiguousIdentifierException if model contains more than one kind
     * with given term
     */
    public List<Kind> findRelatedKinds(String term) throws AmbiguousIdentifierException {
        Kind main = findKind(term);
        return getRelatedKinds(main);
    }

    private List<Kind> getRelatedKinds(Kind main) {
        List<Kind> related = new ArrayList<>();
        if (main == null) {
            return related;
        }

        for (Kind kind : kinds.getSet()) {
            if (kind.relatesTo(main)) {
                related.add(kind);
            }
        }

        return related;
    }

    /**
     * Determines CollectionType for given kind (for parsing purposes).
     *
     * @param kind
     * @return CollectionType instance if determined, null otherwise
     */
    public CollectionType findKindType(Kind kind) {
        while (kind != null) {
            if (kind.getIdentifier().equals(Resource.KIND_IDENTIFIER_DEFAULT)) {
                return CollectionType.RESOURCE;
            }
            if (kind.getIdentifier().equals(Link.KIND_IDENTIFIER_DEFAULT)) {
                return CollectionType.LINK;
            }
            kind = kind.getParentKind();
        }

        return null;
    }

    /**
     * Determines CollectionType for kind with given location (for parsing
     * purposes).
     *
     * @param location
     * @return CollectionType instance if determined, null otherwise
     */
    public CollectionType findKindType(String location) {
        Kind kind = null;
        for (Kind k : kinds.getSet()) {
            if (k.getLocation().toString().equals(location)) {
                kind = k;
                break;
            }
        }

        return findKindType(kind);
    }

    //TODO: refactor findMixin methods
    /**
     * Finds mixin with given identifier (schema+term) in model.
     *
     * @param identifier
     * @return Mixin instance with given identifier if found, null otherwise
     */
    public Mixin findMixin(URI identifier) {
        if (identifier == null) {
            return null;
        }

        String identigfierString = identifier.toString();
        for (Mixin mixin : mixins.getSet()) {
            if (mixin.getIdentifier().equals(identigfierString)) {
                return mixin;
            }
        }

        return null;
    }

    /**
     * Finds mixin with given term in model.
     *
     * @param term
     * @return Mixin instance with given term if found, null otherwise
     * @throws AmbiguousIdentifierException if model contains more than one
     * mixin with given term
     */
    public Mixin findMixin(String term) throws AmbiguousIdentifierException {
        Mixin foundMixin = null;
        for (Mixin mixin : mixins.getSet()) {
            if (mixin.getTerm().equals(term)) {
                if (foundMixin != null) {
                    throw new AmbiguousIdentifierException("term '" + term + "' is ambiguous");
                }
                foundMixin = mixin;
            }
        }

        return foundMixin;
    }

    /**
     * Finds mixin with given term and relation in model.
     *
     * @param term
     * @param rel term of related mixin
     * @return Mixin instance with given term and relation if found, null
     * otherwise
     * @throws AmbiguousIdentifierException if model contains more than one
     * mixin with given term
     */
    public Mixin findMixin(String term, String rel) throws AmbiguousIdentifierException {
        Mixin relMixin = findMixin(rel);
        if (relMixin == null) {
            return null;
        }

        Mixin foundMixin = null;
        for (Mixin mixin : mixins.getSet()) {
            if (mixin.getTerm().equals(term) && mixin.relatesTo(relMixin)) {
                if (foundMixin != null) {
                    throw new AmbiguousIdentifierException("term '" + term + "' is ambiguous");
                }
                foundMixin = mixin;
            }
        }

        return foundMixin;
    }

    /**
     * Finds mixin with given term and relation in model.
     *
     * @param term
     * @param rel identifier of related mixin (scheme+term)
     * @return Mixin instance with given term and relation if found, null
     * otherwise
     * @throws AmbiguousIdentifierException if model contains more than one
     * mixin with given term
     */
    public Mixin findMixin(String term, URI rel) throws AmbiguousIdentifierException {
        if (rel == null) {
            return null;
        }

        Mixin foundMixin = null;
        for (Mixin mixin : mixins.getSet()) {
            if (mixin.getTerm().equals(term) && mixin.relatesTo(rel.toString())) {
                if (foundMixin != null) {
                    throw new AmbiguousIdentifierException("term '" + term + "' is ambiguous");
                }
                foundMixin = mixin;
            }
        }

        return foundMixin;
    }

    /**
     * Finds mixins related to mixin specified by given identifier.
     *
     * @param identifier
     * @return list of Mixins related to the one specified Mixin
     */
    public List<Mixin> findRelatedMixins(URI identifier) {
        Mixin main = findMixin(identifier);
        return getRelatedMixins(main);
    }

    /**
     * Finds mixins related to mixin specified by given term.
     *
     * @param term
     * @return list of Mixins related to the one specified Mixin
     * @throws AmbiguousIdentifierException if model contains more than one
     * mixin with given term
     */
    public List<Mixin> findRelatedMixins(String term) throws AmbiguousIdentifierException {
        Mixin main = findMixin(term);
        return getRelatedMixins(main);
    }

    private List<Mixin> getRelatedMixins(Mixin main) {
        List<Mixin> related = new ArrayList<>();
        if (main == null) {
            return related;
        }

        for (Mixin mixin : mixins.getSet()) {
            if (mixin.relatesTo(main)) {
                related.add(mixin);
            }
        }

        return related;
    }

    /**
     * Finds action with given term in model.
     *
     * @param term
     * @return Action instance with given term if found, null otherwise
     * @throws AmbiguousIdentifierException if model contains more than one
     * action with given term
     */
    public Action findAction(String term) throws AmbiguousIdentifierException {
        Action foundAction = null;
        for (Action action : actions.getSet()) {
            if (action.getTerm().equals(term)) {
                if (foundAction != null) {
                    throw new AmbiguousIdentifierException("term '" + term + "' is ambiguous");
                }
                foundAction = action;
            }
        }

        return foundAction;
    }

    /**
     * Finds action with given identifier (schema+term) in model.
     *
     * @param identifier
     * @return Action instance with given identifier if found, null otherwise
     */
    public Action findAction(URI identifier) {
        if (identifier == null) {
            return null;
        }

        String identigfierString = identifier.toString();
        for (Action action : actions.getSet()) {
            if (action.getIdentifier().equals(identigfierString)) {
                return action;
            }
        }

        return null;
    }

    /**
     * @see Object#hashCode()
     * @return model's hash code
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.kinds);
        hash = 59 * hash + Objects.hashCode(this.mixins);
        hash = 59 * hash + Objects.hashCode(this.actions);
        return hash;
    }

    /**
     * @see Object#equals(java.lang.Object)
     * @param obj object to compare model with
     * @return true if two models are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Model other = (Model) obj;
        if (!Objects.equals(this.kinds, other.kinds)) {
            return false;
        }
        if (!Objects.equals(this.mixins, other.mixins)) {
            return false;
        }
        if (!Objects.equals(this.actions, other.actions)) {
            return false;
        }
        return true;
    }

    /**
     * Resturns string representation of the model
     *
     * @see Object#toString()
     * @return string representation of the model
     */
    @Override
    public String toString() {
        return "Model{" + "kinds=" + kinds + ", mixins=" + mixins + ", actions=" + actions + '}';
    }
}
