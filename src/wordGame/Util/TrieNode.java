package wordGame.Util;

import java.util.ArrayList;
import java.util.List;

public class TrieNode {
	private boolean endOfWord = false;
	private String data;
	private List<TrieNode> children;
	
	public TrieNode(String value, boolean end){
		data = value;
		children = new ArrayList<TrieNode>();
		endOfWord = end;
	}
	
	public String getData(){
		return data;
	}
	public boolean isEndOfWord(){
		return endOfWord;
	}
	public List<TrieNode> getChildren(){
		return children;
	}
	public void addChild(TrieNode child){
		children.add(child);
	}
	public void setEndOfWord(boolean eow){
		endOfWord = eow;
	}

}
