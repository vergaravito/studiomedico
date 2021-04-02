import React, { useState, useEffect } from 'react';
import axios from "axios";
import { Row, Form, Button, Table, Alert} from "react-bootstrap";
import 'bootstrap/dist/css/bootstrap.min.css';
import * as FaIcons from "react-icons/fa";
import AsyncSelect from 'react-select/async';

export function Dottori(props) {
    const [postId, setPostId] = useState(null);

    const [id, setId] = useState(null);
    const [name, setName] = useState("");
    const [cognome, setCognome] = useState("");
    const [idStudio, setIdStudio] = useState("");

    const [listStudi, setListStudi] = useState("");
    const [dataStudi, setDataStudi] = useState([]);

    const [tipoins, setTipoins] = useState('Inserisci nuovo');
    
    const requestOptions = {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ id: id, nome: name, cognome: cognome })
    };

    const [showSuccessAlert, isShowSuccessAlert]= useState(false);
    const [showFailAlert, isShowFailAlert]= useState(false);

    const [showSuccessDeleteAlert, isShowSuccessDeleteAlert]= useState(false);
    const [showFailDeleteAlert, isShowFailDeleteAlert]= useState(false);

    const handleSubmit = (evt) => {
        evt.preventDefault();
        fetch('http://localhost:8080/insert/dottore', requestOptions)
            .then(response => {
                response.json()
                console.log(response.data)
            })
            .then(json => {
                isShowSuccessAlert(true);
                clearForm();
                fetchDottori();
              })
            .catch(err => {
                isShowFailAlert(true);
            });
    }

    const requestOptionsDottoreStudio = {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(listStudi)
    };

    const associaDottoreStudio = () => {
        fetch('http://localhost:8080/join/dottore/studio', requestOptionsDottoreStudio)
            .then(response => response.json())
            .then(json => {             
                isShowSuccessAlert(true);
                clearForm();
                fetchDottori();
              })
            .catch(err => {
                isShowFailAlert(true);
            });
    }

    const handleDelete = (dottore) => {
        var r = window.confirm(`Confermi di eliminare il dottore: ${dottore.nome} , ${dottore.cognome} `);
        if (r === true) {
            const deleteOptions = {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({ id: dottore.id, nome: dottore.name, cognome: dottore.cognome })
            };
            fetch('http://localhost:8080/delete/dottore/', deleteOptions)
                .then(response => {
                    if(response.ok) {
                        isShowSuccessDeleteAlert(true);
                        clearForm();
                        fetchDottori();
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

    const handleEdit = (dottore) => {
        console.log("EDIT", dottore);
        setId(dottore.id);
        setName(dottore.nome);
        setCognome(dottore.cognome);
        setTipoins('Modifica Dottore');
    }

    const clearForm = () => {
        setId(null);
        setName("");
        setCognome("");
        setTipoins('Inserisci nuovo');
    }

    const [data, setData] = useState([]);

    const fetchDottori = () => {
        axios.get("http://localhost:8080/fetch/dottori").then( res => {
            console.log(res);
            setData(res.data);
        });
    };
    
    const fetchStudi = () => {
        axios.get("http://localhost:8080/fetch/studi").then( res => {
            setDataStudi(res.data);
        });
    };

    useEffect(() => {
        fetchDottori();
        fetchStudi();
    }, []);

    let dottoriArray = data;

    const renderDottori = (dottore) => {
        return (
            <tr key={dottore.id}>
            <td>{dottore.nome}</td>
            <td>{dottore.cognome}</td>
            <td><Button onClick={() => handleEdit(dottore)}><FaIcons.FaEdit/></Button></td>
            <td><Button onClick={() => handleDelete(dottore)}><FaIcons.FaTrash/></Button></td>
            </tr>
        )
    }

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

    const setListStudiToUpdate = (e) => {
        if(e !== null){
            setListStudi(e.map((studio, index) =>(
                    { id: null, idStudio: studio.value, idDottore: id }
                    ))
            );
            console.log(e.map((studio, index) =>(
                { id: null, idStudio: studio.value, idDottore: id }
                )));
        } else {
            setListStudi([]);
        }
    };

    return (
        <div class="container">
            <div class="row">
                <div class="col-sm-10 mx-auto text-center form p-4">
                <h1 class="display-5 py-2 text-truncate">Elenco Dottori</h1>
                { showSuccessDeleteAlert && <Alert idx="1" variant="success">Dottore eliminato con successo</Alert>}
                { showFailDeleteAlert && <Alert idx="2" variant="danger">Eliminazione dottore fallita</Alert> }
                    <Table striped condensed hover>
                        <thead>
                            <tr>
                            <th>Nome</th>
                            <th>Cognome</th>
                            <th>Modifica</th>
                            <th>Elimina</th>
                            </tr>
                        </thead>
                        <tbody>
                            {dottoriArray.map(renderDottori)}
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
                                    placeholder="Nome Dottore"
                                    value={name}
                                    onChange={e => setName(e.target.value)}
                                />
                                <Form.Text className="text-muted">
                                Inserisci il nome dottore
                                </Form.Text>
                            </Form.Group>

                            <Form.Group as={Row} controlId="formPlaintextAddress">
                                <Form.Label> Cognome </Form.Label>
                                <Form.Control
                                    type="text"
                                    placeholder="Cognome Dottore"
                                    value={cognome}
                                    onChange={e => setCognome(e.target.value)}
                                />
                                <Form.Text className="text-muted">
                                Inserisci il cognome dottore
                                </Form.Text>
                            </Form.Group>

                            <Form.Group controlId="exampleForm.SelectCustomSizeSm">
                                <Form.Label> Studi </Form.Label>
                                <AsyncSelect
                                    isMulti
                                    cacheOptions
                                    placeholder="Seleziona uno o più studi"
                                    loadOptions={loadStudi}
                                    defaultOptions={dataStudi.map((studio, index) => (                                        
                                        { value: studio.id, label: studio.nome }
                                    ))}
                                    onChange={(e) => setListStudiToUpdate(e)}
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

export default Dottori;
