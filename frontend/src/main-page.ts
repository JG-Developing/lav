import { html, LitElement } from 'lit';
import '@vaadin/button';

class MainPage extends LitElement {
    render() {
        return html`
            <style>
                :host {
                    display: block;
                    box-sizing: border-box;
                    height: 100%;
                }
                :host([hidden]), [hidden] {
                    display: none !important;
                }
                #outlet {
                    position: fixed;
                    height: 100% !important;
                }
                [content] {
                    position: fixed;
                    display: flex;
                    justify-content: center;
                    padding: var(--lumo-space-l);
                    background-color: var(--lumo-base-color);                    
                    right: 2vw;
                    bottom: 210px;
                    height: 65vh;
                    width: 75vw;
                    margin-left: 18vw;
                    border: 1px solid black;
                    border-radius: 18px;
                }
                .panel {
                    position: fixed;
                    z-index: 1;
                    background-color: var(--lumo-base-color);
                    overflow: hidden;
                    transition: 0.5s;
                    border: 1px solid black;
                }
                .menu {
                    left: 0;
                    top: 0;
                    margin-left: 0px;
                    height: 100%;
                    width: 15vw;
                    border-top-right-radius: 18px;
                    border-bottom-right-radius: 18px;
                    border-left-style: none;
                }
                .resources {
                    display: flex;
                    bottom: 0;
                    height: 40px;
                    width: 80vw;
                    margin-left: 18vw;
                    margin-right: 2vw;
                    border-top-left-radius: 18px;
                    border-top-right-radius: 18px;
                    border-bottom-style: none;
                }
                .menu-title {
                    font-size: 2rem;
                    width: fit-content;
                    height: fit-content;
                    margin-left: auto;
                    margin-right: auto;
                    margin: 10px auto auto auto;
                    text-decoration: underline;
                }
                .menuTitle-close {
                    writing-mode: vertical-rl;
                    text-orientation: upright;
                    margin-top: 10px;
                    margin-right: auto;
                    margin-left: auto;
                    width: fit-content;
                    height: fit-content;
                }
                .panel-title {
                    margin-top: 5px;
                    margin-left: 10px;
                    width: fit-content;
                    height: 33px;
                    border-bottom: 1px solid black;
                }
                .panelbtn {
                    display: block;
                    position: absolute;
                    top: 0;
                    right: 20px;
                    margin-top: 5px;
                    font-size: 1.5rem;
                    text-decoration: none;
                    color: black;
                    font-size: 1rem;
                    width: fit-content;
                }
                .menubtn {
                    display: block;
                    font-size: 1.5rem;
                    text-decoration: none;
                    color: black;
                }
                .info {
                    position: absolute;
                    border: 1px solid black;
                    border-style: hidden;
                    width: 95%;
                    height: 0px;
                    bottom: 0;
                    right: 5px;
                    transition: height 0.5s
                }
                .vuln-nav-tabs {
                    width: fit-content !important;
                    position: absolute;
                    top: 0;
                    height: 30px;
                    margin: 7px auto 0px 150px;
                    overflow: hidden;
                    border: 1px solid #ccc;
                    background-color: #f1f1f1;
                    border-bottom: none;
                }
                vaadin-tab {
                    background-color: inherit;
                    float: left;
                    border: none;
                    outline: none;
                    cursor: pointer;
                    padding: 10px 10px;
                    transition: 0.2s;
                }
                vaadin-tab:hover {
                    background-color: #ddd;
                }
                .vulnContent {
                    display: none;
                    padding: 6px 12px;
                    border: 1px solid #ccc;
                    border-top: none;
                    margin-top: 0px;
                    animation: fadeEffect 0.5s;
                }
                @keyframes fadeEffect {
                    from {opacity: 0;}
                    to {opacity: 1;}
                }
            </style>
            <div part="heading" id="heading">
                <slot name="heading"></slot>
            </div>
            <div part="sideMenu" id="sideMenu">
                <slot name="sideMenu" id="sideMenuSlot"></slot>
            </div>
            <div content>
                <slot></slot>
            </div>
            <div part="resourcePanel" id="resourcePanel">
                <slot name="resourcePanel"></slot>
            </div>
        `;
    }
}

customElements.define('main-page', MainPage);