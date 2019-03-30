import React, { Component } from 'react';
import { Layout, Menu, Icon, Row, Col } from 'antd';
import '../../Styles/Header.css';
import { getToken, removeToken } from '../../Utils/token'
import history from '../../Utils/history';
import { message } from 'antd';

const { Header } = Layout;
class Nav extends Component {
    state = {
        current: 'mail',
    }

    handleClick = (e) => {
        // console.log('click ', e);
        this.setState({
            current: e.key,
        });
    }

    logout = () => {
        // const { history } = this.props;
        if (getToken() !== null) {
            removeToken();
            message.success("Đăng xuất thành công.");
            setTimeout(() => {
                history.push('/login');
            }, 1500);

        }
    }

    getDataMenu() {

    }

    renderMenu() {
        return this.props.lstMenu.map(item => {
            return (
                <Menu.Item key={btoa(item.moduleID)} className="menu_header_item">
                    {item.modulName}
                </Menu.Item>
            )
        })
    }

    render() {
        return (
            <Header style={{ background: '#fff', padding: 0, height: 'auto', position: 'fixed', width: '100%', zIndex: 9 }}>

                <Row type="flex" justify="start">
                    <Col md={1}>
                        <Icon
                            className="trigger"
                            type={this.props.collapsed ? 'menu-unfold' : 'menu-fold'}
                            onClick={this.props.toggle}
                        />
                    </Col>

                    <Col md={12}>
                        <Menu
                            onClick={this.props.handleMenuClick}
                            selectedKeys={[this.props.currenKey]}
                            mode="horizontal"
                            className={'menu_header'}
                        >
                            {this.renderMenu()}

                        </Menu>
                    </Col>
                    <Col md={11}>
                        <Menu
                            mode="horizontal"
                            style={{ lineHeight: '64px' }}
                            onClick={this.menuClick}
                        >
                            <Menu.SubMenu style={{}} title={<span className="avatar"><img src={this.props.avatar} alt="avatar" /><i className="on bottom b-white" /></span>}>
                                <Menu.ItemGroup title="Cá nhân">
                                    <Menu.Item key="logout"><span onClick={this.logout}><Icon type="logout" />Logout</span></Menu.Item>
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