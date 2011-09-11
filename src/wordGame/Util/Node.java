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
	}
	public void setChecked(){
		isChecked = true;
	}
	public void setChecked(boolean checked){
		isChecked = checked;
	}
	public boolean isChecked(){
		return isChecked;
	}
	public List<Node> getNeighbors(){
		return mNeighbors;
	}

}
