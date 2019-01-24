import React from 'react';
import Inventory from './Inventory';
import 'bootstrap/dist/css/bootstrap.css';

class InventoryList extends React.Component{
    
    render(){

        let inventories = this.props.inventories.map(inventory => <Inventory inventory={inventory}/>);

        return (
            <table className="table">
				<thead className="thead-dark">
					<tr>
						<th>Inventory Name</th>
						<th>Inventory Quantity</th>
						<th>Inventory Type</th>
					</tr>
				</thead>
				<tbody>
					{inventories}
				</tbody>
			</table>
		)
    }

}

export default InventoryList;