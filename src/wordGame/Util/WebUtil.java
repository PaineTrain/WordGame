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

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

public class WebUtil {
	private static final String WEBROOT = "http://li325-80.members.linode.com:8000";
	private static final String WEBDIR = "/games/create_board/";
	
	public static boolean SaveBoardToServer(Board board) throws UnsupportedEncodingException{
		DefaultHttpClient httpclient = new DefaultHttpClient();
		HttpPost postMethod = new HttpPost(WEBROOT + WEBDIR);
		String boardData = board.toWebString();
		List<NameValuePair> formParameters = new ArrayList<NameValuePair>();
		formParameters.add(new BasicNameValuePair("board_data", boardData));
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
