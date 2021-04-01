import React, { useState, useEffect, Component } from 'react';
import axios from "axios";
import { Row, Form, Button, Table, Alert} from "react-bootstrap";
import 'bootstrap/dist/css/bootstrap.min.css';
import Moment from 'react-moment';
import 'moment-timezone';

import AsyncSelect from 'react-select/async';

export function Incarichi(props) {
    const [postId, setPostId] = useState(null);

    const [id, setId] = useState(null);
    const [numero_incarico, setNumeroIncarico] = useState("");
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
        body: JSON.stringify({ id: id, numero_incarico: numero_incarico, tipo: tipo, id_assicurazione: idAssicurazione,
            id_liquidatore: idLiquidatore, ambito: ambito, id_soggetto: idSoggetto,
            id_avvocato: idAvvocato, n_sinistro: nSinistro, id_dottore: idDottore,
            data_sinistro: dataSinistro, data_incarico: dataIncarico, note: note })
    };

    const [showSuccessAlert, isShowSuccessAlert]= useState(false);
    const [showFailAlert, isShowFailAlert]= useState(false);

    const [showSuccessDeleteAlert, isShowSuccessDeleteAlert]= useState(false);
    const [showFailDeleteAlert, isShowFailDeleteAlert]= useState(false);

    const handleSubmit = (evt) => {
        console.log(requestOptions);
        evt.preventDefault();
        fetch('http://localhost:8080/insert/incarico', requestOptions)
            .then(response => response.json())
            .then(json => {             
                isShowSuccessAlert(true);
                clearForm();
                fetchIncarichi();
              })
            .catch(err => {
                isShowFailAlert(true);
            });
    }
    const handleDelete = (incarico) => {
        var r = window.confirm(`Confermi di eliminare il incarico: ${incarico.nome} , ${incarico.cognome} `);
        if (r === true) {
            const deleteOptions = {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({ id: incarico.id, numero_incarico: incarico.numero_incarico, tipo: incarico.tipo, id_assicurazione: incarico.id_assicurazione,
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
        setNumeroIncarico(incarico.numero_incarico);
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
        setNumeroIncarico("");
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
            setDataAss(res.data);
        });
    };

    const fetchLiquidatori = () => {
        axios.get("http://localhost:8080/fetch/liquidatori").then( res => {
            setDataLiq(res.data);
        });
    };

    const fetchSoggetti = () => {
        axios.get("http://localhost:8080/fetch/soggetti").then( res => {
            setDataSog(res.data);
        });
    };

    const fetchAvvocati = () => {
        axios.get("http://localhost:8080/fetch/avvocati").then( res => {
            setDataAvv(res.data);
        });
    };

    const fetchDottori = () => {
        axios.get("http://localhost:8080/fetch/dottori").then( res => {
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

    const renderIncarichi = (incarico) => {
        return (
            <tr key={incarico.id}>
            <td>{incarico.numero_incarico}</td>
            <td>{incarico.tipo}</td>
            <td>{getNomeAssicurazione(incarico.id_assicurazione)}</td>
            <td>{getNomeLiquidatore(incarico.id_liquidatore)}</td>
            <td>{incarico.ambito}</td>
            <td>{getNomeSoggetto(incarico.id_soggetto)}</td>
            <td>{incarico.id_avvocato}</td>
            <td>{incarico.n_sinistro}</td>
            <td>{getNomeDottore(incarico.id_dottore)}</td>
            <td>
                <Moment format="DD/MM/YY">
                    {incarico.data_sinistro}
                </Moment>
            </td>
            <td>
                <Moment format="DD/MM/YY">
                    {incarico.data_incarico}
                </Moment>
            </td>
            <td>{incarico.note}</td>
            <td><Button onClick={() => handleEdit(incarico)}>Edit</Button></td>
            <td><Button onClick={() => handleDelete(incarico)}>Delete</Button></td>
            </tr>
        )
    }

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

    const getNomeLiquidatore = (id) => {
        const nome = "";
        for (let index = 0; index < dataLiq.length; index++) {
            const element = dataLiq[index].id;
            if(element === id){
                return dataLiq[index].cognome + " " + dataLiq[index].nome;
            }
        }
        return nome;
    };

    const getNomeSoggetto = (id) => {
        const nome = "";
        for (let index = 0; index < dataSog.length; index++) {
            const element = dataSog[index].id;
            if(element === id){
                return dataSog[index].cognome + " " + dataLiq[index].nome;
            }
        }
        return nome;
    };

    const getNomeDottore = (id) => {
        const nome = "";
        for (let index = 0; index < dataDot.length; index++) {
            const element = dataDot[index].id;
            if(element === id){
                return dataDot[index].cognome + " " + dataLiq[index].nome;
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
    
    const filterLiquidatori = (inputValue) => {
        return dataLiq.map((liquidatore, index) => (                                        
            { value: liquidatore.id, label: liquidatore.cognome + " " + liquidatore.nome }
        )).filter(i =>
          i.label.toLowerCase().includes(inputValue.toLowerCase())
        );
    };
    const loadLiquidatori = (inputValue, callback) => {
        setTimeout(() => {
          callback(filterLiquidatori(inputValue));
        }, 1000);
    };

    const filterSoggetti = (inputValue) => {
        return dataSog.map((soggetto, index) => (                                        
            { value: soggetto.id, label: soggetto.cognome + " " + soggetto.nome + " - " + soggetto.datanascita.substring(0, 10)}
        )).filter(i =>
          i.label.toLowerCase().includes(inputValue.toLowerCase())
        );
    };
    const loadSoggetti = (inputValue, callback) => {
        setTimeout(() => {
          callback(filterSoggetti(inputValue));
        }, 1000);
    };

    const filterAvvocati = (inputValue) => {
        return dataAvv.map((avvocato, index) => (                                        
            { value: avvocato.id, label: avvocato.cognome + " " + avvocato.nome }
        )).filter(i =>
          i.label.toLowerCase().includes(inputValue.toLowerCase())
        );
    };
    const loadAvvocati = (inputValue, callback) => {
        setTimeout(() => {
          callback(filterAvvocati(inputValue));
        }, 1000);
    };

    const filterDottori = (inputValue) => {
        return dataDot.map((dottore, index) => (                                        
            { value: dottore.id, label: dottore.cognome + " " + dottore.nome }
        )).filter(i =>
          i.label.toLowerCase().includes(inputValue.toLowerCase())
        );
    };
    const loadDottori = (inputValue, callback) => {
        setTimeout(() => {
          callback(filterDottori(inputValue));
        }, 1000);
    };

    const getSoggettoSelected = (idSoggetto) => {
        for (let index = 0; index < dataSog.length; index++) {
            if(dataSog[index].id === idSoggetto){
                return { value: dataSog[index].id, label: dataSog[index].cognome + " " + dataSog[index].nome + " - " + dataSog[index].datanascita.substring(0, 10)  }
            }
        }
        return ""
    };

    const getAssicurazioneSelected = (idAssicurazione) => {
        for (let index = 0; index < dataAss.length; index++) {
            if(dataAss[index].id === idAssicurazione){
                return { value: dataAss[index].id, label: dataAss[index].nome }
            }
        }
        return ""
    };

    const getLiquidatoreSelected = (idLiquidatore) => {
        for (let index = 0; index < dataLiq.length; index++) {
            if(dataLiq[index].id === idLiquidatore){
                return { value: dataLiq[index].id, label: dataLiq[index].cognome + " " + dataLiq[index].nome }
            }
        }
        return ""
    };

    const getAvvocatoSelected = (idAvvocato) => {
        for (let index = 0; index < dataAvv.length; index++) {
            if(dataAvv[index].id === idAvvocato){
                return { value: dataAvv[index].id, label: dataAvv[index].cognome + " " + dataAvv[index].nome }
            }
        }
        return ""
    };

    const getDottoreSelected = (idDottore) => {
        for (let index = 0; index < dataDot.length; index++) {
            if(dataDot[index].id === idDottore){
                return { value: dataDot[index].id, label: dataDot[index].cognome + " " + dataDot[index].nome }
            }
        }
        return ""
    };

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
                            <th>Numero Incarico</th>
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
                                <Form.Label> Numero Incarico </Form.Label>
                                <Form.Control
                                    type="text"
                                    placeholder="es. 0000/2020"
                                    defaultValue=""
                                    value={numero_incarico}
                                    onChange={e => setNumeroIncarico(e.target.value)}
                                    disabled
                                />
                                <Form.Text className="text-muted">
                                Numero incarico autogenerato in fase di inserimento
                                </Form.Text>
                            </Form.Group>
                            <Form.Group as={Row} controlId="formPlaintextName">
                                <Form.Label> Tipo </Form.Label>
                                <Form.Control
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

                            <Form.Group as={Row} controlId="formPlaintextName">
                                <Form.Label> Ambito </Form.Label>
                                <Form.Control
                                    type="text"
                                    placeholder="Ambito Incarico"
                                    defaultValue=""
                                    value={ambito}
                                    onChange={e => setAmbito(e.target.value)}
                                />
                                <Form.Text className="text-muted">
                                Inserisci ambito Incarico
                                </Form.Text>
                            </Form.Group>

                            <Form.Group as={Row} controlId="formPlaintextName">
                                <Form.Label> Numero Sinistro </Form.Label>
                                <Form.Control
                                    type="text"
                                    placeholder="N. Sinistro"
                                    defaultValue=""
                                    value={nSinistro}
                                    onChange={e => setNSinistro(e.target.value)}
                                />
                                <Form.Text className="text-muted">
                                Inserisci numero Sinistro
                                </Form.Text>
                            </Form.Group>
                            <Form.Group as={Row} controlId="formPlaintextName">
                                <Form.Label> Data Sinistro </Form.Label>
                                <Form.Control
                                    type="date"
                                    placeholder="Data Sinistro"
                                    defaultValue=""
                                    value={dataSinistro}
                                    onChange={e => setDataSinistro(e.target.value)}
                                />
                                <Form.Text className="text-muted">
                                Inserisci la Data Sinistro
                                </Form.Text>
                            </Form.Group>
                            <Form.Group as={Row} controlId="formPlaintextName">
                                <Form.Label> Data Incarico </Form.Label>
                                <Form.Control
                                    type="date"
                                    placeholder="Data Incarico"
                                    defaultValue=""
                                    value={dataIncarico}
                                    onChange={e => setDataIncarico(e.target.value)}
                                />
                                <Form.Text className="text-muted">
                                Inserisci la Data Incarico
                                </Form.Text>
                            </Form.Group>
                            <Form.Group controlId="exampleForm.SelectCustomSizeSm">
                                <Form.Label> Soggetto </Form.Label>
                                <AsyncSelect
                                    cacheOptions
                                    placeholder="Seleziona Soggetto"
                                    loadOptions={loadSoggetti}
                                    defaultOptions={dataSog.map((soggetto, index) => (                                        
                                        { value: soggetto.id, label: soggetto.cognome + " " + soggetto.nome + " - " + soggetto.datanascita.substring(0, 10) }
                                    ))}
                                    value={getSoggettoSelected(idSoggetto)}
                                    onChange={e => setIdSoggetto(e.value)}
                                />
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

                            <Form.Group controlId="exampleForm.SelectCustomSizeSm">
                                <Form.Label> Liquidatore </Form.Label>
                                <AsyncSelect
                                    cacheOptions
                                    placeholder="Seleziona Liquidatore"
                                    loadOptions={loadLiquidatori}
                                    defaultOptions={dataLiq.map((liquidatore, index) => (                                        
                                        { value: liquidatore.id, label: liquidatore.cognome + " " + liquidatore.nome }
                                    ))}
                                    value={getLiquidatoreSelected(idLiquidatore)}
                                    onChange={e => setIdLiquidatore(e.value)}
                                />
                            </Form.Group>

                            <Form.Group controlId="exampleForm.SelectCustomSizeSm">
                                <Form.Label> Avvocato </Form.Label>
                                <AsyncSelect
                                    cacheOptions
                                    placeholder="Seleziona Avvocato"
                                    loadOptions={loadAvvocati}
                                    defaultOptions={dataAvv.map((avvocato, index) => (                                        
                                        { value: avvocato.id, label: avvocato.cognome + " " + avvocato.nome }
                                    ))}
                                    value={getAvvocatoSelected(idAvvocato)}
                                    onChange={e => setIdAvvocato(e.value)}
                                />
                            </Form.Group>

                            <Form.Group controlId="exampleForm.SelectCustomSizeSm">
                                <Form.Label> Dottore </Form.Label>
                                <AsyncSelect
                                    cacheOptions
                                    placeholder="Seleziona Dottore"
                                    loadOptions={loadDottori}
                                    defaultOptions={dataDot.map((dottore, index) => (                                        
                                        { value: dottore.id, label: dottore.cognome + " " + dottore.nome }
                                    ))}
                                    value={getDottoreSelected(idDottore)}
                                    onChange={e => setIdDottore(e.value)}
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

export default Incarichi;
