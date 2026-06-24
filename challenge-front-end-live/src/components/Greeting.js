import { useState } from "react";

function Greeting({ name, message }) {
    const [messageState, setMessage] = useState(message);

    const changeMessage = () => {
        setMessage('GoodBye!')
    }
    return (
        <>
        <h2>Hi {name}!</h2>
        <p> {messageState} </p>
        <button onClick={changeMessage}> Change Message </button>
        </>
    )
}

export default Greeting;