import { useState } from "react";
import { Button } from "@mui/material";
import "../assets/css/Login.css";

const users = {
  username: "hobadong",
  password: "123",
};

function Login() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  const handleLogin = () => {
    if (username === users.username && password === users.password) {
      alert("Đăng nhập thành công");
    } else {
      alert("Đăng nhập thành công");
    }
  };
  return (
    <div className="wrapper">
      <div className="login-wrapper">
        <div className="login">
          <div className="login-header">
            <p className="login-header__greeting">Xin chào! Bắt đầu nào</p>
            <p className="login-header__title">Đăng nhập để tiếp tục</p>
          </div>
          <div className="login-form">
            <div className="form-group">
              <input
                value={username}
                onChange={(e) => setUsername(e.target.value)}
                placeholder="Username"
              />
            </div>
            <div className="form-group">
              <input
                value={password}
                onChange={(e) => setPassword(e.target.value)}
                placeholder="Password"
              />
            </div>
          </div>
          <div className="login-footer">
            <div className="login-footer-btn">
              <Button onClick={handleLogin}>Đăng nhập</Button>
              <a href="#" className="login-footer__forgetpw">
                Forgot password?
              </a>
            </div>
            <div className="login-footer-homeback">
              <Button>Trang chủ</Button>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Login;
