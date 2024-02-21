<script>
  import { createEventDispatcher, onMount } from 'svelte';
  import { Stomp } from '@stomp/stompjs';

  const URL = "ws://localhost:5001/alert-ws";
  let stompClient = null;
  let data = '';
  let message = '';
  const dispatch = createEventDispatcher();
  const subscribeToTopic = () => {
  const socket = new WebSocket(URL);
  stompClient = Stomp.over(socket);
  stompClient.connect({}, function() {
    stompClient.subscribe('/topic/alerts', function(alertMessage) {
      // Parse the message
      const content= JSON.parse(alertMessage.body).content;
      console.log("el conten tien",alertMessage.body);
      console.log('Mensaje recibido:', content);
      message = content;
      dispatch('messageReceived', { detail: { message: content } });
    });
    
    // Call the setConnected function with true to indicate connection success
    setConnected(true);
  }, function(err) {
    // Handle connection error
    console.error('Error: ', err);
  });
}


  onMount(() => {
    subscribeToTopic();
  });

  // Function to handle connection status
  function setConnected(connected) {
    console.log('Connected:', connected);
    // Implement your logic here to handle the connection status
    if (connected) {
      // Now that we're connected, send the initial data
      sendData();
    }
  }

  // Function to send data to the microservice
  function sendData() {
    stompClient.send('/app/alert', {}, JSON.stringify({ name: data }));
    console.log('Datos enviados:', data);
  }

  // Function to handle input change
  function handleInputChange(event) {
    data = event.target.value;
  }

  
</script>

<main>
  <h1>Enviar Datos al Microservicio</h1>
  <form on:submit|preventDefault={sendData}>
    <label for="data">Ingrese los Datos:</label>
    <input type="text" id="data" on:input={handleInputChange}>
    <button type="submit">Enviar</button>
  </form>
  {#if message}
    <div>
      <h2>Mensaje del Microservicio:</h2>
      <p>{message}</p>
    </div>
  {/if}
</main>

<style>
  main {
    text-align: center;
    padding: 20px;
  }

  form {
    margin-top: 20px;
  }

  input {
    margin-right: 10px;
  }
</style>
