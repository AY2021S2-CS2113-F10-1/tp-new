package seedu.hdbuy.api;

import java.util.HashMap;

import seedu.hdbuy.data.QueryKey;
import seedu.hdbuy.data.Unit;
import seedu.hdbuy.data.exception.EmptyResponseException;

public class ApiRepository {

    /**
     * Gets all units from database matching user's filter criteria.
     * If there are no units retrieved, returns empty map.
     * @param inputs User's filter criteria.
     * @return Map of units, each unit has a unique ID generated by hashcode.
     */
    public static HashMap<Integer, Unit> fetchUnits(HashMap<QueryKey,String> inputs) {
        String query = QueryFormatter.formQuery(inputs);
        try {
            return GetRequest.getResponse(query);
        } catch (EmptyResponseException emptyResponseException) {
            System.out.println(emptyResponseException.getMessage());
            return new HashMap<>();
        }
    }
}
