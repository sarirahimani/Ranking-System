package project1;
/**
 * This is the tester for the ArraySequence 
 * Here I will test the methods of the movie class
 * I will test the methods of the ArraySequence class
 * and I will add movies to the sequence and perform different
 * functions. This is the tester of the Movie Ranking System.
 *
 * The ranking system is done with an ArraySequence. The movies
 * in this ranking system are ranked according to their IMDB rating
 * if two IMDB ratings are the same then I employ the Rotten Tomatoes 
 * Ratings. 
 * 
 * The movies added to the ArraySequence are sorted, the first 
 * movie in the sequence is the one with the highest rating and the last one
 * is the one with the lowest rating. 
 * 
 * In this case the current element in the sequence is
 * considered a random recommendation. 
 *  
 * @author Sahara Karima Mosin Rahimani
 */
public class projectTester {
	public static void main(String[] args){
	try {
		//Testing all of the methods in the movie object
		 //Create a movie object and test the argumented constructor and the to string
	
		movie myMovie1=new movie("Parent Trap", "Comedy", 6, 86);
		System.out.println(myMovie1);
		
		/**  this must print Movie [name= Parent trap,
		 * genre= Comedy, imdbRating= 6, rtRating= 86] 
		 */
		//This will create another movie object and test the unargumented constrictor
		movie myMovie2=new movie();
		System.out.println(myMovie2);
		/**  this must print Movie [name= ,
		 * genre= , imdbRating= 0, rtRating= 0] 
		 */
		
		/**
		 * Test the setters of the movie object these statements set the 
		 * Name, Genre, imdb Rating and rotten tomatoes rating of the movie object
		 */
		myMovie2.setName("Cruella");
		myMovie2.setGenre("Comedy");
		myMovie2.setImdbRating(10);
		myMovie2.setRtRating(90);
		//Print out the movie again 
		System.out.println(myMovie2);
		/**
		 *  this must print Movie [name= Cruella,
		 * genre= Comedy , imdbRating= 10, rtRating= 90]
		 */
		//These statements test the getters 
		System.out.println("Name: "+myMovie2.getName());//this statement must print: Name: Cruella
		System.out.println("Genre: "+myMovie2.getGenre());//this statement must print: Genre: Comedy
		System.out.println("IMDB: "+myMovie2.getImdbRating());//this statement must print: IMDB: 10
		System.out.println("Rotten Tomatoes: "+myMovie2.getRtRating());//this statement must print: Rotten Tomatoes: 90
		System.out.println("------------------------------------------------");//Used to separate output
		
		
		/**Testing all the methods in the ArraySequence and adding movies to the array sequence
		 * Creating an ArraySequence object and testing the unargumented constructor
		 */
		ArraySequence ArraySeq=new ArraySequence();
		System.out.println(ArraySeq);//This must print: Empty ArraySequence!
		//Check if there is a current element
		System.out.println("Is there a random recommendation? "+ ArraySeq.isCurrent());//This must print: Is there a random recommendation? False
		//add movies to the ArraySequence
		ArraySeq.addAfter(myMovie1);
		System.out.println(ArraySeq);
		System.out.println("Is there a random recommendation? "+ ArraySeq.isCurrent());//This must print: Is there a random recommendation? True
		ArraySeq.addAfter(myMovie2);
		System.out.println(ArraySeq);
		System.out.println("------------------------------------------------");//Used to separate output
		
		
		//Create more movies, test add methods and print after each new addition
		movie myMovie3=new movie("Bugs Bunny", "Comedy", 7, 60);
		ArraySeq.addBefore(myMovie3);
		System.out.println(ArraySeq);
		movie myMovie4=new movie("Princess Diaries", "Comedy", 6, 100);
		ArraySeq.addBefore(myMovie4);
		System.out.println(ArraySeq);
		movie myMovie5=new movie("Jackass", "Comedy", 7, 10);
		ArraySeq.addAfter(myMovie5);
		System.out.println(ArraySeq);
		movie myMovie6=new movie("Princess Bride", "Comedy", 1, 20);
		ArraySeq.addAfter(myMovie6);
		System.out.println(ArraySeq);
		//Check the size of the Sequence after adding six movies 
		System.out.println("Size of ArraySeq: "+ArraySeq.size());//This must print Size of ArraySeq: 6
		System.out.println("------------------------------------------------");//Used to separate output
		
		
		//Test the method to get the current element
		System.out.println("Current Movie Recommendation: "+ArraySeq.getCurrent());//This statement must print: Current Movie Recommendation: Movie [name=Princess Diaries, genre=Comedy, imdbRating=6, rtRating=100]
		
		//Change the current to the first movie
		ArraySeq.start();
		//This statement must print: Current Movie after start: 
		//Movie [name=Cruella, genre=Comedy, imdbRating=10, rtRating=90]
		System.out.println("Current Movie after start: "+ArraySeq.getCurrent());
		
		//Change the current movie to the second movie
		ArraySeq.advance();
		//This statement must print: Current Movie Rec after advancing once: 
		//Movie [name=Bugs Bunny, genre=Comedy, imdbRating=7, rtRating=60]
		System.out.println("Current Movie Rec after advancing once: "+ArraySeq.getCurrent());
		
		//Change the current movie to the third movie
		ArraySeq.advance();
		//This statement must print: Current Movie Rec after advancing twice: 
		//Movie [name=Jackass, genre=Comedy, imdbRating=7, rtRating=10]
		System.out.println("Current Movie Rec after advancing twice: "+ArraySeq.getCurrent());
		
		//Change the current to the first movie again
		ArraySeq.start();
		//This statement must print: Current Movie Rec after start: 
		//Movie [name=Cruella, genre=Comedy, imdbRating=10, rtRating=90]
		System.out.println("Current Movie Rec after start: "+ArraySeq.getCurrent());
	
		//I want to remove the current movie, so I will eliminate parent trap from the sequence
		//This will print: Successful removal of current Rec? True
		System.out.println("Successful removal of current Rec? "+ArraySeq.removeCurrent());
		//This will print: New Current Rec after removing parent trap:  
		//Movie [name=Bugs Bunny, genre=Comedy, imdbRating=7, rtRating=60]
		System.out.println("New Current Rec after removing parent trap: "+ArraySeq.getCurrent());
		//This will print the entire sequence without parent trap 
		System.out.println(ArraySeq);
		System.out.println("------------------------------------------------");//Used to separate output
		
		
		//This ArraySequence is not full so I will trim it to the size it has 
		//This prints:Capacity before trimming: 10
		System.out.println("Capacity before trimming: "+ArraySeq.getCapacity());
		ArraySeq.trimToSize();
		//This prints: Capacity after trimming: 5
		System.out.println("Capacity after trimming: "+ArraySeq.getCapacity());
		
		//I want to resize/ensure I have more space and I print the capacity to check
		//This prints:Capacity before resizing: 5
		System.out.println("Capacity before resizing: "+ArraySeq.getCapacity());
		//Now sequence has a capacity of 10
		ArraySeq.ensureCapacity(10);
		//This will print:Capacity after resizing: 10
		System.out.println("Capacity after resizing: "+ArraySeq.getCapacity());
		System.out.println("------------------------------------------------");//Used to separate output
		
		
		//Creating another ArraySequence object and testing the argumented constructor and setting the ArraySequence to size 5
		ArraySequence ArraySeq1=new ArraySequence(5);
		System.out.println(ArraySeq1);//This must print: Empty ArraySequence!
		//Check the capacity of the sequence
		System.out.println("Capacity of ArraySeq1: "+ArraySeq1.getCapacity());//This must print: Capacity of ArraySeq1: 5
		System.out.println("------------------------------------------------");//Used to separate output
		
		
		//Filling ArraySeq1
		movie Movie1=new movie("Harry Potter 1", "Fantasy", 2, 30);
		ArraySeq1.addBefore(Movie1);
		movie Movie2=new movie("Harry Potter 2", "Fantasy", 4, 60);
		ArraySeq1.addBefore(Movie2);
		movie Movie3=new movie("Harry Potter 3", "Fantasy", 6, 20);
		ArraySeq1.addBefore(Movie3);
		movie Movie4=new movie("Harry Potter 4", "Fantasy", 10, 100);
		ArraySeq1.addAfter(Movie4);
		movie Movie5=new movie("Harry Potter 5", "Fantasy", 9, 70);
		ArraySeq1.addAfter(Movie5);
		
		//Add all the elements in ArraySeq1 to ArraySeq
		ArraySeq.addAll(ArraySeq1);
		//ArraySeq with all new elements
		System.out.println("After adding ArraySeq1: "+ArraySeq);
		System.out.println("------------------------------------------------");//Used to separate output
		
		
		//Concatenate both arrays and print
		System.out.println(ArraySeq.concatenate(ArraySeq, ArraySeq1));
		
		
		
	}catch(Exception e) {
		System.out.println("Try Again");
	}
		
	}
}
