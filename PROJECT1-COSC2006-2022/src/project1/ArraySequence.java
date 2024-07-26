package project1;
/**
 * 
 * @author Sahara Karima Mosin Rahimani
 * This class/data structure is a class that
 * has three fields:
 * data: which is an array of movies
 * items: which is an integer that stores the number of items in the array
 * current: which is an integer that stores the index of the current element in the sequence
 * This class is a sequence that is implemented with a dynamic array which is resized as needed
 * A sequence is a container class which allows duplicates and is ordered. In this case
 * the objects/movies stored in this sequence will be ordered according to 
 * their imdb and rotten tomatoes rating in descending order. 
 */
		
public class ArraySequence{
	movie[] data;
	int items;
	int current;
	/**
	 * Unargumented constructor that calls the
	 * Argumented constructor and initializes an array 
	 * of size 10 and sets the rest of the fields to default 
	 * values so items=0 and current=-1
	 */
	public ArraySequence(){
		//Calls the argumented constructor
		this(10); 
	}
	/**
	 * Argumented constructor 
	 * @param initialCapacity is the initial capacity 
	 * for the data array this value is used to initialize the
	 * array. 
	 * The constructor sets the other fields to their default values
	 * so current=-1 and items=0
	 */
	public ArraySequence(int initialCapacity){
		data = new movie[initialCapacity];
		items = 0;
		current = -1;
	}
	/**
	 * This method adds an element after the current element
	 * and makes it the new current element.
	 * if there is no current element then the element is added
	 * to the end of the sequence and it is assigned as the new current element
	 * @param element is a movie that has to be added to the sequence after the
	 * current element
	 */
	public void addAfter(movie element){
		//check if there is enough space in the array, if not double the size of the array
		if(items >= data.length) ensureCapacity(data.length * 2);
		//check if there is a current element, if there is add the element and sort
		if(isCurrent()){
			cascadeForward(current+1);
			data[current+1] = element;
			//set the new element as the current element
			current++;
			//increase the number of items
			items++;
			sort();
		}
		else{
			//if there is no current add to the end of the sequence and set is as the new current
			data[items] = element;
			current = items;
			//increase number of items
			items++;
		}
	}
	/**
	 * This method adds an element or movie before the current element
	 * and sets the new element as the new current element, if there is 
	 * no current element the movie is added to the start of the sequence and
	 * it is set as the new current element. 
	 * @param element is the movie that must be added to the sequence before the current
	 * element
	 */
	public void addBefore(movie element){
		//check if there is enough space in the array, if not double the size of the array
		if(items >= data.length) ensureCapacity(data.length * 2);
		//check if there is a current element, if there is add element before current element
		if(isCurrent()){
			cascadeForward(current);
			data[current] = element;
			//increase the number of items and sort
			items++;
			sort();
		}
		else{//if there is no current element add to the start of the sequence and set element as current element
			cascadeForward(0);
			data[0] = element;
			current = 0;
			items++;
		}
	}
	/**
	 * This method adds all the elements in addend
	 * to the data array. The method resizes as needed
	 * @param addend is the array sequence that will be added
	 * after the current element.
	 * @throws Exception if there is an exception the compiler does not handle it
	 * it throws the exception again. 
	 */
	public void addAll(ArraySequence addend) throws Exception{
		//checks if the size of data and the size of the argument is greater or equal to the capacity of data
		//if it is then increase the size of the data array then add all the elements in addend
		if(size() + addend.size() >= getCapacity())
			ensureCapacity((size() + addend.size()) * 2);
		current = items-1;
		addend.start();
		while(addend.isCurrent()){
			addAfter(addend.getCurrent());
			addend.advance();
		}
		sort();
	}
	/**
	 * This method ensures that the data array 
	 * has the required space needed for operations.
	 * @param minimumCapacity is the minimum capacity that 
	 * the array must have
	 */
	public void ensureCapacity(int minimumCapacity){
		//create new array with the size of the minimumCapacity argument
		movie[] newData = new movie[minimumCapacity];
		//copy old array into new array
		System.arraycopy(data, 0, newData, 0, data.length);
		//set newData equal to data
		data = newData;
	}
	/**
	 * This is a getter for the capacity
	 * @return the length of the array or the capacity
	 */
	public int getCapacity(){ return data.length; }
	/**
	 * This method removes or deletes the current element
	 * from the sequence. It also sets the following element
	 * as the new current element and if there is not a 
	 * following element the current element is undefined
	 * @return if the current element was successfully removed it returns
	 * true, if not then it returns false.
	 */
	public boolean removeCurrent(){
		//check if there is a current, if there is remove it, decrease the number of items and sort the sequence
		//if the operation is successful then return true if there is not a current return false
		if(isCurrent()){
			cascadeBack(current);
			items--;
			sort();
			return true;
		}
		else return false;
	}
	/**
	 * This method trims the array so that it has 
	 * the same length as the number of items in the array. 
	 * We do this to avoid having a partially filled array
	 */
	public void trimToSize(){
		//create new array with the size of the number of items
		movie[] newData =  new movie[items];
		//copy elements of old array into the new array
		System.arraycopy(data, 0, newData, 0, newData.length);
		//set the new array equal to the old array
		data = newData;
	}
	/**
	 * This method sets the current element as the first element
	 * in the sequence. If the list is empty the current element is
	 * undefined,
	 */
	public void start(){ current = 0; }
	/**
	 * This method makes the current element 
	 * equal to the next element in the sequence 
	 * if there is not a next element then the current
	 * element is undefined.
	 */
	public void advance(){
		current++;
		//if the index of current is greater of equal to the number of 
		//items then set current equal to -1
		if(current >= items) current = -1;
	}
	/**
	 * This method is a getter for the current element.
	 * It checks if there is a current element
	 * @return if there is a current element 
	 * the current movie is returned
	 * @throws Exception if there is not a current element
	 * the method throws and exception and shows the message 
	 * "There is no current."
	 */
	public movie getCurrent() throws Exception {
		//if there is a current movie then return the current movie
		if(isCurrent()) return data[current]; 
		//if there is not a current movie throw an exception that states that there's no current
		else throw new Exception("There is no current.");
	}
	/**
	 * This method checks if there is a 
	 * current element
	 * @return true if there is a current element and false if there
	 * is not a current element.
	 */
	public boolean isCurrent(){ return current > -1; }
	/**
	 * This method concatenates two array sequences. 
	 * @param s1 the first array sequence that will be concatenated
	 * @param s2 the second array sequence that will be concatenated
	 * @return temp the merged/concatenated array sequence 
	 * @throws Exception if there is an exception the compiler does not handle it
	 * it throws the exception again.
	 */
	public ArraySequence concatenate(ArraySequence s1, ArraySequence s2) throws Exception {
		//create a temporary arraySequence
		ArraySequence temp = new ArraySequence();
		//add all elements of the arguments in this temporary array sequence 
		//sort the temporary array sequence and return it
		temp.addAll(s1);
		temp.addAll(s2);
		temp.sort();
		return temp;
	}
	/**
	 * This method is a getter for the number of items
	 * @return the number of items
	 */
	public int size(){ return items; }
	/**
	 * This method cascades back all elements from a specific index
	 * up to the last element in the array
	 * @param index is the index from which the elements in the array
	 * will start to cascade back
	 */
	public void cascadeBack(int index){
		for(int i = index; i < data.length-1; i++)
			data[i] = data[i+1];
	}
	/**
	 * This method cascades forward all elements from a the last element
	 * up to an index in the array
	 * @param index is the index up to which the elements in the array
	 * will be cascaded forward
	 */
	public void cascadeForward(int index){
		for(int i = items; i > index; i--)
			data[i] = data[i-1];
	}
	/**
	 * This method sorts the movies in the array sequence
	 * in descending order according to the element's imdb 
	 * rating and if the imdb rating of two movies is the same it compares
	 * the rotten tomatoes rating for the movies and sorts them accordingly
	 */
	public void sort(){
		//create a temporary movie to facilitate the sorting
		//use for loops and if statements to sort
		//if the imdb rating of two movies is the came use the rotten tomatoes rating as a criteria for sorting
			
			movie temp=new movie();
			for (int i = 0; i < data.length - 1 ; i++) {
			      for (int j = 0; j < data.length - i - 1; j++) {
			    	  
			   if(data[j]!=null && data[j+1]!=null){
				   
				        if (data[j].imdbRating < data[j+1].imdbRating) 
				        {
				          temp = data[j];
				          data[j] = data[j+1];
				          data[j+1] = temp;
				        }else if(data[j].imdbRating == data[j+1].imdbRating) {
				        	if(data[j].rtRating < data[j+1].rtRating) {
				        		temp = data[j];
						        data[j] = data[j+1];
						        data[j+1] = temp;
				        	}
				        }
			      }
			      }
			    }


	
	}
	/**
	 * This is a simple toString for easy printing
	 * @return a string with all the information of each element in the array sequence
	 * if the array sequence is empty it shows a message that states "Empty ArraySequence!"
	 */
	public String toString(){
		//create a StringBuilder object, append all the data in the data array
		//if there are no items append a message that states that the ArraySequence is empty
		//return the StringBuilder as a String
		StringBuilder str = new StringBuilder("");
		if(items!=0)
		str.append("Current: " +data[current]+ "\n");
		for(int i = 0; i < items; i++)
			str.append(data[i] + "\n");
		if(items == 0) str.append("Empty ArraySequence!"+ "\n");
		return str.toString();
	}
}