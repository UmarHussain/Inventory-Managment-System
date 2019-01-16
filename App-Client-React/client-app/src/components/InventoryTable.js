import React from 'react';
import InventoryList from './InventoryList';
import axios from 'axios';

class InventoryTable extends React.Component{

    constructor(props) {
		super(props);
		this.state = {inventories: []};
    }
    
    componentDidMount() {
        axios.post('http://localhost:8080/inventoryService/v1/search',{}).then(response => {
            this.setState({inventories : response.data.data});
        });
    }
    
    render(){
        return (
			<InventoryList inventories={this.state.inventories}/>
		)
    }

}

export default InventoryTable;