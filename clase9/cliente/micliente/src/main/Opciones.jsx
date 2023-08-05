import { useEffect, useState } from "react";
import consultaapi from "./consultaapi";

function Opciones(props) {
    let [huboCambios, setHuboCambios] = useState(false)

    useEffect(() => {
        consultaapi({
            "tipo" : "put",
            "vencimiento" : "oct",
            "precio" : "14.35",
            "strike" : "9700",
            "ccl" : "583"
        })
        .then(z => {
            console.log(z)
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

export default Opciones