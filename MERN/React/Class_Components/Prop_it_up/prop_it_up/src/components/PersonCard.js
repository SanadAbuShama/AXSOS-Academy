import React from "react";

// Class components
/* class PersonCard extends Component {
  constructor(props) {
    super(props);
    this.state = {
      age: this.props.age,
    };
  }

  clickHandler = () => {
    const age = this.state.age;
    this.setState({ age: age + 1 });
  };

  render() {
    const { firstName, lastName, hairColor } = this.props;
    return (
      <>
        <h2>
          {lastName}, {firstName}
        </h2>
        <p>Age: {this.state.age}</p>
        <p>Hair Color: {hairColor}</p>
        <button onClick={this.clickHandler}>
          Birthday button for {firstName} {lastName}
        </button>
      </>
    );
  }
} */

const PersonCard = (props) => {
  return (
    <div>
      <h1>
        {props.lastName}, {props.firstName}
      </h1>
      <p>Age: {props.age}</p>
      <p>Hair Color: {props.hairColor}</p>
    </div>
  );
};

export default PersonCard;
