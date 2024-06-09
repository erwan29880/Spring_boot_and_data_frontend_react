import { Input } from './Input'
import { Trash } from "../icons/Icons";
import { useState } from 'react'
import { port } from '../config';

export function Table ({data, getData, err, setErr}) {

    const [loading, setLoading] = useState(false);

    const deleteById = async (id) => {
        await fetch("http://localhost:"+port+"/facture/" + id, {
            method: "DELETE",
            headers: {"Content-Type" : "application/json"}
        }).then(res => {
            console.log("API : REQUETE DELETE")
            if (res.status === 200) {
                setErr("élément supprimé")
            } else {
                setErr("Problème avec la suppression")
            }
            getData();

        })
    }
 
    const handleDelete = (id) => {
        setLoading(true);
        deleteById(id);
        setLoading(false);
    }

    return (
        <div className="width-full">
            {data.map((el, inc) => {
                return (
                <div className="display-flex-between margin-vetical" key={`ul${inc}`}>
                    <Input texte={el.prenom} inc={inc} numero={el.prenom} id={`${el.id}0`} />
                    <Input texte={el.nom} inc={inc} numero={el.nom} id={`${el.id}1`} />
                    <Input texte={el.id} inc={inc} numero={el.facture} id={`${el.id}2`} />
                    <button disabled={loading} className='btn-blue' onClick={() => handleDelete(el.id)}><Trash /></button>
                </div>
                )
            })}
        </div>
    )
}