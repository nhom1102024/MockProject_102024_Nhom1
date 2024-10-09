import React from "react";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";

import Login from "./components/Login";
import EditDebt from "./components/EditDebt";

function App() {
  return (
    <Router>
      <div className="App">
        <Routes>
          <Route path="/" element={<Login />} />
          <Route
            path="/debt"
            element={
              <>
                <EditDebt /> {}
              </>
            }
          />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
