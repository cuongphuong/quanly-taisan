package tpm.qlts.custommodels;

import java.util.List;

public class LuanChuyenOptions {
	private String label;
	private List<options> options;
	
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public List<options> getOptions() {
		return options;
	}
	public void setOptions(List<options> options) {
		this.options = options;
	}
	public LuanChuyenOptions(String label, List<tpm.qlts.custommodels.options> options) {
		super();
		this.label = label;
		this.options = options;
	}
	public LuanChuyenOptions() {
		super();
		// TODO Auto-generated constructor stub
	}
}

