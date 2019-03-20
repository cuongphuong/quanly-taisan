import React, { Component } from 'react';
import { Layout } from 'antd';
import '../../Styles/Layout.css';
import Nav from '../Layout/Nav';
import Sidebar from '../Layout/Sidebar';
import MyBreadcrumb from '../Layout/MyBreadcrumb';
import ContentRouter from '../../Routers/ContentRouter';
// import MyFooter from '../Layout/MyFooter';

const { Content } = Layout;

class Dashboard extends Component {
    constructor(props) {
        super(props);
        this.state = {
            collapsed: false,
        };
    }
    toggle = () => {
        this.setState({
            collapsed: !this.state.collapsed,
        });
    }
    render() {
        return (
            <Layout style={{ height: "100vh" }}>
                <Sidebar collapsed={this.state.collapsed}></Sidebar>
                <Layout>
                    <Nav collapsed={this.state.collapsed} toggle={this.toggle}></Nav>
                    <MyBreadcrumb style={{ padding: '10px 10px 10px 17px', background: 'rgb(250, 250, 250)', marginTop: '64px' }}></MyBreadcrumb>
                    <Content style={{ padding: 24, background: '#fff' }}
                    >
                        <ContentRouter></ContentRouter>
                    </Content>
                    {/* <MyFooter></MyFooter> */}
                </Layout>
            </Layout>
        );
    }
}

export default Dashboard;