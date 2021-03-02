import React, { useState, useEffect } from 'react';
import axios from "axios";
import { Row, Form, Button, Table, Alert} from "react-bootstrap";
import 'bootstrap/dist/css/bootstrap.min.css';

export function Incarichi(props) {
    const [postId, setPostId] = useState(null);

    const [id, setId] = useState(null);
    const [tipo, setTipo] = useState("");
    const [idAssicurazione, setIdAssicurazione] = useState("");
    const [idLiquidatore, setIdLiquidatore] = useState("");
    const [ambito, setAmbito] = useState("");
    const [idSoggetto, setIdSoggetto] = useState("");
    const [idAvvocato, setIdAvvocato] = useState("");
    const [nSinistro, setNSinistro] = useState("");
    const [idDottore, setIdDottore] = useState("");
    const [dataSinistro, setDataSinistro] = useState("");
    const [dataIncarico, setDataIncarico] = useState("");
    const [note, setNote] = useState("");

    const [tipoins, setTipoins] = useState('Inserisci nuovo');
    
    const requestOptions = {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ id: id, tipo: tipo, id_assicurazione: idAssicurazione,
            id_liquidatore: idLiquidatore, ambito: ambito, id_soggetto: idSoggetto,
            id_avvocato: idAvvocato, n_sinistro: nSinistro, id_dottore: idDottore,
            data_sinistro: dataSinistro, data_incarico: dataIncarico, note: note })
    };

    const [showSuccessAlert, isShowSuccessAlert]= useState(false);
    const [showFailAlert, isShowFailAlert]= useState(false);

    const [showSuccessDeleteAlert, isShowSuccessDeleteAlert]= useState(false);
    const [showFailDeleteAlert, isShowFailDeleteAlert]= useState(false);

    const handleSubmit = (evt) => {
        evt.preventDefault();
        fetch('http://localhost:8080/insert/incarico', requestOptions)
            .then(response => response.json())
            .then(json => {             
                isShowSuccessAlert(true);
                clearForm();
                fetchIncarichi();
              })
            .catch(err => {
                console.log(err);
                isShowFailAlert(true);
            });
    }
    const handleDelete = (incarico) => {
        var r = window.confirm(`Confermi di eliminare il incarico: ${incarico.nome} , ${incarico.cognome} `);
        if (r === true) {
            const deleteOptions = {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({ id: incarico.id, tipo: incarico.tipo, id_assicurazione: incarico.id_assicurazione,
                    id_liquidatore: incarico.id_liquidatore, ambito: incarico.ambito, id_soggetto: incarico.id_soggetto,
                    id_avvocato: incarico.id_avvocato, n_sinistro: incarico.n_sinistro, id_dottore: incarico.id_dottore,
                    data_sinistro: incarico.data_sinistro, data_incarico: incarico.data_incarico, note: incarico.note })
            };
            fetch('http://localhost:8080/delete/incarico/', deleteOptions)
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

    const handleEdit = (incarico) => {
        console.log("EDIT", incarico);
        setId(incarico.id);
        setTipo(incarico.tipo);
        setIdAssicurazione(incarico.id_assicurazione);
        setIdLiquidatore(incarico.id_liquidatore);
        setAmbito(incarico.ambito);
        setIdSoggetto(incarico.id_soggetto);
        setIdAvvocato(incarico.id_avvocato);
        setNSinistro(incarico.n_sinistro);
        setIdDottore(incarico.id_dottore);
        setDataSinistro(incarico.data_sinistro);
        setDataIncarico(incarico.data_incarico);
        setNote(incarico.note);

        setTipoins('Modifica Incarico');
    }

    const clearForm = () => {
        setId(null);

        setTipo("");
        setIdAssicurazione("");
        setIdLiquidatore("");
        setAmbito("");
        setIdSoggetto("");
        setIdAvvocato("");
        setNSinistro("");
        setIdDottore("");
        setDataSinistro("");
        setDataIncarico("");
        setNote("");

        setTipoins('Inserisci nuovo');
    }

    const [data, setData] = useState([]);
    const [dataAss, setDataAss] = useState([]);
    const [dataLiq, setDataLiq] = useState([]);
    const [dataSog, setDataSog] = useState([]);
    const [dataAvv, setDataAvv] = useState([]);
    const [dataDot, setDataDot] = useState([]);

    const fetchIncarichi = () => {
        axios.get("http://localhost:8080/fetch/incarichi").then( res => {
            console.log(res);
            setData(res.data);
        });
    };

    const fetchAssicurazioni = () => {
        axios.get("http://localhost:8080/fetch/assicurazioni").then( res => {
            console.log(res);
            setDataAss(res.data);
        });
    };

    const fetchLiquidatori = () => {
        axios.get("http://localhost:8080/fetch/liquidatori").then( res => {
            console.log(res);
            setDataLiq(res.data);
        });
    };

    const fetchSoggetti = () => {
        axios.get("http://localhost:8080/fetch/soggetti").then( res => {
            console.log(res);
            setDataSog(res.data);
        });
    };

    const fetchAvvocati = () => {
        axios.get("http://localhost:8080/fetch/avvocati").then( res => {
            console.log(res);
            setDataAvv(res.data);
        });
    };

    const fetchDottori = () => {
        axios.get("http://localhost:8080/fetch/dottori").then( res => {
            console.log(res);
            setDataDot(res.data);
        });
    };

    useEffect(() => {
        fetchIncarichi();
        fetchAssicurazioni();
        fetchLiquidatori();
        fetchSoggetti();
        fetchAvvocati();
        fetchDottori();
    }, []);

    let incarichiArray = data;
    let assicurazioniArray = dataAss;
    let liquidatoriArray = dataLiq;
    let soggettiArray = dataSog;
    let avvocatiArray = dataAvv;
    let dottoriArray = dataDot;

    const renderAssicurazioni = (assicurazione) => {
        return (
            <option value={assicurazione.id}>{assicurazione.nome}</option>
        )
    }

    const renderIncarichi = (incarico) => {
        return (
            <tr key={incarico.id}>
            <td>{incarico.tipo}</td>
            <td>{incarico.id_assicurazione}</td>
            <td>{incarico.id_liquidatore}</td>
            <td>{incarico.ambito}</td>
            <td>{incarico.id_soggetto}</td>
            <td>{incarico.id_avvocato}</td>
            <td>{incarico.n_sinistro}</td>
            <td>{incarico.id_dottore}</td>
            <td>{incarico.data_sinistro}</td>
            <td>{incarico.data_incarico}</td>
            <td>{incarico.note}</td>
            <td><Button onClick={() => handleEdit(incarico)}>Edit</Button></td>
            <td><Button onClick={() => handleDelete(incarico)}>Delete</Button></td>
            </tr>
        )
    }

    return (
        <div class="container">
            <div class="row">
                <div class="col-sm-10 mx-auto text-center form p-4">
                <h1 class="display-5 py-2 text-truncate">Elenco Incarichi</h1>
                { showSuccessDeleteAlert && <Alert idx="1" variant="success">Incarico eliminato con successo</Alert>}
                { showFailDeleteAlert && <Alert idx="2" variant="danger">Eliminazione Incarico fallita</Alert> }
                    <Table striped condensed hover>
                        <thead>
                            <tr>
                            <th>Tipo</th>
                            <th>Assicurazione</th>
                            <th>Liquidatore</th>
                            <th>Ambito</th>
                            <th>Soggetto</th>
                            <th>Avvocato</th>
                            <th>N. Sinistro</th>
                            <th>Dottore</th>
                            <th>Data Sinistro</th>
                            <th>Data Incarico</th>
                            <th>Modifica</th>
                            <th>Elimina</th>
                            </tr>
                        </thead>
                        <tbody>
                            {incarichiArray.map(renderIncarichi)}
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
                                <Form.Label> Tipo </Form.Label>
                                <Form.Control
                                    required
                                    type="text"
                                    placeholder="Tipo Incarico"
                                    defaultValue=""
                                    value={tipo}
                                    onChange={e => setTipo(e.target.value)}
                                />
                                <Form.Text className="text-muted">
                                Inserisci il tipo Incarico
                                </Form.Text>
                            </Form.Group>
                            <Form.Group controlId="exampleForm.SelectCustomSizeSm">
                                <Form.Label> Assicurazione </Form.Label>
                                <Form.Control
                                    as="select"
                                    value={idAssicurazione}
                                    onChange={e => setIdAssicurazione(e.target.value)}>
                                    {assicurazioniArray.map(renderAssicurazioni)}
                                </Form.Control>
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

export default Incarichi;
