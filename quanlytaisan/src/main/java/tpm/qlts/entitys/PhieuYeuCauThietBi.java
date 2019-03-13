package tpm.qlts.entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the PhieuYeuCauThietBi database table.
 * 
 */
@Entity
@NamedQuery(name="PhieuYeuCauThietBi.findAll", query="SELECT p FROM PhieuYeuCauThietBi p")
public class PhieuYeuCauThietBi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MaPhieu")
	private int maPhieu;

	@Column(name="MucDich")
	private String mucDich;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="NgayLapPhieu")
	private Date ngayLapPhieu;

	//bi-directional many-to-one association to ChiTietYeuCau
	@OneToMany(mappedBy="phieuYeuCauThietBi")
	private List<ChiTietYeuCau> chiTietYeuCaus;

	//bi-directional many-to-one association to NhanVien
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MaNhanVien")
	private NhanVien nhanVien;

	public PhieuYeuCauThietBi() {
	}

	public int getMaPhieu() {
		return this.maPhieu;
	}

	public void setMaPhieu(int maPhieu) {
		this.maPhieu = maPhieu;
	}

	public String getMucDich() {
		return this.mucDich;
	}

	public void setMucDich(String mucDich) {
		this.mucDich = mucDich;
	}

	public Date getNgayLapPhieu() {
		return this.ngayLapPhieu;
	}

	public void setNgayLapPhieu(Date ngayLapPhieu) {
		this.ngayLapPhieu = ngayLapPhieu;
	}

	public List<ChiTietYeuCau> getChiTietYeuCaus() {
		return this.chiTietYeuCaus;
	}

	public void setChiTietYeuCaus(List<ChiTietYeuCau> chiTietYeuCaus) {
		this.chiTietYeuCaus = chiTietYeuCaus;
	}

	public ChiTietYeuCau addChiTietYeuCaus(ChiTietYeuCau chiTietYeuCaus) {
		getChiTietYeuCaus().add(chiTietYeuCaus);
		chiTietYeuCaus.setPhieuYeuCauThietBi(this);

		return chiTietYeuCaus;
	}

	public ChiTietYeuCau removeChiTietYeuCaus(ChiTietYeuCau chiTietYeuCaus) {
		getChiTietYeuCaus().remove(chiTietYeuCaus);
		chiTietYeuCaus.setPhieuYeuCauThietBi(null);

		return chiTietYeuCaus;
	}

	public NhanVien getNhanVien() {
		return this.nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

}