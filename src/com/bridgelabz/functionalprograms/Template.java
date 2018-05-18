/******************************************************************************
 *  
 *  Purpose: Replacing string template
 *
 *  @author  Simran Bodra
 *  @version 1.0
 *  @since   17-05-2018
 *
 ******************************************************************************/
package com.bridgelabz.functionalprograms;

import com.bridgelabz.utils.Utility;

public class Template {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter username:-");
		// @param string username to take input from the user.
		String username = Utility.stringInput();
		// @param string propername to get the replaced template
		String propername = Utility.replaceTemplate(username);
		System.out.println(propername);
		
	}

}