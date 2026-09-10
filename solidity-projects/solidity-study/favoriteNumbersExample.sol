// SPDX-License-Identifier: MIT
pragma solidity ^0.8.19;

contract FavoriteNumber {
    struct Person {
        uint256 favoriteNumber;
        bool exists;
    }

    mapping (string => Person) public personsMapping;


    function addPerson(string memory _name, uint256 _favoriteNumber) public {
        if(personsMapping[_name].exists == false){
            personsMapping[_name] = Person(_favoriteNumber, true);  
        }
    }

    function updateNumber(string memory _name, uint256 _newNumber) public {
        if(personsMapping[_name].exists == true) {
            personsMapping[_name].favoriteNumber = _newNumber;
        }
    }

    function getNumber(string memory _name) public view returns (uint256 favoriteNumber) {
        if(personsMapping[_name].exists == true) {
            return personsMapping[_name].favoriteNumber;
        }
    }
}