import React from "react";
import { useFormik } from "formik";
import * as Yup from "yup";

import "./Login.css";

const Login = () => {
  const formik = useFormik({
    initialValues: {
      email: "",
      password: "",
    },
    validationSchema: Yup.object({
      email: Yup.string().email("Invalid email address").required("Required"),
      password: Yup.string()
        .min(6, "Password must be at least 6 characters")
        .required("Required"),
    }),
    onSubmit: (values) => {
      alert(JSON.stringify(values, null, 2));
      history.push("/dashboard");
    },
  });

  return (
    <div className="wrapper">
      <div className="login-container">
        <div className="login-heading">
          <h2 className="heading">Xin Chào! Bắt đầu nào</h2>
          <h3 className="title">Đăng nhập để tiếp tục</h3>
        </div>
        <form onSubmit={formik.handleSubmit} className="form-control">
          <div className="inputGroup">
            <input
              id="email"
              name="email"
              type="email"
              placeholder="Username"
              onChange={formik.handleChange}
              onBlur={formik.handleBlur}
              value={formik.values.email}
              className="input"
            />
            {formik.touched.email && formik.errors.email ? (
              <div className="error">{formik.errors.email}</div>
            ) : null}
          </div>
          <div className="inputGroup">
            <input
              id="password"
              name="password"
              type="password"
              placeholder="Password"
              onChange={formik.handleChange}
              onBlur={formik.handleBlur}
              value={formik.values.password}
              className="input"
            />
            {formik.touched.password && formik.errors.password ? (
              <div className="error">{formik.errors.password}</div>
            ) : null}
          </div>
          <button type="submit" className="button">
            Login
          </button>
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
