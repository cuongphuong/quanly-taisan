package tpm.qlts.entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the NhanVien database table.
 * 
 */
@Entity
@NamedQuery(name="NhanVien.findAll", query="SELECT n FROM NhanVien n")
public class NhanVien implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MaNhanVien")
	private String maNhanVien;

	@Column(name="MaTinhTrang")
	private String maTinhTrang;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="NgaySinh")
	private Date ngaySinh;

	@Column(name="QueQuan")
	private String queQuan;

	@Column(name="TenNhanVien")
	private String tenNhanVien;

	//bi-directional many-to-one association to NhanVienRefThietBi
	@OneToMany(mappedBy="nhanVien")
	private List<NhanVienRefThietBi> nvTbs;

	//bi-directional many-to-one association to ChucVu
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MaChucVu")
	private ChucVu chucVu;

	//bi-directional many-to-one association to PhongBan
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MaPhongBan")
	private PhongBan phongBan;

	//bi-directional many-to-one association to PhieuYeuCauThietBi
	@OneToMany(mappedBy="nhanVien")
	private List<PhieuYeuCauThietBi> phieuYeuCauThietBis;

	public NhanVien() {
	}

	public String getMaNhanVien() {
		return this.maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public String getMaTinhTrang() {
		return this.maTinhTrang;
	}

	public void setMaTinhTrang(String maTinhTrang) {
		this.maTinhTrang = maTinhTrang;
	}

	public Date getNgaySinh() {
		return this.ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getQueQuan() {
		return this.queQuan;
	}

	public void setQueQuan(String queQuan) {
		this.queQuan = queQuan;
	}

	public String getTenNhanVien() {
		return this.tenNhanVien;
	}

	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}

	public List<NhanVienRefThietBi> getNvTbs() {
		return this.nvTbs;
	}

	public void setNvTbs(List<NhanVienRefThietBi> nvTbs) {
		this.nvTbs = nvTbs;
	}

	public NhanVienRefThietBi addNvTb(NhanVienRefThietBi nvTb) {
		getNvTbs().add(nvTb);
		nvTb.setNhanVien(this);

		return nvTb;
	}

	public NhanVienRefThietBi removeNvTb(NhanVienRefThietBi nvTb) {
		getNvTbs().remove(nvTb);
		nvTb.setNhanVien(null);

		return nvTb;
	}

	public ChucVu getChucVu() {
		return this.chucVu;
	}

	public void setChucVu(ChucVu chucVu) {
		this.chucVu = chucVu;
	}

	public PhongBan getPhongBan() {
		return this.phongBan;
	}

	public void setPhongBan(PhongBan phongBan) {
		this.phongBan = phongBan;
	}

	public List<PhieuYeuCauThietBi> getPhieuYeuCauThietBis() {
		return this.phieuYeuCauThietBis;
	}

	public void setPhieuYeuCauThietBis(List<PhieuYeuCauThietBi> phieuYeuCauThietBis) {
		this.phieuYeuCauThietBis = phieuYeuCauThietBis;
	}

	public PhieuYeuCauThietBi addPhieuYeuCauThietBi(PhieuYeuCauThietBi phieuYeuCauThietBi) {
		getPhieuYeuCauThietBis().add(phieuYeuCauThietBi);
		phieuYeuCauThietBi.setNhanVien(this);

		return phieuYeuCauThietBi;
	}

	public PhieuYeuCauThietBi removePhieuYeuCauThietBi(PhieuYeuCauThietBi phieuYeuCauThietBi) {
		getPhieuYeuCauThietBis().remove(phieuYeuCauThietBi);
		phieuYeuCauThietBi.setNhanVien(null);

		return phieuYeuCauThietBi;
	}

}