import { useEffect, useState } from "react";
import consultaapi from "./consultaapi";
import "./opciones.css"


function BotonRefrescar(props) {
    let [huboCambios, setHuboCambios] = useState(false)
    
    useEffect(() => {
        consultaapi({
            "tipo" : "call",
            "vencimiento" : "ago",
            "precio" : 14.51,
            "strike" : "10000",
            "ccl" : props.dolar
        })
        .then(z => {
            props.setterFunction(z)
        })
        .catch(err => {
            console.log(err)
        })
    }, [huboCambios])

    window.disparar = () => setHuboCambios(!huboCambios)
    window.ver = () => console.log(huboCambios)

    return (
        <button onClick={() => setHuboCambios(!huboCambios)}>Calcular</button>
    )
}

function PrecioVolatilidad(props) {

    return props.datos.map(z => (
        <tr key={z*z.volatilidad}>
            <td>{z.precio}</td>
            <td>{z.volatilidad}</td>
        </tr>
    ))
}

function DatosOpciones(props) {
    return (
        <>
        <table className="tablaOpciones">
            <thead>
                <tr>
                    <td>Precio</td>
                    <td>Volatilidad</td>
                </tr>
            </thead>
            <tbody>
                <PrecioVolatilidad datos={props.datos} />
            </tbody>
        </table>
        </>
    )
}

function EntradaDolar(props) {
    let [valorDolar, setValorDolar] = useState(500)

    let actualizar = e => {
        setValorDolar(e.target.value)
        props.setterFunction(e.target.value)
    }

    return (
        <><input className="entradaDolar" type="text" onChange={actualizar} value={valorDolar} /></>
    )
}

function Opciones(props) {
    let [datosOpciones, setDatosOpciones] = useState([])
    let [valorDolar, setValorDolar] = useState(500)

    return (
        <>        
        <BotonRefrescar setterFunction={setDatosOpciones} dolar={valorDolar} />
        <EntradaDolar setterFunction={setValorDolar} />
        <DatosOpciones datos={datosOpciones} />
        </>
    )
}

export default Opciones