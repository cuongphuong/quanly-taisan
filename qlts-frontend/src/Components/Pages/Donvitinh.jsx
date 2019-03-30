import React, { Component } from 'react';
import { Modal, Button, Table, Divider, Form, Input} from 'antd';
import { getALLDonvitinh, addNewDonvitinh, updateDonvitinh, deleteDonvitinh } from '../../Services/apimanh';

class Donvitinh extends Component{
    state = {
        visible: false,
        selectedRowKeys: [], // Check here to configure the default column
        loading: false,
        data: [],
        columns:[{
            title: 'Mã ĐVT',
            dataIndex: 'maDonViTinh',
            width: 170,
        },{
            title:'Tên ĐVT',
            dataIndex:'tenDonViTinh',
            width: 370,
        },{
            title:'Mô tả',
            dataIndex: 'moTa',
            width: 380,
        },{
            title: 'Điều khiển',
            fixed: 'right',
            width: 150,
            render: (text, record) => {
                return <div>
                    <span className="span-link"
                        onClick={() => this.editFunction(record)}
                    >Chỉnh sửa</span>

                    <Divider type="vertical" />

                    <span className="span-link"
                        onClick={() => this.deleteFunction(record)}> Xóa</span>
                </div>
            }
        }],
    isUpdate: false,
    dataForm: {
        tenDonViTinh:'',
        moTa:'',
    }
    }
    showModal = () => {
        this.setState({
            visible: true,
        });
    }
    handleCancel = (e) => {
        this.props.form.resetFields();
        this.setState({
            visible: false,
            isUpdate: false,
            dataForm: {
                maDonViTinh : '',
                tenDonViTinh: '',
                moTa:'',
            }
        }); 
    }
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

    editFunction = (record) => {
        this.setState({
            dataForm: record,
            visible: true,
            isUpdate: true
        });
    }

    getALLDonvitinh = async () => {
        let data = await getALLDonvitinh();
        this.setState({
            data: data
        });
        console.log(data);
    }
    componentDidMount()
    {
        this.getALLDonvitinh();
    }

    handlSubmit = (e) => {
        e.preventDefault();
        this.props.form.validateFields(async (err, values) =>{
            if(!err){
                if(this.state.isUpdate === false){
                    let res = await addNewDonvitinh(values);
                    if(res){
                        this.setState({
                            data: [res, ... this.state.data]
                        });
                        this.handleCancel();
                    }
                    
                }else{
                    let res = await updateDonvitinh(values);
                    var item = this.state.data.find(function(element){
                        return element.maDonViTinh === values.maDonViTinh;
                    });

                    item.maDonViTinh = res.maDonViTinh;
                    item.tenDonViTinh = res.tenDonViTinh;
                    item.moTa = res.moTa;
                    this.handleCancel();
                }
            }
        })
    }
    deleteFunction = async(record) =>{
        if(window.confirm("Xóa" + record.maDonViTinh)){
            await deleteDonvitinh(record.maDonViTinh);
            this.setState({
                data: this.setState.data.filter(e => e.maDonViTinh !== record.maDonViTinh)
            });
        }
    }
    onDeleteAllRecord = async() =>{
        if(window.confirm("Xóa mục đã chọn")){
            await deleteDonvitinh(this.state.selectedRowKeys);
            this.getALLDonvitinh();
            this.setState(
                {
                    selectedRowKeys: []
                }
            )
        }
    }
    render(){
        const {loading, selectedRowKeys} = this.state;
        const rowSelection = {
            selectedRowKeys,
            onchange: this.onSelectChange,
        };
        const hasSelected = selectedRowKeys.length > 0;

        const{ getFieldDecorator } = this.props.form;
        const formItemLayout = {
            labelCol: {
                xs: { span: 24 },
                sm: { span: 7 },
            },
            wrapperCol: {
                xs: { span: 24 },
                sm: { span: 16 },
            },
        };
        return(
            <div>
                <Button
                    type="primary"
                    icon="plus-square-o" onClick={this.showModal}>Thêm ĐVT</Button>
                <Button
                    style={{ marginLeft: '5px' }}
                    type="danger"
                    onClick={this.onDeleteAllRecord}
                    disabled={!hasSelected}
                    loading={loading}
                >Xóa mục chọn</Button>
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
                <Table rowKey='maDonViTinh' style={{ marginTop: '10px' }} rowSelection={rowSelection} columns={this.state.columns} dataSource={this.state.data} />
                <Modal
                    onCancel={this.handleCancel}
                    title={this.state.isUpdate === false ? "Thêm Chức ĐVT" : "Cập nhật ĐVT"}
                    visible={this.state.visible}
                    footer={[
                        <Button form="addĐVTForm" key="submit" type="primary" htmlType="submit">
                            Submit </Button>,
                        <Button key="cancel" onClick={this.handleCancel}>
                            Đóng </Button>

                    ]}
                    >
                    <Form id ="addĐVTForm" onSubmit ={this.handlSubmit}>
                        <Form.Item
                            {...formItemLayout}
                            hasFeedback
                            label="Tên ĐVT"
                        >
                            {getFieldDecorator('tenDonViTinh', {
                                initialValue: this.state.dataForm.tenDonViTinh,
                                rules: [{
                                    required: true, message: 'Yêu cầu nhập tên ĐVT!',
                                }],
                            })(
                                <Input />
                            )}
                        </Form.Item> 
                        <Form.Item
                            {...formItemLayout}
                            hasFeedback
                            label="Mô tả"
                        >
                            {getFieldDecorator('moTa', {
                                initialValue: this.state.dataForm.moTa,
                                rules: [],
                            })(
                                <Input />
                            )}
                        </Form.Item>   
                    </Form>
                </Modal>

      
            </div>
        )
    }

}
export default Form.create()(Donvitinh);