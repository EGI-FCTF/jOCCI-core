package cz.cesnet.cloud.occi.infrastructure;

import cz.cesnet.cloud.occi.Model;
import cz.cesnet.cloud.occi.core.Kind;
import cz.cesnet.cloud.occi.exception.InvalidAttributeException;
import cz.cesnet.cloud.occi.exception.InvalidAttributeValueException;
import cz.cesnet.cloud.occi.infrastructure.enumeration.Allocation;
import java.net.URI;

public class IPNetworkInterface extends NetworkInterface {

    public static final String ADDRESS_ATTRIBUTE_NAME = "occi.networkinterface.address";
    public static final String GATEWAY_ATTRIBUTE_NAME = "occi.networkinterface.gateway";
    public static final String ALLOCATION_ATTRIBUTE_NAME = "occi.networkinterface.allocation";

    public IPNetworkInterface(URI id, Kind kind, String title, Model model) {
        super(id, kind, title, model);
    }

    public IPNetworkInterface(URI id, Kind kind) {
        super(id, kind);
    }

    public String getAddress() {
        return getValue(ADDRESS_ATTRIBUTE_NAME);
    }

    public void setAddress(String address) throws InvalidAttributeException, InvalidAttributeValueException {
        addAttribute(ADDRESS_ATTRIBUTE_NAME, address);
    }

    public String getGateway() {
        return getValue(GATEWAY_ATTRIBUTE_NAME);
    }

    public void setGateway(String gateway) throws InvalidAttributeException, InvalidAttributeValueException {
        addAttribute(GATEWAY_ATTRIBUTE_NAME, gateway);
    }

    public String getAllocation() {
        return getValue(ALLOCATION_ATTRIBUTE_NAME);
    }

    public void setAllocation(Allocation allocation) throws InvalidAttributeException, InvalidAttributeValueException {
        addAttribute(ALLOCATION_ATTRIBUTE_NAME, allocation.toString());
    }

    public void setAllocation(String allocationName) throws InvalidAttributeException, InvalidAttributeValueException {
        addAttribute(ALLOCATION_ATTRIBUTE_NAME, allocationName);
    }
}
