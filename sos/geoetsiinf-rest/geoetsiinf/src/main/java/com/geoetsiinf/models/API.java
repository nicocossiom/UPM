package com.geoetsiinf.models;

import java.util.List;

import javax.ws.rs.GET;

import com.geoetsiinf.dao.DAOEnums.URIs;

import org.json.JSONObject;


public class API {
    private String treasures;
    private String users;

    public API() {
        this.users = URIs.USERS.toString();
        this.treasures = URIs.TREASURES.toString();

    }

    public JSONObject getJson() {
        JSONObject json = new JSONObject();
        
        json.put("users", this.users);
        json.put("treasures", this.treasures);
        return json;
    }
}
