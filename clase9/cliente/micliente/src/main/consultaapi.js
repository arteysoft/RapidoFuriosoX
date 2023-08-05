
export default async (dataToSend) => {
    const requestOptions = {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json', // Specify the data format you are sending
        },
        body: JSON.stringify(dataToSend), // Convert the JavaScript object to a JSON string
      };

    let url = '/api/opciones'

    let resp = await fetch(url, requestOptions)
    let enJson = await resp.json()
    return enJson;
}