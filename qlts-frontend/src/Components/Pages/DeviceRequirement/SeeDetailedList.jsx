import React, { Component } from 'react';
import { Row, Col, List, Avatar} from 'antd';
import { getAllPhieuYeucau, getAllByIdPhieuYeucau, getAllDonViTinh } from '../../../Services/apiHuu';


class SeeDetailedList extends Component {
    constructor(props) {
        super(props);
        this.state = {
            data: [],
            dataList: [],
            DonViTinh : []
        }
    }
    getAllPhieuYeucau = async () => {
        let data = await getAllPhieuYeucau();
        this.setState({
            data: data
        });
    }

    getAllDonViTinh = async () => {
        let data= await getAllDonViTinh();
        this.setState({
            DonViTinh : data
        });
    }

    componentDidMount() {
        this.getAllPhieuYeucau();
        this.getAllDonViTinh();
    }

    onShowTable = async (dataId) => {
        let data = await getAllByIdPhieuYeucau(dataId);
        this.setState({
            dataList: data
        });
        // console.log(data);
    }
    convertCodeByName = (id) => {
        if (this.state.DonViTinh.length > 0) {
            let GetTenDonVi = this.state.DonViTinh.find(element => element.maDonViTinh === id);
            return GetTenDonVi.tenDonViTinh;
        }else{
            return '';
        }
    }

    render() {
        var { data, dataList } = this.state;
        var listTable = dataList.map((data, index) => {
            return (
                <tr key= {index}>
                    <td>{data.maCT}</td>
                    <td>{this.convertCodeByName(data.donViTInh)}</td>
                    <td>{data.quyCach_DatTinh}</td>
                    <td>{data.soLuong}</td>
                    <td>
                        {data.tenThietBi}
                    </td>
                </tr>
            )
        });
        return (
            <div>
                <Row>
                    <Col xs={8} sm={8} md={8} lg={8} xl={8} style={{ padding: '10px' }}>
                        <List
                            itemLayout="horizontal"
                            dataSource={data}
                            renderItem={(item, index) => (
                                <List.Item>
                                    <List.Item.Meta
                                        key={index}
                                        avatar={<Avatar>{index + 1}</Avatar>}
                                        title={<span onClick={() => this.onShowTable(item.maPhieu)} style={{ cursor: 'pointer' }}>Phiếu {item.maPhieu}</span>}
                                        description={item.mucDich}
                                    />
                                </List.Item>
                            )}
                        />
                    </Col>
                    <Col xs={16} sm={16} md={16} lg={16} xl={16} style={{ padding: '10px', marginTop: '20px'}}>
                        <table className="table table-bordered table-hover">
                            <thead>
                                <tr>
                                    <th>Mã chi tiêt</th>
                                    <th>Đơn vị tính</th>
                                    <th>Quy cách đặt tính</th>
                                    <th>Số lượng</th>
                                    <th>Tên thiết bị</th>
                                </tr>
                            </thead>
                            <tbody style = {{textAlign : 'center'}}>
                               {listTable}
                            </tbody>
                        </table>
                    </Col>
                </Row>
            </div>
        );
    }
}

export default SeeDetailedList;