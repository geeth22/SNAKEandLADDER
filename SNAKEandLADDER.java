public class SnakeAndLadder{
	
	int CurrentPosition = 0;
	int DiceResult = 0;
	int WinningPosition = 100;
	
	public static void main(String args[]){
		SnakeAndLadder obj = new SnakeAndLadder();
		System.out.println("Player Position : "+ obj.CheckOptions());
	}

	public int DiceRoll(int RollMax){
		Random rand = new Random();
		int DiceRoll = (rand.nextInt(RollMax)) + 1;
		return DiceRoll;
	}

	public int CheckOptions(){
		
		while(CurrentPosition < WinningPosition){
		int CheckOptionsForPlay = DiceRoll(3);

		switch(CheckOptionsForPlay){

         	case 1:
            		System.out.println("\nNo play and Current Position is " + CurrentPosition);
         	break;

         	case 2:
            		DiceResult = DiceRoll(6);

			if(CurrentPosition <= DiceResult){
                  	CurrentPosition = 0;
                  	System.out.println("\nYou got Snake with dice face of " + DiceResult + " and Current Position is " + CurrentPosition);
               		}
 
              		else{
                  	CurrentPosition -= DiceResult;
                  	System.out.println("\nYou got Snake with dice face of " + DiceResult + " and Current Position is " + CurrentPosition);
               		}
         	break;

         	case 3:
            		DiceResult = DiceRoll(6);

                    //current Position + dice should not exceed winning position
                    if(CurrentPosition + DiceResult > WinningPosition){

                        //Dice roll Should result into exact number to Winning Position
                        while(CurrentPosition + DiceResult == WinningPosition){
                            DiceResult = DiceRoll(6);
                            CurrentPosition += DiceResult;
                        }
                        break;
                    }
                    else {
                        CurrentPosition += DiceResult;
                        System.out.println("\nYou got Ladder with dice face of " + DiceResult + " and Current Position is " + CurrentPosition);
            break;
		 }
      		}
	}
      return CurrentPosition;
   }
}
