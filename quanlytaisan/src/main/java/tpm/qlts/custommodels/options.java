package tpm.qlts.custommodels;

public class options {

	private String value;
	private String label;
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public options(String value, String label) {
		super();
		this.value = value;
		this.label = label;
	}
	public options() {
		super();
		// TODO Auto-generated constructor stub
	}
}
