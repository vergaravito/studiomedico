import React, { useState, useEffect } from 'react';
import axios from "axios";
import { Row, Form, Button, Table, Alert} from "react-bootstrap";
import 'bootstrap/dist/css/bootstrap.min.css';
import Moment from 'react-moment';
import 'moment-timezone';

export function Soggetti(props) {
    const [postId, setPostId] = useState(null);

    const [id, setId] = useState(null);
    const [name, setName] = useState("");
    const [cognome, setCognome] = useState("");
    const [luogonascita, setLuogonascita] = useState("");
    const [datanascita, setDatanascita] = useState("");
    const [indirizzo, setIndirizzo] = useState("");
    const [cap, setCap] = useState("");
    const [telefono, setTelefono] = useState("");
    const [sesso, setSesso] = useState("");
    const [note, setNote] = useState("");
    const [email, setEmail] = useState("");
    const [codicefiscale, setCodicefiscale] = useState("");
    
    const [tipoins, setTipoins] = useState('Inserisci nuovo');
    
    const requestOptions = {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ id: id, nome: name, cognome: cognome, luogonascita: luogonascita, datanascita: datanascita, indirizzo: indirizzo, cap: cap, telefono: telefono, sesso: sesso, note: note, email: email, codicefiscale: codicefiscale })
    };

    const [showSuccessAlert, isShowSuccessAlert]= useState(false);
    const [showFailAlert, isShowFailAlert]= useState(false);

    const [showSuccessDeleteAlert, isShowSuccessDeleteAlert]= useState(false);
    const [showFailDeleteAlert, isShowFailDeleteAlert]= useState(false);

    const handleSubmit = (evt) => {
        evt.preventDefault();
        fetch('http://localhost:8080/insert/soggetto', requestOptions)
            .then(response => response.json())
            .then(json => {             
                isShowSuccessAlert(true);
                clearForm();
                fetchSoggetti();
              })
            .catch(err => {
                console.log(err);
                isShowFailAlert(true);
            });
    }
    const handleDelete = (soggetto) => {
        var r = window.confirm(`Confermi di eliminare lo soggetto: ${soggetto.nome} , ${soggetto.cognome}`);
        if (r === true) {
            const deleteOptions = {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(soggetto)
            };
            fetch('http://localhost:8080/delete/soggetto/', deleteOptions)
                .then(response => {
                    if(response.ok) {
                        isShowSuccessDeleteAlert(true);
                        clearForm();
                        fetchSoggetti();
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

    const handleEdit = (soggetto) => {
        console.log("EDIT", soggetto);
        setId(soggetto.id);
        setName(soggetto.nome);
        setCognome(soggetto.cognome);
        setLuogonascita(soggetto.luogonascita);
        setDatanascita(soggetto.datanascita);
        setIndirizzo(soggetto.indirizzo);
        setCap(soggetto.cap);
        setTelefono(soggetto.telefono);
        setSesso(soggetto.sesso);
        setNote(soggetto.note);
        setEmail(soggetto.email);
        setCodicefiscale(soggetto.codicefiscale);
        setTipoins('Modifica Soggetto');
    }

    const clearForm = () => {
        setId(null);
        setName("");
        setCognome("");
        setLuogonascita("");
        setDatanascita("");
        setIndirizzo("");
        setCap("");
        setTelefono("");
        setSesso("");
        setNote("");
        setEmail("");
        setCodicefiscale("");

        setTipoins('Inserisci nuovo');
    }

    const [data, setData] = useState([]);

    const fetchSoggetti = () => {
        axios.get("http://localhost:8080/fetch/soggetti").then( res => {
            console.log(res);
            setData(res.data);
        });
    };

    useEffect(() => {
        fetchSoggetti();
    }, []);

    let soggettiArray = data;

    const renderSoggetti = (soggetto) => {
        return (
            <tr key={soggetto.id}>
            <td>{soggetto.nome}</td>
            <td>{soggetto.cognome}</td>
            <td>{soggetto.luogonascita}</td>
            <td>
                <Moment format="DD/MM/YY">
                    {soggetto.datanascita}
                </Moment>
            </td>
            <td>{soggetto.indirizzo}</td>
            <td>{soggetto.cap}</td>
            <td>{soggetto.telefono}</td>
            <td>{soggetto.sesso}</td>
            <td>{soggetto.note}</td>
            <td>{soggetto.email}</td>
            <td>{soggetto.codicefiscale}</td>
            <td><Button onClick={() => handleEdit(soggetto)}>Edit</Button></td>
            <td><Button onClick={() => handleDelete(soggetto)}>Delete</Button></td>
            </tr>
        )
    }

    return (
        <div class="container">
            <div class="row">
                <div class="col-sm-10 mx-auto text-center form p-4">
                <h1 class="display-5 py-2 text-truncate">Elenco Soggetti</h1>
                { showSuccessDeleteAlert && <Alert idx="1" variant="success">Soggetto eliminato con successo</Alert>}
                { showFailDeleteAlert && <Alert idx="2" variant="danger">Eliminazione Soggetto fallita</Alert> }
                    <Table striped condensed hover>
                        <thead>
                            <tr>
                            <th>Nome</th>
                            <th>Cognome</th>
                            <th>Luogo di Nascita</th>
                            <th>Data di Nascita</th>
                            <th>Indirizzo</th>
                            <th>CAP</th>
                            <th>Telfono</th>
                            <th>Sesso</th>
                            <th>Note</th>
                            <th>Email</th>
                            <th>Codice Fiscale</th>
                            <th>Modifica</th>
                            <th>Elimina</th>
                            </tr>
                        </thead>
                        <tbody>
                            {soggettiArray.map(renderSoggetti)}
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
                                    placeholder="Nome Soggetto"
                                    defaultValue=""
                                    value={name}
                                    onChange={e => setName(e.target.value)}
                                />
                                <Form.Text className="text-muted">
                                Inserisci il nome Soggetto
                                </Form.Text>
                            </Form.Group>
                            <Form.Group as={Row} controlId="formPlaintextName">
                                <Form.Label> Cognome </Form.Label>
                                <Form.Control
                                    type="text"
                                    placeholder="Cognome Soggetto"
                                    defaultValue=""
                                    value={cognome}
                                    onChange={e => setCognome(e.target.value)}
                                />
                                <Form.Text className="text-muted">
                                Inserisci il cognome Soggetto
                                </Form.Text>
                            </Form.Group>
                            <Form.Group as={Row} controlId="formPlaintextName">
                                <Form.Label> Luogo di nascita </Form.Label>
                                <Form.Control
                                    type="text"
                                    placeholder="Luogo di nascita"
                                    defaultValue=""
                                    value={luogonascita}
                                    onChange={e => setLuogonascita(e.target.value)}
                                />
                                <Form.Text className="text-muted">
                                Inserisci il Luogo di nascita Soggetto
                                </Form.Text>
                            </Form.Group>
                            <Form.Group as={Row} controlId="formPlaintextName">
                                <Form.Label> Data di nascita </Form.Label>
                                <Form.Control
                                    type="date"
                                    placeholder="Data di nascita"
                                    defaultValue=""
                                    value={datanascita}
                                    onChange={e => setDatanascita(e.target.value)}
                                />
                                <Form.Text className="text-muted">
                                Inserisci il Data di nascita Soggetto
                                </Form.Text>
                            </Form.Group>
                            <Form.Group as={Row} controlId="formPlaintextAddress">
                                <Form.Label> Indirizzo </Form.Label>
                                <Form.Control
                                    type="text"
                                    placeholder="Indirizzo Soggetto"
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
                                    placeholder="CAP Soggetto"
                                    defaultValue=""
                                    value={cap}
                                    onChange={e => setCap(e.target.value)}
                                />
                                <Form.Text className="text-muted">
                                Inserisci CAP es. "50122"
                                </Form.Text>
                                
                            </Form.Group>
                            <Form.Group as={Row} controlId="formPlaintextName">
                                <Form.Label> Telefono </Form.Label>
                                <Form.Control
                                    type="text"
                                    placeholder="Telefono"
                                    defaultValue=""
                                    value={telefono}
                                    onChange={e => setTelefono(e.target.value)}
                                />
                                <Form.Text className="text-muted">
                                Inserisci il Telefono Soggetto
                                </Form.Text>
                            </Form.Group>
                            <Form.Group as={Row} controlId="formPlaintextName">
                                <Form.Label> Sesso </Form.Label>
                                <Form.Control
                                    type="text"
                                    placeholder="M/F"
                                    defaultValue=""
                                    value={sesso}
                                    onChange={e => setSesso(e.target.value)}
                                />
                                <Form.Text className="text-muted">
                                Inserisci il sesso Soggetto es "F"
                                </Form.Text>
                            </Form.Group>
                            <Form.Group as={Row} controlId="formPlaintextName">
                                <Form.Label> Email </Form.Label>
                                <Form.Control
                                    type="text"
                                    placeholder="email@dominio.es"
                                    defaultValue=""
                                    value={email}
                                    onChange={e => setEmail(e.target.value)}
                                />
                                <Form.Text className="text-muted">
                                Inserisci Email Soggetto
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
                                Inserisci il Codice Fiscale Soggetto
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
                                Inserisci eventuali Note per il Soggetto
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

export default Soggetti;
