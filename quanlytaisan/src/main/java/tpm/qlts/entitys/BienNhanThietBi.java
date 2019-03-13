package tpm.qlts.entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the BienNhanThietBi database table.
 * 
 */
@Entity
@NamedQuery(name="BienNhanThietBi.findAll", query="SELECT b FROM BienNhanThietBi b")
public class BienNhanThietBi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MaBienNhan")
	private String maBienNhan;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="NgayBienNhan")
	private Date ngayBienNhan;

	//bi-directional many-to-one association to ChiTiet
	@OneToMany(mappedBy="bienNhanThietBi")
	private List<ChiTiet> chiTiets;

	//bi-directional many-to-one association to ThietBi
	@OneToMany(mappedBy="bienNhanThietBi")
	private List<ThietBi> thietBis;

	public BienNhanThietBi() {
	}

	public String getMaBienNhan() {
		return this.maBienNhan;
	}

	public void setMaBienNhan(String maBienNhan) {
		this.maBienNhan = maBienNhan;
	}

	public Date getNgayBienNhan() {
		return this.ngayBienNhan;
	}

	public void setNgayBienNhan(Date ngayBienNhan) {
		this.ngayBienNhan = ngayBienNhan;
	}

	public List<ChiTiet> getChiTiets() {
		return this.chiTiets;
	}

	public void setChiTiets(List<ChiTiet> chiTiets) {
		this.chiTiets = chiTiets;
	}

	public ChiTiet addChiTiet(ChiTiet chiTiet) {
		getChiTiets().add(chiTiet);
		chiTiet.setBienNhanThietBi(this);

		return chiTiet;
	}

	public ChiTiet removeChiTiet(ChiTiet chiTiet) {
		getChiTiets().remove(chiTiet);
		chiTiet.setBienNhanThietBi(null);

		return chiTiet;
	}

	public List<ThietBi> getThietBis() {
		return this.thietBis;
	}

	public void setThietBis(List<ThietBi> thietBis) {
		this.thietBis = thietBis;
	}

	public ThietBi addThietBi(ThietBi thietBi) {
		getThietBis().add(thietBi);
		thietBi.setBienNhanThietBi(this);

		return thietBi;
	}

	public ThietBi removeThietBi(ThietBi thietBi) {
		getThietBis().remove(thietBi);
		thietBi.setBienNhanThietBi(null);

		return thietBi;
	}

}