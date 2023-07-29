import React from 'react'


function ComponenteConEstado() {
    let [contador, setContador] = React.useState(1000)

    let incrementar = () => {
        contador++
        setContador(contador)
    }

    return (
        <>
            <button onClick={incrementar}>{"CONTADOR: " + contador}</button>
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

function App() {
    return (        
      <div className="App">        
        <body>
            <h1>EJEMPLO REACT</h1>
            <hr />
            <ComponenteExperimental />
            <ComponenteConEstado />
        </body>
      </div>
    );
  }
  
  export default App;