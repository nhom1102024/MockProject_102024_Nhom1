import React, { useState } from "react";
import { Link } from "react-router-dom";
import "../assets/scss/LoginForm.css";

const LoginForm = () => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState("");
  const [successMessage, setSuccessMessage] = useState("");

  const hardcodedUsername = "admin";
  const hardcodedPassword = "123";

  const handleLogin = () => {
    console.log("Button clicked");
    if (username === hardcodedUsername && password === hardcodedPassword) {
      setSuccessMessage("Đăng nhập thành công!");
      setError("");
      // Có thể chuyển hướng đến dashboard hoặc trang khác ở đây
    } else {
      setError("Tên đăng nhập hoặc mật khẩu không đúng!");
      setSuccessMessage("");
      console.log("Login failed");
    }
  };

  const handleForgotPassword = () => {
    console.log("Forgot password clicked");
  };

  return (
    <div className="login-container">
      <h2>Xin chào! Bắt đầu nào</h2>
      <p>Đăng nhập để tiếp tục</p>
      {error && <p className="error-message">{error}</p>}
      {successMessage && (
        <p className="success-message">{successMessage}</p>
      )}{" "}
      {/* Hiển thị thông báo thành công */}
      <input
        type="text"
        placeholder="Username"
        value={username}
        onChange={(e) => setUsername(e.target.value)}
      />
      <input
        type="password"
        placeholder="Password"
        value={password}
        onChange={(e) => setPassword(e.target.value)}
      />
      <button className="login-button" onClick={handleLogin}>
        ĐĂNG NHẬP
      </button>
      <div className="extra-options">
        <p className="forgot-password" onClick={handleForgotPassword}>
          Quên mật khẩu?
        </p>
        <span> | </span>
        <Link to="/register" className="register-link">
          Đăng ký tài khoản
        </Link>
      </div>
      <button className="home-button">TRANG CHỦ</button>
    </div>
  );
};

export default LoginForm;
