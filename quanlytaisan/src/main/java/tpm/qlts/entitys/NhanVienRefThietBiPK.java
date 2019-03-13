package tpm.qlts.entitys;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the NV_TB database table.
 * 
 */
@Embeddable
public class NhanVienRefThietBiPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="MaNhanVien", insertable=false, updatable=false)
	private String maNhanVien;

	@Column(name="MaThietBi", insertable=false, updatable=false)
	private long maThietBi;

	public NhanVienRefThietBiPK() {
	}
	public String getMaNhanVien() {
		return this.maNhanVien;
	}
	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	public long getMaThietBi() {
		return this.maThietBi;
	}
	public void setMaThietBi(long maThietBi) {
		this.maThietBi = maThietBi;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof NhanVienRefThietBiPK)) {
			return false;
		}
		NhanVienRefThietBiPK castOther = (NhanVienRefThietBiPK)other;
		return 
			this.maNhanVien.equals(castOther.maNhanVien)
			&& (this.maThietBi == castOther.maThietBi);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.maNhanVien.hashCode();
		hash = hash * prime + ((int) (this.maThietBi ^ (this.maThietBi >>> 32)));
		
		return hash;
	}
}