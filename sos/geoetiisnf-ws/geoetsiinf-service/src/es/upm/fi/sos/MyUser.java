package es.upm.fi.sos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyUser {

    private String username;
    private String password;
    private Set<String> followed;
    private List<MyTreasure> treasuresCreated;
    private List<MyTreasure> treasuresFound;

    public MyUser(String username, String password) {
        this.username = username;
        this.password = password;
        followed = new HashSet<>();
        treasuresCreated = new ArrayList<>();
        treasuresFound = new ArrayList<>();
    }

    public boolean follow(String username) {
        return followed.add(username);
    }

    public boolean unfollow(String username) {
        return followed.remove(username);
    }

    public void addFoundTreasure(MyTreasure treasure) {
        treasuresFound.add(treasure);
    }

    public void addCreatedTreasure(MyTreasure treasure) {
        treasuresCreated.add(treasure);
    }

    public Set<String> getFollowed() {
        return followed;
    }

    public void setFollowed(Set<String> followed) {
        this.followed = followed;
    }

    public List<MyTreasure> getTreasuresFound() {
        return treasuresFound;
    }
 

    public List<MyTreasure> getTreasuresCreated() {
        return treasuresCreated;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof MyUser) {
            MyUser user = (MyUser) obj;
            return user.getUsername().equals(this.username) && user.getPassword().equals(this.password);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return username.hashCode() + password.hashCode();
    }

}
