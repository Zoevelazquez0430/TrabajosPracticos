package ternilapili;

public class PlayerO extends Player{
	
	public boolean isPlayingX() {
		return false;
	}
	
	public boolean isPlayingO() {
		return true;
	}
	
	public Player playsX() {
		return new PlayerX();
	}
	
	public Player playsO() {
		return new PlayerO();
	}
	
}
