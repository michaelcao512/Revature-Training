import { Link } from 'react-router-dom';
export default function NavBar() {
    return (
        <div className="navbar">
            <h2>React Demo</h2>
            <div className="links">
                <Link to="/hello">Hello</Link>
                <Link to="/listandkeys">List/Keys</Link>
                <Link to="/sdc">State</Link>
                <Link to="/todolist">Todo List</Link>
                <Link to="/fetchdemo">Fetch CRUD </Link>
                <Link to="/useref">UseRef</Link>
                <Link to="/controlledcomponent">ControlledComponent </Link>
            </div>
        </div>
    );
}