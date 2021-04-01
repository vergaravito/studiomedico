import React, { useState, useEffect, Component } from 'react';
import axios from "axios";
import { Row, Form, Button, Table, Alert} from "react-bootstrap";
import 'bootstrap/dist/css/bootstrap.min.css';
import Moment from 'react-moment';
import 'moment-timezone';
import * as FaIcons from "react-icons/fa";

import Calendar from 'react-calendar'
import '../../node_modules/react-calendar/dist/Calendar.css';
import moment from 'moment';
import AsyncSelect from 'react-select/async';

export function Home(props) {
    
    const [id, setId] = useState(null);
    const [idStudio, setIdStudio] = useState("");
    const [dataAppuntamento, setDataAppuntamento] = useState(new Date());
    const [oraAppuntamento, setOraAppuntamento] = useState("");
    const [durata, setDurata] = useState(15);
    const [idIncarico, setIdIncarico] = useState("");
    const [note, setNote] = useState("");
    const [value, onChange] = useState(new Date());

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
        getAppuntamentoByDate(value);
        fetchIncarichi();
        fetchStudi();
        fetchDottori();
        fetchSoggetti();
    }, []);

    const requestOptions = {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ id: id, idStudio: idStudio, dataAppuntamento: dataAppuntamento, oraAppuntamento: oraAppuntamento,
                            durata: durata, idIncarico: idIncarico, note: note })
    };
    
    const getAppuntamenti = (value, event) => {
        getAppuntamentoByDate(value);
    }
    const [showSuccessAlert, isShowSuccessAlert]= useState(false);
    const [showFailAlert, isShowFailAlert]= useState(false);

    const [showSuccessDeleteAlert, isShowSuccessDeleteAlert] = useState(false);
    const [showFailDeleteAlert, isShowFailDeleteAlert] = useState(false);

    const [appuntamentiNotEmpty, isAppuntamentiNotEmpty ] = useState(false);

    const getAppuntamentoByDate = (value) => {
        axios.get('http://localhost:8080/get/appuntamenti?date='+ moment(value.toISOString()).format('DD/MM/YYYY')).then( res => {
            console.log(res);
            setDataAppuntamenti(res.data);
            if (res.data != null && res.data.length != 0) {
                isAppuntamentiNotEmpty(true);
            } else {
                isAppuntamentiNotEmpty(false);
            }
        });
    }
    const handleDelete = (appuntamento) => {
        var r = window.confirm(`Confermi di eliminare appuntamento in data ${appuntamento.dataAppuntamento.substring(0,10)} alle ore ${appuntamento.oraAppuntamento} per l'incarico ${getNumeroIncarico(appuntamento.idIncarico)} `);
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
                        getAppuntamentoByDate(value);
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

    const handleSubmit = (evt) => {
        console.log(requestOptions);
        evt.preventDefault();
        fetch('http://localhost:8080/insert/appuntamento', requestOptions)
            .then(response => response.json())
            .then(json => {             
                isShowSuccessAlert(true);
                clearForm();
                getAppuntamentoByDate(value);
              })
            .catch(err => {
                isShowFailAlert(true);
            });
    }

    const handleEdit = (appuntamento) => {
        console.log("EDIT", appuntamento);
        setId(appuntamento.id);
        setIdStudio(appuntamento.idStudio);
        setDataAppuntamento(new Date(appuntamento.dataAppuntamento));
        setDurata(appuntamento.durata);
        setIdIncarico(appuntamento.idIncarico);
        setNote(appuntamento.note);

        setTipoins('Modifica Appuntamento');
    }

    const clearForm = () => {
        setId(null);

        setId("");
        setIdStudio("");
        setDataAppuntamento(new Date());
        setDurata(15);
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
            <td><Moment format="DD/MM/YY">
                    {appuntamento.dataAppuntamento}
                </Moment>
            </td>
            <td>{appuntamento.oraAppuntamento}</td>
            <td>
                {appuntamento.durata} minuti
            </td>
            <td>{appuntamento.note}</td>
            <td><Button onClick={() => handleEdit(appuntamento)}><FaIcons.FaEdit/></Button></td>
            <td><Button onClick={() => handleDelete(appuntamento)}><FaIcons.FaTrash/></Button></td>
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

    const getStudioSelected = (idStudio) => {
        for (let index = 0; index < dataStudi.length; index++) {
            if(dataStudi[index].id === idStudio){
                return { value: dataStudi[index].id, label: dataStudi[index].nome }
            }
        }
        return ""
    };

    const getIncaricoSelected = (idIncarico) => {
        for (let index = 0; index < dataIncarichi.length; index++) {
            if(dataIncarichi[index].id === idIncarico){
                return { value: dataIncarichi[index].id, label: dataIncarichi[index].numero_incarico }
            }
        }
        return ""
    };

    const filterStudi = (inputValue) => {
        return dataStudi.map((studio, index) => (                                        
            { value: studio.id, label: studio.nome }
        )).filter(i =>
          i.label.toLowerCase().includes(inputValue.toLowerCase())
        );
    };
    const loadStudi = (inputValue, callback) => {
        setTimeout(() => {
          callback(filterStudi(inputValue));
        }, 1000);
    };
    
    const filterIncarichi = (inputValue) => {
        return dataIncarichi.map((incarico, index) => (                                        
            { value: incarico.id, label: incarico.numero_incarico }
        )).filter(i =>
          i.label.toLowerCase().includes(inputValue.toLowerCase())
        );
    };
    const loadIncarichi = (inputValue, callback) => {
        setTimeout(() => {
          callback(filterIncarichi(inputValue));
        }, 1000);
    };

    const options = { weekday: 'long', year: 'numeric', month: 'long', day: 'numeric' };

    const formatDate = (date) => {
        if(date != null && date != ""){
            return new Date(date).toISOString().substring(0,10);
        }
        return null;
    }

    return (
        <div class="container">
            <div class="row">
                <div class="col-sm-10 mx-auto text-center form p-4">
                    <h3 class="display-5 py-2 text-truncate">Appuntamenti di {value.toLocaleString("it-IT", options)}</h3>
                    <Calendar
                        className={['c1','c2']}
                        style="margin: auto;"
                        locale="it-IT"
                        onChange={onChange}
                        value={value}
                        onClickDay={getAppuntamenti}
                    />
                    { showSuccessDeleteAlert && <Alert idx="1" variant="success">Appuntamento eliminato con successo</Alert>}
                    { showFailDeleteAlert && <Alert idx="2" variant="danger">Eliminazione Appuntamento fallita</Alert> }
                    </div>
                    </div>

                    <div class="row">
                    <div class="col-sm-10 mx-auto text-center form p-4">
                    { appuntamentiNotEmpty ? (
                        <Table striped condensed hover>
                            <thead>
                                <tr>
                                <th>Dottore</th>
                                <th>Studio</th>
                                <th>Incarico</th>
                                <th>Soggetto</th>
                                <th>Data Appuntamento</th>
                                <th>Ora</th>
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
                    ):(
                        <h4>Non ci sono appuntamenti per il giorno selezionato</h4>
                    )}
                    </div>
                    </div>
                    
                    <div class="row">
                    <div class="col-xl-5 col-lg-6 col-md-8 col-sm-10 mx-auto text-center form p-4">
                        <h1 class="display-5 py-2 text-truncate">{tipoins}</h1>
                        <Form onSubmit={handleSubmit}>

                            <Form.Group as={Row} controlId="formPlaintextName">
                                <Form.Label> Durata </Form.Label>
                                <Form.Control
                                    type="number"
                                    placeholder="15"
                                    defaultValue=""
                                    value={durata}
                                    onChange={e => setDurata(e.target.value)}
                                />
                                <Form.Text className="text-muted">
                                Inserisci Durata in minuti (default: 15)
                                </Form.Text>
                            </Form.Group>

                            <Form.Group as={Row} controlId="formPlaintextName">
                                <Form.Label> Data </Form.Label>
                                <Form.Control
                                    required
                                    type="date"
                                    value={formatDate(dataAppuntamento)}
                                    onChange={e => setDataAppuntamento(e.target.value)}
                                />
                                <Form.Text className="text-muted">
                                Inserisci la Data Appuntamento
                                </Form.Text>
                            </Form.Group>

                            <Form.Group as={Row} controlId="formPlaintextName">
                                <Form.Label> Ora </Form.Label>
                                <Form.Control
                                    type="text"
                                    placeholder="Ora appuntamento"
                                    defaultValue=""
                                    value={oraAppuntamento}
                                    onChange={e => setOraAppuntamento(e.target.value)}
                                />
                                <Form.Text className="text-muted">
                                Inserisci l'ora dell'appuntamento (es. 15:00)
                                </Form.Text>
                            </Form.Group>

                            <Form.Group controlId="exampleForm.SelectCustomSizeSm">
                                <Form.Label> Studio </Form.Label>
                                <AsyncSelect
                                    cacheOptions
                                    placeholder="Seleziona Studio"
                                    loadOptions={loadStudi}
                                    defaultOptions={dataStudi.map((studio, index) => (                                        
                                        { value: studio.id, label: studio.nome }
                                    ))}
                                    value={getStudioSelected(idStudio)}
                                    onChange={e => setIdStudio(e.value)}
                                />
                            </Form.Group>

                            <Form.Group controlId="exampleForm.SelectCustomSizeSm">
                                <Form.Label> Incarico </Form.Label>
                                <AsyncSelect
                                    cacheOptions
                                    placeholder="Seleziona Incarico"
                                    loadOptions={loadIncarichi}
                                    defaultOptions={dataIncarichi.map((incarico, index) => (                                        
                                        { value: incarico.id, label: incarico.numero_incarico }
                                    ))}
                                    value={getIncaricoSelected(idIncarico)}
                                    onChange={e => setIdIncarico(e.value)}
                                />
                            </Form.Group>
                            
                            <Form.Group as={Row} controlId="formPlaintextName">
                                <Form.Label> Note </Form.Label>
                                <Form.Control
                                    type="text"
                                    placeholder="Note Incarico"
                                    defaultValue=""
                                    value={note}
                                    onChange={e => setNote(e.target.value)}
                                />
                                <Form.Text className="text-muted">
                                Inserisci Note
                                </Form.Text>
                            </Form.Group>

                            <Form.Group as={Row} controlId="formPlaintextSubmit">
                                <Button variant="primary" type="submit">Salva</Button>
                                <Button variant="secondary" onClick={() => clearForm()}>Annulla</Button>
                            </Form.Group>
                        </Form>
                </div>
            </div>
        </div>
        
    )
}

export default Home;
