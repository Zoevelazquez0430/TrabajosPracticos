package ternilapili;

public class PlayerX extends Player{
	
	public boolean isPlayingX() {
		return true;
	}
	
	public boolean isPlayingO() {
		return false;
	}
	
	public Player playsX() {
		return new PlayerX();
	}
	
	public Player playsO() {
		return new PlayerO();
	}
	
}