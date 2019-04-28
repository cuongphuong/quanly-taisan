package tpm.qlts.entitys;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

/**
 * The persistent class for the LoaiTB database table.
 * 
 */
@Entity
@NamedQuery(name = "LoaiTB.findAll", query = "SELECT l FROM LoaiTB l")
public class LoaiTB implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "MaLoai")
	private String maLoai;

	@Column(name = "MaLoaiCha", nullable=true)
	private String maLoaiCha;

	@Column(name = "MoTa")
	private String moTa;

	@Column(name = "TenLoai")
	private String tenLoai;

	// bi-directional many-to-one association to NhaCungCap
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MaNCC")
	private NhaCungCap nhaCungCap;

	// bi-directional many-to-one association to ThietBi
	@JsonIgnore
	@OneToMany(mappedBy = "loaiTb")
	private List<ThietBi> thietBis;

	public LoaiTB() {
	}

	public String getMaLoai() {
		return this.maLoai;
	}

	public void setMaLoai(String maLoai) {
		this.maLoai = maLoai;
	}

	public String getMaLoaiCha() {
		return this.maLoaiCha;
	}

	public LoaiTB(String maLoai, String maLoaiCha, String moTa, String tenLoai) {
		super();
		this.maLoai = maLoai;
		this.maLoaiCha = maLoaiCha;
		this.moTa = moTa;
		this.tenLoai = tenLoai;
	}

	public void setMaLoaiCha(String maLoaiCha) {
		this.maLoaiCha = maLoaiCha;
	}

	public String getMoTa() {
		return this.moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public String getTenLoai() {
		return this.tenLoai;
	}

	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}

	public NhaCungCap getNhaCungCap() {
		return this.nhaCungCap;
	}

	public void setNhaCungCap(NhaCungCap nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
	}

	public List<ThietBi> getThietBis() {
		return this.thietBis;
	}

	public void setThietBis(List<ThietBi> thietBis) {
		this.thietBis = thietBis;
	}

	public ThietBi addThietBi(ThietBi thietBi) {
		getThietBis().add(thietBi);
		thietBi.setLoaiTb(this);

		return thietBi;
	}

	public ThietBi removeThietBi(ThietBi thietBi) {
		getThietBis().remove(thietBi);
		thietBi.setLoaiTb(null);

		return thietBi;
	}

}