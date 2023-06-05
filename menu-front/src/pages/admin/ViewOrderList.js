import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
export function ViewOrderList(){
    const [orders, setOrders] = useState([]);
    const getOrders = () => {
        fetch('api/main/orders/-1')
        .then(response => response.json())
        .then(jsonResponse => setOrders(jsonResponse));
    };
    useEffect(() => {
        getOrders();
    }, []);
    return (<div>
        
        <TableContainer component={Paper}>
      <Table sx={{ minWidth: 650 }} aria-label="simple table">
        <TableHead>
          <TableRow>
            <TableCell>Order</TableCell>
            <TableCell align="right">Ordered Meals</TableCell>
            <TableCell align="right">Confirmed</TableCell>
            <TableCell align="right">Confirm</TableCell>
            <TableCell align="right">Cancel</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {Object.entries(orders).map(([order, items]) => (
            <TableRow
              key={order}
              sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
            >
              <TableCell component="th" scope="row">
                {order.split(", ")[0].slice(10)}
              </TableCell>
              <TableCell align="right">{items.map((item) => (<li>{item.meal.title} Qty: {item.quantity}</li>))}</TableCell>
              <TableCell align="right">{(order.split(", ")[1] === 'confirmed=1)')? 'TRUE':'FALSE'}</TableCell>
              <TableCell align="right"><Link to={'/admin/confirmorder/'}>Confirm</Link></TableCell>
              <TableCell align="right"><Link to={'/admin/cancelorder/'}>Cancel</Link></TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
    </div>);
}