package persistence;

import org.json.JSONObject;

public interface Writable {
    //EFFECTS: Returns this as a JSON Object
    JSONObject toJson();
}
