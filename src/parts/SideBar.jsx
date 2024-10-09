import React, { useState } from "react";
import { Icon } from "@iconify/react";
import "../assets/scss/SideBar.css"; // Đường dẫn CSS
import logoImage from "../assets/img/logo192.png"; // Đường dẫn hình ảnh logo

const SideBar = () => {
  const [isAssetManagementOpen, setIsAssetManagementOpen] = useState(false);

  const toggleAssetManagement = () => {
    setIsAssetManagementOpen((prev) => !prev);
  };

  return (
    <div className="sidebar">
      <h2>
        <img
          src={logoImage}
          alt="Logo"
          style={{ width: "40px", height: "40px", marginRight: "10px" }} // Style cho logo
        />
        Apartment
      </h2>
      <ul>
        <li>Home Page</li>
        <li>Financial Management</li>
        <li>Human Resources Management</li>
        <li>
          {/* Bấm vào Asset Management để mở rộng danh sách con */}
          <div
            onClick={toggleAssetManagement}
            style={{ cursor: "pointer", display: "flex", alignItems: "center" }}
          >
            Asset Management
            <Icon
              icon={
                isAssetManagementOpen ? "mdi:chevron-down" : "mdi:chevron-right"
              }
              className="sidebar-icon"
              style={{ marginLeft: "10px" }}
            />
          </div>
          {isAssetManagementOpen && (
            <ul>
              <li>Building Information</li>
              <li>Technical Systems</li>
              <li>Service Contracts</li>
              <li>Company Maintenance</li>
            </ul>
          )}
        </li>
      </ul>
    </div>
  );
};

export default SideBar;
