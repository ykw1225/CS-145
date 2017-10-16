// <your name here>
// Section <your section here>
// CSE 143, Autumn 2013
// Homework 3
// A Note object represents a musical note in scientific music notation. 
// For example, middle C is represented as C4. 

public class Note {
	
	// pre : duration > 0 and 0 <= octave <= 10, otherwise throws an IllegalArgumentException
	// post: constructs a note with the provided duration, pitch, octave, accidental 
	//       and repeat settings.
	public Note(double duration, Pitch note, int octave, Accidental accidental, 
			boolean repeat) {
		
	}
	
	// pre : duration > 0, otherwise throws an IllegalArgumentException
	// post: constructs a note with the passed in duration, pitch and repeat settings. 
	public Note(double duration, Pitch note, boolean repeat) {
		
	}
	
	// post: returns the length of the note in seconds
	public double getDuration() {
		return 0.0;
	}
	
	// pre : d must be greater than 0, otherwise an IllegalArgumentException is thrown
	// post: sets the duration of the note to be the given time
	public void setDuration(double time) {
		
	}
	
	// post: returns true if the note is the beginning or ending note in a repeated section, 
	//       false otherwise
	public boolean isRepeat() {
		return false;
	}
	
	// post: plays the sound this note represents
	public void play() {

	}
	
	// post: returns a string in the format "<duration> <pitch> <repeat>" if the note is a rest,
	//       otherwise returns a string in the format: 
	//       "<duration> <pitch> <octave> <accidental> <repeat>"
	//       For example "2.3 A 4 SHARP true" and "1.5 R true".
	public String toString() {
		return "";
	}
}