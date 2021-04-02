import React, {useState, useEffect} from "react";
import './App.css';

import Navbar from "./components/Navbar";
import { Route, BrowserRouter as Router, Switch } from "react-router-dom";
import Home from './pages/Home';
import Assicurazioni from './pages/Assicurazioni';
import Avvocati from './pages/Avvocati';
import Dottori from './pages/Dottori';
import Incarichi from './pages/Incarichi';
import Liquidatori from './pages/Liquidatori';
import Soggetti from './pages/Soggetti';
import Studi from './pages/Studi';



function App() {
  return (
    <>
      <Router>
        <Navbar />
        <Switch>
          <Route path='/' exact component={Home} />
          <Route path='/incarichi' component={Incarichi} />
          <Route path='/soggetti' component={Soggetti} />
          <Route path='/dottori' component={Dottori} />
          <Route path='/avvocati' component={Avvocati} />
          <Route path='/assicurazioni' component={Assicurazioni} />
          <Route path='/liquidatori' component={Liquidatori} />
          <Route path='/studi' component={Studi} />
        </Switch>
      </Router>
    </>
  );
}

export default App;
 