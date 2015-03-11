package cz.cesnet.cloud.occi.infrastructure;

import cz.cesnet.cloud.occi.Model;
import cz.cesnet.cloud.occi.core.Category;
import cz.cesnet.cloud.occi.core.Kind;
import cz.cesnet.cloud.occi.core.Resource;
import cz.cesnet.cloud.occi.exception.InvalidAttributeValueException;
import cz.cesnet.cloud.occi.infrastructure.enumeration.NetworkState;
import java.net.URI;

/**
 * Class representing an OCCI Network
 *
 * @author Michal Kimle <kimle.michal@gmail.com>
 */
public class Network extends Resource {

    public static final String VLAN_ATTRIBUTE_NAME = "occi.network.vlan";
    public static final String LABEL_ATTRIBUTE_NAME = "occi.network.label";
    public static final String STATE_ATTRIBUTE_NAME = "occi.network.state";

    /**
     * Constructor.
     *
     * @param id occi.core.id attribute. Cannot be null.
     * @param kind network's kind. Cannot be null.
     * @param title occi.core.title attribute
     * @param model network's model
     * @param summary network's summary
     * @throws InvalidAttributeValueException in case of invalid id, title or
     * summary value
     */
    public Network(String id, Kind kind, String title, Model model, String summary) throws InvalidAttributeValueException {
        super(id, kind, title, model, summary);
    }

    /**
     * Constructor.
     *
     * @param id occi.core.id attribute. Cannot be null.
     * @param kind network's kind. Cannot be null.
     * @throws InvalidAttributeValueException in case of invalid id value
     */
    public Network(String id, Kind kind) throws InvalidAttributeValueException {
        super(id, kind);
    }

    /**
     * Returns network's vlan number (attribute occi.network.vlan).
     *
     * @return network's vlan number
     */
    public String getVlan() {
        return getValue(VLAN_ATTRIBUTE_NAME);
    }

    /**
     * Sets network's vlan number.
     *
     * @param vlan network's vlan number
     * @throws InvalidAttributeValueException in case value for vlan is invalid
     */
    public void setVlan(int vlan) throws InvalidAttributeValueException {
        addAttribute(VLAN_ATTRIBUTE_NAME, String.valueOf(vlan));
    }

    /**
     * Sets network's vlan number.
     *
     * @param vlan network's vlan number
     * @throws InvalidAttributeValueException in case value for vlan is invalid
     */
    public void setVlan(String vlan) throws InvalidAttributeValueException {
        addAttribute(VLAN_ATTRIBUTE_NAME, vlan);
    }

    /**
     * Returns network's label (attribute occi.network.label).
     *
     * @return network's label
     */
    public String getLabel() {
        return getValue(LABEL_ATTRIBUTE_NAME);
    }

    /**
     * Sets network's label.
     *
     * @param label network's label
     * @throws InvalidAttributeValueException in case value for label is invalid
     */
    public void setLabel(String label) throws InvalidAttributeValueException {
        addAttribute(LABEL_ATTRIBUTE_NAME, label);
    }

    /**
     * Returns network's state (attribute occi.network.state).
     *
     * @return network's state
     */
    public String getState() {
        return getValue(STATE_ATTRIBUTE_NAME);
    }

    /**
     * Sets network's state.
     *
     * @param state network's state. Cannot be null.
     * @throws InvalidAttributeValueException in case value for state is invalid
     */
    public void setState(NetworkState state) throws InvalidAttributeValueException {
        if (state == null) {
            throw new NullPointerException("state cannot be null");
        }
        addAttribute(STATE_ATTRIBUTE_NAME, state.toString());
    }

    /**
     * Sets network's state.
     *
     * @param stateName network's state
     * @throws InvalidAttributeValueException in case value for state is invalid
     */
    public void setState(String stateName) throws InvalidAttributeValueException {
        addAttribute(STATE_ATTRIBUTE_NAME, stateName);
    }

    /**
     * Returns network's default scheme
     * 'http://schemas.ogf.org/occi/infrastructure#'
     *
     * @return network's default scheme
     */
    public static URI getSchemeDefault() {
        return Category.SCHEME_INFRASTRUCTURE_DEFAULT;
    }

    /**
     * Returns network's default term 'network'
     *
     * @return network's default term
     */
    public static String getTermDefault() {
        return "network";
    }
}
