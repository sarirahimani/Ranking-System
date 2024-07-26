package project1;
/**
 * 
 * @author Sahara Karima Mosin Rahimani
 * The movie class/object creates a movie with 
 * the following fields:
 * name: which is a string and stores the name of the movie
 * genre: which is a string and stores the genre of the movie
 * imdbRating: which is an integer and stores the movie's imdb rating
 * rtRating: which is an integer and stores the movie's rotten tomatoes
 */
public class movie {
	String name;
	String genre;
	int imdbRating;
	int rtRating;
	/**
	 * Unargumented constructor that calls the argumented
	 * constructor and sets all fields to default values:
	 * name=" "
	 * genre=" "
	 * imdbRating=0
	 * rtRating=0
	 */
	public movie() {
		//this is the argumented method call
		this("","",0,0);
	}
	/**
	 * Argumented constructors that has the following parameters:
	 * @param name is the name of the movie
	 * @param genre is the genre of the movie
	 * @param imdbRating is the imdb rating of the movie
	 * @param rtRating is the rotten tomatoes rating of the movie
	 */
	public movie(String name, String genre, int imdbRating, int rtRating) {
		//these statements set the fields equal to their corresponding parameters or arguments
		this.name = name;
		this.genre = genre;
		this.imdbRating = imdbRating;
		this.rtRating = rtRating;
	}
	/**
	 * This is a getter for the name of the movie
	 * @return the name is returned
	 */
	public String getName() {
		return name;
	}
	/**
	 * This is a setter for the name
	 * It sets the name of the movie
	 * @param name the name of the movie
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * This is a getter for the genre of the movie
	 * @return genre of the movie is returned
	 */
	public String getGenre() {
		return genre;
	}
	/**
	 * This is a setter for the genre
	 * It sets the genre of the movie
	 * @param genre of the movie
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}
	/**
	 * This is a getter for the imdb rating of the movie
	 * @return the imdbRating the imdb rating of the movie
	 */
	public int getImdbRating() {
		return imdbRating;
	}
	/**
	 * This is a setter for the imdbRating
	 * It sets the imdb Rating
	 * @param imdbRating is the imdb rating of the movie
	 */
	public void setImdbRating(int imdbRating) {
		this.imdbRating = imdbRating;
	}
	/**
	 * This is a getter for the rotten tomatoes rationg of the movie
	 * @return the rtRating is the rotten tomatoes rating of the movie
	 */
	public int getRtRating() {
		return rtRating;
	}
	/**
	 * This is a setter for rtRating
	 * It sets the rotten tomatoes rating of the movie
	 * @param rtRating is the rotten tomatoes rating
	 */
	public void setRtRating(int rtRating) {
		this.rtRating = rtRating;
	}
	/**
	 * This is a simple toString for easy printing
	 * @return a string with all the information of each movie
	 * the information is the string includes the name, genre, imdb rating
	 * and rotten tomatoes rating of the movie
	 */
	public String toString() {
		return "Movie [name=" + name + ", genre=" + genre + ", imdbRating=" + imdbRating + ", rtRating=" + rtRating
				+ "]";
	}
	
	

}
