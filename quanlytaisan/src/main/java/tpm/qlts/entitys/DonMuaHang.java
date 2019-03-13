package tpm.qlts.entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the DonMuaHang database table.
 * 
 */
@Entity
@NamedQuery(name="DonMuaHang.findAll", query="SELECT d FROM DonMuaHang d")
public class DonMuaHang implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MaHoaDon")
	private int maHoaDon;

	@Column(name="DiaDiemGiao")
	private String diaDiemGiao;

	@Column(name="NgayLapHoaDon")
	private String ngayLapHoaDon;

	@Column(name="NhaCungCap")
	private String nhaCungCap;

	@Column(name="ThoiGianGiao")
	private Timestamp thoiGianGiao;

	@Column(name="TongTien")
	private double tongTien;

	//bi-directional many-to-one association to ChiTiet
	@OneToMany(mappedBy="donMuaHang")
	private List<ChiTiet> chiTiets;

	public DonMuaHang() {
	}

	public int getMaHoaDon() {
		return this.maHoaDon;
	}

	public void setMaHoaDon(int maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	public String getDiaDiemGiao() {
		return this.diaDiemGiao;
	}

	public void setDiaDiemGiao(String diaDiemGiao) {
		this.diaDiemGiao = diaDiemGiao;
	}

	public String getNgayLapHoaDon() {
		return this.ngayLapHoaDon;
	}

	public void setNgayLapHoaDon(String ngayLapHoaDon) {
		this.ngayLapHoaDon = ngayLapHoaDon;
	}

	public String getNhaCungCap() {
		return this.nhaCungCap;
	}

	public void setNhaCungCap(String nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
	}

	public Timestamp getThoiGianGiao() {
		return this.thoiGianGiao;
	}

	public void setThoiGianGiao(Timestamp thoiGianGiao) {
		this.thoiGianGiao = thoiGianGiao;
	}

	public double getTongTien() {
		return this.tongTien;
	}

	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}

	public List<ChiTiet> getChiTiets() {
		return this.chiTiets;
	}

	public void setChiTiets(List<ChiTiet> chiTiets) {
		this.chiTiets = chiTiets;
	}

	public ChiTiet addChiTiet(ChiTiet chiTiet) {
		getChiTiets().add(chiTiet);
		chiTiet.setDonMuaHang(this);

		return chiTiet;
	}

	public ChiTiet removeChiTiet(ChiTiet chiTiet) {
		getChiTiets().remove(chiTiet);
		chiTiet.setDonMuaHang(null);

		return chiTiet;
	}

}