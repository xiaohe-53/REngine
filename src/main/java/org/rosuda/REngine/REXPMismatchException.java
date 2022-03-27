package org.rosuda.REngine;// org.rosuda.REngine.REngine - generic Java/R API
//
// Copyright (C) 2007,2008 Simon Urbanek
// --- for licensing information see LICENSE file in the distribution ---
//
//  REXPMismatch.java
//
//  Created by Simon Urbanek on 2007/05/03
//
//  $Id: org.rosuda.REngine.REngineException.java 2555 2006-06-21 20:36:42Z urbaneks $
//

/** This exception is thrown whenever the operation requested is not supported by the given R object type, e.g. using <tt>asStrings</tt> on an S4 object. Most {@link REXP} methods throw this exception. Previous R/Java interfaces were silently returning <code>null</code> in those cases, but using exceptions helps to write more robust code. */
public class REXPMismatchException extends Exception {
	REXP sender;
	String access;
	
	/** primary constructor. The exception message will be formed as "attempt to access &lt;org.rosuda.REngine.REXP-class&gt; as &lt;access-string&gt;"
	 * @param sender R object that triggered this exception (cannot be <code>null</code>!)
	 * @param access assumed type of the access that was requested. It should be a simple name of the assumed type (e.g. <tt>"vector"</tt>). The type name can be based on R semantics beyond basic types reflected by org.rosuda.REngine.REXP classes. In cases where certain assertions were not satisfied, the string should be of the form <tt>"type (assertion)"</tt> (e.g. <tt>"data frame (must have dim>0)"</tt>). */
    public REXPMismatchException(REXP sender, String access) {
        super("attempt to access "+sender.getClass().getName()+" as "+access);
		this.sender = sender;
		this.access = access;
    }
	
	/** retrieve the exception sender/origin
	 * @return org.rosuda.REngine.REXP object that triggered the exception */
	public REXP getSender() {
		return sender;
	}
	
	/** get the assumed access type that was violated by the sender.
	 * @return string describing the access type. See {@link #REXPMismatchException} for details. */
	public String getAccess() {
		return access;
	}
}
