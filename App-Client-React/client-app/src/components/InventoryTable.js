import React from 'react';
import InventoryList from './InventoryList';
import axios from 'axios';

class InventoryTable extends React.Component{

    constructor(props) {
		super(props);
		this.state = {inventories: []};
    }
    
    componentWillMount() {
        let headers = {
            'Content-Type': 'application/json',
            'Authorization': sessionStorage.getItem("jwtToken")
        };
        axios.post('http://localhost:8080/inventoryService/v1/search',{}, {headers : headers})
            .then(response => {
            this.setState({inventories : response.data.data});
        }).catch(err => {alert(err)});
    }
    
    render(){
        return (
            <div className="inventory-table">
			    <InventoryList inventories={this.state.inventories}/>
            </div>
		)
    }

}

export default InventoryTable;