import React, { useState, useEffect, Component } from 'react';
import axios from "axios";
import { Row, Form, Button, Table, Alert} from "react-bootstrap";
import 'bootstrap/dist/css/bootstrap.min.css';
import Moment from 'react-moment';
import 'moment-timezone';

import Calendar from 'react-calendar'
import '../../node_modules/react-calendar/dist/Calendar.css';
import moment from 'moment';

export function Home(props) {
    
    const [id, setId] = useState(null);
    const [idStudio, setIdStudio] = useState("");
    const [dataAppuntamento, setDataAppuntamento] = useState("");
    const [durata, setDurata] = useState(15);
    const [idIncarico, setIdIncarico] = useState("");
    const [note, setNote] = useState("");
    
    const [tipoins, setTipoins] = useState('Inserisci nuovo');
    const [dataIncarichi, setDataIncarichi] = useState([]);
    const [dataAppuntamenti, setDataAppuntamenti] = useState([]);
    const [dataStudi, setDataStudi] = useState([]);
    const [dataSog, setDataSog] = useState([]);
    const [dataAvv, setDataAvv] = useState([]);
    const [dataDot, setDataDot] = useState([]);

    const fetchAppuntamenti = () => {
        axios.get("http://localhost:8080/fetch/appuntamenti").then( res => {
            console.log(res);
            setDataAppuntamenti(res.data);
        });
    };

    const fetchIncarichi = () => {
        axios.get("http://localhost:8080/fetch/incarichi").then( res => {
            console.log(res);
            setDataIncarichi(res.data);
        });
    };

    const fetchStudi = () => {
        axios.get("http://localhost:8080/fetch/studi").then( res => {
            setDataStudi(res.data);
        });
    };

    const fetchDottori = () => {
        axios.get("http://localhost:8080/fetch/dottori").then( res => {
            setDataDot(res.data);
        });
    };

    const fetchSoggetti = () => {
        axios.get("http://localhost:8080/fetch/soggetti").then( res => {
            setDataSog(res.data);
        });
    };

    useEffect(() => {
        fetchIncarichi();
        fetchAppuntamenti();
        fetchStudi();
        fetchDottori();
        fetchSoggetti();
    }, []);

    const requestOptions = {
        method: 'GET',
        headers: { 'Content-Type': 'text/html', 'Accept': 'application/json' }
    };

    const [value, onChange] = useState(new Date());
    
    const getAppuntamenti = (value, event) => {
        console.log(value);
        getAppuntamentoByDate(value);
    }
    const [showSuccessAlert, isShowSuccessAlert]= useState(false);
    const [showFailAlert, isShowFailAlert]= useState(false);

    const [showSuccessDeleteAlert, isShowSuccessDeleteAlert]= useState(false);
    const [showFailDeleteAlert, isShowFailDeleteAlert]= useState(false);

    const getAppuntamentoByDate = (value) => {
        axios.get('http://localhost:8080/get/appuntamenti?date='+ moment(value.toISOString()).format('DD/MM/YYYY')).then( res => {
            console.log(res);
            setDataAppuntamenti(res.data);
        });
    }
    const handleDelete = (appuntamento) => {
        var r = window.confirm(`Confermi di eliminare appuntamento: ${appuntamento.dataAppuntamento} , ${appuntamento.idIncarico} `);
        if (r === true) {
            const deleteOptions = {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({ id: appuntamento.id, idStudio: appuntamento.idStudio, dataAppuntamento: appuntamento.dataAppuntamento,
                    durata: appuntamento.durata, idIncarico: appuntamento.idIncarico, note: appuntamento.note })
            };
            fetch('http://localhost:8080/delete/appuntamento/', deleteOptions)
                .then(response => {
                    if(response.ok) {
                        isShowSuccessDeleteAlert(true);
                        clearForm();
                        fetchIncarichi();
                    } else {
                        isShowFailDeleteAlert(true);
                    }
                })
                .catch(err => {
                    console.log(err);
                    isShowFailDeleteAlert(true);
                });
        }
    }

    const handleEdit = (appuntamento) => {
        console.log("EDIT", appuntamento);
        setId(appuntamento.id);
        setIdStudio(appuntamento.idStudio);
        setDataAppuntamento(appuntamento.dataAppuntamento);
        setDurata(appuntamento.durata);
        setIdIncarico(appuntamento.idIncarico);
        setNote(appuntamento.note);

        setTipoins('Modifica Appuntamento');
    }

    const clearForm = () => {
        setId(null);

        setId("");
        setIdStudio("");
        setDataAppuntamento("");
        setDurata("");
        setIdIncarico("");
        setNote("");

        setTipoins('Inserisci nuovo');
    }


    const renderAppuntamenti = (appuntamento) => {
        return (
            <tr key={appuntamento.id}>
            <td>
                {getDottore(appuntamento.idIncarico)}
            </td>
            <td>{getNomeStudio(appuntamento.idStudio)}</td>
            <td>{getNumeroIncarico(appuntamento.idIncarico)}</td>
            <td>
                {getSoggetto(appuntamento.idIncarico)}
            </td>
            <td><Moment format="DD/MM/YY HH:mm">
                    {appuntamento.dataAppuntamento}
                </Moment>
            </td>
            <td>{appuntamento.durata} minuti</td>
            <td>{appuntamento.note}</td>
            <td><Button onClick={() => handleEdit(appuntamento)}>Edit</Button></td>
            <td><Button onClick={() => handleDelete(appuntamento)}>Delete</Button></td>
            </tr>
        )
    }

    const getNumeroIncarico = (id) => {
        const numero = "";
        for (let index = 0; index < dataIncarichi.length; index++) {
            const element = dataIncarichi[index].id;
            if(element === id){
                return dataIncarichi[index].numero_incarico;
            }
        }
        return numero;
    };

    const getNomeStudio = (id) => {
        const nomeStudio = "";
        for (let index = 0; index < dataStudi.length; index++) {
            const element = dataStudi[index].id;
            if(element === id){
                return dataStudi[index].nome;
            }
        }
        return nomeStudio;
    };

    const getDottore = (idIncarico) => {
        const nomeStudio = "";
        for (let index = 0; index < dataIncarichi.length; index++) {
            if(dataIncarichi[index].id === idIncarico){
                for (let index = 0; index < dataDot.length; index++) {
                    if(dataDot[index].id === dataIncarichi[index].id_dottore){
                        return "Dott. " + dataDot[index].cognome + " " +  dataDot[index].nome;
                    }
                }
            }
        }
        return nomeStudio;
    };

    const getSoggetto = (idIncarico) => {
        const nomeStudio = "";
        for (let index = 0; index < dataIncarichi.length; index++) {
            if(dataIncarichi[index].id === idIncarico){
                for (let index = 0; index < dataSog.length; index++) {
                    if(dataSog[index].id === dataIncarichi[index].id_soggetto){
                        return dataSog[index].cognome + " " +  dataSog[index].nome;
                    }
                }
            }
        }
        return nomeStudio;
    };

    const options = { weekday: 'long', year: 'numeric', month: 'long', day: 'numeric' };

    return (
        <div class="container">
            <div class="row">
                <div class="col-sm-10 mx-auto text-center form p-4">
                <h3 class="display-5 py-2 text-truncate">Appuntamenti di {value.toLocaleString("it-IT", options)}</h3>
                <p>
                    {moment(value.toISOString()).format('DD/MM/YYYY')}
                </p>
                <Calendar
                    className="react-calendar"
                    locale="it-IT"
                    onChange={onChange}
                    value={value}
                    onClickDay={getAppuntamenti}
                />
                { showSuccessDeleteAlert && <Alert idx="1" variant="success">Appuntamento eliminato con successo</Alert>}
                { showFailDeleteAlert && <Alert idx="2" variant="danger">Eliminazione Appuntamento fallita</Alert> }
                    <Table striped condensed hover>
                        <thead>
                            <tr>
                            <th>Dottore</th>
                            <th>Studio</th>
                            <th>Incarico</th>
                            <th>Soggetto</th>
                            <th>Data Appuntamento</th>
                            <th>Durata</th>
                            <th>Note</th>
                            <th>Modifica</th>
                            <th>Elimina</th>
                            </tr>
                        </thead>
                        <tbody>
                            {dataAppuntamenti.map(renderAppuntamenti)}
                        </tbody>
                    </Table>
                </div>
            </div>
        </div>
        
    )
}

export default Home;
