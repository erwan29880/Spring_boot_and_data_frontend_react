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
            if (res.status == 200) {
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
                    <Input texte={el.client3.prenom} inc={inc} numero={el.client3.prenom} id={`${el.numero}0`} />
                    <Input texte={el.client3.nom} inc={inc} numero={el.client3.nom} id={`${el.numero}1`} />
                    <Input texte={el.numero} inc={inc} numero={el.numero} id={`${el.numero}2`} />
                    <button disabled={loading} className='btn-blue' onClick={() => handleDelete(el.ordersId)}><Trash /></button>
                </div>
                )
            })}
        </div>
    )
}