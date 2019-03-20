import React, { Component } from 'react';
import { Layout, Menu, Icon, Row, Col } from 'antd';
import '../../Styles/Header.css';

const { Header } = Layout;
class Nav extends Component {
    state = {
        current: 'mail',
    }

    handleClick = (e) => {
        console.log('click ', e);
        this.setState({
            current: e.key,
        });
    }

    render() {
        return (
            <Header style={{ background: '#fff', padding: 0, height: 'auto', position: 'fixed', width: '100%', zIndex: 9 }}>
                <Row type="flex" justify="start">
                    <Col xs={6} sm={6} md={2} lg={2} xl={1}>
                        <Icon
                            className="trigger"
                            type={this.props.collapsed ? 'menu-unfold' : 'menu-fold'}
                            onClick={this.props.toggle}
                        />
                    </Col>

                    <Col xs={24} sm={18} md={12} lg={8} xl={8}>
                        <Menu
                            onClick={this.handleClick}
                            selectedKeys={[this.state.current]}
                            mode="horizontal"
                            className={'menu_header'}
                        >

                            <Menu.Item key="mail" className="menu_header_item">
                                Nhập
                            </Menu.Item>

                            <Menu.Item key="mot" className="menu_header_item">
                                Quản lý
                            </Menu.Item>

                            <Menu.Item key="hai" className="menu_header_item">
                                Kiểm kê/Báo cáo
                            </Menu.Item>

                        </Menu>
                    </Col>
                    <Col xs={16} sm={8} md={7} lg={6} xl={7}>
                        <Menu
                            mode="horizontal"
                            style={{ lineHeight: '64px' }}
                            onClick={this.menuClick}
                        >
                            <Menu.SubMenu title={<span className="avatar"><img src={this.props.avatar} alt="avatar" /><i className="on bottom b-white" /></span>}>
                                <Menu.ItemGroup title="用户中心">
                                    <Menu.Item key="setting:1">你好 - {this.props.name}</Menu.Item>
                                    <Menu.Item key="setting:2"><Icon type="user" />个人信息</Menu.Item>
                                    <Menu.Item key="logout"><span onClick={this.logout}><Icon type="logout" />退出登录</span></Menu.Item>
                                </Menu.ItemGroup>
                            </Menu.SubMenu>
                        </Menu>
                    </Col>
                </Row>
            </Header>
        );
    }
}

export default Nav;