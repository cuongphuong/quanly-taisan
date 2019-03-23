import React, { Component } from 'react';
import { Layout, Menu, Icon } from 'antd';

const { Sider } = Layout;
class Sidebar extends Component {

    renderSubMenu() {
        return this.props.lstSubMenu.map(item => {
            return (
                <Menu.Item key={item.functionID}>
                    <Icon type={item.iconType} />
                    <span>{item.functionName}</span>
                </Menu.Item>
            )
        })
    }

    render() {
        return (
            <Sider
                style={{ background: '#fff' }}
                trigger={null}
                collapsible
                collapsed={this.props.collapsed}
            >
                <div className="logo" />
                <Menu
                    className="left_menu"
                    onClick={this.props.handleClickMenu}
                    theme="light"
                    mode="inline"
                    defaultSelectedKeys={['1']}>
                    {this.renderSubMenu()}
                </Menu>
            </Sider>
        );
    }
}

export default Sidebar;