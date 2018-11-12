import React, {Component} from 'react';
import './NavBar.css';


class NavBar extends Component {
    render() {
        return (
            <div>
                <nav className="navbar-default">
                    <div className="navbar-header">
                        <button type="button" className="navbar-toggle collapsed" data-toggle="collapse"
                                data-target="#nav-collapsed">
                            <span className="icon-bar"></span>
                            <span className="icon-bar"></span>
                            <span className="icon-bar"></span>
                            <span className="icon-bar"></span>
                        </button>
                        <a className="navbar-brand" href="#">Shop</a>
                    </div>
                </nav>
            </div>
        )

    }


}
export default NavBar;


