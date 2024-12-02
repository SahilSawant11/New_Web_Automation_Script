import React, { useEffect, useState } from 'react';

function TestDashboard() {
  const [log, setLog] = useState('');
  const [testRunning, setTestRunning] = useState(false);
  const [ws, setWs] = useState(null);

  // Initialize WebSocket 
  useEffect(() => {

    const socket = new WebSocket('ws://localhost:8080/test-logs'); 

    socket.onopen = () => {
      console.log('WebSocket connection established');
    };

    socket.onmessage = (event) => {
      // Update the logs 
      setLog(prevLog => prevLog + '\n' + event.data);
    };

    socket.onclose = () => {
      console.log('WebSocket connection closed');
    };

    setWs(socket);

    return () => {
      if (socket) {
        socket.close();
      }
    };
  }, []);

    const handleRunTest = () => {

    if (ws) {
      ws.send('Start Test');
    }
    setTestRunning(true);
  };

  return (
    <div>
      <h2>Test Automation Dashboard</h2>
      <button onClick={handleRunTest} disabled={testRunning}>
        {testRunning ? 'Test Running...' : 'Run Test'}
      </button>
      <pre>{log}</pre>
    </div>
  );
}

export default TestDashboard;
