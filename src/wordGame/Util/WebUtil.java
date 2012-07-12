/*******************************************************************************
 * Copyright (c) 2012 Harrison Paine
 *
 * Permission is hereby granted, free of charge, to any person 
 * obtaining a copy of this software and associated documentation 
 * files (the "Software"), to deal in the Software without restriction, 
 * including without limitation the rights to use, copy, modify, merge, 
 * publish, distribute, sublicense, and/or sell copies of the Software, 
 * and to permit persons to whom the Software is furnished to do so, 
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included 
 * in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, 
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO 
 * THE WARRANTIES OF MERCHANTABILITY, 
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. 
 * IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS 
 * BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, 
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, 
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE 
 * OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *******************************************************************************/
package wordGame.Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

public class WebUtil {
	public static final String WEBROOT = "http://li325-80.members.linode.com:8000";
	public static final String WEBCREATEBOARD = WEBROOT + "/games/create_board/";
	public static final String WEBGETBOARD = WEBROOT + "/games/get_board/";
	public static final String WEBGETDICTIONARY = WEBROOT + "/dictionary/get_dictionary/";
	
	public static Board GetBoardFromServer(String boardID){
		DefaultHttpClient httpclient = new DefaultHttpClient();
		HttpGet getMethod = new HttpGet(WEBGETBOARD + boardID);
		Scanner fileScanner = null;
		String boardString = null;
		try {
			HttpResponse response = httpclient.execute(getMethod);
			HttpEntity responseEntity = response.getEntity();
		
			if (responseEntity != null){
				fileScanner = new Scanner(new BufferedReader(new InputStreamReader(responseEntity.getContent())));
				while (fileScanner.hasNext()){
					boardString = fileScanner.next();
					return BoardGenerator.generateCubesFromWebString(boardString);
				}
			}
		}
		catch (IOException e){
			return null;
		}
		return null;
		
	}
	
	public static boolean SaveBoardToServer(Board board, String userID, String cubesID, String dictID) throws UnsupportedEncodingException{
		DefaultHttpClient httpclient = new DefaultHttpClient();
		HttpPost postMethod = new HttpPost(WEBCREATEBOARD);
		String boardData = board.toWebString();
		List<NameValuePair> formParameters = new ArrayList<NameValuePair>();
		formParameters.add(new BasicNameValuePair("board_data", boardData));
		formParameters.add(new BasicNameValuePair("user_id", userID));
		formParameters.add(new BasicNameValuePair("cubes_id", cubesID));
		formParameters.add(new BasicNameValuePair("dictionary_id", dictID));
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formParameters, "UTF-8");
		postMethod.setEntity(entity);
		try {
			HttpResponse response = httpclient.execute(postMethod);
			HttpEntity responseEntity = response.getEntity();
			if (responseEntity != null){
				responseEntity.writeTo(System.out);
			}
			
			return true;
		}
		catch (IOException e){
			return false;
		}
	
	}
	
	
	

	private static String encode(String input){
		
		return input;
	}

}
