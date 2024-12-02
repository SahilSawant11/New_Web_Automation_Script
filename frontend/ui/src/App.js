import React from 'react';
import './App.css';
import TestDashboard from './components/TestDashboard'; // Import the TestDashboard component

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <h1>Test Automation Dashboard</h1>
        <p>Run test suites and get results here</p>
      </header>

      
      <TestDashboard />
    </div>
  );
}

export default App;
