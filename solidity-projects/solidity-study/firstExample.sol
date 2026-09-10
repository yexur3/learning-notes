// SPDX-License-Identifier: MIT
pragma solidity ^0.8.19;

contract SimpleStorage {
    uint256 public myNumber;

    function add(uint256 _number) public {
        myNumber += _number;
    }

    function subtract(uint256 _number) public {
        if(myNumber > _number){
            myNumber -= _number;
        }
    }

    function doubleNumber() public {
        myNumber =  myNumber * 2;
    }
}