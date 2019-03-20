import React, { Component } from 'react';
import {
    Form, Input, Tooltip, Icon, Cascader, Select, Row, Col, Checkbox, Button, AutoComplete,
} from 'antd';

class CreateUser extends Component {

    render() {
        const { getFieldDecorator } = this.props.form;
        const formItemLayout = {
            labelCol: {
                xs: { span: 12 },
                sm: { span: 4 },
            },
            wrapperCol: {
                xs: { span: 12 },
                sm: { span: 8 },
            },
        };

        return (
            <div>
                <Row type="flex" justify="start">
                    <Col xs={24} sm={24} md={12} lg={6} xl={6} style={{ backgroundColor: '#fafafa' }}>
                        Menu group
                    </Col>
                    <Col xs={24} sm={24} md={12} lg={9} xl={9}>
                        Form
                    </Col>
                    <Col xs={24} sm={24} md={12} lg={9} xl={9}>
                        Permission
                    </Col>
                </Row>
            </div>
        );
    }
}

export default Form.create()(CreateUser);