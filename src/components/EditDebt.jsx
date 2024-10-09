import React, { useState } from "react";

import { Icon } from "@iconify/react";
import Header from "../parts/Header";
import SideBar from "../parts/SideBar";
import "../assets/scss/EditDebt.css";

const EditDebt = () => {
  const [name, setName] = useState("");
  const [serviceFee, setServiceFee] = useState("");
  const [paid, setPaid] = useState("");
  const [outstanding, setOutstanding] = useState("");

  const handleSubmit = (event) => {
    event.preventDefault();
    // Handle form submission here
    console.log("Name:", name);
    console.log("Service Fee:", serviceFee);
    console.log("Paid:", paid);
    console.log("Outstanding:", outstanding);
  };

  return (
    <div className="edit-debt">
      <div className="main-layout">
        <SideBar />
        <div className="right-section">
          <Header />
          <div className="tab-header">
            <span className="tab-title">Financial Management</span>
          </div>
          <div className="content">
            <h2>Edit Debt</h2>
            <form className="form-content" onSubmit={handleSubmit}>
              <div className="form-group">
                <div className="label" htmlFor="name">
                  Name:
                </div>
                <input
                  type="text"
                  id="name"
                  value={name}
                  onChange={(e) => setName(e.target.value)}
                />
              </div>
              <div className="form-group">
                <div className="label" htmlFor="serviceFee">
                  Service Fee:
                </div>
                <input
                  type="number"
                  id="serviceFee"
                  value={serviceFee}
                  onChange={(e) => setServiceFee(e.target.value)}
                />
              </div>
              <div className="form-group">
                <div className="label" htmlFor="paid">
                  Paid:
                </div>
                <input
                  type="number"
                  id="paid"
                  value={paid}
                  onChange={(e) => setPaid(e.target.value)}
                />
              </div>
              <div className="form-group">
                <div className="label" htmlFor="outstanding">
                  Outstanding:
                </div>
                <input
                  type="number"
                  id="outstanding"
                  value={outstanding}
                  onChange={(e) => setOutstanding(e.target.value)}
                />
              </div>
              <div className="button-click">
                <button type="button">Return</button>
                <button type="submit" className="btn-edit">
                  Edit
                </button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  );
};

export default EditDebt;
