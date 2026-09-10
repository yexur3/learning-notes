// SPDX-License-Identifier: MIT
pragma solidity ^0.8.19;

contract phoneBook {
    mapping (string => uint256) public phonebook;

    function addContact(string memory _name, uint256 phoneNumber) public {
        phonebook[_name] = phoneNumber;
    }

    function getPhone(string memory _name) public view returns (uint256 phoneNumber) {
        return phonebook[_name];
    }

    function deletePhone(string memory _name) public {
        delete phonebook[_name];
    }
}