package com.geoetsiinf.dao;

public class DAOEnums {
    public enum URIs{
        BASE {
            @Override
            public String toString() {
                return "http://" + SERVER.toString() + "/geoetsiinf/api";
            }
        },
        SERVER {
            @Override
            public String toString() {
                return "localhost:8080";
            }
        },
        TREASURES {
            @Override
            public String toString() {
                return BASE.toString() + "/treasures";
            }
        },
        USERS {
            @Override
            public String toString() {
                return BASE.toString() + "/users";
            }
        },
        USER{
            public String toString(String user) {
                return "http://" + SERVER.toString() + "/geoetsiinf/api/users/"+user;
            }
        },
        FRIENDS{
            public String toString(String user) {
                return USER.toString(user)+"/friends";
            }
        },
        PROFILE{
            public String toString(String user) {
                return USER.toString(user)+"/profile";
            }
        },
        ADDEDTREASURES {
            public String toString(String user) {
                return USER.toString(user) + "/treasures";
            }
        },
        FOUNDTREASURES {
            public String toString(String user) {
                return USER.toString(user) + "/foundTreasures";
            }
        },
        TREASURE {
            public String toString(String treasureId) {
                return BASE.toString() + "/treasures/" + treasureId;
            }
        };

        public String toString(String user) {
            return "http://" + SERVER.toString() + "/geoetsiinf/api/users/" + user;
        }
    }
}
