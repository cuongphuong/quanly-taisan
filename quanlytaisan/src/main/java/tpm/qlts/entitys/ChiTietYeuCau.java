package tpm.qlts.entitys;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ChiTietYeuCau database table.
 * 
 */
@Entity
@NamedQuery(name="ChiTietYeuCau.findAll", query="SELECT c FROM ChiTietYeuCau c")
public class ChiTietYeuCau implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MaCT")
	private int maCT;

	@Column(name="DonViTInh")
	private int donViTInh;

	@Column(name="QuyCach_DatTinh")
	private String quyCach_DatTinh;

	@Column(name="SoLuong")
	private int soLuong;

	@Column(name="TenThietBi")
	private String tenThietBi;

	//bi-directional many-to-one association to PhieuYeuCauThietBi
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MaPhieu")
	private PhieuYeuCauThietBi phieuYeuCauThietBi;

	public ChiTietYeuCau() {
	}

	public int getMaCT() {
		return this.maCT;
	}

	public void setMaCT(int maCT) {
		this.maCT = maCT;
	}

	public int getDonViTInh() {
		return this.donViTInh;
	}

	public void setDonViTInh(int donViTInh) {
		this.donViTInh = donViTInh;
	}

	public String getQuyCach_DatTinh() {
		return this.quyCach_DatTinh;
	}

	public void setQuyCach_DatTinh(String quyCach_DatTinh) {
		this.quyCach_DatTinh = quyCach_DatTinh;
	}

	public int getSoLuong() {
		return this.soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public String getTenThietBi() {
		return this.tenThietBi;
	}

	public void setTenThietBi(String tenThietBi) {
		this.tenThietBi = tenThietBi;
	}

	public PhieuYeuCauThietBi getPhieuYeuCauThietBi() {
		return this.phieuYeuCauThietBi;
	}

	public void setPhieuYeuCauThietBi(PhieuYeuCauThietBi phieuYeuCauThietBi) {
		this.phieuYeuCauThietBi = phieuYeuCauThietBi;
	}

}