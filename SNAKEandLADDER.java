public class SnakeAndLadder{
	
	int CurrentPosition = 0;
	int DiceResult = 0;

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

		int CheckOptionsForPlay = DiceRoll(3);

		switch(CheckOptionsForPlay){

         	case 1:
            		System.out.println("No play");
         	break;

         	case 2:
            		System.out.println("You got Snake");
            		DiceResult=DiceRoll(6);
            		CurrentPosition -= DiceResult;
         	break;

         	case 3:
            		System.out.println("You got Ladder");
            		DiceResult = DiceRoll(6);
            		CurrentPosition += DiceResult;
         	break;

      		}
      	return CurrentPosition;
	}
}
