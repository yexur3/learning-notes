// SPDX-License-Identifier: MIT
pragma solidity ^0.8.19;

contract DataLocation{
    struct Person{
        string name;
        uint256 favoriteNumber;
    }

    Person[] public persons;

    function addPeople (string calldata _name, uint256 _favoriteNumber) public {
        persons.push(Person(_name, _favoriteNumber));
    }

    function updatePeople(uint index, string memory newName) public {
        persons[index].name = newName;
    }

    function getPerson(uint index) public view returns (Person memory){ // returns copy of data but not a data, and we need memory
        Person memory pers = persons[index];
        return pers;
    }
}