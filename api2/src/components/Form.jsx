import { Input } from './Input'
import { useState } from 'react';
import { port } from '../config';

export function Form ({getData, err, setErr}) {

    const [loading, setLoading] = useState(false);

    const postData = async (pdata) => {
        await fetch("http://localhost:"+port+"/facture/", {
            method: 'POST',
            body: JSON.stringify(pdata),
            headers: {'Content-Type' : 'application/json'}
        })
        .then(res => res.json())
        .then(res => {
            res.erreur !== null ? setErr(res.erreur)
            : setErr("facture enregistrée !")
            getData();
        })
    }

    const handleSubmit = (e) => {
        e.preventDefault();
        setLoading(true);
        const pdata = {
            numero: e.target[2].value,
            client3: {
                nom: e.target[1].value,
                prenom: e.target[0].value
            }
        }
        postData(pdata)
        e.target[0].value = "";
        e.target[1].value = "";
        e.target[2].value = "";
        setLoading(false);
    }


    return (

        <div className="margin-bottom-2">

            <form onSubmit={handleSubmit}>

                <div className="form-group">
                    <label htmlFor="prenom">Prénom</label>
                    <Input texte="" inc="form" numero="0" id="prenom"/>
                </div>

                <div className="form-group">
                    <label htmlFor="nom">Nom</label>
                    <Input texte="" inc="form" numero="1" id="nom"/>
                </div>

                <div className="form-group">
                    <label htmlFor="numero">Numéro de facture</label>
                    <Input texte="" inc="form" numero="2" id="numero"/>
                </div>

                <button type="submit" disabled={loading} className="btn-blue">valider</button>

            </form>

            {err !== "" ? <div className="alert-warning">{err}</div> : ""}

        </div>

    )
}