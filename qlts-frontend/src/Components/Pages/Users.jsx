import React, { Component } from 'react';
import { Modal, Button, Table } from 'antd';
import { getAllUser } from "../../Services/api";


class Users extends Component {
    state = {
        visible: false,
        selectedRowKeys: [], // Check here to configure the default column
        loading: false,
        data: [],
        columns: [{
            title: 'ID',
            dataIndex: 'userID',
            sorter: true
        }, {
            title: 'Họ tên',
            dataIndex: 'fullName',
        }, {
            title: 'Tên đăng nhập',
            dataIndex: 'username',
        }, {
            title: 'Mật khẩu',
            dataIndex: 'password'
        }]
    }

    showModal = () => {
        this.setState({
            visible: true,
        });
    }

    handleOk = (e) => {
        console.log(e);
        this.setState({
            visible: false,
        });
    }

    handleCancel = (e) => {
        console.log(e);
        this.setState({
            visible: false,
        });
    }

    // on table

    start = () => {
        this.setState({ loading: true });
        // ajax request after empty completing
        setTimeout(() => {
            this.setState({
                selectedRowKeys: [],
                loading: false,
            });
        }, 1000);
    }

    onSelectChange = (selectedRowKeys) => {
        this.setState({ selectedRowKeys });
    }

    // send request to get data

    getAllUser = async () => {
        let data = await getAllUser();
        this.setState({
            data: data
        })
    }

    // function in life cycle
    componentDidMount() {
        this.getAllUser();
    }
    render() {
        const { loading, selectedRowKeys } = this.state;
        const rowSelection = {
            selectedRowKeys,
            onChange: this.onSelectChange,
        };
        const hasSelected = selectedRowKeys.length > 0;
        return (
            <div>
                <Button
                    type="primary"
                    icon="plus-square-o" onClick={this.showModal}>Thêm user</Button>
                <Button
                    style={{ marginLeft: '5px' }}
                    type="dashed"
                    onClick={this.start}
                    disabled={!hasSelected}
                    loading={loading}
                >Bỏ chọn tất cả</Button>
                <span style={{ marginLeft: 8 }}>
                    {hasSelected ? `Selected ${selectedRowKeys.length} items` : ''}
                </span>
                <Table style={{ marginTop: '10px' }} rowSelection={rowSelection} columns={this.state.columns} dataSource={this.state.data} />
                <Modal
                    title="Tạo tài khoản mới"
                    visible={this.state.visible}
                    onOk={this.handleOk}
                    onCancel={this.handleCancel}
                >
                    
                </Modal>
            </div>
        );
    }
}

export default Users;