import React, { Component } from 'react';
import { Row, Col, Select, Button, Icon } from 'antd';
import DualListBox from 'react-dual-listbox';
import 'react-dual-listbox/lib/react-dual-listbox.css';
import { getAllPhongBan, getAllLoaiThietBi, getAllLoaiTbPhongBan, getThietBiTheoLoai } from '../../../Services/apiHuu';
import { actFetchPhongBans, actFetchThietBi } from './../../../Reducers/actions/index';
import { connect } from 'react-redux';
import { Link } from 'react-router-dom';


const Option = Select.Option;
class RotationType extends Component {

    constructor(props) {
        super(props);
        this.state = {
            loaiThietBis: [],
            phongbanloai: [],
            maphongban: '',
            loaiTBById: [],
            optionsphongBan: [],
            keyPhongBan: '',
            keyLoai: '',
            optionLoai: [],
            loading: false,
            selected: []
        }
    }

    getAllPhongBan = async () => {
        let data = await getAllPhongBan();
        this.props.fetchAllPhongBans(data);
    }

    getAllLoaiThietBi = async () => {
        let data = await getAllLoaiThietBi();
        this.setState({
            loaiThietBis: data
        });
    }


    componentDidMount() {
        this.getAllPhongBan();
        this.getAllLoaiThietBi();
    }

    handleChange = async (value) => {
        if (value) {
            this.setState({
                keyPhongBan: value
            });
            let res = await getAllLoaiTbPhongBan(value);
            this.setState({
                optionsphongBan: res
            });
            // console.log(res);
        }
    }

    handleChangetwo = async (value) => {
        if (value) {
            var { keyPhongBan } = this.state;
            this.setState({
                keyLoai: value
            })
            let res = await getThietBiTheoLoai(keyPhongBan, value);
            this.setState({
                optionLoai: res
            });
            // console.log(res)
        }
    }

    onChange = (selected) => {
        // console.log(selected)
        this.setState({ selected });
        this.props.fetAllThietBi(selected);
        // console.log(selected)
    }
    enterLoading = () => {
        this.setState({
            loading: true,
            keyPhongBan: '',
            keyLoai: '',
            optionsphongBan: [],
            optionLoai: []
        });
        let test = this;
        setTimeout(function () {
            test.setState({
                loading: false
            })
        }, 1000);
    }
    disabledSelect = () => {
        if (this.state.selected.length > 0) {
            return true;
        }else{
            return false;
        }
    }

    render() {
        var { loaiThietBis, optionsphongBan, optionLoai, keyLoai, keyPhongBan} = this.state;
        var options = keyPhongBan && keyLoai ? optionLoai : optionsphongBan;
        var phongBans = this.props.phongban;
        return (
            <div>
                <Row type="flex" justify="start">
                    <Col xs={12} sm={12} md={12} lg={12} xl={12} style={{ padding: '10px' }}>
                        <div style={{ textAlign: 'center' }}>
                            <Select
                                showSearch
                                style={{ width: 200, marginRight: 10 }}
                                placeholder="Phòng Ban"
                                disabled={this.disabledSelect()}
                                optionFilterProp="children"
                                onChange={this.handleChange}
                                filterOption={(input, option) => option.props.children.toLowerCase().indexOf(input.toLowerCase()) >= 0}
                            >
                                {phongBans.map(element => <Option key={element.maPhongBan} value={element.maPhongBan}>{element.tenPhongBan}</Option>)}

                            </Select>
                            <Select
                                showSearch
                                style={{ width: 200 }}
                                placeholder="Loại thiết bị"
                                optionFilterProp="children"
                                onChange={this.handleChangetwo}
                                filterOption={(input, option) => option.props.children.toLowerCase().indexOf(input.toLowerCase()) >= 0}
                            >
                                {loaiThietBis.map(element => <Option key={element.maLoai} value={element.maLoai}>{element.tenLoai}</Option>)}
                            </Select>
                            <br />
                            {/* <Search
                                style={{ width: 300, marginTop: 10 }}
                                placeholder="input search text"
                                onSearch={value => console.log(value)}
                            /> */}
                            <Button
                                type="primary"
                                loading={this.state.loading}
                                onClick={this.enterLoading}
                                style={{ width: 300, marginTop: 10 }}
                            >
                                Chọn lại
                            </Button>
                        </div>
                        <br /><br />
                    </Col>
                    <Col xs={12} sm={12} md={12} lg={12} xl={12} style={{ padding: '10px', marginTop: '20px' }}>

                    </Col>

                </Row>
                <div style={{ marginTop: '50px' }}>
                    <DualListBox
                        canFilter
                        filterCallback={(options, filterInput) => {
                            if (filterInput === '') {
                                return true;
                            }

                            return (new RegExp(filterInput, 'i')).test(options.label);
                        }}
                        filterPlaceholder="Filter..."
                        alignActions="top"
                        options={options}
                        selected={this.state.selected}
                        onChange={this.onChange}
                        icons={{
                            moveLeft: <span className="fa fa-chevron-left" />,
                            moveAllLeft: [
                                <span key={0} className="fa fa-chevron-left" />,
                                <span key={1} className="fa fa-chevron-left" />,
                            ],
                            moveRight: <span className="fa fa-chevron-right" />,
                            moveAllRight: [
                                <span key={0} className="fa fa-chevron-right" />,
                                <span key={1} className="fa fa-chevron-right" />,
                            ],
                            moveDown: <span className="fa fa-chevron-down" />,
                            moveUp: <span className="fa fa-chevron-up" />,
                        }}
                    />
                </div>
                <div className="btn pull-right" style={{marginRight : '30px', marginTop : '30px'}}>
                    <Link to="/app/listrotationtype"  className="btn btn-primary" style ={{width : 150}}>Hoàn tất chọn<Icon type="right" /></Link>
                </div>
            </div>
        );
    }
}

const mapStateToProps = state => {
    return {
        phongban: state.phongban
    }
}

const mapDispatchToProps = (dispatch, props) => {
    return {
        fetchAllPhongBans: (phongban) => {
            dispatch(actFetchPhongBans(phongban));
        },
        fetAllThietBi: (thietbis) => {
            dispatch(actFetchThietBi(thietbis))
        }
    }
}

export default connect(mapStateToProps, mapDispatchToProps)(RotationType);

