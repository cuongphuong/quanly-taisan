import React, { Component } from "react";
import { Badge } from "antd";
import "./list.css";

class List extends Component {
    render() {
        return (
            <div>
                {
                    this.props.data.length > 0 ?
                        this.props.data.map(element => {
                            return (
                                <div key={element.maLoaiTB}>
                                    <button className="collapsible">{`[${element.maLoaiTB}] ${element.tenLoaiThietBi}`}</button>
                                    <div className="content">
                                        {
                                            element.lstThietBi.map(element1 => {
                                                return (
                                                    <div key={element1.maTB} className="sub-item">
                                                        <h3>
                                                            <Badge
                                                                count={`Mã: ${element1.maTB}`}
                                                                style={{ backgroundColor: "#52c41a" }}
                                                            />
                                                            <Badge
                                                                count={`${element1.tenThietBi}`}
                                                                style={{
                                                                    backgroundColor: "#f1f1f1",
                                                                    color: "rgb(0, 160, 209)",
                                                                    fontWeight: "bold",
                                                                    fontSize: "15px"
                                                                }}
                                                            />
                                                        </h3>
                                                        <span>Tinh trang thiet bi</span>
                                                        <br />
                                                        <span className="mota">Mo ta thiet bi</span>
                                                        <span onClick={() => this.props.handleClickSelect(element1.maTB)} className="selected-item">>> {this.props.lableClick}</span>
                                                    </div>
                                                )
                                            })
                                        }
                                    </div>
                                </div>
                            )
                        })
                        :
                        'Có cái loz nè chọn không'
                }
            </div>
        );
    }
}

export default List;
