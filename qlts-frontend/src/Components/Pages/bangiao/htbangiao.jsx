import React, { Component } from "react";
import { Row, Col, Input, Select, Button, Avatar, List } from "antd";
import { getallphongban, getallnhanvien } from "../../../Services/apimanh1";
import { element } from "prop-types";
import { connect } from "react-redux";

const Option = Select.Option;
function handleChange1(value) {
  console.log(`selected ${value}`);
}


class bangiao1 extends Component {
  constructor(props) {
    super(props);
    this.state = {
      phongBan: [],
      nhanVien: []
    };
  }
  callapi = async () => {
    let phongBan = await getallphongban();
    let nhanVien = await getallnhanvien();
    this.setState({
      phongBan: phongBan,
      nhanVien: nhanVien
    });
    console.log(phongBan);
    console.log(nhanVien);
  };
  componentDidMount() {
    this.callapi();
  }

  handleChangepb = async value => {
    let vaR = await getallphongban(value);

    this.setState({
      phongBan: vaR
    });
    console.log(value);
  };

  handleChangenv = async nv => {
    let VaR = await getallnhanvien(nv);
    this.setState({
      nhanVien: VaR
    });
    console.log(nv);
  };

  onHandleClickSubmit1 = () => {
    var b = window.confirm("Bạn có muốn hoàn tất");
    if (b == true) {
    }
  };

  render() {
    const { thietbiLoai } = this.props;
    console.log(thietbiLoai);
    const { phongBan, nhanVien } = this.state;
    return (
      <div>
        <Row>
          <Col
            xs={12}
            sm={12}
            md={12}
            lg={12}
            xl={12}
            style={{ textAlign: "center", fontSize: "150%" }}
          >
            <div>
              DANH SÁCH THIẾT BỊ BÀN GIAO
              <div
                style={{
                  marginLeft: "90px",
                  marginRight: "90px",
                  marginTop: "10px",
                  textAlign: "center",
                  borderBottom: "1.5px solid #110a0a"
                }}
              />
              <div style={{ marginTop: "50px", marginRight: "40px" }}>
                <List
                  bordered
                  dataSource={thietbiLoai}
                  renderItem={item => (
                    <List.Item>
                      {item}
                    </List.Item>
                  )}
                />
              </div>
            </div>
          </Col>

          <Col
            xs={12}
            sm={12}
            md={12}
            lg={12}
            xl={12}
            style={{ textAlign: "center", fontSize: "150%" }}
          >
            <div>
              THÔNG TIN BÀN GIAO
              <div
                style={{
                  marginLeft: "90px",
                  marginRight: "90px",
                  marginTop: "10px",
                  textAlign: "center",
                  borderBottom: "1.5px solid #110a0a"
                }}
              />
              <div style={{ marginTop: "30px", marginRight: "40px" }}>
                <label
                  style={{
                    padding: "10px",
                    fontSize: "80%",
                    fontWeight: "10 bold"
                  }}
                >
                  Kiểu bàn giao
                </label>
                <br />
                <Select
                  defaultValue="Chọn kiểu bàn giao"
                  style={{ width: 300 }}
                  onChange={handleChange1}
                >
                  <Option value={0}>Cá nhân</Option>
                  <Option value={1}>Đơn vị</Option> 
                </Select>
              </div>
              <div style={{ marginTop: "30px", marginRight: "40px" }}>
                <label
                  style={{
                    padding: "10px",
                    fontSize: "80%",
                    fontWeight: "10 bold"
                  }}
                >
                  Đơn vị nhận bàn giao
                </label>
                <br />
                <Select
                  defaultValue="Chọn phòng ban"
                  style={{ width: 300 }}
                  onChange={this.handleChangepb}
                >
                  {phongBan.map(element => (
                    <Option key={element.maPhongBan} value={element.maPhongBan}>
                      {element.tenPhongBan}
                    </Option>
                  ))}
                </Select>
              </div>
              <div style={{ marginTop: "30px", marginRight: "40px" }}>
                <label
                  style={{
                    padding: "10px",
                    fontSize: "80%",
                    fontWeight: "10 bold"
                  }}
                >
                  Người nhận bàn giao
                </label>
                <br />
                <Select
                  defaultValue="Chọn Nhân viên"
                  style={{ width: 300 }}
                  onChange={this.handleChangenv}
                >
                  {nhanVien.map(element => (
                    <Option key={element.maNhanVien} value={element.maNhanVien}>
                      {element.tenNhanVien}
                    </Option>
                  ))}
                </Select>
              </div>
              <Button
                onClick={this.onHandleClickSubmit1}
                type="primary"
                style={{ marginLeft: "30%", marginTop: "50px" }}
              >
                Hoàn tất bàn giao
              </Button>
            </div>
          </Col>
        </Row>
      </div>
    );
  }
}

const mapStateToProps = state => {
  return {
    thietbiLoai: state.thietbiLoai
  };
};

export default connect(
  mapStateToProps,
  null
)(bangiao1);
