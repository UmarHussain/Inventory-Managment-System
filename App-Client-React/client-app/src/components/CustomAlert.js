import React from 'react';
import { Alert } from "react-bootstrap";

export class CustomAlert extends React.Component {
  constructor(props) {
    super(props);
  }
  render() {

    if (this.props.show) {
      return (<Alert bsStyle={this.props.type}>
        <strong>{this.props.message}</strong>
      </Alert>);
    }
    return (<div></div>);
  }
}
