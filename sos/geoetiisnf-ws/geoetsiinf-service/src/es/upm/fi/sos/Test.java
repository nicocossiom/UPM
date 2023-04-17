package es.upm.fi.sos;

import es.upm.fi.sos.model.xsd.Treasure;
import es.upm.fi.sos.model.xsd.Username;

public class Test {

    public static void main(String[] args) {

        UPMGeoCachingSkeleton service = new UPMGeoCachingSkeleton();

        // addFollower()
        // AddFollower toFollow = new AddFollower();
        // Username username = new Username();
        // username.setUsername("John");
        // toFollow.setArgs0(username);
        // service.addFollower(toFollow);
        // service.addFollower(toFollow);

        // removeFollower()
        // RemoveFollower toRemove = new RemoveFollower();
        // Username username = new Username();
        // username.setUsername("John");
        // toRemove.setArgs0(username);
        // service.removeFollower(toRemove);

        // getMyFollowers()
        // GetMyFollowers getMyFollowers = new GetMyFollowers();
        // service.getMyFollowers(getMyFollowers);

        // createTreasure()
        // Treasure treasure = new Treasure();
        // treasure.setName("Chest");
        // treasure.setLatitude(10.0);
        // treasure.setAltitude(10.0);
        // CreateTreasure createTreasure = new CreateTreasure();
        // createTreasure.setArgs0(treasure);
        // service.createTreasure(createTreasure);
        //service.createTreasure(createTreasure);


        // findTreasures()
        // Treasure treasure = new Treasure();
        // treasure.setName("Chest");
        // treasure.setLatitude(10.0);
        // treasure.setAltitude(10.0);
        // FindTreasure findTreasure = new FindTreasure();
        // findTreasure.setArgs0(treasure);
        // service.findTreasure(findTreasure);
        // service.findTreasure(findTreasure);

        // getMyTreasuresFound()
        // GetMyTreasuresFound getMyTreasuresFound = new GetMyTreasuresFound();
        // service.getMyTreasuresFound(getMyTreasuresFound);

        // getMyTreasuresFound()
        // GetMyTreasuresCreated getMyTreasuresCreated = new GetMyTreasuresCreated();
        // service.getMyTreasuresCreated(getMyTreasuresCreated);

        // getMyTreasuresFound()
        GetMyFollowerTreasuresCreated getMyFollowerTreasuresCreated = new GetMyFollowerTreasuresCreated();
        Username username = new Username();
        username.setUsername("admin");
        getMyFollowerTreasuresCreated.setArgs0(username);
        service.getMyFollowerTreasuresCreated(getMyFollowerTreasuresCreated);
    }
    
}
