import React from 'react';
import { Breadcrumb, Icon } from 'antd';

class MyBreadcrumb extends React.PureComponent {

    render() {
        return (
            <Breadcrumb style={this.props.style}>
                <Breadcrumb.Item href="">
                    <Icon type="home" />
                </Breadcrumb.Item>
                <Breadcrumb.Item href="">
                    <Icon type="user" />
                    <span>Application List</span>
                </Breadcrumb.Item>
                <Breadcrumb.Item>
                    Application
                </Breadcrumb.Item>
            </Breadcrumb>

        );
    }
}
export default MyBreadcrumb;
