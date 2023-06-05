import { Link } from 'react-router-dom';
export function AdminPage(){
    return(<div>
        <ul>
        <li><Link to='/admin/viewmenulist'>View Menu List</Link></li>
        <li><Link to='/admin/viewmeallist'>View Meal List</Link></li>
        <li><Link to='/admin/vieworderlist'>View Order List</Link></li>
        </ul>
    </div>)
}