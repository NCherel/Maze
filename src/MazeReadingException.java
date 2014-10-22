
public class MazeReadingException extends Exception{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MazeReadingException(String fileName, int line, String error) {
		super("Problem for file : " + fileName + "at line " + line +"\n" + error);
	}
	
	

}
