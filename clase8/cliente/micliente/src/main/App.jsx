import React, {useState} from 'react'

function ContadorConSalto(props) {
    let {salto} = props // destructuring
    let [contador, setContador] = React.useState(props.valorInicial)

    let incrementar = () => {
        contador += salto
        setContador(contador)
    }

    return (
        <>
            <button onClick={incrementar}>{"CONTADOR: " + contador}</button>
        </>
    )
}

function ComponenteConEstado(props) {
    return (
        <>
            <ContadorConSalto valorInicial={props.valorInicial} salto={1} />
        </>
    )
}

function ComponenteExperimental() {
    return (
        <>
            <h3>mi primer componente</h3>
            <h3>es muy lindo</h3>
        </>
    )
}


function ParametroCallPut() {
    const [selectedOption, setSelectedOption] = useState('call');

    let CrearJSX = () => <h1>ESTA ES LA OPCION SELECCIONADA</h1>

    let handleSelectChange = (event) => {
        setSelectedOption(event.target.value)
    }

    return (
        <>
            <label htmlFor="mySelect">Select an option:</label>
            <select id="mySelect" value={selectedOption} onChange={handleSelectChange}>
                <option value="call">CALL</option>
                <option value="put">PUT</option>
            </select>
            <p>Selected Option: {selectedOption}</p>
            <CrearJSX />
        </>
    )
}

function Vencimiento() {
    const [selectedOption, setSelectedOption] = useState('ago');

    let handleSelectChange = (event) => {
        setSelectedOption(event.target.value)
    }

    return (
        <>
            <label>vencimiento:</label>
            <select value={selectedOption} onChange={handleSelectChange}>
                <option value="ago">ago</option>
                <option value="oct">oct</option>
                <option value="dic">dic</option>
                <option value="feb">feb</option>
            </select>
            <p>Selected Option: {selectedOption}</p>
        </>
    )
}

function Precio(props) {
    const [precio, setearPrecio] = useState(props.precioInicial)

    let incrementar = () => {}
    let decrementar = () => {}
    let cambiarForma1 = (signo) => () => {
        if (signo === '+') {
            setearPrecio(precio + 1)
            return
        }
        if (signo === '-') {
            setearPrecio(precio - 1)
            return
        }
        alert('Esta mal la configuracion')
    }

    function cambiarForma1OtraSintaxis(signo) {
        return function() {
            if (signo === '+') {
                alert('subo')
                return
            }
            if (signo === '-') {
                alert('bajo')
                return
            }
            alert('Esta mal la configuracion')
        }
    }

    return (
        <>
            <label>precio: {precio}</label>
            <label>precio: {precio}</label>
            <label>precio: {precio}</label>
            <label>precio: {precio}</label>
            <label>precio: {precio}</label>
            <button onClick={cambiarForma1('+')}>{"SUBIR"}</button>
            <button onClick={cambiarForma1('-')}>{"BAJAR"}</button>
        </>
    )

}


function ParametrosOpciones() {
    return (
        <>
            <ParametroCallPut />
            <Vencimiento />
            <Precio precioInicial={8000} />
        </>
    )
}

function App() {
    return (        
      <div className="App">        
        <body>
            <h1>Ejemplo opciones</h1>
            <hr />

            <ComponenteExperimental />
            <ComponenteConEstado valorInicial={5 + 6} />
            <ComponenteConEstado valorInicial={1000} />
            <ComponenteConEstado valorInicial={2000} />
            <ComponenteConEstado valorInicial={5 + 6} />
            <ComponenteConEstado valorInicial={7000} />
            <ContadorConSalto valorInicial={10000} salto={3} />
            <ContadorConSalto valorInicial={10000} salto={10} />
            <ContadorConSalto valorInicial={10000} salto={100} />
            <hr />
            <ParametrosOpciones />
        </body>
      </div>
    );
  }
  
  export default App;