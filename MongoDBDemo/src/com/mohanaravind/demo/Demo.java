/**
 * 
 */
package com.mohanaravind.demo;

import java.net.UnknownHostException;
import java.util.ArrayList;

import com.mongodb.DB;
import com.mongodb.DBCollection;

import com.mongodb.MongoException;



/**
 * @author Aravind Mohan
 *
 */
public class Demo {

	private static String uriString = "mongodb://user:password@ds037817-a.mongolab.com:37817/mongolabmis";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Declarations
		DB db = null;
		DBCollection log = null;
		
		try {

		
			MongoDB objMongoDB = new MongoDB(uriString, "user", new char[]{'p','a','s','s','w','o','r','d'});
			 
			ArrayList<String> arrAdministrators = objMongoDB.getAdministrators();
			
			for (String string : arrAdministrators) {
				System.out.println(string);
			}
			

		} catch(UnknownHostException uhe) {
		    System.out.println("UnknownHostException: " + uhe);
		} catch(MongoException me) {
		    System.out.println("MongoException: " + me);
		}




	}

}
