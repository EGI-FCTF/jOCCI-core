package cz.cesnet.cloud.occi.infrastructure;

import cz.cesnet.cloud.occi.Model;
import cz.cesnet.cloud.occi.core.Attribute;
import cz.cesnet.cloud.occi.core.Kind;
import cz.cesnet.cloud.occi.core.Mixin;
import cz.cesnet.cloud.occi.exception.InvalidAttributeValueException;
import cz.cesnet.cloud.occi.infrastructure.enumeration.Allocation;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * Class representing an OCCI IPNetwork
 *
 * @author Michal Kimle <kimle.michal@gmail.com>
 */
public class IPNetwork extends Network {

    public static final String ADDRESS_ATTRIBUTE_NAME = "occi.network.address";
    public static final String GATEWAY_ATTRIBUTE_NAME = "occi.network.gateway";
    public static final String ALLOCATION_ATTRIBUTE_NAME = "occi.network.allocation";
    public static final URI SCHEME_DEFAULT = URI.create("http://schemas.ogf.org/occi/infrastructure/network#");
    public static final String TERM_DEFAULT = "ipnetwork";
    public static final String MIXIN_IDENTIFIER_DEFAULT = SCHEME_DEFAULT + TERM_DEFAULT;

    /**
     * Constructor.
     *
     * @param id occi.core.id attribute. Cannot be null.
     * @param kind ipnetwork's kind. Cannot be null.
     * @param title occi.core.title attribute
     * @param model ipnetwork's model
     * @param summary ipnetwork's summary
     * @throws InvalidAttributeValueException in case of invalid id, title or
     * summary value
     */
    public IPNetwork(String id, Kind kind, String title, Model model, String summary) throws InvalidAttributeValueException {
        super(id, kind, title, model, summary);
    }

    /**
     * Constructor.
     *
     * @param id occi.core.id attribute. Cannot be null.
     * @param kind ipnetwork's kind. Cannot be null.
     * @throws InvalidAttributeValueException in case of invalid id value
     */
    public IPNetwork(String id, Kind kind) throws InvalidAttributeValueException {
        super(id, kind);
    }

    /**
     * Returns ipnetwork's address (attribute occi.network.address).
     *
     * @return ipnetwork's address
     */
    public String getAddress() {
        return getValue(ADDRESS_ATTRIBUTE_NAME);
    }

    /**
     * Sets ipnetwork's address.
     *
     * @param address ipnetwork's address
     * @throws InvalidAttributeValueException in case value for address is
     * invalid
     */
    public void setAddress(String address) throws InvalidAttributeValueException {
        addAttribute(ADDRESS_ATTRIBUTE_NAME, address);
    }

    /**
     * Returns ipnetwork's gateway (attribute occi.network.gateway).
     *
     * @return ipnetwork's gateway
     */
    public String getGateway() {
        return getValue(GATEWAY_ATTRIBUTE_NAME);
    }

    /**
     * Sets ipnetwork's gateway
     *
     * @param gateway ipnetwork's gateway
     * @throws InvalidAttributeValueException in case value for gateway is
     * invalid
     */
    public void setGateway(String gateway) throws InvalidAttributeValueException {
        addAttribute(GATEWAY_ATTRIBUTE_NAME, gateway);
    }

    /**
     * Returns ipnetwork's allocation (attribute occi.network.allocation).
     *
     * @return ipnetwork's allocation
     */
    public String getAllocation() {
        return getValue(ALLOCATION_ATTRIBUTE_NAME);
    }

    /**
     * Sets ipnetwork's allocation.
     *
     * @param allocation ipnetwork's allocation. Cannot be null.
     * @throws InvalidAttributeValueException in case value for allocation is
     * invalid
     */
    public void setAllocation(Allocation allocation) throws InvalidAttributeValueException {
        if (allocation == null) {
            throw new NullPointerException("allocation cannot be null");
        }
        addAttribute(ALLOCATION_ATTRIBUTE_NAME, allocation.toString());
    }

    /**
     * Sets ipnetwork's allocation.
     *
     * @param allocationName ipnetwork's allocation. Cannot be null.
     * @throws InvalidAttributeValueException in case value for allocation is
     * invalid
     */
    public void setAllocation(String allocationName) throws InvalidAttributeValueException {
        addAttribute(ALLOCATION_ATTRIBUTE_NAME, allocationName);
    }

    /**
     * Returns ipnetwork's default identifier
     * 'http://schemas.ogf.org/occi/infrastructure/network#ipnetworking'
     *
     * @return ipnetwork's default identifier
     */
    @Override
    public String getDefaultKindIdentifier() {
        return MIXIN_IDENTIFIER_DEFAULT;
    }

    public static List<Attribute> getDefaultAttributes() {
        List<Attribute> list = new ArrayList<>();
        list.add(new Attribute(ADDRESS_ATTRIBUTE_NAME, false, false));
        list.add(new Attribute(GATEWAY_ATTRIBUTE_NAME, false, false));
        list.add(new Attribute(ALLOCATION_ATTRIBUTE_NAME, false, false));

        return list;
    }

    public static Mixin getDefaultMixin() {
        Mixin mixin = new Mixin(SCHEME_DEFAULT, TERM_DEFAULT, "IP Network Mixin", URI.create("/mixins/ipnetwork/"), IPNetwork.getDefaultAttributes());
        return mixin;
    }
}
