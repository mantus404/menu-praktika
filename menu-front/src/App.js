import logo from './logo.svg';
import './App.css';
import { AppBar, Menu, MenuItem } from '@mui/material';
import { HashRouter, Route, Routes } from 'react-router-dom';
import { ViewMenu } from './pages/ViewMenu';
import { Nav } from './nav/Nav';
import { AdminPage } from './pages/admin/AdminPage';
import { ViewMenuList } from './pages/admin/ViewMenuList';
import { ViewMealList } from './pages/admin/ViewMealList';
import { ViewOrderList } from './pages/admin/ViewOrderList';

function App() {
  return (
    <div>
      <HashRouter>
        <Nav />
        <Routes>
          <Route path='/' element={<ViewMenu />} />
          <Route path='/admin' element={<AdminPage />} />
          <Route path='/admin/viewmenulist' element={<ViewMenuList />} />
          <Route path='/admin/viewmeallist' element={<ViewMealList />} />
          <Route path='/admin/vieworderlist' element={<ViewOrderList />} />
        </Routes>
      </HashRouter>
    </div>
  );
}

export default App;
