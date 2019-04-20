import React, { Component } from 'react'
import { connect } from 'react-redux'
import { Row, Col, List, Select, Icon } from 'antd';
import { Link } from 'react-router-dom';
import { getAllNhanVien, getAllPhongBan, getDanhSachThietBi, updateNhanVienRefThietBi, getNhanVienRefPhongBan} from '../../../Services/apiHuu';


const Option = Select.Option;

class ListRotationType extends Component {

    constructor(props) {
        super(props);
        this.state = {
            NhanVien: [],
            PhongBan: [],
            DanhSachTB: [],
            maNhanVien: '',
            maPhongBan: '',
            kieuBanGiao : 0,
            NhanVienPhongbans : []
        }
    }

    getAllNhanVien = async () => {
        var data = await getAllNhanVien();
        this.setState({
            NhanVien: data
        });
    }

    getAllPhongBan = async () => {
        let data = await getAllPhongBan();
        this.setState({
            PhongBan: data
        });
    }

    getDanhSachThietBi = async () => {
        let res = await getDanhSachThietBi();
        this.setState({
            DanhSachTB: res
        });
    }

    componentDidMount() {
        this.getAllNhanVien();
        this.getAllPhongBan();
        this.getDanhSachThietBi();
    }

    convertCodeByName = (id) => {
        if (this.state.DanhSachTB.length > 0) {
            let objDS = this.state.DanhSachTB.find(element => element.maThietBi === id);
            return objDS.tenLoai;
        } else {
            return 'n/a'
        }

    }

    handleChangeDVT = (value) => {
        this.setState({
            maDonViTinh: value
        });
    }

    handleChangeNV = (value) => {
        this.setState({
            maNhanVien: value
        });
    }

    handleChangePB = async (value) => {
        let NhanVienPhongban = await getNhanVienRefPhongBan(value);
        this.setState({
            NhanVienPhongbans : NhanVienPhongban
        });
        this.setState({
            maPhongBan: value
        });
    }

    handleChangeBG = (value) => {
        this.setState({
            kieuBanGiao : value
        })
    }

    disabledSelectDonVi = () => {
        var {kieuBanGiao} = this.state;
        if (kieuBanGiao === 0) {
            return true;
        }else{
            return false;
        }
    }

    disabledSelectCaNhan = () => {
        var {kieuBanGiao, maPhongBan} = this.state;
        if (kieuBanGiao === 1 && maPhongBan) {
            return false;
        }else if(kieuBanGiao === 1){
            return true;
        }
        else{
            return false;
        }
    
    }

    onRotation = async () => {
        var { kieuBanGiao, maNhanVien } = this.state;
        var { thietbis } = this.props;
        var dataSend = {maNhanVien : maNhanVien, kieuBangiao : kieuBanGiao, lstThietBi : [...thietbis]};
        // console.log(dataSend);
        await updateNhanVienRefThietBi(dataSend);
    }

    render() {
        var { PhongBan, NhanVien, maPhongBan, NhanVienPhongbans } = this.state;
        var nhanviens = !maPhongBan ? NhanVien : NhanVienPhongbans;
        var { thietbis } = this.props;
        // console.log(thietbis);
        return (
            <div>
                <Row type="flex" justify="start">
                    <Col xs={12} sm={12} md={12} lg={12} xl={12} style={{ padding: '10px' }}>
                        <div style={{ top: '50%', left: ' 50%', marginRight: '30%', textAlign: 'center' }}>
                            <h3 style={{ fontSize: '25px', borderBottom: '2px solid #4caf50', marginBottom: '50px', padding: ' 13px 0' }}>Danh sách thiết bị luân chuyển</h3>
                        </div>
                        <div style={{ margin: '50px', }}>
                            <List
                                bordered
                                dataSource={thietbis}
                                renderItem={item => (<List.Item>{`${this.convertCodeByName(item)}`}</List.Item>)}
                            />
                        </div>
                        <div className="btn pull-left" style={{ marginTop: '30px' }}>
                            <Link to="/app/rotationtype" className="btn btn-primary"><Icon type="left" />Chọn lại</Link>
                        </div>
                    </Col>
                    <Col xs={12} sm={12} md={12} lg={12} xl={12} style={{ padding: '10px' }}>
                        <div style={{ top: '50%', left: ' 50%', marginRight: '40%', textAlign: 'center' }}>
                            <h3 style={{ fontSize: '25px', borderBottom: '2px solid #4caf50', marginBottom: '50px', padding: ' 13px 0' }}>Hoàn tất luân chuyển</h3>
                        </div>
                        <div style={{ textAlign: 'center' }}>
                            <Select
                                showSearch
                                style={{ width: 300 }}
                                placeholder="Lựa chọn kiểu bàn giao"
                                optionFilterProp="children"
                                onChange={this.handleChangeBG}
                                filterOption={(input, option) => option.props.children.toLowerCase().indexOf(input.toLowerCase()) >= 0}
                            >
                                <Option value={0}>Cá nhân</Option>
                                <Option value={1}>Đơn vị</Option>
                            </Select>
                            <br /><br />
                            <Select
                                showSearch
                                style={{ width: 300 }}
                                placeholder="lựa chọn nhân viên"
                                optionFilterProp="children"
                                disabled={this.disabledSelectCaNhan()}
                                onChange={this.handleChangeNV}
                                filterOption={(input, option) => option.props.children.toLowerCase().indexOf(input.toLowerCase()) >= 0}
                            >
                                {nhanviens.map(element => <Option key={element.maNhanVien} value={element.maNhanVien}>{element.tenNhanVien}</Option>)}
                            </Select>
                            <br /><br />
                            <Select
                                showSearch
                                style={{ width: 300 }}
                                placeholder="lựa chọn phòng ban"
                                optionFilterProp="children"
                                disabled={this.disabledSelectDonVi()}
                                onChange={this.handleChangePB}
                                filterOption={(input, option) => option.props.children.toLowerCase().indexOf(input.toLowerCase()) >= 0}
                            >
                                {PhongBan.map(elemet => <Option key={elemet.maPhongBan} value={elemet.maPhongBan}>{elemet.tenPhongBan}</Option>)}
                            </Select>
                            <br /><br />
                            <div className="btn pull-Button" style={{ marginTop: '30px' }}>
                                <Link to="/app/rotationtype"  className="btn btn-primary" onClick={() => this.onRotation()}>Xác nhận</Link>
                            </div>
                        </div>
                    </Col>
                </Row>
            </div >
        )
    }
}

const mapStateToProps = (state) => {
    return {
        thietbis: state.thietbis,
    }
}
export default connect(mapStateToProps, null)(ListRotationType)
