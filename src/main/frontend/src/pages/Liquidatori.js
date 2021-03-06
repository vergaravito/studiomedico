import React, { useState, useEffect } from 'react';
import axios from "axios";
import { Row, Form, Button, Table, Alert} from "react-bootstrap";
import 'bootstrap/dist/css/bootstrap.min.css';
import * as FaIcons from "react-icons/fa";
import AsyncSelect from 'react-select/async';

export function Liquidatori(props) {
    const [postId, setPostId] = useState(null);

    const [id, setId] = useState(null);
    const [name, setName] = useState("");
    const [cognome, setCognome] = useState("");
    const [idAssicurazione, setIdAssicurazione] = useState("");
    const [dataAss, setDataAss] = useState([]);
    const [tipoins, setTipoins] = useState('Inserisci nuovo');
    
    const requestOptions = {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ id: id, nome: name, cognome: cognome, idAssicurazione: idAssicurazione})
    };

    const [showSuccessAlert, isShowSuccessAlert]= useState(false);
    const [showFailAlert, isShowFailAlert]= useState(false);

    const [showSuccessDeleteAlert, isShowSuccessDeleteAlert]= useState(false);
    const [showFailDeleteAlert, isShowFailDeleteAlert]= useState(false);

    const handleSubmit = (evt) => {
        evt.preventDefault();
        fetch('http://localhost:8080/insert/liquidatore', requestOptions)
            .then(response => response.json())
            .then(json => {             
                isShowSuccessAlert(true);
                clearForm();
                fetchLiquidatori();
              })
            .catch(err => {
                console.log(err);
                isShowFailAlert(true);
            });
    }
    const handleDelete = (liquidatore) => {
        var r = window.confirm(`Confermi di eliminare il liquidatore: ${liquidatore.nome} , ${liquidatore.cognome} `);
        if (r === true) {
            const deleteOptions = {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({ id: liquidatore.id, nome: liquidatore.name, cognome: liquidatore.cognome, idAssicurazione: idAssicurazione})
            };
            fetch('http://localhost:8080/delete/liquidatore/', deleteOptions)
                .then(response => {
                    if(response.ok) {
                        isShowSuccessDeleteAlert(true);
                        clearForm();
                        fetchLiquidatori();
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

    const handleEdit = (liquidatore) => {
        console.log("EDIT", liquidatore);
        setId(liquidatore.id);
        setName(liquidatore.nome);
        setCognome(liquidatore.cognome);
        setIdAssicurazione(liquidatore.idAssicurazione);
        setTipoins('Modifica Liquidatore');
    }

    const clearForm = () => {
        setId(null);
        setName("");
        setCognome("");
        setTipoins('Inserisci nuovo');
    }

    const [data, setData] = useState([]);

    const fetchLiquidatori = () => {
        axios.get("http://localhost:8080/fetch/liquidatori").then( res => {
            console.log(res);
            setData(res.data);
        });
    };

    const fetchAssicurazioni = () => {
        axios.get("http://localhost:8080/fetch/assicurazioni").then( res => {
            setDataAss(res.data);
        });
    };

    useEffect(() => {
        fetchLiquidatori();
        fetchAssicurazioni();
    }, []);

    const getNomeAssicurazione = (id) => {
        const nome = "";
        for (let index = 0; index < dataAss.length; index++) {
            const element = dataAss[index].id;
            if(element === id){
                return dataAss[index].nome;
            }
        }
        return nome;
    };

    const filterAssicurazioni = (inputValue) => {
        return dataAss.map((assicurazione, index) => (                                        
            { value: assicurazione.id, label: assicurazione.nome }
        )).filter(i =>
          i.label.toLowerCase().includes(inputValue.toLowerCase())
        );
    };
    const loadAssicurazioni = (inputValue, callback) => {
        setTimeout(() => {
          callback(filterAssicurazioni(inputValue));
        }, 1000);
    };
    const getAssicurazioneSelected = (idAssicurazione) => {
        for (let index = 0; index < dataAss.length; index++) {
            if(dataAss[index].id === idAssicurazione){
                return { value: dataAss[index].id, label: dataAss[index].nome }
            }
        }
        return ""
    };

    let liquidatoriArray = data;

    const renderLiquidatori = (liquidatore) => {
        return (
            <tr key={liquidatore.id}>
            <td>{liquidatore.nome}</td>
            <td>{liquidatore.cognome}</td>
            <td>{getNomeAssicurazione(liquidatore.idAssicurazione)}</td>
            <td><Button onClick={() => handleEdit(liquidatore)}><FaIcons.FaEdit/></Button></td>
            <td><Button onClick={() => handleDelete(liquidatore)}><FaIcons.FaTrash/></Button></td>
            </tr>
        )
    }

    return (
        <div class="container">
            <div class="row">
                <div class="col-sm-10 mx-auto text-center form p-4">
                <h1 class="display-5 py-2 text-truncate">Elenco Liquidatori</h1>
                { showSuccessDeleteAlert && <Alert idx="1" variant="success">Liquidatore eliminato con successo</Alert>}
                { showFailDeleteAlert && <Alert idx="2" variant="danger">Eliminazione Liquidatore fallita</Alert> }
                    <Table striped condensed hover>
                        <thead>
                            <tr>
                            <th>Nome</th>
                            <th>Cognome</th>
                            <th>Assicurazione</th>
                            <th>Modifica</th>
                            <th>Elimina</th>
                            </tr>
                        </thead>
                        <tbody>
                            {liquidatoriArray.map(renderLiquidatori)}
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
                                <Form.Label> Nome </Form.Label>
                                <Form.Control
                                    type="text"
                                    placeholder="Nome Liquidatore"
                                    defaultValue=""
                                    value={name}
                                    onChange={e => setName(e.target.value)}
                                />
                                <Form.Text className="text-muted">
                                Inserisci il nome Liquidatore
                                </Form.Text>
                            </Form.Group>

                            <Form.Group as={Row} controlId="formPlaintextAddress">
                                <Form.Label> Cognome </Form.Label>
                                <Form.Control
                                    type="text"
                                    placeholder="Cognome Liquidatore"
                                    defaultValue=""
                                    value={cognome}
                                    onChange={e => setCognome(e.target.value)}
                                />
                                <Form.Text className="text-muted">
                                Inserisci il cognome Liquidatore
                                </Form.Text>
                            </Form.Group>
                            <Form.Group controlId="exampleForm.SelectCustomSizeSm">
                                <Form.Label> Assicurazione </Form.Label>
                                <AsyncSelect
                                    cacheOptions
                                    placeholder="Seleziona Assicurazione"
                                    loadOptions={loadAssicurazioni}
                                    defaultOptions={dataAss.map((assicurazione, index) => (                                        
                                        { value: assicurazione.id, label: assicurazione.nome }
                                    ))}
                                    value={getAssicurazioneSelected(idAssicurazione)}
                                    onChange={e => setIdAssicurazione(e.value)}
                                />
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

export default Liquidatori;
