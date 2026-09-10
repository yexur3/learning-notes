// SPDX-License-Identifier: MIT
pragma solidity ^0.8.19;

contract UserProfiles {
    struct User {
        string name;
        uint256 age;
    }

    mapping (string => User) public users;

    function addUser(string memory _name, uint256 age) public {
        users[_name] = User(_name, age);
    }

    function updateAge(string memory _name, uint256 newAge) public {
        users[_name].age = newAge;
    }

    function getUser(string memory _name) public view returns (User memory) {
        return users[_name];
    }
}