
/**
 * UPMGeoCachingMessageReceiverInOut.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
        package es.upm.fi.sos;

        /**
        *  UPMGeoCachingMessageReceiverInOut message receiver
        */

        public class UPMGeoCachingMessageReceiverInOut extends org.apache.axis2.receivers.AbstractInOutMessageReceiver{


        
        /** 
         * @param msgContext
         * @param newMsgContext
         * @throws org.apache.axis2.AxisFault
         */
        public void invokeBusinessLogic(org.apache.axis2.context.MessageContext msgContext, org.apache.axis2.context.MessageContext newMsgContext)
        throws org.apache.axis2.AxisFault{

        try {

        // get the implementation class for the Web Service
        Object obj = getTheImplementationObject(msgContext);

        UPMGeoCachingSkeleton skel = (UPMGeoCachingSkeleton)obj;
        //Out Envelop
        org.apache.axiom.soap.SOAPEnvelope envelope = null;
        //Find the axisOperation that has been set by the Dispatch phase.
        org.apache.axis2.description.AxisOperation op = msgContext.getOperationContext().getAxisOperation();
        if (op == null) {
        throw new org.apache.axis2.AxisFault("Operation is not located, if this is doclit style the SOAP-ACTION should specified via the SOAP Action to use the RawXMLProvider");
        }

        java.lang.String methodName;
        if((op.getName() != null) && ((methodName = org.apache.axis2.util.JavaUtils.xmlNameToJavaIdentifier(op.getName().getLocalPart())) != null)){


        

            if("removeFollower".equals(methodName)){
                
                es.upm.fi.sos.RemoveFollowerResponse removeFollowerResponse52 = null;
	                        es.upm.fi.sos.RemoveFollower wrappedParam =
                                                             (es.upm.fi.sos.RemoveFollower)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    es.upm.fi.sos.RemoveFollower.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               removeFollowerResponse52 =
                                                   
                                                   
                                                         skel.removeFollower(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), removeFollowerResponse52, false, new javax.xml.namespace.QName("http://sos.fi.upm.es",
                                                    "removeFollower"));
                                    } else 

            if("getMyTreasuresFound".equals(methodName)){
                
                es.upm.fi.sos.GetMyTreasuresFoundResponse getMyTreasuresFoundResponse54 = null;
	                        es.upm.fi.sos.GetMyTreasuresFound wrappedParam =
                                                             (es.upm.fi.sos.GetMyTreasuresFound)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    es.upm.fi.sos.GetMyTreasuresFound.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               getMyTreasuresFoundResponse54 =
                                                   
                                                   
                                                         skel.getMyTreasuresFound(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), getMyTreasuresFoundResponse54, false, new javax.xml.namespace.QName("http://sos.fi.upm.es",
                                                    "getMyTreasuresFound"));
                                    } else 

            if("getMyFollowers".equals(methodName)){
                
                es.upm.fi.sos.GetMyFollowersResponse getMyFollowersResponse56 = null;
	                        es.upm.fi.sos.GetMyFollowers wrappedParam =
                                                             (es.upm.fi.sos.GetMyFollowers)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    es.upm.fi.sos.GetMyFollowers.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               getMyFollowersResponse56 =
                                                   
                                                   
                                                         skel.getMyFollowers(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), getMyFollowersResponse56, false, new javax.xml.namespace.QName("http://sos.fi.upm.es",
                                                    "getMyFollowers"));
                                    } else 

            if("getMyTreasuresCreated".equals(methodName)){
                
                es.upm.fi.sos.GetMyTreasuresCreatedResponse getMyTreasuresCreatedResponse58 = null;
	                        es.upm.fi.sos.GetMyTreasuresCreated wrappedParam =
                                                             (es.upm.fi.sos.GetMyTreasuresCreated)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    es.upm.fi.sos.GetMyTreasuresCreated.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               getMyTreasuresCreatedResponse58 =
                                                   
                                                   
                                                         skel.getMyTreasuresCreated(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), getMyTreasuresCreatedResponse58, false, new javax.xml.namespace.QName("http://sos.fi.upm.es",
                                                    "getMyTreasuresCreated"));
                                    } else 

            if("removeUser".equals(methodName)){
                
                es.upm.fi.sos.RemoveUserResponse removeUserResponse60 = null;
	                        es.upm.fi.sos.RemoveUser wrappedParam =
                                                             (es.upm.fi.sos.RemoveUser)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    es.upm.fi.sos.RemoveUser.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               removeUserResponse60 =
                                                   
                                                   
                                                         skel.removeUser(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), removeUserResponse60, false, new javax.xml.namespace.QName("http://sos.fi.upm.es",
                                                    "removeUser"));
                                    } else 

            if("addFollower".equals(methodName)){
                
                es.upm.fi.sos.AddFollowerResponse addFollowerResponse62 = null;
	                        es.upm.fi.sos.AddFollower wrappedParam =
                                                             (es.upm.fi.sos.AddFollower)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    es.upm.fi.sos.AddFollower.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               addFollowerResponse62 =
                                                   
                                                   
                                                         skel.addFollower(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), addFollowerResponse62, false, new javax.xml.namespace.QName("http://sos.fi.upm.es",
                                                    "addFollower"));
                                    } else 

            if("createTreasure".equals(methodName)){
                
                es.upm.fi.sos.CreateTreasureResponse createTreasureResponse64 = null;
	                        es.upm.fi.sos.CreateTreasure wrappedParam =
                                                             (es.upm.fi.sos.CreateTreasure)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    es.upm.fi.sos.CreateTreasure.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               createTreasureResponse64 =
                                                   
                                                   
                                                         skel.createTreasure(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), createTreasureResponse64, false, new javax.xml.namespace.QName("http://sos.fi.upm.es",
                                                    "createTreasure"));
                                    } else 

            if("findTreasure".equals(methodName)){
                
                es.upm.fi.sos.FindTreasureResponse findTreasureResponse66 = null;
	                        es.upm.fi.sos.FindTreasure wrappedParam =
                                                             (es.upm.fi.sos.FindTreasure)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    es.upm.fi.sos.FindTreasure.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               findTreasureResponse66 =
                                                   
                                                   
                                                         skel.findTreasure(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), findTreasureResponse66, false, new javax.xml.namespace.QName("http://sos.fi.upm.es",
                                                    "findTreasure"));
                                    } else 

            if("addUser".equals(methodName)){
                
                es.upm.fi.sos.AddUserResponse addUserResponse68 = null;
	                        es.upm.fi.sos.AddUser wrappedParam =
                                                             (es.upm.fi.sos.AddUser)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    es.upm.fi.sos.AddUser.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               addUserResponse68 =
                                                   
                                                   
                                                         skel.addUser(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), addUserResponse68, false, new javax.xml.namespace.QName("http://sos.fi.upm.es",
                                                    "addUser"));
                                    } else 

            if("getMyFollowerTreasuresCreated".equals(methodName)){
                
                es.upm.fi.sos.GetMyFollowerTreasuresCreatedResponse getMyFollowerTreasuresCreatedResponse70 = null;
	                        es.upm.fi.sos.GetMyFollowerTreasuresCreated wrappedParam =
                                                             (es.upm.fi.sos.GetMyFollowerTreasuresCreated)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    es.upm.fi.sos.GetMyFollowerTreasuresCreated.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               getMyFollowerTreasuresCreatedResponse70 =
                                                   
                                                   
                                                         skel.getMyFollowerTreasuresCreated(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), getMyFollowerTreasuresCreatedResponse70, false, new javax.xml.namespace.QName("http://sos.fi.upm.es",
                                                    "getMyFollowerTreasuresCreated"));
                                    } else 

            if("changePassword".equals(methodName)){
                
                es.upm.fi.sos.ChangePasswordResponse changePasswordResponse72 = null;
	                        es.upm.fi.sos.ChangePassword wrappedParam =
                                                             (es.upm.fi.sos.ChangePassword)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    es.upm.fi.sos.ChangePassword.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               changePasswordResponse72 =
                                                   
                                                   
                                                         skel.changePassword(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), changePasswordResponse72, false, new javax.xml.namespace.QName("http://sos.fi.upm.es",
                                                    "changePassword"));
                                    } else 

            if("login".equals(methodName)){
                
                es.upm.fi.sos.LoginResponse loginResponse74 = null;
	                        es.upm.fi.sos.Login wrappedParam =
                                                             (es.upm.fi.sos.Login)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    es.upm.fi.sos.Login.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               loginResponse74 =
                                                   
                                                   
                                                         skel.login(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), loginResponse74, false, new javax.xml.namespace.QName("http://sos.fi.upm.es",
                                                    "login"));
                                    
            } else {
              throw new java.lang.RuntimeException("method not found");
            }
        

        newMsgContext.setEnvelope(envelope);
        }
        }
        catch (java.lang.Exception e) {
        throw org.apache.axis2.AxisFault.makeFault(e);
        }
        }
        
        
        /** 
         * @param param
         * @param optimizeContent
         * @return OMElement
         * @throws org.apache.axis2.AxisFault
         */
        //
            private  org.apache.axiom.om.OMElement  toOM(es.upm.fi.sos.Logout param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(es.upm.fi.sos.Logout.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            
            /** 
             * @param param
             * @param optimizeContent
             * @return OMElement
             * @throws org.apache.axis2.AxisFault
             */
            private  org.apache.axiom.om.OMElement  toOM(es.upm.fi.sos.RemoveFollower param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(es.upm.fi.sos.RemoveFollower.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            
            /** 
             * @param param
             * @param optimizeContent
             * @return OMElement
             * @throws org.apache.axis2.AxisFault
             */
            private  org.apache.axiom.om.OMElement  toOM(es.upm.fi.sos.RemoveFollowerResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(es.upm.fi.sos.RemoveFollowerResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            
            /** 
             * @param param
             * @param optimizeContent
             * @return OMElement
             * @throws org.apache.axis2.AxisFault
             */
            private  org.apache.axiom.om.OMElement  toOM(es.upm.fi.sos.GetMyTreasuresFound param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(es.upm.fi.sos.GetMyTreasuresFound.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            
            /** 
             * @param param
             * @param optimizeContent
             * @return OMElement
             * @throws org.apache.axis2.AxisFault
             */
            private  org.apache.axiom.om.OMElement  toOM(es.upm.fi.sos.GetMyTreasuresFoundResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(es.upm.fi.sos.GetMyTreasuresFoundResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            
            /** 
             * @param param
             * @param optimizeContent
             * @return OMElement
             * @throws org.apache.axis2.AxisFault
             */
            private  org.apache.axiom.om.OMElement  toOM(es.upm.fi.sos.GetMyFollowers param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(es.upm.fi.sos.GetMyFollowers.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            
            /** 
             * @param param
             * @param optimizeContent
             * @return OMElement
             * @throws org.apache.axis2.AxisFault
             */
            private  org.apache.axiom.om.OMElement  toOM(es.upm.fi.sos.GetMyFollowersResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(es.upm.fi.sos.GetMyFollowersResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            
            /** 
             * @param param
             * @param optimizeContent
             * @return OMElement
             * @throws org.apache.axis2.AxisFault
             */
            private  org.apache.axiom.om.OMElement  toOM(es.upm.fi.sos.GetMyTreasuresCreated param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(es.upm.fi.sos.GetMyTreasuresCreated.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            
            /** 
             * @param param
             * @param optimizeContent
             * @return OMElement
             * @throws org.apache.axis2.AxisFault
             */
            private  org.apache.axiom.om.OMElement  toOM(es.upm.fi.sos.GetMyTreasuresCreatedResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(es.upm.fi.sos.GetMyTreasuresCreatedResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            
            /** 
             * @param param
             * @param optimizeContent
             * @return OMElement
             * @throws org.apache.axis2.AxisFault
             */
            private  org.apache.axiom.om.OMElement  toOM(es.upm.fi.sos.RemoveUser param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(es.upm.fi.sos.RemoveUser.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            
            /** 
             * @param param
             * @param optimizeContent
             * @return OMElement
             * @throws org.apache.axis2.AxisFault
             */
            private  org.apache.axiom.om.OMElement  toOM(es.upm.fi.sos.RemoveUserResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(es.upm.fi.sos.RemoveUserResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            
            /** 
             * @param param
             * @param optimizeContent
             * @return OMElement
             * @throws org.apache.axis2.AxisFault
             */
            private  org.apache.axiom.om.OMElement  toOM(es.upm.fi.sos.AddFollower param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(es.upm.fi.sos.AddFollower.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            
            /** 
             * @param param
             * @param optimizeContent
             * @return OMElement
             * @throws org.apache.axis2.AxisFault
             */
            private  org.apache.axiom.om.OMElement  toOM(es.upm.fi.sos.AddFollowerResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(es.upm.fi.sos.AddFollowerResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            
            /** 
             * @param param
             * @param optimizeContent
             * @return OMElement
             * @throws org.apache.axis2.AxisFault
             */
            private  org.apache.axiom.om.OMElement  toOM(es.upm.fi.sos.CreateTreasure param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(es.upm.fi.sos.CreateTreasure.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            
            /** 
             * @param param
             * @param optimizeContent
             * @return OMElement
             * @throws org.apache.axis2.AxisFault
             */
            private  org.apache.axiom.om.OMElement  toOM(es.upm.fi.sos.CreateTreasureResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(es.upm.fi.sos.CreateTreasureResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            
            /** 
             * @param param
             * @param optimizeContent
             * @return OMElement
             * @throws org.apache.axis2.AxisFault
             */
            private  org.apache.axiom.om.OMElement  toOM(es.upm.fi.sos.FindTreasure param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(es.upm.fi.sos.FindTreasure.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            
            /** 
             * @param param
             * @param optimizeContent
             * @return OMElement
             * @throws org.apache.axis2.AxisFault
             */
            private  org.apache.axiom.om.OMElement  toOM(es.upm.fi.sos.FindTreasureResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(es.upm.fi.sos.FindTreasureResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            
            /** 
             * @param param
             * @param optimizeContent
             * @return OMElement
             * @throws org.apache.axis2.AxisFault
             */
            private  org.apache.axiom.om.OMElement  toOM(es.upm.fi.sos.AddUser param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(es.upm.fi.sos.AddUser.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            
            /** 
             * @param param
             * @param optimizeContent
             * @return OMElement
             * @throws org.apache.axis2.AxisFault
             */
            private  org.apache.axiom.om.OMElement  toOM(es.upm.fi.sos.AddUserResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(es.upm.fi.sos.AddUserResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            
            /** 
             * @param param
             * @param optimizeContent
             * @return OMElement
             * @throws org.apache.axis2.AxisFault
             */
            private  org.apache.axiom.om.OMElement  toOM(es.upm.fi.sos.GetMyFollowerTreasuresCreated param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(es.upm.fi.sos.GetMyFollowerTreasuresCreated.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            
            /** 
             * @param param
             * @param optimizeContent
             * @return OMElement
             * @throws org.apache.axis2.AxisFault
             */
            private  org.apache.axiom.om.OMElement  toOM(es.upm.fi.sos.GetMyFollowerTreasuresCreatedResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(es.upm.fi.sos.GetMyFollowerTreasuresCreatedResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            
            /** 
             * @param param
             * @param optimizeContent
             * @return OMElement
             * @throws org.apache.axis2.AxisFault
             */
            private  org.apache.axiom.om.OMElement  toOM(es.upm.fi.sos.ChangePassword param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(es.upm.fi.sos.ChangePassword.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            
            /** 
             * @param param
             * @param optimizeContent
             * @return OMElement
             * @throws org.apache.axis2.AxisFault
             */
            private  org.apache.axiom.om.OMElement  toOM(es.upm.fi.sos.ChangePasswordResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(es.upm.fi.sos.ChangePasswordResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            
            /** 
             * @param param
             * @param optimizeContent
             * @return OMElement
             * @throws org.apache.axis2.AxisFault
             */
            private  org.apache.axiom.om.OMElement  toOM(es.upm.fi.sos.Login param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(es.upm.fi.sos.Login.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            
            /** 
             * @param param
             * @param optimizeContent
             * @return OMElement
             * @throws org.apache.axis2.AxisFault
             */
            private  org.apache.axiom.om.OMElement  toOM(es.upm.fi.sos.LoginResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(es.upm.fi.sos.LoginResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
                    
                    /** 
                     * @param factory
                     * @param param
                     * @param optimizeContent
                     * @param methodQName
                     * @return SOAPEnvelope
                     * @throws org.apache.axis2.AxisFault
                     */
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, es.upm.fi.sos.RemoveFollowerResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(es.upm.fi.sos.RemoveFollowerResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         
                         /** 
                          * @return RemoveFollowerResponse
                          */
                         private es.upm.fi.sos.RemoveFollowerResponse wrapremoveFollower(){
                                es.upm.fi.sos.RemoveFollowerResponse wrappedElement = new es.upm.fi.sos.RemoveFollowerResponse();
                                return wrappedElement;
                         }
                    
                    
                    /** 
                     * @param factory
                     * @param param
                     * @param optimizeContent
                     * @param methodQName
                     * @return SOAPEnvelope
                     * @throws org.apache.axis2.AxisFault
                     */
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, es.upm.fi.sos.GetMyTreasuresFoundResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(es.upm.fi.sos.GetMyTreasuresFoundResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         
                         /** 
                          * @return GetMyTreasuresFoundResponse
                          */
                         private es.upm.fi.sos.GetMyTreasuresFoundResponse wrapgetMyTreasuresFound(){
                                es.upm.fi.sos.GetMyTreasuresFoundResponse wrappedElement = new es.upm.fi.sos.GetMyTreasuresFoundResponse();
                                return wrappedElement;
                         }
                    
                    
                    /** 
                     * @param factory
                     * @param param
                     * @param optimizeContent
                     * @param methodQName
                     * @return SOAPEnvelope
                     * @throws org.apache.axis2.AxisFault
                     */
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, es.upm.fi.sos.GetMyFollowersResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(es.upm.fi.sos.GetMyFollowersResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         
                         /** 
                          * @return GetMyFollowersResponse
                          */
                         private es.upm.fi.sos.GetMyFollowersResponse wrapgetMyFollowers(){
                                es.upm.fi.sos.GetMyFollowersResponse wrappedElement = new es.upm.fi.sos.GetMyFollowersResponse();
                                return wrappedElement;
                         }
                    
                    
                    /** 
                     * @param factory
                     * @param param
                     * @param optimizeContent
                     * @param methodQName
                     * @return SOAPEnvelope
                     * @throws org.apache.axis2.AxisFault
                     */
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, es.upm.fi.sos.GetMyTreasuresCreatedResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(es.upm.fi.sos.GetMyTreasuresCreatedResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         
                         /** 
                          * @return GetMyTreasuresCreatedResponse
                          */
                         private es.upm.fi.sos.GetMyTreasuresCreatedResponse wrapgetMyTreasuresCreated(){
                                es.upm.fi.sos.GetMyTreasuresCreatedResponse wrappedElement = new es.upm.fi.sos.GetMyTreasuresCreatedResponse();
                                return wrappedElement;
                         }
                    
                    
                    /** 
                     * @param factory
                     * @param param
                     * @param optimizeContent
                     * @param methodQName
                     * @return SOAPEnvelope
                     * @throws org.apache.axis2.AxisFault
                     */
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, es.upm.fi.sos.RemoveUserResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(es.upm.fi.sos.RemoveUserResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         
                         /** 
                          * @return RemoveUserResponse
                          */
                         private es.upm.fi.sos.RemoveUserResponse wrapremoveUser(){
                                es.upm.fi.sos.RemoveUserResponse wrappedElement = new es.upm.fi.sos.RemoveUserResponse();
                                return wrappedElement;
                         }
                    
                    
                    /** 
                     * @param factory
                     * @param param
                     * @param optimizeContent
                     * @param methodQName
                     * @return SOAPEnvelope
                     * @throws org.apache.axis2.AxisFault
                     */
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, es.upm.fi.sos.AddFollowerResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(es.upm.fi.sos.AddFollowerResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         
                         /** 
                          * @return AddFollowerResponse
                          */
                         private es.upm.fi.sos.AddFollowerResponse wrapaddFollower(){
                                es.upm.fi.sos.AddFollowerResponse wrappedElement = new es.upm.fi.sos.AddFollowerResponse();
                                return wrappedElement;
                         }
                    
                    
                    /** 
                     * @param factory
                     * @param param
                     * @param optimizeContent
                     * @param methodQName
                     * @return SOAPEnvelope
                     * @throws org.apache.axis2.AxisFault
                     */
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, es.upm.fi.sos.CreateTreasureResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(es.upm.fi.sos.CreateTreasureResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         
                         /** 
                          * @return CreateTreasureResponse
                          */
                         private es.upm.fi.sos.CreateTreasureResponse wrapcreateTreasure(){
                                es.upm.fi.sos.CreateTreasureResponse wrappedElement = new es.upm.fi.sos.CreateTreasureResponse();
                                return wrappedElement;
                         }
                    
                    
                    /** 
                     * @param factory
                     * @param param
                     * @param optimizeContent
                     * @param methodQName
                     * @return SOAPEnvelope
                     * @throws org.apache.axis2.AxisFault
                     */
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, es.upm.fi.sos.AddUserResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(es.upm.fi.sos.AddUserResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         
                         /** 
                          * @return AddUserResponse
                          */
                         private es.upm.fi.sos.AddUserResponse wrapaddUser(){
                                es.upm.fi.sos.AddUserResponse wrappedElement = new es.upm.fi.sos.AddUserResponse();
                                return wrappedElement;
                         }
                    
                    
                    /** 
                     * @param factory
                     * @param param
                     * @param optimizeContent
                     * @param methodQName
                     * @return SOAPEnvelope
                     * @throws org.apache.axis2.AxisFault
                     */
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, es.upm.fi.sos.FindTreasureResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(es.upm.fi.sos.FindTreasureResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         
                         /** 
                          * @return FindTreasureResponse
                          */
                         private es.upm.fi.sos.FindTreasureResponse wrapfindTreasure(){
                                es.upm.fi.sos.FindTreasureResponse wrappedElement = new es.upm.fi.sos.FindTreasureResponse();
                                return wrappedElement;
                         }
                    
                    
                    /** 
                     * @param factory
                     * @param param
                     * @param optimizeContent
                     * @param methodQName
                     * @return SOAPEnvelope
                     * @throws org.apache.axis2.AxisFault
                     */
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, es.upm.fi.sos.GetMyFollowerTreasuresCreatedResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(es.upm.fi.sos.GetMyFollowerTreasuresCreatedResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         
                         /** 
                          * @return GetMyFollowerTreasuresCreatedResponse
                          */
                         private es.upm.fi.sos.GetMyFollowerTreasuresCreatedResponse wrapgetMyFollowerTreasuresCreated(){
                                es.upm.fi.sos.GetMyFollowerTreasuresCreatedResponse wrappedElement = new es.upm.fi.sos.GetMyFollowerTreasuresCreatedResponse();
                                return wrappedElement;
                         }
                    
                    
                    /** 
                     * @param factory
                     * @param param
                     * @param optimizeContent
                     * @param methodQName
                     * @return SOAPEnvelope
                     * @throws org.apache.axis2.AxisFault
                     */
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, es.upm.fi.sos.ChangePasswordResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(es.upm.fi.sos.ChangePasswordResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         
                         /** 
                          * @return ChangePasswordResponse
                          */
                         private es.upm.fi.sos.ChangePasswordResponse wrapchangePassword(){
                                es.upm.fi.sos.ChangePasswordResponse wrappedElement = new es.upm.fi.sos.ChangePasswordResponse();
                                return wrappedElement;
                         }
                    
                    
                    /** 
                     * @param factory
                     * @param param
                     * @param optimizeContent
                     * @param methodQName
                     * @return SOAPEnvelope
                     * @throws org.apache.axis2.AxisFault
                     */
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, es.upm.fi.sos.LoginResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(es.upm.fi.sos.LoginResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         
                         /** 
                          * @return LoginResponse
                          */
                         private es.upm.fi.sos.LoginResponse wraplogin(){
                                es.upm.fi.sos.LoginResponse wrappedElement = new es.upm.fi.sos.LoginResponse();
                                return wrappedElement;
                         }
                    


        /**
        *  get the default envelope
        */
        private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory){
        return factory.getDefaultEnvelope();
        }


        
        /** 
         * @param param
         * @param type
         * @param extraNamespaces
         * @return Object
         * @throws org.apache.axis2.AxisFault
         */
        private  java.lang.Object fromOM(
        org.apache.axiom.om.OMElement param,
        java.lang.Class type,
        java.util.Map extraNamespaces) throws org.apache.axis2.AxisFault{

        try {
        
                if (es.upm.fi.sos.Logout.class.equals(type)){
                
                           return es.upm.fi.sos.Logout.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (es.upm.fi.sos.RemoveFollower.class.equals(type)){
                
                           return es.upm.fi.sos.RemoveFollower.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (es.upm.fi.sos.RemoveFollowerResponse.class.equals(type)){
                
                           return es.upm.fi.sos.RemoveFollowerResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (es.upm.fi.sos.GetMyTreasuresFound.class.equals(type)){
                
                           return es.upm.fi.sos.GetMyTreasuresFound.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (es.upm.fi.sos.GetMyTreasuresFoundResponse.class.equals(type)){
                
                           return es.upm.fi.sos.GetMyTreasuresFoundResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (es.upm.fi.sos.GetMyFollowers.class.equals(type)){
                
                           return es.upm.fi.sos.GetMyFollowers.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (es.upm.fi.sos.GetMyFollowersResponse.class.equals(type)){
                
                           return es.upm.fi.sos.GetMyFollowersResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (es.upm.fi.sos.GetMyTreasuresCreated.class.equals(type)){
                
                           return es.upm.fi.sos.GetMyTreasuresCreated.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (es.upm.fi.sos.GetMyTreasuresCreatedResponse.class.equals(type)){
                
                           return es.upm.fi.sos.GetMyTreasuresCreatedResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (es.upm.fi.sos.RemoveUser.class.equals(type)){
                
                           return es.upm.fi.sos.RemoveUser.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (es.upm.fi.sos.RemoveUserResponse.class.equals(type)){
                
                           return es.upm.fi.sos.RemoveUserResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (es.upm.fi.sos.AddFollower.class.equals(type)){
                
                           return es.upm.fi.sos.AddFollower.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (es.upm.fi.sos.AddFollowerResponse.class.equals(type)){
                
                           return es.upm.fi.sos.AddFollowerResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (es.upm.fi.sos.CreateTreasure.class.equals(type)){
                
                           return es.upm.fi.sos.CreateTreasure.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (es.upm.fi.sos.CreateTreasureResponse.class.equals(type)){
                
                           return es.upm.fi.sos.CreateTreasureResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (es.upm.fi.sos.FindTreasure.class.equals(type)){
                
                           return es.upm.fi.sos.FindTreasure.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (es.upm.fi.sos.FindTreasureResponse.class.equals(type)){
                
                           return es.upm.fi.sos.FindTreasureResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (es.upm.fi.sos.AddUser.class.equals(type)){
                
                           return es.upm.fi.sos.AddUser.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (es.upm.fi.sos.AddUserResponse.class.equals(type)){
                
                           return es.upm.fi.sos.AddUserResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (es.upm.fi.sos.GetMyFollowerTreasuresCreated.class.equals(type)){
                
                           return es.upm.fi.sos.GetMyFollowerTreasuresCreated.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (es.upm.fi.sos.GetMyFollowerTreasuresCreatedResponse.class.equals(type)){
                
                           return es.upm.fi.sos.GetMyFollowerTreasuresCreatedResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (es.upm.fi.sos.ChangePassword.class.equals(type)){
                
                           return es.upm.fi.sos.ChangePassword.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (es.upm.fi.sos.ChangePasswordResponse.class.equals(type)){
                
                           return es.upm.fi.sos.ChangePasswordResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (es.upm.fi.sos.Login.class.equals(type)){
                
                           return es.upm.fi.sos.Login.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (es.upm.fi.sos.LoginResponse.class.equals(type)){
                
                           return es.upm.fi.sos.LoginResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
        } catch (java.lang.Exception e) {
        throw org.apache.axis2.AxisFault.makeFault(e);
        }
           return null;
        }



    

        /**
        *  A utility method that copies the namepaces from the SOAPEnvelope
        */
        private java.util.Map getEnvelopeNamespaces(org.apache.axiom.soap.SOAPEnvelope env){
        java.util.Map returnMap = new java.util.HashMap();
        java.util.Iterator namespaceIterator = env.getAllDeclaredNamespaces();
        while (namespaceIterator.hasNext()) {
        org.apache.axiom.om.OMNamespace ns = (org.apache.axiom.om.OMNamespace) namespaceIterator.next();
        returnMap.put(ns.getPrefix(),ns.getNamespaceURI());
        }
        return returnMap;
        }

        
        /** 
         * @param e
         * @return AxisFault
         */
        private org.apache.axis2.AxisFault createAxisFault(java.lang.Exception e) {
        org.apache.axis2.AxisFault f;
        Throwable cause = e.getCause();
        if (cause != null) {
            f = new org.apache.axis2.AxisFault(e.getMessage(), cause);
        } else {
            f = new org.apache.axis2.AxisFault(e.getMessage());
        }

        return f;
    }

        }//end of class
    