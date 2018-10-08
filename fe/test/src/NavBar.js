import React, {Component} from 'react';

import './header.css';

class NavBar extends Component {


    render() {

        let linksMarkup = this.props.items.map((link, index) => {
            console.log(link);
            return (
                <li key={index}><a href={link.link}><i className="site-nav--icon"></i>
                    {link.label}
                </a></li>
            )
        });
        return (
            <div>
                <nav className="site-nav">
                    <ul>
                        {linksMarkup}
                    </ul>
                </nav>
            </div>
        );
    }
}

export default NavBar;