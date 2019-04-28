import React, { Component } from "react";
import { Row, Col, Input, Select, Button, List } from "antd";
import List2 from "./List";
import {
  getAllloaitb,
  gettenloai,
  getbyIdNCC
} from "../../../Services/apimanh";
import { getAllNhacungcap } from "../../../Services/apimanh1";
import DualListBox from "react-dual-listbox";
import "react-dual-listbox/lib/react-dual-listbox.css";
import { element } from "prop-types";
import history from "../../../Utils/history";
import { connect } from "react-redux";
import { FetAllThietBi } from "./../../../Reducers/action/index";

const Option = Select.Option;

class Bangiao extends Component {
  constructor(props) {
    super(props);
    this.state = {
      nhaCungCap: [],
      loaiTBs: [],
      tenLoais: [],
      mancc: "",
      maloai: "",
      selected: [],
      options: [],
      lst1: [],
      lst2: []
    };
  }
  callapi = async () => {
    let loaiTBs = await getAllloaitb();
    let nhaCungCap = await getAllNhacungcap();
    this.setState({
      nhaCungCap: nhaCungCap,
      loaiTBs: loaiTBs
    });
  };

  componentDidMount() {
    this.callapi();
  }

  handleselectchangeLoai = async value => {
    this.setState({
      maloai: value
    });
    let tenLoais = await gettenloai(this.state.mancc, value);
    this.setState({
      options: tenLoais
    });
    console.log(tenLoais);
  };

  handleselectchanngeNCC = async (value) => {
    let res = await getbyIdNCC(value);
    this.setState({
      lst1: res,
      mancc: value
    });
  };

  onHandleClickSubmit = () => {
    var r = window.confirm("bạn có muốn chuyển trang");
    if (r === true) {
      history.push("/app/htbangiao");
    }
  };

  //n tạo 1 cái component mới để list, ko dùng cái DualListBox nữa

  //thay đổi dữ liệu khi nhấn chọn
  changeDataInList = key => {
    var { lst1, lst2 } = this.state;
    var index = 0;

    for (var element of lst1) {
      var objectCanTim = element.lstThietBi.find(e => {
        return e.maTB.toString() === key.toString();
      });

      if (objectCanTim) {
        var tenLoaiTB = element.tenLoaiThietBi;
        var maLoaiTB = element.maLoaiTB;
        var objectLoaiTim = lst2.find(
          element2 =>
            element2.tenLoaiThietBi.toString() === tenLoaiTB.toString()
        );

        if (!objectLoaiTim) {
          lst2 = [
            ...lst2,
            { tenLoaiThietBi: tenLoaiTB, maLoaiTB: maLoaiTB, lstThietBi: [objectCanTim] }
          ];
        } else {
          lst2 = lst2.filter(element => {
            return element.tenLoaiThietBi !== objectLoaiTim.tenLoaiThietBi;
          });
          objectLoaiTim = {
            ...objectLoaiTim,
            lstThietBi: [...objectLoaiTim.lstThietBi, objectCanTim]
          };
          lst2 = [...lst2, objectLoaiTim];
        }

        var lstTBNew = element.lstThietBi.filter(element => {
          return element.maTB !== objectCanTim.maTB;
        });

        lst1[index].lstThietBi = lstTBNew;

        this.setState({ lst1: lst1, lst2: lst2 });
        break;
      }
      index++;
    }
  };

  render() {
    const { nhaCungCap, loaiTBs, lst1 } = this.state;
    return (
      <div>
        <Row>
          <Col
            xs={12}
            sm={12}
            md={12}
            lg={12}
            xl={12}
          >
            <div style={{ marginRight: '5px' }}>
              <div style={{ marginBottom: '10px', height: '30px' }}>
                <Select
                  defaultValue="Nhà cung cấp"
                  style={{ width: '50%' }}
                  onChange={this.handleselectchanngeNCC}
                >
                  {nhaCungCap.map(element => (
                    <Option key={element.maNCC} value={element.maNCC}>
                      {element.tenNCC}
                    </Option>
                  ))}
                </Select>

                <Select
                  defaultValue="Loại Thiết bị"
                  style={{ width: '50%' }}
                  onChange={this.handleselectchangeLoai}
                >
                  {loaiTBs.map(element => (
                    <Option key={element.maLoai} value={element.maLoai}>
                      {element.tenLoai}
                    </Option>
                  ))}
                </Select>
              </div>
              <List2 handleClickSelect={this.changeDataInList} lableClick="Chọn" data={lst1} />
            </div>
            <div />
          </Col>
          <Col
            xs={12}
            sm={12}
            md={12}
            lg={12}
            xl={12}
          >
            <div style={{ height: '30px', marginBottom: '10px' }}>
              <h3 style={{ textAlign: 'center' }}>DANH SÁCH CHỌN</h3>
            </div>
            <List2 handleClickSelect={this.changeDataInList} lableClick="Bỏ chọn" data={this.state.lst2} />
          </Col>
        </Row>
        <div style={{ margin: "40px" }}>
          {/* <DualListBox
            canFilter
            filterCallback={(option, filterInput) => {
              if (filterInput === "") {
                return true;
              }

              return new RegExp(filterInput, "i").test(option.label);
            }}
            filterPlaceholder="Filter..."
            options={options}
            selected={this.state.selected}
            onChange={selected => {
              this.setState({ selected });
              this.props.fetThietBiLoai(selected)
            }}
          /> */}

        </div>

        <Button
          onClick={this.onHandleClickSubmit}
          type="primary"
          style={{ marginLeft: "80%" }}
        >
          Hoàn tất chọn
        </Button>
      </div>
    );
  }
}

const mapDispatchToProps = (dispatch, props) => {
  return {
    fetThietBiLoai: thietbi => {
      dispatch(FetAllThietBi(thietbi));
    }
  };
};
export default connect(
  null,
  mapDispatchToProps
)(Bangiao);
