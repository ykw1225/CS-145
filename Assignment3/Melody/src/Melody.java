import java.util.*;
import java.io.*;

/**
 * This class represents a melody object
 * which likes a song with a queue of note.
 * @author Kit Wong
 */
public class Melody{

	Queue<Note> melody;
	private double length;

	/**
	 * This method is the constructor with no param.
	 */
	public Melody() {
		melody = new LinkedList<Note>();
		length = 0;
	}

	/**
	 * This method is to take information from a text file
	 * and create a new melody.
	 * @param input is the text file.
	 */
	public void input(Scanner input) {
		melody = new LinkedList<Note> ();
		Note tempNote;
		double duration;
		Pitch note;
		int octave;
		Accidental accidental;
		boolean repeat;
		while(input.hasNext()) {
			String line = input.nextLine();
			Scanner lineScan = new Scanner(line);
			while(lineScan.hasNext()) {
				duration = lineScan.nextDouble();
				length += duration;
				note = Pitch.valueOf(lineScan.next());
				if (lineScan.hasNextInt()) {
					octave = lineScan.nextInt();
					accidental = Accidental.valueOf(lineScan.next());
					repeat = lineScan.nextBoolean();
					tempNote = new Note(duration, note, octave, accidental, repeat);
					melody.add(tempNote);
				}
				else {
					repeat = lineScan.nextBoolean();
					tempNote = new Note(duration, note, repeat);
					melody.add(tempNote);
				}
			}
		}
	}

	/**
	 * This method is getting the length of the melody queue.
	 * @return	is sending the length.
	 */
	public double getLength() {
		return length;
	}

	/**
	 * This method is taking the information of note from
	 * the melody queue into the output of a text file.
	 * @param out is the output file.
	 */
	public void output(PrintStream out) {
		Queue<Note> temp = new LinkedList<Note> (melody);
		while(!temp.isEmpty()) {
			out.println(temp.remove());
		}
	}

	/**
	 * This method is changing the tempo of the song.
	 * @param tempo is how many times changing to the song.
	 */
	public void changeTempo(double tempo) {
		Note tempNote;
		for(int i = 0; i < melody.size(); i++) {
			tempNote = melody.remove();
			tempNote.setDuration(tempNote.getDuration()*tempo);
			melody.add(tempNote);
		}
	}

	/**
	 * This method is to reverse the song.
	 */
	public void reverse() {
		Stack<Note> temp = new Stack<Note> ();
		while(!melody.isEmpty()) {
			temp.add(melody.remove());
		}
		while(!temp.isEmpty()) {
			melody.add(temp.pop());
		}
	}

	/**
	 * This method is appending an other song to the current loaded song.
	 * @param other is the song need to append.
	 */
	public void append(Melody other) {
		Queue<Note> temp = new LinkedList<Note> (other.melody);
		Note tempNote;
		while(!temp.isEmpty()) {
			melody.add(temp.remove());
		}
	}

	/**
	 * This method is to play the song.
	 */
	public void play() {
		Queue<Note> temp = new LinkedList<Note>();
		Note tempNote;
		boolean repeat = false;
		for(int i=0; i < melody.size(); i++) {
			tempNote = melody.remove();
			tempNote.play();
			melody.add(tempNote);
			if(tempNote.isRepeat() && repeat == false) {
				repeat = true;
			}
			else if(tempNote.isRepeat() && repeat == true) {
				repeat = false;
				temp.add(tempNote);
				while(!temp.isEmpty()) {
					temp.remove().play();
				}
			}
			if(repeat) {
				temp.add(tempNote);
			}
		}
	}

	/**
	 * This method is to play the song at a specific time.
	 * @param time is the time start to play the song..
	 */
	public void play(double time) {
		Queue<Note> temp = new LinkedList<Note>();
		Note tempNote;
		boolean repeat = false;
		double timeCounter = 0;
		for(int i=0; i < melody.size(); i++) {
			tempNote = melody.remove();
			if(timeCounter >= time) tempNote.play();
			melody.add(tempNote);
			timeCounter += tempNote.getDuration();
			if(tempNote.isRepeat() && repeat == false){
				repeat = true;
			}
			else if(tempNote.isRepeat() && repeat == true){
				repeat = false;
				temp.add(tempNote);
				while(!temp.isEmpty()) {
					if(timeCounter >= time){
						temp.peek().play();
					}
					timeCounter += temp.remove().getDuration();
				}
			}
			if(repeat) {
				temp.add(tempNote);
			}
		}
	}
}