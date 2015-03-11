package cz.cesnet.cloud.occi.infrastructure.enumeration;

/**
 *
 * @author Michal Kimle <kimle.michal@gmail.com>
 */
public enum Allocation {

    DYNAMIC, STATIC;

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
