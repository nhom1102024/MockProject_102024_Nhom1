import React, { useState } from "react";
import "../assets/scss/Register.css";
import { Link } from "react-router-dom";

const Register = () => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [email, setEmail] = useState("");
  const [confirmPassword, setConfirmPassword] = useState(""); // Thêm state cho xác nhận mật khẩu
  const [errorMessage, setErrorMessage] = useState(""); //
  const handleRegister = () => {
    console.log("Register clicked");
    // Xử lý đăng ký tại đây
  };

  return (
    <div className="register-container">
      <h2>Đăng ký tài khoản</h2>
      <p>Tạo tài khoản để tiếp tục</p>
      <input
        type="text"
        placeholder="Username"
        value={username}
        onChange={(e) => setUsername(e.target.value)}
      />
      <input
        type="email"
        placeholder="Email"
        value={email}
        onChange={(e) => setEmail(e.target.value)}
      />
      <input
        type="password"
        placeholder="Password"
        value={password}
        onChange={(e) => setPassword(e.target.value)}
      />
      <input
        type="password"
        placeholder="Confirm Password"
        value={confirmPassword}
        onChange={(e) => setConfirmPassword(e.target.value)} // Thêm trường xác nhận mật khẩu
      />
      {errorMessage && <p className="error-message">{errorMessage}</p>}{" "}
      {/* Hiển thị thông báo lỗi nếu có */}
      <button className="register-button" onClick={handleRegister}>
        ĐĂNG KÝ
      </button>
      <p className="back-to-login">
        <Link to="/">Quay lại đăng nhập</Link>
      </p>
    </div>
  );
};

export default Register;
