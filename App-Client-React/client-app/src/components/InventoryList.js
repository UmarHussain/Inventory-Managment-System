import React from 'react';
import Inventory from './Inventory';

class InventoryList extends React.Component{
    
    render(){

        let inventories = this.props.inventories.map(inventory => <Inventory inventory={inventory}/>);

        return (
            <table border='1'>
				<tbody>
					<tr>
						<th>Inventory Name</th>
						<th>Inventory Quantity</th>
						<th>Inventory Type</th>
					</tr>
					{inventories}
				</tbody>
			</table>
		)
    }

}

export default InventoryList;