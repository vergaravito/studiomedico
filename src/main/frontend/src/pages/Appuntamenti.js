import React, { useState, useEffect, Component } from 'react';
import axios from "axios";
import { Row, Form, Button, Table, Alert} from "react-bootstrap";
import 'bootstrap/dist/css/bootstrap.min.css';
import Moment from 'react-moment';
import 'moment-timezone';

import AsyncSelect from 'react-select/async';

export function Appuntamenti(props) {

    const [id, setId] = useState(null);
    const [idStudio, setIdStudio] = useState("");
    const [dataAppuntamento, setDataAppuntamento] = useState("");
    const [durata, setDurata] = useState(15);
    const [idIncarico, setIdIncarico] = useState("");
    const [note, setNote] = useState("");
    
    const [tipoins, setTipoins] = useState('Inserisci nuovo');
    
    const requestOptions = {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ id: id, idStudio: idStudio, dataAppuntamento: dataAppuntamento,
            durata: durata, idIncarico: idIncarico, note: note })
    };

    const [showSuccessAlert, isShowSuccessAlert]= useState(false);
    const [showFailAlert, isShowFailAlert]= useState(false);

    const [showSuccessDeleteAlert, isShowSuccessDeleteAlert]= useState(false);
    const [showFailDeleteAlert, isShowFailDeleteAlert]= useState(false);

    const handleSubmit = (evt) => {
        console.log(requestOptions);
        evt.preventDefault();
        fetch('http://localhost:8080/insert/appuntamento', requestOptions)
            .then(response => response.json())
            .then(json => {             
                isShowSuccessAlert(true);
                clearForm();
                fetchAppuntamenti();
              })
            .catch(err => {
                isShowFailAlert(true);
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
        setDurata(15);
        setIdIncarico("");
        setNote("");

        setTipoins('Inserisci nuovo');
    }

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

    useEffect(() => {
        fetchIncarichi();
        fetchAppuntamenti();
        fetchStudi();
    }, []);

    let appuntamentiArray = dataAppuntamenti;

    const renderAppuntamenti = (appuntamento) => {
        return (
            <tr key={appuntamento.id}>
            <td>{getNomeStudio(appuntamento.idStudio)}</td>
            <td><Moment format="DD/MM/YY HH:mm">
                    {appuntamento.dataAppuntamento}
                </Moment></td>
            <td>{appuntamento.durata} minuti</td>
            <td>{getNumeroIncarico(appuntamento.idIncarico)}</td>
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

    return (
        <div class="container">
            <div class="row">
                <div class="col-sm-10 mx-auto text-center form p-4">
                <h1 class="display-5 py-2 text-truncate">Elenco Appuntamenti</h1>
                { showSuccessDeleteAlert && <Alert idx="1" variant="success">Appuntamento eliminato con successo</Alert>}
                { showFailDeleteAlert && <Alert idx="2" variant="danger">Eliminazione Appuntamento fallita</Alert> }
                    <Table striped condensed hover>
                        <thead>
                            <tr>
                            <th>Studio</th>
                            <th>Data Appuntamento</th>
                            <th>Durata</th>
                            <th>Incarico</th>
                            <th>Note</th>
                            <th>Modifica</th>
                            <th>Elimina</th>
                            </tr>
                        </thead>
                        <tbody>
                            {appuntamentiArray.map(renderAppuntamenti)}
                        </tbody>
                    </Table>
                </div>
            </div>
            
            <div class="row">
                <div class="col-xl-5 col-lg-6 col-md-8 col-sm-10 mx-auto text-center form p-4">
                <h1 class="display-5 py-2 text-truncate">{tipoins}</h1>
                { showSuccessAlert && <Alert idx="3" variant="success">Aggiornato con successo</Alert>}
                { showFailAlert && <Alert idx="4" variant="danger">Aggiornamento fallito</Alert> }

                    <div class="px-2">
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
                                <Form.Label> Data Appuntamento </Form.Label>
                                <Form.Control
                                    required
                                    type="datetime-local" timeFormat="YYYY-MM-DD HH:mm"
                                    placeholder="Data Appuntamento"
                                    defaultValue=""
                                    value={dataAppuntamento}
                                    onChange={e => setDataAppuntamento(e.target.value)}
                                />
                                <Form.Text className="text-muted">
                                Inserisci il Data Appuntamento
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
        </div>
    )
}

export default Appuntamenti;
