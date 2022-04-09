import React, { useState } from "react";

const UserForm = (props) => {
  const [firstName, setFirstname] = useState("");
  const [firstNameError, setFirstnameError] = useState("");
  const [lastName, setLastname] = useState("");
  const [lastNameError, setLastnameError] = useState("");
  const [email, setEmail] = useState("");
  const [emailError, setEmailError] = useState("");
  const [password, setPassword] = useState("");
  const [passwordError, setPasswordError] = useState("");
  const [confirmPassword, setConfirmpassword] = useState("");
  const [confirmPasswordError, setConfirmPasswordError] = useState("");

  const firstNameHandler = (e) => {
    setFirstname(e.target.value);
    if (e.target.value.length === 0 || e.target.value.length >= 2) {
      setFirstnameError("");
    } else if (e.target.value.length < 2) {
      setFirstnameError("First name must be at least 2 characters!");
    }
  };
  const lastNameHandler = (e) => {
    setLastname(e.target.value);
    if (e.target.value.length === 0 || e.target.value.length >= 2) {
      setLastnameError("");
    } else if (e.target.value.length < 2) {
      setLastnameError("Last name must be at least 2 characters!");
    }
  };

  const emailHandler = (e) => {
    setEmail(e.target.value);
    if (e.target.value.length === 0 || e.target.value.length >= 5) {
      setEmailError("");
    } else if (e.target.value.length < 5) {
      setEmailError("Email must be at least 5 characters!");
    }
  };

  const passwordHandler = (e) => {
    setPassword(e.target.value);

    if (e.target.value.length === 0 || e.target.value.length >= 8) {
      setPasswordError("");
    } else if (e.target.value.length < 8) {
      setPasswordError("Password must be at least 8 characters!");
    }
  };

  const confirmPasswordHandler = (e) => {
    setConfirmpassword(e.target.value);
    if (e.target.value.length === 0 || confirmPassword === password) {
      setConfirmPasswordError("");
    } else if (password !== confirmPassword) {
      setConfirmPasswordError("Passwords must match!");
    }
  };

  return (
    <>
      <form>
        {firstNameError ? <p style={{ color: "red" }}>{firstNameError}</p> : ""}
        <div>
          <label>First Name: </label>
          <input type="text" onChange={firstNameHandler} />
        </div>
        <div>
          {lastNameError ? <p style={{ color: "red" }}>{lastNameError}</p> : ""}
          <label>Last Name: </label>
          <input type="text" onChange={lastNameHandler} />
        </div>

        <div>
          {emailError ? <p style={{ color: "red" }}>{emailError}</p> : ""}
          <label>Email Address: </label>
          <input type="text" onChange={emailHandler} />
        </div>

        <div>
          {passwordError ? <p style={{ color: "red" }}>{passwordError}</p> : ""}
          <label>Password: </label>
          <input type="password" onChange={passwordHandler} />
        </div>
        <div>
          {confirmPasswordError ? (
            <p style={{ color: "red" }}>{confirmPasswordError}</p>
          ) : (
            ""
          )}
          <label>Confirm Password: </label>
          <input type="password" onChange={confirmPasswordHandler} />
        </div>
      </form>
      <div>
        <h4>Form Data:</h4>
        <p>First name: {firstName}</p>
        <p>Last Name: {lastName}</p>
        <p>Email: {email}</p>
        <p>Password: {password}</p>
        <p>Confirm Password: {confirmPassword}</p>
      </div>
    </>
  );
};

export default UserForm;
