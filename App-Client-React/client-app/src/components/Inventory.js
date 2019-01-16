const React = require('react');

class Inventory extends React.Component{
    render() {
		return (
			<tr>
				<td>{this.props.inventory.name}</td>
				<td>{this.props.inventory.quantity}</td>
				<td>{this.props.inventory.inventoryType}</td>
			</tr>
		)
	}
}

export default Inventory;