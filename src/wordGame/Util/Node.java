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
/**
 * 
 */
package wordGame.Util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Harrison
 *
 */
public class Node {
	private List<Node> mNeighbors;
	private int index;
	private LetterData mData;
	private boolean isChecked;
	
	public Node(LetterData data, int indexOf){
		mNeighbors = new ArrayList<Node>();
		index = indexOf;
		mData = data;
		isChecked = false;
	}
	
	public int getIndex(){
		return index;
	}
	public LetterData getData(){
		return mData;
	}
	public void addNeighbor(Node neighbor){
		mNeighbors.add(neighbor);
	}
	public void setUnchecked(){
		isChecked = false;
		if (mData != null)
			mData.deselect();
	}
	public void setChecked(){
		isChecked = true;
		if (mData != null)
			mData.select();
	}
	public void setChecked(boolean checked){
		isChecked = checked;
		if (checked && mData != null)
			mData.select();
		else
			mData.deselect();
	}
	public boolean isChecked(){
		if (mData != null)
			return mData.isSelected();
		else
			return isChecked;
	}
	public List<Node> getNeighbors(){
		return mNeighbors;
	}

}
