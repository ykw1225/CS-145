
/**
 * This class represents a single note in scientific music notation.
 * @author Kit Wong
 */
public class Note {

	private double duration;
	Pitch note;
	private int octave;
	Accidental accidental;
	private boolean repeat;

	/**
	 * This method is checking if the duration is smaller than zero.
	 * @param duration is the duration need to check.
	 */
	private void checkDuration (double duration) {
		if (duration <= 0) throw new IllegalArgumentException ();
	}

	/**
	 * This method is checking if the octave is between 0 to 10.
	 * @param octave is the octave need to check.
	 */
	private void checkOctave (int octave) {
		if (octave < 0 || octave > 10) throw new IllegalArgumentException ();
	}

	/**
	 * This method is the constructor that contain all information.
	 * @param duration is the duration of the note.
	 * @param note is the note name.
	 * @param octave is the octave of the note.
	 * @param accidental is the accidental of the note.
	 * @param repeat is if the note repeat or not.
	 */
	public Note(double duration, Pitch note, int octave, Accidental accidental,
			boolean repeat) {
				checkDuration (duration);
				checkOctave (octave);
				this.duration = duration;
				this.note = note;
				this.octave = octave;
				this.accidental = accidental;
				this.repeat = repeat;
	}

	/**
	 * This method is the constructor that contain duration, note name, and repeat.
	 * @param duration is the duration of the note.
	 * @param note is the note name.
	 * @param repeat is if the note repeat or not.
	 */
	public Note(double duration, Pitch note, boolean repeat) {
		checkDuration (duration);
		this.duration = duration;
		this.note = note;
		this.repeat = repeat;
	}

	/**
	 * This method is getting the duration.
	 * @return the duration of the note.
	 */
	public double getDuration() {
		return duration;
	}

	/**
	 * This method is setting the duration.
	 * @param time the new duration need to set.
	 */
	public void setDuration(double time) {
		this.duration = time;
	}

	/**
	 * This method is checking if the repeat option of the note
	 * is on or not.
	 * @return if the repeat is on return true, otherwise return false.
	 */
	public boolean isRepeat() {
		return repeat;
	}

	/**
	 * This method is to play the note.
	 */
	public void play() {
		StdAudio.play (duration, note, octave, accidental);
	}

	/**
	 * This method is sending out the information of the note
	 * with a String type.
	 * @return the information of the note.
	 */
	public String toString() {
		String result = "";
		result += duration + " ";
		result += note + " ";
		if (note.equals(Pitch.R)) {
			result += repeat;
		}
		else {
			result += octave + " " + accidental + " " + repeat;
		}
		return result;
	}
}