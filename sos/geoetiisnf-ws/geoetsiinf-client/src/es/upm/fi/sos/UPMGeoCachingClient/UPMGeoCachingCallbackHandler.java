
/**
 * UPMGeoCachingCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package es.upm.fi.sos.UPMGeoCachingClient;

    /**
     *  UPMGeoCachingCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class UPMGeoCachingCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public UPMGeoCachingCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public UPMGeoCachingCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for removeUser method
            * override this method for handling normal response from removeUser operation
            */
           public void receiveResultremoveUser(
                    es.upm.fi.sos.UPMGeoCachingClient.ServiceStub.RemoveUserResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from removeUser operation
           */
            public void receiveErrorremoveUser(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for addFollower method
            * override this method for handling normal response from addFollower operation
            */
           public void receiveResultaddFollower(
                    es.upm.fi.sos.UPMGeoCachingClient.ServiceStub.AddFollowerResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addFollower operation
           */
            public void receiveErroraddFollower(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getMyFollowers method
            * override this method for handling normal response from getMyFollowers operation
            */
           public void receiveResultgetMyFollowers(
                    es.upm.fi.sos.UPMGeoCachingClient.ServiceStub.GetMyFollowersResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getMyFollowers operation
           */
            public void receiveErrorgetMyFollowers(java.lang.Exception e) {
            }
                
               // No methods generated for meps other than in-out
                
           /**
            * auto generated Axis2 call back method for getMyTreasuresCreated method
            * override this method for handling normal response from getMyTreasuresCreated operation
            */
           public void receiveResultgetMyTreasuresCreated(
                    es.upm.fi.sos.UPMGeoCachingClient.ServiceStub.GetMyTreasuresCreatedResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getMyTreasuresCreated operation
           */
            public void receiveErrorgetMyTreasuresCreated(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getMyFollowerTreasuresCreated method
            * override this method for handling normal response from getMyFollowerTreasuresCreated operation
            */
           public void receiveResultgetMyFollowerTreasuresCreated(
                    es.upm.fi.sos.UPMGeoCachingClient.ServiceStub.GetMyFollowerTreasuresCreatedResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getMyFollowerTreasuresCreated operation
           */
            public void receiveErrorgetMyFollowerTreasuresCreated(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getMyTreasuresFound method
            * override this method for handling normal response from getMyTreasuresFound operation
            */
           public void receiveResultgetMyTreasuresFound(
                    es.upm.fi.sos.UPMGeoCachingClient.ServiceStub.GetMyTreasuresFoundResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getMyTreasuresFound operation
           */
            public void receiveErrorgetMyTreasuresFound(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for changePassword method
            * override this method for handling normal response from changePassword operation
            */
           public void receiveResultchangePassword(
                    es.upm.fi.sos.UPMGeoCachingClient.ServiceStub.ChangePasswordResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from changePassword operation
           */
            public void receiveErrorchangePassword(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for findTreasure method
            * override this method for handling normal response from findTreasure operation
            */
           public void receiveResultfindTreasure(
                    es.upm.fi.sos.UPMGeoCachingClient.ServiceStub.FindTreasureResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from findTreasure operation
           */
            public void receiveErrorfindTreasure(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for login method
            * override this method for handling normal response from login operation
            */
           public void receiveResultlogin(
                    es.upm.fi.sos.UPMGeoCachingClient.ServiceStub.LoginResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from login operation
           */
            public void receiveErrorlogin(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for removeFollower method
            * override this method for handling normal response from removeFollower operation
            */
           public void receiveResultremoveFollower(
                    es.upm.fi.sos.UPMGeoCachingClient.ServiceStub.RemoveFollowerResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from removeFollower operation
           */
            public void receiveErrorremoveFollower(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for addUser method
            * override this method for handling normal response from addUser operation
            */
           public void receiveResultaddUser(
                    es.upm.fi.sos.UPMGeoCachingClient.ServiceStub.AddUserResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addUser operation
           */
            public void receiveErroraddUser(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for createTreasure method
            * override this method for handling normal response from createTreasure operation
            */
           public void receiveResultcreateTreasure(
                    es.upm.fi.sos.UPMGeoCachingClient.ServiceStub.CreateTreasureResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from createTreasure operation
           */
            public void receiveErrorcreateTreasure(java.lang.Exception e) {
            }
                


    }
    