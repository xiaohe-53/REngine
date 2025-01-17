package org.rosuda.REngine;// org.rosuda.REngine.REngine - generic Java/R API
//
// Copyright (C) 2006 Simon Urbanek
// --- for licensing information see LICENSE file in the original JRclient distribution ---
//
//  RSrvException.java
//
//  Created by Simon Urbanek on Wed Jun 21 2006.
//
//  $Id$
//

/** <code>org.rosuda.REngine.REngineException</code> is a generic exception that can be thrown by methods invoked on an R engine. */
public class REngineException extends Exception {
	/** engine associated with this exception */
    protected REngine engine;

    /** creates an R engine exception
	@param engine engine associated with this exception
	@param msg message describing the cause
	@param cause original cause if this is a chained exception
    */
    public REngineException(REngine engine, String msg, Throwable cause) {
        super(msg, cause);
        this.engine = engine;
    }
 
    /** creates an R engine exception
	@param engine engine associated with this exception
	@param msg message describing the cause
    */
    public REngineException(REngine engine, String msg) {
        super(msg);
        this.engine = engine;
    }

    /** returns the engine associated with this exception
	@return engine associated with this exception */
    public REngine getEngine() { return engine; }
}
