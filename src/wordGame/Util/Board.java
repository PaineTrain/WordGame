/**
 * 
 */
package wordGame.Util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Stack;



/**
 * @author Harrison
 *
 */
public class Board{
	
	private static final int DEFAULT_WIDTH = 4;
	private static final int DEFAULT_HEIGHT = 4;
	private static final int ROOT_NODE_VALUE = -1;
	
	private int mWidth;
	private int mHeight;
	private int dSize;
	private Node mRootNode;
	private ArrayList<Node> mSquares;
	/**
	 * Constructor for custom Grid data object.  Grid represents a 2d, width by height rectangle,
	 * where each node is connected to its 8 adjacent neighbors.
	 * @param values
	 * @param width
	 * @param height
	 */
	public Board(LetterData[] values, int width, int height) {
		mWidth = width;
		mHeight = height;
		dSize = width * height;
		mRootNode = new Node(null, ROOT_NODE_VALUE);
		
		assert(dSize == values.length);
		
		mSquares = new ArrayList<Node>();
		Node neighbor;
		for (int i = 0; i < values.length; i++){
			neighbor = new Node(values[i], i);
			mSquares.add(neighbor);
			mRootNode.addNeighbor(neighbor);
		}
		createGrid();
		
		
	}
	
	public void clear(){
		this.markAllUnchecked();
	}
	
	
	public void findPath(LetterData[] word){
		boolean path = findPath(null, mRootNode, word, 0);
		System.out.println(path);
		
	}
	
	private boolean findPath(Stack<Node> checkedNodes, Node currentNode, LetterData[] word, int wordPosition){
		if (currentNode == null){
			currentNode = mRootNode;
		}
		if (checkedNodes == null){
			checkedNodes = new Stack<Node>();
		}
		
		// end of searched-for word is reached
		
		if (wordPosition >= word.length){
			// markAllUnchecked();
			currentNode.setChecked();
			return true;
		}
		LetterData currentLetter = word[wordPosition];
		Iterator<Node> neighborIterator = currentNode.getNeighbors().iterator();
		Node currentNeighbor;
		checkedNodes.add(currentNode);
		currentNode.setChecked();
		while (neighborIterator.hasNext()){
			currentNeighbor = neighborIterator.next();
			if (!currentNeighbor.isChecked() && currentNeighbor.getData().equals(currentLetter)){
				if (findPath(checkedNodes, currentNeighbor, word, wordPosition+1)){
					return true;
				}
			}
		}
		checkedNodes.pop();
		currentNode.setUnchecked();
		return false;
		
		
	}
	public String toString(){
		String boardDisplay = "";
		Node currentNode;
		for (int i = 0; i < dSize; i++){
			currentNode = mSquares.get(i);
			if (currentNode.isChecked()){
				boardDisplay += (currentNode.getData().toString().toUpperCase());
			}
			else{
				boardDisplay += (currentNode.getData().toString());
			}
			if (i != 0 && i % mWidth == mWidth - 1){
				boardDisplay += ("\n");				
			}
			else {
				boardDisplay += (" ");
			}
		}
		return boardDisplay;
	}
	
	
	/**
	 * Internal method for drawing connections between each node and its adjacent neighbors.
	 */
	private void createGrid(){
		boolean hasNext = false;
		boolean hasPrev = false;
		int index;
		Node currentNode;
		Iterator<Node> i = mSquares.iterator();
		while (i.hasNext()){
			currentNode = i.next();
			index = currentNode.getIndex();
			if ((index % mWidth) != (mWidth - 1)){ // current node is not in last column
				hasNext = true;
				currentNode.addNeighbor(mSquares.get(index + 1)); // add square to right to current node's neighbors
			}
			if ((index % mWidth) != 0){ // current node is not in first column
				hasPrev = true;
				currentNode.addNeighbor(mSquares.get(index - 1)); // add square to left to current node's neighbors
			}
			if ((index + mWidth) < dSize) { // current node is not in last row
				currentNode.addNeighbor(mSquares.get(index + mWidth)); // add square below to current node's neighbors
				if (hasNext){
					currentNode.addNeighbor(mSquares.get(index + mWidth + 1)); // add diagonal bottom right to neighbors;
				}
				if (hasPrev){
					currentNode.addNeighbor(mSquares.get(index + mWidth - 1)); // add diagonal bottom left to neighbors
				}
			}
			if ((index - mWidth) >= 0){ // current node is not in first row
				currentNode.addNeighbor(mSquares.get(index - mWidth)); // add square above to current node's neighbors
				if (hasNext){
					currentNode.addNeighbor(mSquares.get(index - mWidth + 1)); // add diagonal top right to neighbors
				}
				if (hasPrev){
					currentNode.addNeighbor(mSquares.get(index - mWidth - 1)); // add diagonal top left to neighbors
				}
			}
			// reset next/prev booleans
			hasNext = false;
			hasPrev = false;
					
		}
		
	}
	/**
	 * Marks all nodes in board as unchecked
	 */
	private void markAllUnchecked(){
		Iterator<Node> iter = mSquares.iterator();
		while (iter.hasNext()){
			iter.next().setUnchecked();
		}
	}
	

}
