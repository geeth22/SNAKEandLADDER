import java.util.Random;

public class SnakeAndLadder{

    int Player1CurrentPosition;
    int Player2CurrentPosition;
    int DiceResult = 0;
    public static final int WinningPosition = 100; 

    public static void main(String args[]){

        SnakeAndLadder obj = new SnakeAndLadder();

        while (obj.Player1Position() < 100 && obj.Player2Position() < 100){
            obj.Player1Position();
            obj.Player2Position();
        }
    }

    public int Player1Position(){

        Player1CurrentPosition = CheckOptions(Player1CurrentPosition,1);
        return Player1CurrentPosition;
    }

    public int Player2Position(){
        Player2CurrentPosition = CheckOptions(Player2CurrentPosition,2);
        return Player2CurrentPosition;
    }

    public int DiceRoll(int RollMax){
        Random rand = new Random();
        int DiceRoll = (rand.nextInt(RollMax)) + 1;
        return DiceRoll;
    }

    public int CheckOptions(int CurrentPosition, int Player) {

            int CheckOptionsForPlay = DiceRoll(3);

            switch (CheckOptionsForPlay) {
                
                case 1:
                    System.out.println("\nPlayer "+ Player + " No play and Current Position is " + CurrentPosition);
                break;

                case 2:
                    DiceResult = DiceRoll(6);

                    if (CurrentPosition <= DiceResult) {
                        CurrentPosition = 0;
                        System.out.println("\nPlayer "+ Player + " got Snake with dice face of " + DiceResult + " and Current Position is " + CurrentPosition);
                    } else {
                        CurrentPosition -= DiceResult;
                        System.out.println("\nPlayer "+ Player + " You got Snake with dice face of " + DiceResult + " and Current Position is " + CurrentPosition);
                    }
                break;

                case 3:
                    DiceResult = DiceRoll(6);

                    if (CurrentPosition + DiceResult > WinningPosition) {

                        while (CurrentPosition + DiceResult == WinningPosition) {
                            DiceResult = DiceRoll(6);
                            CurrentPosition += DiceResult;
                        }
                        break;
                    } else {
                        CurrentPosition += DiceResult;
                        System.out.println("\nPlayer " + Player +" got Ladder with dice face of " + DiceResult + " and Current Position is " + CurrentPosition);

                        //Checking Each Player's position which should be below Winning Position
                        if(CurrentPosition == WinningPosition){
                            System.out.println("\nPlayer "+ Player + " won");
                        }
                        break;
                    }
            }
        return CurrentPosition;

    }
}
