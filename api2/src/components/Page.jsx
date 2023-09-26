import { useState, useEffect } from "react";
import { Form } from "./Form";
import { Table } from './Table'
import { port } from '../config';

/**
 * page principale
 * @returns la page dans App
 */
export function Page () {

    const [data, setData] = useState([]);
    const [err, setErr] = useState("");

    const getData = async () => {
        await fetch("http://localhost:"+port+"/facture/all")
        .then(res => res.json())
        .then(res => {
            setData(res)
        })
    }

    useEffect(() => {
        getData();
    }, [])

    
    return (

        <div>
            <Form getData={getData} err={err} setErr={setErr}/>
            <Table data={data} getData={getData} err={err} setErr={setErr}/>
        </div>
    )
}