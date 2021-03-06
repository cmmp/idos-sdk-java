package com.veridu.idos.endpoints;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;

import com.google.gson.JsonObject;
import com.veridu.idos.exceptions.SDKException;
import com.veridu.idos.utils.Filter;
import com.veridu.idos.utils.IdOSAuthType;

/**
 * Profile Scores Endpoint Class
 *
 * @version 2.0
 *
 */
public class ProfileScores extends AbstractEndpoint {
    /**
     * Constructor Class
     *
     * @param credentials
     * @param baseURL
     * @param doNotCheckSSL
     */
    public ProfileScores(HashMap<String, String> credentials, String baseURL, boolean doNotCheckSSL) {
        super(credentials, IdOSAuthType.HANDLER, baseURL, doNotCheckSSL);
    }

    /**
     * Lists all scores for the given user
     *
     * @param username
     * @return JsonObject response
     * @throws SDKException
     */
    public JsonObject listAll(String username) throws SDKException {
        return this.fetch("GET", "profiles/" + username + "/scores");
    }

    /**
     * Lists all scores for the given user with filtering
     *
     * @param username
     * @param filter
     * @return JsonObject response
     * @throws SDKException
     */
    public JsonObject listAll(String username, Filter filter) throws SDKException {
        return this.fetch("GET", "profiles/" + username + "/scores", null, filter);
    }

    /**
     * Retrieves the score for the given score name
     *
     * @param username
     * @param scoreName
     * @return JsonObject response
     * @throws SDKException
     */
    public JsonObject getOne(String username, String scoreName) throws SDKException {
        return this.fetch("GET", "profiles/" + username + "/scores/" + scoreName);
    }

    /**
     * Creates a new score for the given user
     *
     * @param username
     * @param scoreName
     * @param attributeName
     * @param value
     * @return JsonObject response
     * @throws SDKException
     * @throws UnsupportedEncodingException
     */
    public JsonObject create(String username, String scoreName, String attributeName, double value)
            throws SDKException, UnsupportedEncodingException {
        JsonObject data = new JsonObject();
        data.addProperty("name", scoreName);
        data.addProperty("value", value);
        data.addProperty("attribute", attributeName);
        return this.fetch("POST", "profiles/" + username + "/scores", data);
    }

    /**
     * Creates or updates a score for the given user
     *
     * @param username
     * @param scoreName
     * @param attributeName
     * @param value
     * @return JsonObject response
     * @throws SDKException
     * @throws UnsupportedEncodingException
     */
    public JsonObject upsert(String username, String scoreName, String attributeName, double value)
            throws SDKException, UnsupportedEncodingException {
        JsonObject data = new JsonObject();
        data.addProperty("name", scoreName);
        data.addProperty("value", value);
        data.addProperty("attribute", attributeName);
        return this.fetch("PUT", "profiles/" + username + "/scores", data);
    }

    /**
     * Updates an existing score for the given score name
     *
     * @param username
     * @param scoreName
     * @param attributeName
     * @param value
     * @return JsonObject response
     * @throws SDKException
     * @throws UnsupportedEncodingException
     */
    public JsonObject update(String username, String scoreName, String attributeName, double value)
            throws SDKException, UnsupportedEncodingException {
        JsonObject data = new JsonObject();
        data.addProperty("value", value);
        data.addProperty("attribute", attributeName);
        return this.fetch("PATCH", "profiles/" + username + "/scores/" + scoreName, data);
    }

    /**
     * Deletes a score given its score name
     *
     * @param username
     * @param scoreName
     * @return JsonObject response
     * @throws SDKException
     */
    public JsonObject delete(String username, String scoreName) throws SDKException {
        return this.fetch("DELETE", "profiles/" + username + "/scores/" + scoreName);
    }

    /**
     * Deletes all scores related to the given user
     *
     * @param username
     * @return JsonObject response
     * @throws SDKException
     */
    public JsonObject deleteAll(String username) throws SDKException {
        return this.fetch("DELETE", "profiles/" + username + "/scores");
    }

    /**
     * Deletes all scores related to the given user
     *
     * @param username
     * @param filter
     * @return JsonObject response
     * @throws SDKException
     */
    public JsonObject deleteAll(String username, Filter filter) throws SDKException {
        return this.fetch("DELETE", "profiles/" + username + "/scores", null, filter);
    }
}
