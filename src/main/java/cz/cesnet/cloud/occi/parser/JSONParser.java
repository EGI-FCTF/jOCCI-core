package cz.cesnet.cloud.occi.parser;

import com.sun.net.httpserver.Headers;
import cz.cesnet.cloud.occi.Collection;
import cz.cesnet.cloud.occi.Model;
import cz.cesnet.cloud.occi.exception.ParsingException;
import java.net.URI;
import java.util.List;

/**
 *
 * @author Michal Kimle <kimle.michal@gmail.com>
 */
public class JSONParser implements Parser {

    @Override
    public Model parseModel(String mediaType, String body, Headers headers) throws ParsingException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Collection parseCollection(String mediaType, String body, Headers headers, CollectionType collectionType) throws ParsingException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<URI> parseLocations(String mediaType, String body, Headers headers) throws ParsingException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
