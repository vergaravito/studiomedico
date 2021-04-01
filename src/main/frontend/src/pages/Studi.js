import React, { useState, useEffect } from 'react';
import axios from "axios";
import { Row, Form, Button, Table, Alert} from "react-bootstrap";
import 'bootstrap/dist/css/bootstrap.min.css';
import * as FaIcons from "react-icons/fa";

export function Studi(props) {
    const [postId, setPostId] = useState(null);

    const [id, setId] = useState(null);
    const [name, setName] = useState("");
    const [indirizzo, setIndirizzo] = useState("");
    const [cap, setCap] = useState("");
    
    const [tipoins, setTipoins] = useState('Inserisci nuovo');
    
    const requestOptions = {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ id: id, nome: name, indirizzo: indirizzo, cap: cap })
    };

    const [showSuccessAlert, isShowSuccessAlert]= useState(false);
    const [showFailAlert, isShowFailAlert]= useState(false);

    const [showSuccessDeleteAlert, isShowSuccessDeleteAlert]= useState(false);
    const [showFailDeleteAlert, isShowFailDeleteAlert]= useState(false);

    const handleSubmit = (evt) => {
        evt.preventDefault();
        fetch('http://localhost:8080/insert/studio', requestOptions)
            .then(response => response.json())
            .then(json => {             
                isShowSuccessAlert(true);
                clearForm();
                fetchStudi();
              })
            .catch(err => {
                console.log(err);
                isShowFailAlert(true);
            });
    }
    const handleDelete = (studio) => {
        var r = window.confirm(`Confermi di eliminare lo studio: ${studio.nome} , ${studio.indirizzo} , ${studio.cap}`);
        if (r === true) {
            const deleteOptions = {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({ id: studio.id, nome: studio.name, indirizzo: studio.indirizzo, cap: studio.cap })
            };
            fetch('http://localhost:8080/delete/studio/', deleteOptions)
                .then(response => {
                    if(response.ok) {
                        isShowSuccessDeleteAlert(true);
                        clearForm();
                        fetchStudi();
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

    const handleEdit = (studio) => {
        console.log("EDIT", studio);
        setId(studio.id);
        setName(studio.nome);
        setIndirizzo(studio.indirizzo);
        setCap(studio.cap);
        setTipoins('Modifica Studio');
    }

    const clearForm = () => {
        setId(null);
        setName("");
        setIndirizzo("");
        setCap("");
        setTipoins('Inserisci nuovo');
    }

    const [data, setData] = useState([]);

    const fetchStudi = () => {
        axios.get("http://localhost:8080/fetch/studi").then( res => {
            console.log(res);
            setData(res.data);
        });
    };

    useEffect(() => {
        fetchStudi();
    }, []);

    let studiArray = data;

    const renderStudi = (studio) => {
        return (
            <tr key={studio.id}>
            <td>{studio.nome}</td>
            <td>{studio.indirizzo}</td>
            <td>{studio.cap}</td>
            <td><Button onClick={() => handleEdit(studio)}><FaIcons.FaEdit/></Button></td>
            <td><Button onClick={() => handleDelete(studio)}><FaIcons.FaTrash/></Button></td>
            </tr>
        )
    }

    return (
        <div class="container">
            <div class="row">
                <div class="col-sm-10 mx-auto text-center form p-4">
                <h1 class="display-5 py-2 text-truncate">Elenco Studi</h1>
                { showSuccessDeleteAlert && <Alert idx="1" variant="success">Studio eliminato con successo</Alert>}
                { showFailDeleteAlert && <Alert idx="2" variant="danger">Eliminazione Studio fallita</Alert> }
                    <Table striped condensed hover>
                        <thead>
                            <tr>
                            <th>Nome</th>
                            <th>Indirizzo</th>
                            <th>CAP</th>
                            <th>Modifica</th>
                            <th>Elimina</th>
                            </tr>
                        </thead>
                        <tbody>
                            {studiArray.map(renderStudi)}
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
                                    placeholder="Nome Studio"
                                    defaultValue=""
                                    value={name}
                                    onChange={e => setName(e.target.value)}
                                />
                                <Form.Text className="text-muted">
                                Inserisci il nome Studio
                                </Form.Text>
                            </Form.Group>

                            <Form.Group as={Row} controlId="formPlaintextAddress">
                                <Form.Label> Indirizzo </Form.Label>
                                <Form.Control
                                    type="text"
                                    placeholder="Indirizzo Studio"
                                    defaultValue=""
                                    value={indirizzo}
                                    onChange={e => setIndirizzo(e.target.value)}
                                />
                                <Form.Text className="text-muted">
                                Inserisci l'indirizzo es. "Via Dante Alighieri, 3, Firenze"
                                </Form.Text>
                            </Form.Group>

                            <Form.Group as={Row} controlId="formPlaintextCap">
                                <Form.Label> CAP </Form.Label>
                                <Form.Control
                                    type="number"
                                    placeholder="CAP Studio"
                                    defaultValue=""
                                    value={cap}
                                    onChange={e => setCap(e.target.value)}
                                />
                                <Form.Text className="text-muted">
                                Inserisci CAP es. "50122"
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

export default Studi;
