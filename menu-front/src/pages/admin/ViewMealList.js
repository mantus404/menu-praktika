import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
export function ViewMealList(){
    const [meals, setMeals] = useState([]);
    const getMeals = () => {
        fetch('api/main/meal')
        .then(response => response.json())
        .then(jsonResponse => setMeals(jsonResponse));
    };
    useEffect(() => {
        getMeals();
    }, []);
    return (<div>
        <TableContainer component={Paper}>
      <Table sx={{ minWidth: 650 }} aria-label="simple table">
        <TableHead>
          <TableRow>
            <TableCell>Title</TableCell>
            <TableCell align="right">Description</TableCell>
            <TableCell align="right">Quantity</TableCell>
            <TableCell align="right">Menu Title</TableCell>
            <TableCell align="right">Edit</TableCell>
            <TableCell align="right">Delete</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {meals.map((meal) => (
            <TableRow
              key={meal.id}
              sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
            >
              <TableCell component="th" scope="row">
                {meal.title}
              </TableCell>
              <TableCell align="right">{meal.description}</TableCell>
              <TableCell align="right">{meal.quantity}</TableCell>
              <TableCell align="right">{meal.menu.title}</TableCell>
              <TableCell align="right"><Link to={'/admin/editmeal/' + meal.id}>Edit</Link></TableCell>
              <TableCell align="right"><Link to={'/admin/deletemeal/' + meal.id}>Delete</Link></TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
    </div>);
}