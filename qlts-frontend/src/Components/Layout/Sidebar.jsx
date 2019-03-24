import React, { Component } from 'react';
import { Layout, Menu, Icon, Empty } from 'antd';

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
                {(this.props.lstSubMenu.length > 0) ?
                    <Menu
                        className="left_menu"
                        onClick={this.props.handleClickMenu}
                        theme="light"
                        mode="inline"
                        defaultSelectedKeys={['1']}>
                        {this.renderSubMenu()}
                    </Menu>
                    : <Empty className="empty_menu" image="https://gw.alipayobjects.com/mdn/miniapp_social/afts/img/A*pevERLJC9v0AAAAAAAAAAABjAQAAAQ/original" />}

            </Sider>
        );
    }
}

export default Sidebar;