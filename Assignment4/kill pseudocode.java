public void kill(String name){
		//if front person is killed  do later
		//if killer/killed is middle of the kill list

		//keep the stalker one step behind the victim
		//one step ahead
			//The current node is the killer; set the victim's killer
			//member to reflect that
			
			//set stalker's next node to skip over the victim
			
			//bury them
			bury (victim);
			return;
			}
			//keep up the traverse
		}
		//ok here's the special case. The victim is the first person
		//and the stalker/killer is the last in the loop
		//We are already at the end of the loop and stalker is the killer.
		//And victim is the first person in the list so killFront must point
		//to them.

		//stalker is still the killer
		//now advance the kill ring over the victim
		//bury
		bury(victim);
		return;

	}
	//fix data in the first graveFront node

	private void bury(AssassinNode victim){
		
	}
	/**public void kill(String name)
In this method you should record the killing of the person with the given name, transferring the person from the kill ring
to the front of the graveyard. This operation should not change the relative order of the kill ring (i.e., the links of who is
killing whom should stay the same other than the person who is being killed/removed). Ignore case in comparing names.
A node remembers who killed the person in its killer field. It is your code's responsibility to set that field's value.
You should throw an IllegalStateException if the game is over, or an IllegalArgumentException if the given
name is not part of the kill ring (if both of these conditions are true, the IllegalStateException takes precedence).
The kill method is the hardest one, so write it last. Use the jGRASP debugger and println statements liberally to
debug problems in your code. You will likely have a lot of NullPointerException errors, infinite loops, etc. and will
have a very hard time tracking them down unless you are comfortable with debugging techniques and jGRASP.
For full credit, every method's runtime should be at worst O(N), where N is the number of people in your linked lists.*/