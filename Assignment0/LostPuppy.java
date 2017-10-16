/**
 * Represents the location in a building where a puppy was lost
 * @author Kit Wong
 * @version 1.0
 */
import java.util.*;
public class LostPuppy {

    private char hidingPlaces[][];
    private int floorLocation;
    private int roomLocation;
    private char winner;
    private boolean found;
    private int floorSize;
    private int roomSize;

    /**
     * Initialize the number of floors and rooms in the building and each room is empty
     * Set the puppy in a room randomly and set the room as 'P'
     * Set the winner to a single space
     * Set the found to false
     * @param floorSize how many floors in the building
     * @param roomSize how many rooms in each floor
     */
    public LostPuppy (int floorSize, int roomSize){
        this.floorSize = floorSize;
        this.roomSize = roomSize;
        hidingPlaces = new char[floorSize][roomSize];
        for (int i = 0; i < floorSize; i++){
            for (int j = 0; j < roomSize; j++) {
                hidingPlaces[i][j] = ' ';
            }
        }
        Random rand = new Random();
        floorLocation = rand.nextInt(floorSize);
        roomLocation = rand.nextInt(roomSize);
        hidingPlaces[floorLocation][roomLocation] = 'P';
        winner = ' ';
        found = false;
    }

    /**
     * To check if the room is searched or not
     * @param floorSearch which floor want to check
     * @param roomSearch which room want to check
     * @return return true if the room is searched, otherwise return false
     */
    public boolean roomSearchedAlready (int floorSearch, int roomSearch){
        if (hidingPlaces[floorSize-floorSearch-1][roomSearch] == ' ' ||
                hidingPlaces[floorSize-floorSearch-1][roomSearch] == 'P'){
            return false;
        }
        return true;
    }

    /**
     * To check if the room is where the puppy locate
     * @param floorSearch which floor want to check
     * @param roomSearch which room want to check
     * @return return true if the puppy is in the room, other wise return false
     */
    public boolean puppyLocation (int floorSearch, int roomSearch){
        if (hidingPlaces[floorSize-floorSearch-1][roomSearch] == 'P'){
            return true;
        }
        return false;
    }

    /**
     * To check if the floor and room that the user want to check is in the range
     * of the building maximum floor and room
     * @param floorSearch which floor want to check
     * @param roomSearch which room want to check
     * @return return true if the floor and room that the user want to check is in the range
     * of the building maximum floor and room, other wise return false
     */
    public boolean indicesOK (int floorSearch, int roomSearch){
        if (floorSearch <= floorSize && roomSearch <= roomSize) {
            return true;
        }
        return false;
    }

    /**
     * To get the maximum number of floor in the building
     * @return return the maximum number of floor in the building
     */
    public int numberOfFloors (){
        return floorSize;
    }

    /**
     * To get the maximum number of room in the building
     * @return return the maximum number of room in the building
     */
    public int numberOfRooms (){
        return roomSize;
    }

    /**
     * To check if the room is where the puppy locate
     * If yes, update winner to current player, found to true
     * If not, update the room to current player index
     * @param floorSearch the floor need to search
     * @param roomSearch the room need to search
     * @param player the current player index
     * @return return true if the puppy is in the room, otherwise return false
     */
    public boolean searchRoom (int floorSearch, int roomSearch, char player){
        if (hidingPlaces[floorSize-floorSearch-1][roomSearch] == 'P'){
            winner = player;
            found = true;
            return true;
        }
        hidingPlaces[floorSize-floorSearch-1][roomSearch] = player;
        return false;
    }

    /**
     * To print out the outlook of the building by using some character
     * @return return the outlook of the building as string type
     */
    public String toString (){
        String building = "\t";
        for (int i = 0; i < roomSize*4+1; i++){
            building += "-";
        }
        building += "\n\t";
        for (int i = 0; i < floorSize; i++){
            for (int j = 0; j < roomSize; j++){
                if (found == false){
                    if(hidingPlaces[i][j]=='P'){
                        building += "|   ";
                    }
                    else{
                        building += "| "+hidingPlaces[i][j]+" ";
                    }
                }
                else{
                    if(hidingPlaces[i][j]=='P'){
                        building += "|"+winner+"P ";
                    }
                    else{
                        building += "| "+hidingPlaces[i][j]+" ";
                    }
                }
            }
            building += "|\t<<< Floor "+(floorSize-i-1)+"\n\t";
            for (int j = 0; j < roomSize; j++){
                building += "|---";
            }
            building += "|\n\t";
        }
        return building;
    }
}
