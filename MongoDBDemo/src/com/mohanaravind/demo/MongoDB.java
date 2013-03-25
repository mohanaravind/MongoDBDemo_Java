/**
 * 
 */
package com.mohanaravind.demo;

import java.net.UnknownHostException;
import java.util.ArrayList;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoURI;

/**
 * @author Aravind Mohan
 * 9/23/2012
 * 
 * This class is responsible for all the data fetches which happens with the MongoDB
 *
 */
public class MongoDB {	
	//Declarations
	private DB _objDB = null;


	/**
	 * Constructor
	 * @throws UnknownHostException 
	 */
	public MongoDB(String strURI, String strUser, char[] arrPassword ) throws UnknownHostException{
		//Create the MongoURI
		MongoURI objMongoURI = new MongoURI(strURI);

		//Connect with the MongoDB
		_objDB = objMongoURI.connectDB();

		//Authenticate with the MongoDB with the given credentials
		_objDB.authenticate(strUser, arrPassword);
	}


	/**
	 * This method can be used to get the list of administrators who are authorized to 
	 * access this log viewer application
	 * @return
	 */
	public ArrayList<String> getAdministrators(){
		//Declarations
		ArrayList<String> arrAdministrators = new ArrayList<String>();
		DBObject objResult;
		String strAdministrator;
		
		if(_objDB != null){
			//Fetch the list of administrators from MongoDB database
			DBCollection colAdministrators = _objDB.getCollection("Administrators");
			
			DBCursor objCursor = colAdministrators.find();
			
			while(objCursor.hasNext()){
				//Get the result
				objResult = objCursor.next();
				
				//Get the administrator name
				strAdministrator = (String) objResult.get("Name");
				
				//Add the administrator to the list
				arrAdministrators.add(strAdministrator);				
			}

		}


		return arrAdministrators;
	}





}
