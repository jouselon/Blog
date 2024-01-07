import React from "react";
import './style.css'
import Header from "../Header";
import {Outlet, useLocation} from "react-router-dom";
import Footer from "../Footer";
import {AUTH_PATH} from "../../constant";

//component : 레이아웃 컴포넌트
export default function Container(){

    //state : 현재 페이지 path name 상태
    const {pathname} = useLocation();


    //render : 레이아웃 렌더링
    return(
       <>
           <Header />
           <Outlet />
           {pathname !== AUTH_PATH() && <Footer />}
       </>
    )
}