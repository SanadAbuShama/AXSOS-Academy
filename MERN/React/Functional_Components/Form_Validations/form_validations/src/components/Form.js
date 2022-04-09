import React, { useReducer } from "react";
const initialState = {
  firstName: {
    value: "",
    error: null,
  },
  lastName: {
    value: "",
    error: null,
  },
  email: {
    value: "",
    error: null,
  },
};

function reducer(state, action) {
  return {
    ...state,
    [action.type]: action.payload,
  };
}
const Form = () => {
  const [state, dispatch] = useReducer(reducer, initialState);
  function handleChange(e) {
    let error = "";
    const { name, value } = e.target;
    if (name === "firstName") {
      error = firstNameValidator(value);
    } else if (name === "lastName") {
      error = lastNameValidator(value);
    } else if (name === "email") {
      error = emailValidator(value);
    }
    dispatch({
      type: name,
      payload: { value, error },
    });
  }

  const firstNameValidator = (value) => {
    if (value.length < 4) {
      return "First name must be at least 4 characters!";
    }
  };
  const lastNameValidator = (value) => {
    if (value.length < 4) {
      return "Last name must be at least 4 characters!";
    }
  };

  const emailValidator = (value) => {
    const mailformat = /^\w+([\\.-]?\w+)*@\w+([\\.-]?\w+)*(\.\w{2,3})+$/;
    if (!value.match(mailformat)) {
      return "Please enter a valid email!";
    }
  };

  return (
    <div className="container my-5">
      <div className="row">
        <div className="col-6 offset-3">
          <form>
            <div class="mb-3">
              {state.firstName.error !== null && (
                <p className="text-danger">{state.firstName.error}</p>
              )}
              <input
                type="text"
                className="form-control"
                placeholder="First Name"
                name="firstName"
                value={state.firstName.value}
                onChange={handleChange}
              />
            </div>
            <div class="mb-3">
              {state.lastName.error !== null && (
                <p className="text-danger">{state.lastName.error}</p>
              )}
              <input
                type="text"
                className="form-control"
                placeholder="Last Name"
                name="lastName"
                value={state.lastName.value}
                onChange={handleChange}
              />
            </div>
            <div class="mb-3">
              {state.email.error !== null && (
                <p className="text-danger">{state.email.error}</p>
              )}
              <input
                type="email"
                className="form-control"
                placeholder="example@example.com"
                name="email"
                value={state.email.value}
                onChange={handleChange}
              />
            </div>
            <button type="button" class="btn btn-primary float-start">
              Submit
            </button>
          </form>
        </div>
      </div>
    </div>
  );
};

export default Form;
