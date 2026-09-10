// SPDX-License-Identifier: MIT
pragma solidity ^0.8.19;

contract UserRegistry {
    struct User {
        string username;
        string email;
        uint256 favoriteNumber;
    }

    mapping (address => User) public Users;

    address[] public userAddresses;
    

    function addUser(string memory _username, string memory _email, uint256 _favoriteNumber) public {
        Users[msg.sender] = User(_username, _email, _favoriteNumber);
        userAddresses.push(msg.sender);
    }

    function getAllUsers() public view returns (User[] memory) {
        User[] memory getUsers = new User[](userAddresses.length);
        for(uint i = 0; i < userAddresses.length; i++){
            getUsers[i] = Users[userAddresses[i]];
        }
        return getUsers;
    }

    function getUser(address _userAddress) public view returns (User memory){
        return Users[_userAddress];
    }
}