

/**
 * UPMGeoCachingMessageReceiverInOnly.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
        package es.upm.fi.sos;

        /**
        *  UPMGeoCachingMessageReceiverInOnly message receiver
        */

        public class UPMGeoCachingMessageReceiverInOnly extends org.apache.axis2.receivers.AbstractInMessageReceiver{

        
        /** 
         * @param inMessage
         * @throws org.apache.axis2.AxisFault
         */
        public void invokeBusinessLogic(org.apache.axis2.context.MessageContext inMessage) throws org.apache.axis2.AxisFault{

        try {

        // get the implementation class for the Web Service
        Object obj = getTheImplementationObject(inMessage);

        UPMGeoCachingSkeleton skel = (UPMGeoCachingSkeleton)obj;
        //Out Envelop
        org.apache.axiom.soap.SOAPEnvelope envelope = null;
        //Find the axisOperation that has been set by the Dispatch phase.
        org.apache.axis2.description.AxisOperation op = inMessage.getOperationContext().getAxisOperation();
        if (op == null) {
        throw new org.apache.axis2.AxisFault("Operation is not located, if this is doclit style the SOAP-ACTION should specified via the SOAP Action to use the RawXMLProvider");
        }

        java.lang.String methodName;
        if((op.getName() != null) && ((methodName = org.apache.axis2.util.JavaUtils.xmlNameToJavaIdentifier(op.getName().getLocalPart())) != null)){

        
            if("logout".equals(methodName)){
            
            es.upm.fi.sos.Logout wrappedParam = (es.upm.fi.sos.Logout)fromOM(
                                                        inMessage.getEnvelope().getBody().getFirstElement(),
                                                        es.upm.fi.sos.Logout.class,
                                                        getEnvelopeNamespaces(inMessage.getEnvelope()));
                                            
                                                     skel.logout(wrappedParam);
                                                
                } else {
                  throw new java.lang.RuntimeException("method not found");
                }
            

        }
        } catch (java.lang.Exception e) {
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



        }//end of class

    