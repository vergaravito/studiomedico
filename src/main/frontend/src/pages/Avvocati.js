import React, { useState, useEffect } from 'react';
import axios from "axios";
import { Row, Form, Button, Table, Alert} from "react-bootstrap";
import 'bootstrap/dist/css/bootstrap.min.css';
import Moment from 'react-moment';
import 'moment-timezone';

export function Avvocati(props) {
    const [postId, setPostId] = useState(null);

    const [id, setId] = useState(null);
    const [name, setName] = useState("");
    const [cognome, setCognome] = useState("");
    const [titolo, setTitolo] = useState("");
    const [indirizzo, setIndirizzo] = useState("");
    const [cap, setCap] = useState("");
    const [email, setEmail] = useState("");
    const [pec, setPec] = useState("");
    const [telefono1, setTelefono1] = useState("");
    const [telefono2, setTelefono2] = useState("");
    const [fax, setFax] = useState("");
    const [note, setNote] = useState("");

    const [tipoins, setTipoins] = useState('Inserisci nuovo');
    
    const requestOptions = {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ id: id, nome: name, cognome: cognome, titolo: titolo, indirizzo: indirizzo, cap: cap, email: email, pec: pec, telefono1: telefono1, telefono2: telefono2, fax: fax, note: note })
    };

    const [showSuccessAlert, isShowSuccessAlert]= useState(false);
    const [showFailAlert, isShowFailAlert]= useState(false);

    const [showSuccessDeleteAlert, isShowSuccessDeleteAlert]= useState(false);
    const [showFailDeleteAlert, isShowFailDeleteAlert]= useState(false);

    const handleSubmit = (evt) => {
        evt.preventDefault();
        fetch('http://localhost:8080/insert/avvocato', requestOptions)
            .then(response => response.json())
            .then(json => {             
                isShowSuccessAlert(true);
                clearForm();
                fetchAvvocati();
              })
            .catch(err => {
                console.log(err);
                isShowFailAlert(true);
            });
    }
    const handleDelete = (avvocato) => {
        var r = window.confirm(`Confermi di eliminare l' avvocato: ${avvocato.nome} , ${avvocato.cognome}`);
        if (r === true) {
            const deleteOptions = {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(avvocato)
            };
            fetch('http://localhost:8080/delete/avvocato/', deleteOptions)
                .then(response => {
                    if(response.ok) {
                        isShowSuccessDeleteAlert(true);
                        clearForm();
                        fetchAvvocati();
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

    const handleEdit = (avvocato) => {
        console.log("EDIT", avvocato);
        setId(avvocato.id);
        setName(avvocato.nome);
        setCognome(avvocato.cognome);
        setTitolo(avvocato.titolo);
        setIndirizzo(avvocato.indirizzo);
        setCap(avvocato.cap);
        setEmail(avvocato.email);
        setPec(avvocato.pec);
        setTelefono1(avvocato.telefono1);
        setTelefono2(avvocato.telefono2);
        setFax(avvocato.fax);
        setNote(avvocato.note);
        setTipoins('Modifica Avvocato');
    }

    const clearForm = () => {
        setId(null);
        setName("");
        setCognome("");
        setTitolo("");
        setIndirizzo("");
        setCap("");
        setEmail("");
        setPec("");
        setTelefono1("");
        setTelefono2("");
        setFax("");
        setNote("");
        setTipoins('Inserisci nuovo');
    }

    const [data, setData] = useState([]);

    const fetchAvvocati = () => {
        axios.get("http://localhost:8080/fetch/avvocati").then( res => {
            console.log(res);
            setData(res.data);
        });
    };

    useEffect(() => {
        fetchAvvocati();
    }, []);

    let avvocatiArray = data;

    const renderAvvocati = (avvocato) => {
        return (
            <tr key={avvocato.id}>
            <td>{avvocato.nome}</td>
            <td>{avvocato.cognome}</td>
            <td>{avvocato.titolo}</td>
            <td>{avvocato.indirizzo}</td>
            <td>{avvocato.cap}</td>
            <td>{avvocato.email}</td>
            <td>{avvocato.pec}</td>
            <td>{avvocato.telefono1}</td>
            <td>{avvocato.telefono2}</td>
            <td>{avvocato.fax}</td>
            <td>{avvocato.note}</td>
            <td><Button onClick={() => handleEdit(avvocato)}>Edit</Button></td>
            <td><Button onClick={() => handleDelete(avvocato)}>Delete</Button></td>
            </tr>
        )
    }

    return (
        <div class="container">
            <div class="row">
                <div class="col-sm-10 mx-auto text-center form p-4">
                <h1 class="display-5 py-2 text-truncate">Elenco Avvocati</h1>
                { showSuccessDeleteAlert && <Alert idx="1" variant="success">Avvocato eliminata con successo</Alert>}
                { showFailDeleteAlert && <Alert idx="2" variant="danger">Eliminazione Avvocato fallita</Alert> }
                    <Table striped condensed hover>
                        <thead>
                            <tr>
                            <th>Nome</th>
                            <th>Cognome</th>
                            <th>Titolo</th>
                            <th>Indirizzo</th>
                            <th>CAP</th>
                            <th>Email</th>
                            <th>PEC</th>
                            <th>Telefono 1</th>
                            <th>Telefono 2</th>
                            <th>Fax</th>
                            <th>Note</th>
                            <th>Modifica</th>
                            <th>Elimina</th>
                            </tr>
                        </thead>
                        <tbody>
                            {avvocatiArray.map(renderAvvocati)}
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
                                    required
                                    type="text"
                                    placeholder="Nome Avvocato"
                                    defaultValue=""
                                    value={name}
                                    onChange={e => setName(e.target.value)}
                                />
                                <Form.Text className="text-muted">
                                Inserisci il nome Avvocato
                                </Form.Text>
                            </Form.Group>
                            <Form.Group as={Row} controlId="formPlaintextName">
                                <Form.Label> Cognome </Form.Label>
                                <Form.Control
                                    required
                                    type="text"
                                    placeholder="Cognome Avvocato"
                                    defaultValue=""
                                    value={cognome}
                                    onChange={e => setCognome(e.target.value)}
                                />
                                <Form.Text className="text-muted">
                                Inserisci il Cognome Avvocato
                                </Form.Text>
                            </Form.Group>
                            <Form.Group as={Row} controlId="formPlaintextName">
                                <Form.Label> Titolo </Form.Label>
                                <Form.Control
                                    required
                                    type="text"
                                    placeholder="Titolo Avvocato"
                                    defaultValue=""
                                    value={titolo}
                                    onChange={e => setTitolo(e.target.value)}
                                />
                                <Form.Text className="text-muted">
                                Inserisci il Titolo Avvocato
                                </Form.Text>
                            </Form.Group>
                            <Form.Group as={Row} controlId="formPlaintextAddress">
                                <Form.Label> Indirizzo </Form.Label>
                                <Form.Control
                                    required
                                    type="text"
                                    placeholder="Indirizzo Avvocato"
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
                                    required
                                    type="number"
                                    placeholder="CAP Avvocato"
                                    defaultValue=""
                                    value={cap}
                                    onChange={e => setCap(e.target.value)}
                                />
                                <Form.Text className="text-muted">
                                Inserisci CAP es. "50122"
                                </Form.Text>
                                
                            </Form.Group>
                            <Form.Group as={Row} controlId="formPlaintextName">
                                <Form.Label> Email </Form.Label>
                                <Form.Control
                                    type="text"
                                    placeholder="Email"
                                    defaultValue=""
                                    value={email}
                                    onChange={e => setEmail(e.target.value)}
                                />
                                <Form.Text className="text-muted">
                                Inserisci Email Avvocato
                                </Form.Text>
                            </Form.Group>
                            <Form.Group as={Row} controlId="formPlaintextName">
                                <Form.Label> Pec </Form.Label>
                                <Form.Control
                                    type="text"
                                    placeholder="PEC"
                                    defaultValue=""
                                    value={pec}
                                    onChange={e => setPec(e.target.value)}
                                />
                                <Form.Text className="text-muted">
                                Inserisci l'indirizzo di posta certificata dell'Avvocato
                                </Form.Text>
                            </Form.Group>
                            <Form.Group as={Row} controlId="formPlaintextName">
                                <Form.Label> Telefono principale </Form.Label>
                                <Form.Control
                                    required
                                    type="text"
                                    placeholder="Telefono principale"
                                    defaultValue=""
                                    value={telefono1}
                                    onChange={e => setTelefono1(e.target.value)}
                                />
                                <Form.Text className="text-muted">
                                Inserisci il Telefono principale
                                </Form.Text>
                            </Form.Group>
                            <Form.Group as={Row} controlId="formPlaintextName">
                                <Form.Label> Telefono secondario </Form.Label>
                                <Form.Control
                                    type="text"
                                    placeholder="Telefono secondario"
                                    defaultValue=""
                                    value={telefono2}
                                    onChange={e => setTelefono2(e.target.value)}
                                />
                                <Form.Text className="text-muted">
                                Inserisci il Telefono secondario
                                </Form.Text>
                            </Form.Group>
                            <Form.Group as={Row} controlId="formPlaintextName">
                                <Form.Label> Note </Form.Label>
                                <Form.Control
                                    type="text"
                                    placeholder="Note"
                                    defaultValue=""
                                    value={note}
                                    onChange={e => setNote(e.target.value)}
                                />
                                <Form.Text className="text-muted">
                                Inserisci eventuali Note per l'Avvocato
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

export default Avvocati;
