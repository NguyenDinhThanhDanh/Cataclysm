
public abstract class AbstractDeplacement implements ComportementAvecDanger {
	 private ComportementAvecDanger next;
	 private String type;

	public ComportementAvecDanger getNext() {
		return next;
	}
	public void setNext(ComportementAvecDanger next) {
		this.next = next;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	  

}
