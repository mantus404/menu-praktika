import { AppBar, Button, Menu, MenuItem, Toolbar } from '@mui/material';
import { Link } from 'react-router-dom';
export function Nav(){
    return(<div>
        <AppBar position='static'>
            <Toolbar>
                <Button color='success' variant='contained'><Link to='/admin' style={{ textDecoration: 'none', color:'white' }}>Admin</Link></Button>
                <Button color='secondary' variant='contained'><Link to='/user' style={{ textDecoration: 'none',color: 'white' }}>User</Link></Button>
          
          </Toolbar>
        </AppBar>
        
    </div>);
}