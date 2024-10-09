import React, { useState } from "react";
import { Router } from "react-router-dom";
import { useNavigate } from "react-router-dom";

import "./Login.css";

const Login = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState("");
  const navigate = useNavigate();

  const hardCodedEmail = "admin@gmail.com";
  const hardCodedPassword = "123456";

  const handleLogin = (e) => {
    e.preventDefault();
    if (email === hardCodedEmail && password === hardCodedPassword) {
      navigate("/debt");
    } else {
      setError("Email or password is incorrect");
    }
  };

  return (
    <div className="wrapper">
      <div className="login-container">
        <div className="login-heading">
          <h2 className="heading">Xin Chào! Bắt đầu nào</h2>
          <h3 className="title">Đăng nhập để tiếp tục</h3>
        </div>
        <form onSubmit={handleLogin} className="form-control">
          <div className="inputGroup">
            <input
              id="email"
              name="email"
              type="email"
              required
              placeholder="Username"
              onChange={(e) => setEmail(e.target.value)}
              className="input"
            />
          </div>
          <div className="inputGroup">
            <input
              id="password"
              name="password"
              type="password"
              required
              placeholder="Password"
              onChange={(e) => setPassword(e.target.value)}
              className="input"
            />
          </div>
          <button type="submit" className="button" onClick={handleLogin}>
            Login
          </button>
          {error && <p className="error">{error}</p>}
        </form>
        <div className="login-footer">
          <a href="#" className="forgot-pass">
            Forgot password?
          </a>
          <a type="submit" className="button">
            Home
          </a>
        </div>
      </div>
    </div>
  );
};

export default Login;
