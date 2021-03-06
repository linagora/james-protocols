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

package org.apache.james.protocols.api;


/**
 * A {@link Logger} implementation which suffix every log message with the
 * session id Id
 * 
 * 
 */
public class ProtocolSessionLogger implements Logger {
    private final Logger logger;
    private final String id;

    public ProtocolSessionLogger(String id, Logger logger) {
        this.logger = logger;
        this.id = id;
    }

    private String getText(String str) {
        return "ID=" + id + " " + str;
    }

    public void debug(String arg0) {
        logger.debug(getText(arg0));
    }

    /**
     * @see org.slf4j.Logger#debug(String, Throwable)
     */
    public void debug(String arg0, Throwable arg1) {
        logger.debug(getText(arg0), arg1);

    }

    /**
     * @see org.slf4j.Logger#error(java.lang.String)
     */
    public void error(String arg0) {
        logger.error(getText(arg0));
    }

    /**
     * @see org.slf4j.Logger#error(java.lang.String, java.lang.Throwable)
     */
    public void error(String arg0, Throwable arg1) {
        logger.error(getText(arg0), arg1);

    }

    public void info(String arg0) {
        logger.info(getText(arg0));

    }

    public void info(String arg0, Throwable arg1) {
        logger.info(getText(arg0), arg1);

    }

    public boolean isDebugEnabled() {
        return logger.isDebugEnabled();
    }

    public boolean isErrorEnabled() {
        return logger.isErrorEnabled();
    }

    public boolean isInfoEnabled() {
        return logger.isInfoEnabled();
    }

    public boolean isTraceEnabled() {
        return logger.isTraceEnabled();
    }

    public boolean isWarnEnabled() {
        return logger.isWarnEnabled();
    }

    public void trace(String arg0) {
        logger.trace(getText(arg0));
    }
    
    public void trace(String arg0, Throwable arg1) {
        logger.trace(getText(arg0), arg1);

    }

    public void warn(String arg0) {
        logger.warn(getText(arg0));

    }


    public void warn(String arg0, Throwable arg1) {
        logger.warn(getText(arg0), arg1);

    }

    public boolean isFatalEnabled() {
        return logger.isFatalEnabled();
    }

    public void fatal(String message) {
        logger.fatal(getText(message));
        
    }

    public void fatal(String message, Throwable t) {
        logger.fatal(getText(message), t);        
    }

}
