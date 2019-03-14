package tpm.qlts.entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the NV_TB database table.
 * 
 */
@Entity
@Table(name="NV_TB")
@NamedQuery(name="NhanVienRefThietBi.findAll", query="SELECT n FROM NhanVienRefThietBi n")
public class NhanVienRefThietBi implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private NhanVienRefThietBiPK id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DenNgay")
	private Date denNgay;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="TuNgay")
	private Date tuNgay;

	//bi-directional many-to-one association to NhanVien
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MaNhanVien", updatable = false, insertable = false)
	private NhanVien nhanVien;

	//bi-directional many-to-one association to ThietBi
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MaThietBi", updatable = false, insertable = false)
	private ThietBi thietBi;

	public NhanVienRefThietBi() {
	}

	public NhanVienRefThietBiPK getId() {
		return this.id;
	}

	public void setId(NhanVienRefThietBiPK id) {
		this.id = id;
	}

	public Date getDenNgay() {
		return this.denNgay;
	}

	public void setDenNgay(Date denNgay) {
		this.denNgay = denNgay;
	}

	public Date getTuNgay() {
		return this.tuNgay;
	}

	public void setTuNgay(Date tuNgay) {
		this.tuNgay = tuNgay;
	}

	public NhanVien getNhanVien() {
		return this.nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public ThietBi getThietBi() {
		return this.thietBi;
	}

	public void setThietBi(ThietBi thietBi) {
		this.thietBi = thietBi;
	}

}