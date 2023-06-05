import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
export function ViewMenuList(){
    const [menus, setMenus] = useState([]);
    const getMenus = () => {
        fetch('api/main/menu')
        .then(response => response.json())
        .then(jsonResponse => setMenus(jsonResponse));
    };
    useEffect(() => {
        getMenus();
    }, []);
    return (<div>
        <TableContainer component={Paper}>
      <Table sx={{ minWidth: 650 }} aria-label="simple table">
        <TableHead>
          <TableRow>
            <TableCell>Title</TableCell>
            <TableCell align="right">Edit</TableCell>
            <TableCell align="right">Delete</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {menus.map((menu) => (
            <TableRow
              key={menu.id}
              sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
            >
              <TableCell component="th" scope="row">
                {menu.title}
              </TableCell>
              <TableCell align="right"><Link to={'/admin/editmenu/' + menu.id}>Edit</Link></TableCell>
              <TableCell align="right"><Link to={'/admin/deletemenu/' + menu.id}>Delete</Link></TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
    </div>);
}