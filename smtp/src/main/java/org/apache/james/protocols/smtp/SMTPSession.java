/****************************************************************
 * Licensed to the Apache Software Foundation (ASF) under one   *
 * or more contributor license agreements.  See the NOTICE file *
 * distributed with this work for additional information        *
 * regarding copyright ownership.  The ASF licenses this file   *
 * to you under the Apache License, Version 2.0 (the            *
 * "License"); you may not use this file except in compliance   *
 * with the License.  You may obtain a copy of the License at   *
 *                                                              *
 *   http://www.apache.org/licenses/LICENSE-2.0                 *
 *                                                              *
 * Unless required by applicable law or agreed to in writing,   *
 * software distributed under the License is distributed on an  *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY       *
 * KIND, either express or implied.  See the License for the    *
 * specific language governing permissions and limitations      *
 * under the License.                                           *
 ****************************************************************/

package org.apache.james.protocols.smtp;

import org.apache.james.protocols.api.ProtocolSession;
import org.apache.james.protocols.api.handler.LineHandler;

/**
 * All the handlers access this interface to communicate with
 * SMTPHandler object
 */

public interface SMTPSession extends ProtocolSession{

    // Keys used to store/lookup data in the internal state hash map
    /** Sender's email address */
    final static String SENDER = "SENDER_ADDRESS";
    /** The message recipients */
    final static String RCPT_LIST = "RCPT_LIST";  
    /** HELO or EHLO */
    final static String CURRENT_HELO_MODE = "CURRENT_HELO_MODE";
    final static String CURRENT_HELO_NAME = "CURRENT_HELO_NAME";

    /**
     * Returns the service wide hello name
     *
     * @return the hello name
     */
    String getHelloName();
    
    /**
     * Returns whether the remote server needs to send a HELO/EHLO
     * of its senders.
     *
     * @return whether SMTP authentication is on
     */
    boolean useHeloEhloEnforcement();
    
    /**
     * Return the SMTPGreeting which should used.
     * 
     * @return the SMTPGreeting
     */
    String getSMTPGreeting();
    
    /**
     * Returns the service wide maximum message size in bytes.
     *
     * @return the maximum message size
     */
    long getMaxMessageSize();
    
    /**
     * Return wheter the mailserver will accept addresses without brackets enclosed.
     * 
     * @return true or false
     */
    boolean useAddressBracketsEnforcement();
    
    /**
     * Returns whether Relaying is allowed or not
     *
     * @return the relaying status
     */
    boolean isRelayingAllowed();
    
    /**
     * Set if reallying is allowed
     * 
     * @param relayingAllowed
     */
    void setRelayingAllowed(boolean relayingAllowed);

    /**
     * Returns whether Authentication is required or not
     *
     * @return authentication required or not
     */
    boolean isAuthSupported();

    
    /**
     * Returns the recipient count
     * 
     * @return recipient count
     */
    int getRcptCount();
    
    /**
     * Put a new line handler in the chain
     * @param overrideCommandHandler
     */
    void pushLineHandler(LineHandler<SMTPSession> overrideCommandHandler);
    
    /**
     * Pop the last command handler 
     */
    void popLineHandler();
    
    /**
     * Return the size of the pushed {@link LineHandler}
     * @return
     */
    int getPushedLineHandlerCount();
    
    
}

