import { useState } from "react";

function CuadroText(props) {
    return (
      <>
        <label htmlFor={props.pId}>{props.pTexto}</label>        
        <input type="text" onChange={e => props.setEstado(e.target.value)} id={props.pId} placeholder="ingrese valor" />
        <br /><br />
      </>
    );
}

function RadioButton(props) {
    return (
      <>
        <input type="radio" onChange={e => props.setOperacion(e.target.value)} name={props.pOperation} id={props.pAction} value={props.pValue} />
        <label htmlFor={props.pAction}>{props.pAction}</label>
        <br />
      </>
    );
}
  


export default function Calcular() {
    let [operacion, setOperation] = useState('+')
    let [estadoComp1, setEstadoComp1] = useState(0)
    let [estadoComp2, setEstadoComp2] = useState(0)
    let [resultado, setResultado] = useState('0')

    let setResultadoWrapper = () => {        
        console.log(operacion)

        let iEstadoComp1 = parseInt(estadoComp1)
        let iEstadoComp2 = parseInt(estadoComp2)

        switch (operacion) {
            case '+':
                setResultado(iEstadoComp1 + iEstadoComp2)
                break
            case '-':
                setResultado(iEstadoComp1 - iEstadoComp2)
                break
            case '*':
                setResultado(iEstadoComp1 * iEstadoComp2)
                break
            case '%':
                setResultado(iEstadoComp1 / iEstadoComp2)
                break
        }
    }
        

    return (
        <>
        <CuadroText pId="nro1" setEstado={setEstadoComp1}  pTexto="Primer Valor: " />
        <RadioButton pOperation="operation" setOperacion={setOperation} pAction="sumar" pValue="+" />
        <RadioButton pOperation="operation" setOperacion={setOperation} pAction="restar" pValue="-" />
        <RadioButton pOperation="operation" setOperacion={setOperation} pAction="multiplicar" pValue="*" />
        <RadioButton pOperation="operation" setOperacion={setOperation} pAction="dividir" pValue="%" />
        <br />
        <CuadroText pId="nro2" setEstado={setEstadoComp2} pTexto="Segundo Valor: " />

        <button onClick={setResultadoWrapper}>Calcular</button>
        <br />
        <label htmlFor="result">{resultado}</label>
        </>
    );
}

