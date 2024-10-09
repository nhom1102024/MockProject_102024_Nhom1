import React, { useState } from "react";
import { Icon } from "@iconify/react";
import "../assets/scss/Header.css"; // Đảm bảo rằng đường dẫn đến file CSS của bạn là chính xác

const Header = () => {
  const [isDropdownOpen, setIsDropdownOpen] = useState(false);

  const toggleDropdown = () => {
    setIsDropdownOpen((prev) => !prev);
  };

  return (
    <header className="header">
      <div className="header-left">
        <Icon icon="mdi:menu" className="header-icon" /> {/* Menu icon */}
        <div className="search-container">
          <Icon icon="mdi:magnify" className="search-icon" />{" "}
          {/* Search icon */}
          <input
            type="text"
            placeholder="Search projects"
            className="search-bar"
          />
        </div>
      </div>
      <div className="header-right">
        <Icon icon="mdi:account-circle" className="header-icon" />{" "}
        {/* Account icon */}
        <span className="admin-name">Admin</span>
        <Icon
          icon="mdi:chevron-down"
          className="header-icon dropdown-icon"
          onClick={toggleDropdown}
        />{" "}
        {/* Dropdown icon */}
        <Icon icon="mdi:bell" className="header-icon" />{" "}
        {/* Notification icon */}
        <Icon icon="mdi:email" className="header-icon" /> {/* Email icon */}
      </div>
      {isDropdownOpen && (
        <div className="dropdown-menu">
          <div className="dropdown-item">Thông tin tài khoản</div>
          <div className="dropdown-item">Đăng xuất</div>
        </div>
      )}
    </header>
  );
};

export default Header;
