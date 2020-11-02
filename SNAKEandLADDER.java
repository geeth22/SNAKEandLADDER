public class SnakeAndLadder{
	
	Random rand = new Random();
	
	public static void main(String args[]) {
		
		SnakeAndLadder obj=new SnakeAndLadder();
		System.out.println("Dice value : "+obj.DiceRoll());
	}
	
	public int DiceRoll(){
		int DiceRoll = (rand.nextInt(6))+1;
		return DiceRoll;
	}

}

