import React from 'react'
import * as FaIcons from "react-icons/fa";
import * as AiIcons from "react-icons/ai";
import * as ImIcons from "react-icons/im";
import * as BiIcons from "react-icons/bi";
import * as RiIcons from "react-icons/ri";

export const SidebarData = [
    {
        title: 'Home',
        path: '/',
        icon: <AiIcons.AiFillHome/>,
        cName: 'nav-text'
    },
    {
        title: 'Incarichi',
        path: '/incarichi',
        icon: <BiIcons.BiClipboard/>,
        cName: 'nav-text'
    },
    {
        title: 'Soggetti',
        path: '/soggetti',
        icon: <FaIcons.FaUser/>,
        cName: 'nav-text'
    },
    {
        title: 'Dottori',
        path: '/dottori',
        icon: <FaIcons.FaUserMd/>,
        cName: 'nav-text'
    },
    {
        title: 'Avvocati',
        path: '/avvocati',
        icon: <FaIcons.FaUserTie/>,
        cName: 'nav-text'
    },
    {
        title: 'Incidenti',
        path: '/incidenti',
        icon: <BiIcons.BiShieldX/>,
        cName: 'nav-text'
    },
    {
        title: 'Assicurazioni',
        path: '/assicurazioni',
        icon: <BiIcons.BiShieldQuarter/>,
        cName: 'nav-text'
    },
    {
        title: 'Liquidatori',
        path: '/liquidatori',
        icon: <RiIcons.RiShieldUserLine/>,
        cName: 'nav-text'
    },
    {
        title: 'Studi',
        path: '/studi',
        icon: <ImIcons.ImOffice/>,
        cName: 'nav-text'
    }
]