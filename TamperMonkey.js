// ==UserScript==
// @name         Ticket By Movie Dates
// @namespace    http://tampermonkey.net/
// @version      0.1
// @description  try to take over the world!
// @author       You
// @match        https://in.bookmyshow.com/buytickets/uri-the-surgical-strike-hyderabad/movie-hyd-ET00062444-MT/20190125
// @grant        none
// ==/UserScript==

(function() {
    'use strict';

    var venue = document.getElementsByClassName("__venue-name")
    var found = false;
    for(var i=0; i<venue.length; i++)
    {
        console.log(venue[i].innerText);
        if(venue[i].innerText.match(/Forum/)!==null)
        {
            window.open('http://localhost:6161/BMSTEST/send/to?email=soumyadeeplogin@gmail.com+soumyadeeplogin@hotmail.com&hall=PVR%20Forum%20Sujana%20Mall:%20Kukatpally,%20Hyderabad&movie=URI-The%20Surgical%20Strike&date=25.01.2019')
            alert('yes');
            found = true;
            break;
        }
    }

    if(!found)
    {
        console.log("reloading")
        setTimeout(window.location.reload.bind(window.location), 300000);
    }
})();