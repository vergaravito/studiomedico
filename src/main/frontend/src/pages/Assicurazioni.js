import React, { useState, useEffect } from 'react';
import axios from "axios";
import { Row, Form, Button, Table, Alert} from "react-bootstrap";
import 'bootstrap/dist/css/bootstrap.min.css';
import * as FaIcons from "react-icons/fa";
import 'moment-timezone';

export function Assicurazioni(props) {
    const [postId, setPostId] = useState(null);

    const [id, setId] = useState(null);
    const [name, setName] = useState("");
    const [email, setEmail] = useState("");
    const [telefono1, setTelefono1] = useState("");
    const [telefono2, setTelefono2] = useState("");
    const [indirizzo, setIndirizzo] = useState("");
    const [cap, setCap] = useState("");
    const [partitaiva, setPartitaiva] = useState("");
    const [codicefiscale, setCodicefiscale] = useState("");
    const [note, setNote] = useState("");

    const [tipoins, setTipoins] = useState('Inserisci nuovo');
    
    const requestOptions = {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ id: id, nome: name, email: email, telefono1: telefono1, telefono2: telefono2, indirizzo: indirizzo, cap: cap, partitaiva: partitaiva, codicefiscale: codicefiscale, note: note })
    };

    const [showSuccessAlert, isShowSuccessAlert]= useState(false);
    const [showFailAlert, isShowFailAlert]= useState(false);

    const [showSuccessDeleteAlert, isShowSuccessDeleteAlert]= useState(false);
    const [showFailDeleteAlert, isShowFailDeleteAlert]= useState(false);

    const handleSubmit = (evt) => {
        evt.preventDefault();
        fetch('http://localhost:8080/insert/assicurazione', requestOptions)
            .then(response => response.json())
            .then(json => {             
                isShowSuccessAlert(true);
                clearForm();
                fetchAssicurazioni();
              })
            .catch(err => {
                console.log(err);
                isShowFailAlert(true);
            });
    }
    const handleDelete = (assicurazione) => {
        var r = window.confirm(`Confermi di eliminare l' assicurazione: ${assicurazione.nome} , ${assicurazione.indirizzo} , ${assicurazione.cap}`);
        if (r === true) {
            const deleteOptions = {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(assicurazione)
            };
            fetch('http://localhost:8080/delete/assicurazione/', deleteOptions)
                .then(response => {
                    if(response.ok) {
                        isShowSuccessDeleteAlert(true);
                        clearForm();
                        fetchAssicurazioni();
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

    const handleEdit = (assicurazione) => {
        console.log("EDIT", assicurazione);
        setId(assicurazione.id);
        setName(assicurazione.nome);
        setEmail(assicurazione.email);
        setTelefono1(assicurazione.telefono1);
        setTelefono2(assicurazione.telefono2);
        setIndirizzo(assicurazione.indirizzo);
        setCap(assicurazione.cap);
        setPartitaiva(assicurazione.partitaiva);
        setCodicefiscale(assicurazione.codicefiscale);
        setNote(assicurazione.note);
        setTipoins('Modifica Assicurazione');
    }

    const clearForm = () => {
        setId(null);
        setName("");
        setEmail("");
        setTelefono1("");
        setTelefono2("");
        setIndirizzo("");
        setCap("");
        setPartitaiva("");
        setCodicefiscale("");
        setNote("");
        setTipoins('Inserisci nuovo');
    }

    const [data, setData] = useState([]);

    const fetchAssicurazioni = () => {
        axios.get("http://localhost:8080/fetch/assicurazioni").then( res => {
            console.log(res);
            setData(res.data);
        });
    };

    useEffect(() => {
        fetchAssicurazioni();
    }, []);

    let assicurazioniArray = data;

    const renderAssicurazioni = (assicurazione) => {
        return (
            <tr key={assicurazione.id}>
            <td>{assicurazione.nome}</td>
            <td>{assicurazione.email}</td>
            <td>{assicurazione.telefono1}</td>
            <td>{assicurazione.telefono2}</td>
            <td>{assicurazione.indirizzo}</td>
            <td>{assicurazione.cap}</td>
            <td>{assicurazione.partitaiva}</td>
            <td>{assicurazione.codicefiscale}</td>
            <td>{assicurazione.note}</td>
            <td><Button onClick={() => handleEdit(assicurazione)}><FaIcons.FaEdit/></Button></td>
            <td><Button onClick={() => handleDelete(assicurazione)}><FaIcons.FaTrash/></Button></td>
            </tr>
        )
    }

    return (
        <div class="container">
            <div class="row">
                <div class="col-sm-10 mx-auto text-center form p-4">
                <h1 class="display-5 py-2 text-truncate">Elenco Assicurazioni</h1>
                { showSuccessDeleteAlert && <Alert idx="1" variant="success">Assicurazione eliminata con successo</Alert>}
                { showFailDeleteAlert && <Alert idx="2" variant="danger">Eliminazione Assicurazione fallita</Alert> }
                    <Table striped condensed hover>
                        <thead>
                            <tr>
                            <th>Nome</th>
                            <th>Email</th>
                            <th>Telefono 1</th>
                            <th>Telefono 2</th>
                            <th>Indirizzo</th>
                            <th>CAP</th>
                            <th>Partita Iva</th>
                            <th>Codice Fiscale</th>
                            <th>Note</th>
                            <th>Modifica</th>
                            <th>Elimina</th>
                            </tr>
                        </thead>
                        <tbody>
                            {assicurazioniArray.map(renderAssicurazioni)}
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
                                    placeholder="Nome Assicurazione"
                                    defaultValue=""
                                    value={name}
                                    onChange={e => setName(e.target.value)}
                                />
                                <Form.Text className="text-muted">
                                Inserisci il nome Assicurazione
                                </Form.Text>
                            </Form.Group>
                            <Form.Group as={Row} controlId="formPlaintextName">
                                <Form.Label> Email </Form.Label>
                                <Form.Control
                                    type="text"
                                    placeholder="Email Assicurazione"
                                    defaultValue=""
                                    value={email}
                                    onChange={e => setEmail(e.target.value)}
                                />
                                <Form.Text className="text-muted">
                                Inserisci il Email Assicurazione
                                </Form.Text>
                            </Form.Group>
                            <Form.Group as={Row} controlId="formPlaintextName">
                                <Form.Label> Telefono principale </Form.Label>
                                <Form.Control
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
                            <Form.Group as={Row} controlId="formPlaintextAddress">
                                <Form.Label> Indirizzo </Form.Label>
                                <Form.Control
                                    type="text"
                                    placeholder="Indirizzo Assicurazione"
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
                                    placeholder="CAP Assicurazione"
                                    defaultValue=""
                                    value={cap}
                                    onChange={e => setCap(e.target.value)}
                                />
                                <Form.Text className="text-muted">
                                Inserisci CAP es. "50122"
                                </Form.Text>
                                
                            </Form.Group>
                            <Form.Group as={Row} controlId="formPlaintextName">
                                <Form.Label> Partita iva </Form.Label>
                                <Form.Control
                                    type="text"
                                    placeholder="Partita iva"
                                    defaultValue=""
                                    value={partitaiva}
                                    onChange={e => setPartitaiva(e.target.value)}
                                />
                                <Form.Text className="text-muted">
                                Inserisci Partita iva Assicurazione
                                </Form.Text>
                            </Form.Group>
                            <Form.Group as={Row} controlId="formPlaintextName">
                                <Form.Label> Codice Fiscale </Form.Label>
                                <Form.Control
                                    type="text"
                                    placeholder="Codice Fiscale"
                                    defaultValue=""
                                    value={codicefiscale}
                                    onChange={e => setCodicefiscale(e.target.value)}
                                />
                                <Form.Text className="text-muted">
                                Inserisci il Codice Fiscale Assicurazione
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
                                Inserisci eventuali Note per l'Assicurazione
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

export default Assicurazioni;
