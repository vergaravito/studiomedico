import React from 'react'
import Calendar from 'react-calendar'
import '../../node_modules/react-calendar/dist/Calendar.css';

function Home() {
    return (
        <>
        <div className='home'>
            <h1>Home</h1>
        </div>
        <div>
            <Calendar className="react-calendar" />
        </div>
        </>
    )
}

export default Home;
