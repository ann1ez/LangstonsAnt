
public class Ant {

	private int ant_r;
	private int ant_c;
	private int orientation;
	private int steps;
	
	public Ant() {
		orientation = 2;
		ant_r = 0;
		ant_c = 0;
	}
	
	public Ant(int orien, int row, int col) {
		orientation = orien;
		ant_r = row;
		ant_c = col;
	}
	
	public int get_r() {
		return ant_r;
	}
	public int get_c() {
		return ant_c;
	}
	public int get_o() {
		return orientation;
	}
	public int get_s() {
		return steps;
	}
	public void set_r(int row) {
		ant_r = row;
	}
	public void set_c(int col) {
		ant_c = col;
	}
	public void set_o(int orien) {
		orientation = orien;
	}
	public void set_s(int st) {
		steps = st;
	}
	
	public String style() {
		if(orientation==0)
			return "^";
		else if(orientation==1)
			return ">";
		else if(orientation==2)
			return "v";
		return "<";
	}
	
}
